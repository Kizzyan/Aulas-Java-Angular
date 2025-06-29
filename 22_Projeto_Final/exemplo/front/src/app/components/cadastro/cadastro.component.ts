import { Component, inject } from '@angular/core';
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

import { Usuario } from '../../models/usuario.model';
import { AuthService } from '../../services/auth.service';
import { catchError } from 'rxjs';

@Component({
  selector: 'app-cadastro',
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
    ToastModule
  ],
  templateUrl: './cadastro.component.html',
  styleUrl: './cadastro.component.scss'
})
export class CadastroComponent {
  usuario: Usuario = new Usuario();
  messageService = inject(MessageService)
  authService = inject(AuthService)
  router = inject(Router)


  onSubmit(form: any) {
    if (form.valid && this.usuario.senha === this.usuario.confirmarSenha) {
      this.messageService.add({
        severity: 'success',
        summary: 'Success',
        detail: 'Usuário cadastrado com sucesso'
      });

      this.authService.cadastro(this.usuario)
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
          this.router.navigate(['/login']);
        });
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
