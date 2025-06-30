import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Cargo } from '../models/cargo.model';

@Injectable({
  providedIn: 'root'
})
export class CargosService {
  http = inject(HttpClient);
  url: string = "http://localhost:8080/cargos"

  listar() {
    return this.http.get<Array<Cargo>>(this.url);
  }

  buscar(id: number) {
    return this.http.get<Cargo>(`${this.url}/${id}`);
  }

  salvar(cargo: Cargo) {
    return this.http.post<Cargo>(`${this.url}/registrar`, cargo);
  }

  atualizar(cargo: Cargo, id: number) {
    return this.http.put<Cargo>(`${this.url}/atualizar/${id}`, cargo);
  }

  excluir(id: number) {
    return this.http.delete<null>(`${this.url}/excluir/${id}`);
  }
}
