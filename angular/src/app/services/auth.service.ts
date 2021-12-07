import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  endpoint: string = 'login'
  constructor(private http: HttpClient) { }
  public login(){
    let url = environment.apiJava + this.endpoint;
    this.http.post<string>(url,
      {
        "mail": "juanperez@gmail.com",
        "contrasena": "12345"
      }
      ).subscribe(res =>{
      console.log(res)
      localStorage.setItem("token", res);
    })

  }
}
