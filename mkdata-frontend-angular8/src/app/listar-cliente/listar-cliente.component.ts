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

  employees: Observable<Cliente[]>;

  constructor(private employeeService: ClienteService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.employees = this.employeeService.getClientesLista();
  }

  deleteEmployee(id: number) {
    this.employeeService.deletarCliente(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  employeeDetails(id: number){
    this.router.navigate(['details', id]);
  }
}
