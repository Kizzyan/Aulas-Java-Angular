import { Component, inject, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { PasswordModule } from 'primeng/password';
import { ButtonModule } from 'primeng/button';
import { MessageService } from 'primeng/api';
import { FloatLabelModule } from 'primeng/floatlabel';
import { DividerModule } from 'primeng/divider';
import { ToastModule } from 'primeng/toast';
import { ChipModule } from 'primeng/chip';

import { Usuario } from '../../models/usuario.model';
import { AuthService } from '../../services/auth.service';
import { catchError } from 'rxjs';
import { JwtService } from '../../services/jwt.service';
import { UsuariosService } from '../../services/usuarios.service';

@Component({
  selector: 'app-home',
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    CardModule,
    InputTextModule,
    PasswordModule,
    ButtonModule,
    FloatLabelModule,
    DividerModule,
    ToastModule,
    ChipModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {
  usuario: Usuario = new Usuario();
  messageService = inject(MessageService);
  authService = inject(AuthService);
  jwtService = inject(JwtService);
  usuarioService = inject(UsuariosService);
  router = inject(Router);
  token: string = localStorage.getItem('jwt') || "";
  isAtualizando: boolean = false;
  novaSenha: string = "";
  confirmarNovaSenha: string = "";

  ngOnInit(): void {
    this.getUsuario();
  }

  getUsuario() {
    this.usuarioService.getUsuarioById(+this.jwtService.getUserId(this.token))
      .pipe(
        catchError((err) => {
          this.messageService.add({
            severity: 'error',
            summary: 'Error',
            detail: err?.error?.descricao || "Um erro desconhecido ocorreu"
          });
          throw err;
        })
      )
      .subscribe((data) => {
        this.usuario = data;
      });
  }

  setAtualizacao() {
    this.isAtualizando = !this.isAtualizando;
  }

  atualizar(form: any) {
    if (form.valid && this.usuario.senha === this.usuario.confirmarSenha) {
      if (this.novaSenha) this.usuario.senha = this.novaSenha;
      this.usuarioService.atualizar(this.usuario, this.usuario.id)
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
          this.isAtualizando = false;
          this.router.navigate(['/']);
          this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Usuário atualizado com sucesso' });
        }
        );


    } else {
      form.control.markAllAsTouched();
      this.messageService.add({
        severity: 'error',
        summary: 'Error',
        detail: 'Preencha todos os campos necessários'
      });
    }
  }
}
