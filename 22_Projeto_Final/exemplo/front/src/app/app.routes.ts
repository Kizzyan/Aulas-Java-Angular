import { Routes } from '@angular/router';
import { authGuard } from './guards/auth.guard';
import { loginGuard } from './guards/login.guard';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    canActivate: [authGuard],
    loadComponent: async () => {
      const m = await import('./components/home/home.component');
      return m.HomeComponent;
    },
  },
  {
    path: 'login',
    canActivate: [loginGuard],
    loadComponent: async () => {
      const m = await import('./components/login/login.component');
      return m.LoginComponent;
    },
  },
  {
    path: 'cadastro',
    canActivate: [loginGuard],
    loadComponent: async () => {
      const m = await import('./components/cadastro/cadastro.component');
      return m.CadastroComponent;
    },
  },
  {
    path: 'funcionarios',
    canActivate: [authGuard],
    loadComponent: () => {
      return import('./components/funcionarios/funcionarios.component')
        .then(m => m.FuncionariosComponent);
    },
  },
  {
    path: 'cargos',
    canActivate: [authGuard],
    loadComponent: () => {
      return import('./components/cargos/cargos.component')
        .then(m => m.CargosComponent);
    }
  },
  {
    path: '**',
    redirectTo: 'login'
  }
];