import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ActivatedRoute, Router } from '@angular/router';
import { ClienteService } from '../cliente.service';
import {Telefone} from "../telefone";

@Component({
  selector: 'app-atualizar-cliente',
  templateUrl: './atualizar-cliente.component.html',
  styleUrls: ['./atualizar-cliente.component.css']
})
export class AtualizarClienteComponent implements OnInit {

  id: number;
  cliente: Cliente;
  telefone:Telefone = new Telefone();
  telefones: Telefone[]=[];

  constructor(private route: ActivatedRoute,private router: Router,
    private service: ClienteService) { }

  ngOnInit() {
    this.cliente = new Cliente();

    this.id = this.route.snapshot.params['id'];

    this.service.getCliente(this.id)
      .subscribe(data => {
        console.log(data)
        this.cliente = data;
      }, error => console.log(error));

    this.telefones = this.cliente.telefones;
  }

  atualizarCliente() {
    this.cliente.telefones = this.telefones;

    this.service.atualizarCliente(this.id, this.cliente)
      .subscribe(data => console.log(data), error => console.log(error));
    this.cliente = new Cliente();
    this.gotoList();
  }

  onSubmit() {
    this.atualizarCliente();
  }

  gotoList() {
    this.router.navigate(['/clientes']);
  }

  adicionarTelefone(telefoneI: Telefone){
    this.telefones.push(telefoneI);
    console.log(this.telefones);
  }

  apagarTelefone(telefoneRemove:number){
    this.telefones.splice(telefoneRemove);
  }
}
