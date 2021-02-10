import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { Router } from '@angular/router';
import { ClienteService } from '../cliente.service';
import {Observable, Subscription} from "rxjs";
import {Telefone} from "../telefone";

@Component({
  selector: 'app-criar-cliente',
  templateUrl: './criar-cliente.component.html',
  styleUrls: ['./criar-cliente.component.css']
})
export class CriarClienteComponent implements OnInit {

  cliente: Cliente = new Cliente();
  submitted = false;
  nuTelefone: number;
  telefone: Telefone;
  telefones: Telefone[]=[];
  clienteCadastrado: Observable<Cliente>;
  clienteJaExiste: boolean;
  constructor(private service: ClienteService,
    private router: Router) { }

  ngOnInit() {
  }

  novoCliente(): void {
    this.submitted = false;
    this.cliente = new Cliente();
  }

  save() {
     this.cliente.telefones = this.telefones;
      this.service.criarCliente(this.cliente)
        .subscribe(data => console.log(data), error => this.clienteJaExiste = true);
      this.cliente = new Cliente();
      this.gotoList();

  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/clientes']);
  }

  adicionarTelefone(nuTelefone: number){
    this.telefone = new Telefone();
    this.telefone.telefone = nuTelefone;
    this.telefones.push(this.telefone);
    console.log(this.telefones);
  }

  apagarTelefone(id:number){
    this.telefones.splice(id);
  }
}
