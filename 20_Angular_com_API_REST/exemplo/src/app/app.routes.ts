import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    loadComponent: async () => {
      const m = await import('./components/home/home.component');
        return m.HomeComponent;
    },
  },
  {
    path: 'todos',
    loadComponent: () => {
      return import('./components/funcionarios/funcionarios.component')
                    .then(m => m.FuncionariosComponent);
    },
  },
];