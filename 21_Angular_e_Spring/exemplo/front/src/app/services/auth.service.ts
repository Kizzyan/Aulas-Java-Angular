import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { tap } from 'rxjs';
import { Usuario } from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  http = inject(HttpClient)

  constructor() { }

  login(usuario: Usuario) {
    return this.http.post<{ token: string }>('http://localhost:8080/login', usuario
    ).pipe(
      tap(response => {
        localStorage.setItem('jwt', response.token);
      })
    );
  }

  cadastro(usuario: Usuario) {
    return this.http.post<{ token: string }>('http://localhost:8080/login', usuario);
  }
}
