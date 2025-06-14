import { HttpClient, HttpHeaders } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Funcionario } from '../models/funcionario.model';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class FuncionariosService {
  http = inject(HttpClient);
  url = "";

  getFuncionarios() {
    return this.http.get<Array<Funcionario>>(this.url);
  }

  getFuncionarioById(id: number) {
    return this.http.get<Array<Funcionario>>(`${this.url}/${id}`);
  }

  saveFuncionario(funcionario: Funcionario) {
    return this.http.post<Funcionario>(`${this.url}/salvar`, funcionario);
  }

  updateFuncionario(funcionario: Funcionario, id: number) {
    return this.http.put<Funcionario>(`${this.url}/atualizar/${id}`, funcionario);
  }

  removeFuncionario(id: number) {
    return this.http.delete<Funcionario>(`${this.url}/excluir/${id}`);
  }
}
