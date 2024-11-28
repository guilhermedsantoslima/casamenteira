import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ContainerComponent } from "./componentes/container/container.component";
import { CabecalhoComponent } from "./componentes/cabecalho/cabecalho.component";
import { CardsComponent } from "./componentes/cards/cards.component";
import { CadastroComponent } from './componentes/cadastro/cadastro.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ContainerComponent, CabecalhoComponent, CardsComponent, CadastroComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'casamenteira-app';
}
