import { Component, inject, OnInit } from '@angular/core';
import { ToolbarModule } from 'primeng/toolbar';
import { ButtonModule } from 'primeng/button';
import { IconFieldModule } from 'primeng/iconfield';
import { InputIconModule } from 'primeng/inputicon';
import { TooltipModule } from 'primeng/tooltip';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-header',
  imports: [
    RouterModule,
    ToolbarModule,
    ButtonModule,
    IconFieldModule,
    InputIconModule,
    TooltipModule
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit {
  isLoggedIn: string | null = "";
  router = inject(Router);
  authService = inject(AuthService);

  ngOnInit(): void {
    this.isLoggedIn = localStorage.getItem('jwt');
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
