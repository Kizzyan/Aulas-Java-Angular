import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';


@Injectable({
  providedIn: 'root'
})
export class JwtService {
  private helper = new JwtHelperService();

  constructor() { }

  decodeToken(token: string): any {
    return this.helper.decodeToken(token);
  }

  getUserId(token: string): string {
    const decoded = this.decodeToken(token);
    return decoded?.id || null;
  }

  getUserRoles(token: string): string[] {
    const decoded = this.decodeToken(token);
    return decoded?.authorities || [];
  }

  hasRole(token: string, role: string): boolean {
    const roles = this.getUserRoles(token);
    return roles.includes(role);
  }

  isTokenExpired(token: string): boolean {
    return this.helper.isTokenExpired(token);
  }

  getTokenExpirationDate(token: string): Date | null {
    return this.helper.getTokenExpirationDate(token);
  }
}
