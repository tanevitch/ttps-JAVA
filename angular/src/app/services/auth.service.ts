import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  endpoint: string = 'login'


  constructor(private http: HttpClient, private router: Router) { }
  public login(data: string){
    let url = environment.apiJava + this.endpoint;
    this.http.post<string>(url,data)
    .subscribe(
      data => {
        window.localStorage.setItem("token", data);
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

  public existeToken(){
    return window.localStorage.getItem("token") != null
  }

}
