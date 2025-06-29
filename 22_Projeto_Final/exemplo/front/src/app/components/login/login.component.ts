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
  selector: 'app-login',
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
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  usuario: Usuario = new Usuario();
  messageService = inject(MessageService)
  authService = inject(AuthService)
  router = inject(Router)

  onSubmit(form: any) {
    if (form.valid) {
      this.authService.login(this.usuario)
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
          this.router.navigate(['/']);
        });
    } else {
      form.control.markAllAsTouched();
      this.messageService.add({
        severity: 'error',
        summary: 'Erro',
        detail: 'Preencha todos os campos necessários'
      });
    }
  }

}
