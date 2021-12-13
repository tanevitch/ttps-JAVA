import { RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { MisServiciosComponent } from './components/servicio/mis-servicios/mis-servicios.component';
import { NuevoServicioComponent } from './components/servicio/nuevo-servicio/nuevo-servicio.component';
import { RegistroComponent } from './components/registro/registro.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProtegerRutaGuard } from './guards/proteger-ruta.guard';
import { EditarServicioComponent} from './components/servicio/editar-servicio/editar-servicio.component';




@NgModule({
  declarations: [
    LoginComponent,
    RegistroComponent,
    AppComponent,
    HomeComponent,
    MisServiciosComponent,
    NuevoServicioComponent,
    NavbarComponent,
    EditarServicioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path : 'login', component: LoginComponent},
      { path : 'registro', component: RegistroComponent},
      { path : '', component: HomeComponent},
      { path : 'servicios', component: MisServiciosComponent, canActivate: [ProtegerRutaGuard]},
      { path : 'servicios/nuevo', component: NuevoServicioComponent, canActivate: [ProtegerRutaGuard]},
      { path : 'servicios/editar/:id', component: EditarServicioComponent, canActivate: [ProtegerRutaGuard]}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
