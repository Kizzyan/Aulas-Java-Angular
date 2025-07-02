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
import { ConfirmationService, MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { DialogModule } from 'primeng/dialog';
import { DatePickerModule } from 'primeng/datepicker';
import { SelectModule } from 'primeng/select';
import { ConfirmPopupModule } from 'primeng/confirmpopup';

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
    SelectModule,
    ConfirmPopupModule
  ],
  templateUrl: './funcionarios.component.html',
  styleUrl: './funcionarios.component.scss'
})
export class FuncionariosComponent implements OnInit {
  funcionarioService = inject(FuncionariosService);
  cargosService = inject(CargosService);
  messageService = inject(MessageService)
  confirmationService = inject(ConfirmationService)
  funcionarios = signal<Array<Funcionario>>([]);
  cargos = signal<Array<Cargo>>([]);
  novoFuncionario = new Funcionario();
  funcionarioAtualizado = new Funcionario();
  isCadastrarVisivel: boolean = false;
  isAtualizarVisivel: boolean = false;

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

  buscarPorId(id: number) {
    this.funcionarioService.buscar(id)
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
        this.funcionarioAtualizado = data;
        let dataNascimento: string = data.dataNascimento?.toString() || "";
        this.funcionarioAtualizado.dataNascimento = new Date(dataNascimento);
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

  mostrarModalCadastrar() {
    this.isCadastrarVisivel = true;
    this.listarCargos();
  }

  mostrarModalAtualizar(id: number) {
    this.isAtualizarVisivel = true;
    this.listarCargos();
    this.buscarPorId(id);
  }

  excluir(id: number, event: Event) {
    this.confirmationService.confirm({
      target: event.target as EventTarget,
      message: 'Deseja mesmo excluir esse funcionário?',
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
        this.funcionarioService.excluir(id)
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
            this.listarFuncionarios();
            this.messageService.add({ severity: 'info', summary: 'Sucesso', detail: 'Funcionário excluído com sucesso', life: 3000 });
          });
      },
    });
  }

  atualizar(id: number | undefined) {
    this.funcionarioService.salvar(this.funcionarioAtualizado)
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
        this.listarFuncionarios();
        this.messageService.add({ severity: 'info', summary: 'Sucesso', detail: 'Funcionário atualizado com sucesso', life: 3000 });
      });
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
        this.isCadastrarVisivel = false;
        this.novoFuncionario = new Funcionario();
        this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Funcionário cadastrado com sucesso' });
        this.listarFuncionarios();
      });

  }
}
