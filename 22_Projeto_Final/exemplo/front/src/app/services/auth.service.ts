import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { tap } from 'rxjs';
import { Usuario } from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  http = inject(HttpClient)
  private _isLoggedIn = signal<boolean>(!!localStorage.getItem('jwt'));
  isLoggedIn = this._isLoggedIn.asReadonly();
  url: string = "http://localhost:8080/auth"

  constructor() { }

  cadastro(usuario: Usuario) {
    return this.http.post<{ token: string }>(`${this.url}/cadastro`, usuario);
  }

  login(usuario: Usuario) {
    return this.http.post<{ token: string }>(`${this.url}/login`, usuario
    ).pipe(
      tap(response => {
        localStorage.setItem('jwt', response.token);
        this._isLoggedIn.set(true);
      })
    );
  }

  logout() {
    localStorage.removeItem('jwt');
    this._isLoggedIn.set(false);
  }
}
