import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarClienteComponent } from './listar-cliente/listar-cliente.component';
import { CriarClienteComponent } from './criar-cliente/criar-cliente.component';
import { AtualizarClienteComponent } from './atualizar-cliente/atualizar-cliente.component';
import { DetalharClienteComponent } from './detalhar-cliente/detalhar-cliente.component';


const routes: Routes = [

  { path: '', redirectTo: 'cliente', pathMatch: 'full' },
  { path: 'clientes', component: ListarClienteComponent },
  { path: 'add', component: CriarClienteComponent },
  { path: 'update/:id', component: AtualizarClienteComponent },
  { path: 'details/:id', component: DetalharClienteComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
