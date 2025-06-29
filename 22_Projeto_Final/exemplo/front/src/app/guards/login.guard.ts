import { CanActivateFn, Router } from '@angular/router';
import { inject } from '@angular/core';

export const loginGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);
  const token = localStorage.getItem('jwt');
  
  if (!token) {
    return true;
  } else {
    return router.createUrlTree(['/'], {
      queryParams: { returnUrl: state.url }
    });
  }
};