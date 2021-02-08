import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ActivatedRoute, Router } from '@angular/router';
import { ClienteService } from '../cliente.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './atualizar-cliente.component.html',
  styleUrls: ['./atualizar-cliente.component.css']
})
export class AtualizarClienteComponent implements OnInit {

  id: number;
  employee: Cliente;

  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: ClienteService) { }

  ngOnInit() {
    this.employee = new Cliente();

    this.id = this.route.snapshot.params['id'];

    this.employeeService.getCliente(this.id)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.employeeService.atualizarCliente(this.id, this.employee)
      .subscribe(data => console.log(data), error => console.log(error));
    this.employee = new Cliente();
    this.gotoList();
  }

  onSubmit() {
    this.updateEmployee();
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }
}
