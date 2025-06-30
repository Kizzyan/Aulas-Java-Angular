import { Component, inject, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { CargosService } from '../../services/cargos.service';
import { Cargo } from '../../models/cargo.model';

import { TableModule } from 'primeng/table';
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { FloatLabelModule } from 'primeng/floatlabel';
import { TooltipModule } from 'primeng/tooltip';
import { catchError } from 'rxjs';
import { ConfirmationService, MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { DialogModule } from 'primeng/dialog';
import { DatePickerModule } from 'primeng/datepicker';
import { ConfirmPopupModule } from 'primeng/confirmpopup';

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
    ConfirmPopupModule
  ],
  templateUrl: './cargos.component.html',
  styleUrl: './cargos.component.scss'
})
export class CargosComponent {
  cargosService = inject(CargosService);
  messageService = inject(MessageService)
  confirmationService = inject(ConfirmationService)
  cargos = signal<Array<Cargo>>([]);
  novoCargo = new Cargo();
  cargoAtualizado = new Cargo();
  isCadastrarVisivel: boolean = false;
  isAtualizarVisivel: boolean = false;

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

  buscarPorId(id: number) {
    this.cargosService.buscar(id)
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
        this.cargoAtualizado = data;
      });
  }

  mostrarModalCadastrar() {
    this.isCadastrarVisivel = true;
    this.listarCargos();
  }

  mostrarModalAtualizar(id: number) {
    this.isAtualizarVisivel = true;
    this.buscarPorId(id);
  }

  excluir(id: number, event: Event) {
    this.confirmationService.confirm({
      target: event.target as EventTarget,
      message: 'Deseja mesmo excluir esse cargo?',
      icon: 'pi pi-exclamation-triangle',
      rejectButtonProps: {
        label: 'Cancel',
        severity: 'secondary',
        outlined: true
      },
      acceptButtonProps: {
        label: 'Excluir'
      },
      accept: () => {
        this.cargosService.excluir(id)
          .pipe(
            catchError((err) => {
              this.messageService.add({
                severity: 'error',
                summary: 'Erro',
                detail: err.error.descricao
              });
              throw err;
            })
          )
          .subscribe(() => {
            this.listarCargos();
            this.messageService.add({ severity: 'info', summary: 'Sucesso', detail: 'Cargo excluído com sucesso', life: 3000 });
          });
      },
    });
  }

  atualizar(id: number | undefined) {
    this.cargosService.salvar(this.cargoAtualizado)
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
        this.isAtualizarVisivel = false;
        this.listarCargos();
        this.messageService.add({ severity: 'info', summary: 'Sucesso', detail: 'Cargo atualizado com sucesso', life: 3000 });
      });
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
        this.isCadastrarVisivel = false;
        this.novoCargo = new Cargo();
        this.listarCargos();
        this.messageService.add({ severity: 'info', summary: 'Sucesso', detail: 'Cargo criado com sucesso', life: 3000 });
      });
  }
}
