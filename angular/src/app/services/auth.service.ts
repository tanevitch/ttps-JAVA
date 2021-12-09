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
  public login(data: string){
    let url = environment.apiJava + this.endpoint;
    this.http.post<string>(url,data)
    .subscribe(
      data => {
        window.localStorage.setItem("token", data);
        window.location.href = "servicios"
      },
      error => {
        console.log("Error", error);
      }
      );

  }

  public logout(){
    window.localStorage.clear()
  }
}
