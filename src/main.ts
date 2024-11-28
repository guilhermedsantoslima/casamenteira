import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { ContainerComponent } from './app/componentes/container/container.component';

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));
