import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarClienteComponent } from './criar-cliente.component';

describe('CreateEmployeeComponent', () => {
  let component: CriarClienteComponent;
  let fixture: ComponentFixture<CriarClienteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CriarClienteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CriarClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
