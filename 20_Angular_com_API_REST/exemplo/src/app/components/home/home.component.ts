import { Component, inject, OnInit } from '@angular/core';
import { FilmesService } from '../../services/filmes.service';
import { catchError } from 'rxjs';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit{
  filmesService = inject(FilmesService)

  ngOnInit(): void {
        this.filmesService
      .getFilmesPopulares(1)
      .pipe(
        catchError((err) => {
          console.log(err);
          throw err;
        })
      )
      .subscribe(filmes => {
        console.log(filmes);
      });
  }
}
