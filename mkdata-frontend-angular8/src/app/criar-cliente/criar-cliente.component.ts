import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { Router } from '@angular/router';
import { ClienteService } from '../cliente.service';
import {Observable, Subscription} from "rxjs";

@Component({
  selector: 'app-criar-cliente',
  templateUrl: './criar-cliente.component.html',
  styleUrls: ['./criar-cliente.component.css']
})
export class CriarClienteComponent implements OnInit {

  cliente: Cliente = new Cliente();
  submitted = false;
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
}
