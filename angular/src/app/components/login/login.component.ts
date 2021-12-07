import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Router} from "@angular/router"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['../../app.component.css']
})

export class LoginComponent implements OnInit {
  form: FormGroup;
  submitted = false;
  loading = false;
  constructor(private authService: AuthService, private fb: FormBuilder,private router: Router) { }

  get f() { return this.form.controls;}

  ngOnInit(): void {
  }

  onSubmit(){
    this.submitted = true

    this.authService.login()
  }
}
