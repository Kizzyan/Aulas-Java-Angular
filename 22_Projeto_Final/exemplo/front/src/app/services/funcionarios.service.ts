import { HttpClient, HttpHeaders } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Funcionario } from '../models/funcionario.model';

@Injectable({
  providedIn: 'root'
})
export class FuncionariosService {
  http = inject(HttpClient);
  url: string = "http://localhost:8080/funcionarios"

  listar() {
    return this.http.get<Array<Funcionario>>(this.url);
  }

  buscar(id: number) {
    return this.http.get<Funcionario>(`${this.url}/${id}`);
  }

  salvar(funcionario: Funcionario) {
    return this.http.post<Funcionario>(`${this.url}/registrar`, funcionario);
  }

  atualizar(funcionario: Funcionario, id: number) {
    return this.http.put<Funcionario>(`${this.url}/atualizar/${id}`, funcionario);
  }

  excluir(id: number) {
    return this.http.delete<Funcionario>(`${this.url}/excluir/${id}`);
  }
}
