import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalharClienteComponent } from './detalhar-cliente.component';

describe('EmployeeDetailsComponent', () => {
  let component: DetalharClienteComponent;
  let fixture: ComponentFixture<DetalharClienteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalharClienteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalharClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
