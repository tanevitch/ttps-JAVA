import { environment } from '../../environments/environment';
import { Injectable } from '@angular/core';
import { Servicio } from '../models/servicio/servicio';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { AuthService } from './auth.service';


@Injectable({
  providedIn: 'root'
})
export class ServicioService {


  endpoint: string = 'api/servicios'
  constructor(private http: HttpClient, private authService: AuthService) { }

  public getServicioConId(id: number){
    let url = environment.apiJava + this.endpoint + "/"+id;
    return this.http.get<Servicio>(url, {
      headers: {
        Authorization: `Bearer ${this.authService.obtenerToken()}`
      }
    });
  }

  public getServicios(): Observable<Array<Servicio>>{
    let url = environment.apiJava + this.endpoint;
    return this.http.get<Array<Servicio>>(url, {
      headers: {
        Authorization: `Bearer ${this.authService.obtenerToken()}`
      }
    });
  }

  public getMisServicios(): Observable<Array<Servicio>>{
    let urlMisServicios = '/usuario/1'
    let url = environment.apiJava + this.endpoint + urlMisServicios;
    return this.http.get<Array<Servicio>>(url, {
      headers: {
        Authorization: `Bearer ${this.authService.obtenerToken()}`
      }
    });
  }

  public borrarServicio(serv: Servicio): Observable<any>{
    let url = environment.apiJava + this.endpoint + `/${serv.id}`
    return this.http.delete(url)
  }

  public editarServicio(serv: Servicio): Observable<any>{
    let url = environment.apiJava + this.endpoint + `/${serv.id}`
    return this.http.put(url, serv)
  }


  public nuevoServicio(serv: Servicio): Observable<any>{
    let url = environment.apiJava + this.endpoint 
    return this.http.post(url, serv)
  }
}
