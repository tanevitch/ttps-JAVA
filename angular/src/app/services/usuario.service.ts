import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Usuario } from '../models/usuario/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  endpoint: string = 'usuarios'
  constructor(private http: HttpClient) { }

  public registrar(data: string): Observable<Usuario>{
    let url = environment.apiJava + this.endpoint;
    return this.http.post<Usuario>(url, data);
  }
}
