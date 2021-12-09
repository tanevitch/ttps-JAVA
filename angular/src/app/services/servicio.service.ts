import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { Servicio } from '../models/servicio/servicio';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ServicioService {


  endpoint: string = 'servicios'
  constructor(private http: HttpClient) { }
  
  public getServicios(): Observable<Array<Servicio>>{
    let url = environment.apiJava + this.endpoint;
    return this.http.get<Array<Servicio>>(url, {
      headers: {
        Authorization: `Bearer ${window.localStorage.getItem("token")}`
      }
    });
  }
}