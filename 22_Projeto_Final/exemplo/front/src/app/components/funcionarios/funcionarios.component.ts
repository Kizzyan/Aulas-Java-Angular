import { Component, inject, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { FuncionariosService } from '../../services/funcionarios.service';
import { CargosService } from '../../services/cargos.service';
import { Funcionario } from '../../models/funcionario.model';
import { Cargo } from '../../models/cargo.model';

import { TableModule } from 'primeng/table';
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { FloatLabelModule } from 'primeng/floatlabel';
import { TooltipModule } from 'primeng/tooltip';
import { catchError } from 'rxjs';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { DialogModule } from 'primeng/dialog';
import { DatePickerModule } from 'primeng/datepicker';
import { SelectModule } from 'primeng/select';

@Component({
  selector: 'app-funcionarios',
  imports: [
    CommonModule,
    FormsModule,
    InputTextModule,
    ButtonModule,
    FloatLabelModule,
    TableModule,
    CardModule,
    TooltipModule,
    ToastModule,
    DialogModule,
    DatePickerModule,
    SelectModule
  ],
  templateUrl: './funcionarios.component.html',
  styleUrl: './funcionarios.component.scss'
})
export class FuncionariosComponent implements OnInit {
  funcionarioService = inject(FuncionariosService);
  cargosService = inject(CargosService);
  messageService = inject(MessageService)
  funcionarios = signal<Array<Funcionario>>([]);
  cargos = signal<Array<Cargo>>([]);
  novoFuncionario = new Funcionario();
  isModalVisivel: boolean = false;

  ngOnInit(): void {
    this.listarFuncionarios();
  }

  listarFuncionarios() {
    this.funcionarioService.listar()
      .pipe(
        catchError((err) => {
          this.messageService.add({
            severity: 'error',
            summary: 'Error',
            detail: err.error.descricao
          });
          throw err;
        })
      )
      .subscribe((data) => {
        this.funcionarios.set(data)
      });
  }

  listarCargos() {
    this.cargosService.listar()
      .pipe(
        catchError((err) => {
          this.messageService.add({
            severity: 'error',
            summary: 'Error',
            detail: err.error.descricao
          });
          throw err;
        })
      )
      .subscribe((data) => {
        this.cargos.set(data)
      });
  }

  mostrarModal() {
    this.isModalVisivel = true;
    this.listarCargos();
  }

  onSubmit() {
    this.funcionarioService.salvar(this.novoFuncionario)
      .pipe(
        catchError((err) => {
          this.messageService.add({
            severity: 'error',
            summary: 'Error',
            detail: err.error.descricao
          });
          throw err;
        })
      )
      .subscribe(() => {
        this.isModalVisivel = false;
        this.novoFuncionario = new Funcionario();
        this.listarFuncionarios();
      });

    this.messageService.add({
      severity: 'success',
      summary: 'Success',
      detail: 'Funcionário cadastrado com sucesso'
    });
  }
}
