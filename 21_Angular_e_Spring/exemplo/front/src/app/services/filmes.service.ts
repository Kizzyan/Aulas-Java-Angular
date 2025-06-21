import { inject, Injectable } from '@angular/core';
import { environment } from '../../environment/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Filme } from '../models/filme.model';

@Injectable({
  providedIn: 'root'
})
export class FilmesService {
  http = inject(HttpClient);
  url = environment.apiUrl;
  headers = new HttpHeaders({
    accept: 'application/json',
    Authorization: `Bearer ${environment.readAcessToken}`
  });

  getFilmesPopulares(pagina: number) {
    return this.http.get<Array<Filme>>(`${this.url}/popular?page=${pagina}`, { headers: this.headers });
  }

  getFilmeById(id: number) {
    return this.http.get<Array<Filme>>(`${this.url}/${id}`, { headers: this.headers });
  }
}

