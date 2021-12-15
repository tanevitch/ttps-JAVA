import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Auth } from '../models/auth/auth';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  endpoint: string = 'login'


  simpleAlert(){
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'Ocurrió un error!',
    })
  }

  errorLogin(error: any){
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: error,
    })
  }

  constructor(private http: HttpClient, private router: Router) { }
  public login(data: string){
    let url = environment.apiJava + this.endpoint;
    this.http.post<Auth>(url,data)
    .subscribe(
      data => {
        window.localStorage.setItem("email", data.email);
        window.localStorage.setItem("id_usuario", data.user_id);
        window.localStorage.setItem("token", data.token);
        this.router.navigate(["dashboard"])
      },
      error => {
        if (error.status == "400" || error.status == "401"){
          this.errorLogin(error.error);
        }
        else{
          this.simpleAlert()
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

  public obtenerIdUsuario(){
    return  window.localStorage.getItem("id_usuario")
  }

  public existeToken(){
    return this.obtenerToken() != null
  }


}
