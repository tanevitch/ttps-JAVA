import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Auth } from '../models/auth/auth';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  endpoint: string = 'login'


  constructor(private http: HttpClient, private router: Router) { }
  public login(data: string){
    let url = environment.apiJava + this.endpoint;
    this.http.post<Auth>(url,data)
    .subscribe(
      data => {
        window.localStorage.setItem("email", data.email);
        window.localStorage.setItem("id_usuario", data.user_id);        
        window.localStorage.setItem("token", data.token);                
        this.router.navigate(["servicios"])
      },
      error => {
        if (error.status == "400" || error.status == "401"){
          alert(error.error);
        }
        else{
          alert("Ocurrió un error")
        }
      }
      );

  }

  public logout(){
    window.localStorage.clear()
    this.router.navigate([""])
  }

  public obtenerToken(){
    return  window.localStorage.getItem("token")
  }

  public existeToken(){
    return this.obtenerToken() != null
  }


}
