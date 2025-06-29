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
  selector: 'app-cargos',
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
  templateUrl: './cargos.component.html',
  styleUrl: './cargos.component.scss'
})
export class CargosComponent {
  cargosService = inject(CargosService);
  messageService = inject(MessageService)
  cargos = signal<Array<Cargo>>([]);
  novoCargo = new Cargo();
  isModalVisivel: boolean = false;

  ngOnInit(): void {
    this.listarCargos();
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
    this.cargosService.salvar(this.novoCargo)
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
        this.novoCargo = new Cargo();
        this.listarCargos();
      });

    this.messageService.add({
      severity: 'success',
      summary: 'Success',
        detail: 'Cargo cadastrado com sucesso'
    });
  }
}
