import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtualizarClienteComponent } from './atualizar-cliente.component';

describe('UpdateEmployeeComponent', () => {
  let component: AtualizarClienteComponent;
  let fixture: ComponentFixture<AtualizarClienteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtualizarClienteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtualizarClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
