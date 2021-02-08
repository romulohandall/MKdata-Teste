import { Cliente } from '../cliente';
import { Component, OnInit, Input } from '@angular/core';
import { ClienteService } from '../cliente.service';
import { ListarClienteComponent } from '../listar-cliente/listar-cliente.component';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-detalhar-cliente',
  templateUrl: './detalhar-cliente.component.html',
  styleUrls: ['./detalhar-cliente.component.css']
})
export class DetalharClienteComponent implements OnInit {

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

  list(){
    this.router.navigate(['employees']);
  }
}
