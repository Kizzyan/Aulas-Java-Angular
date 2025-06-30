import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Usuario } from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {
  http = inject(HttpClient)
  url = "http://localhost:8080/usuarios";

  getUsuarioById(id: number) {
    return this.http.get<Usuario>(`${this.url}/${id}`);
  }

  atualizar(usuario: Usuario, id: number | undefined) {
    return this.http.put<Usuario>(`${this.url}/atualizar/${id}`, usuario);
  }
}
