import { Component, OnInit } from '@angular/core';

import { Observable } from "rxjs";
import { ClienteService } from "../cliente.service";
import { Cliente } from "../cliente";
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-cliente',
  templateUrl: './listar-cliente.component.html',
  styleUrls: ['./listar-cliente.component.css']
})
export class ListarClienteComponent implements OnInit {

  clientes: Observable<Cliente[]>;

  constructor(private service: ClienteService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.clientes = this.service.getClientesLista();
  }

  apagarCliente(id: number) {
    this.service.deletarCliente(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  detalharCliente(id: number){
    this.router.navigate(['details', id]);
  }
}
