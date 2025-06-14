import { Component, inject, OnInit, signal } from '@angular/core';
import { FuncionariosService } from '../../services/funcionarios.service';
import { Funcionario } from '../../models/funcionario.model';
import { catchError } from 'rxjs';

@Component({
  selector: 'app-funcionarios',
  imports: [],
  templateUrl: './funcionarios.component.html',
  styleUrl: './funcionarios.component.scss'
})
export class FuncionariosComponent implements OnInit {
  service = inject(FuncionariosService);
  funcionarios = signal<Array<Funcionario>>([]);
  // pesquisa = signal('');


  ngOnInit(): void {
    this.service
      .getFuncionarios()
      .pipe(catchError(err => { throw err;}))
      .subscribe(funcionarios => this.funcionarios.set(funcionarios));
  }
}
