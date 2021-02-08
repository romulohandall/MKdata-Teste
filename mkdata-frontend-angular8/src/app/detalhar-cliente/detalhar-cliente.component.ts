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
  cliente: Cliente;

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
  }

  list(){
    this.router.navigate(['clientes']);
  }
}
