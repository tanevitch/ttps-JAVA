import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-nuevo-servicio',
  templateUrl: './nuevo-servicio.component.html',
  styleUrls: ['../../../app.component.css'],
})
export class NuevoServicioComponent implements OnInit {
  servicio: FormGroup;
  ngOnInit() {
    this.servicio = new FormGroup({
      nombre: new FormControl('', [Validators.required]),
      tipo: new FormControl('', [Validators.required]),
      descripcion: new FormControl('', [Validators.required]),
      telefono: new FormControl('', [Validators.required]),
      facebook: new FormControl(''),
      instagram: new FormControl(''),
      twitter: new FormControl(''),
      foto: new FormControl(''),
      web: new FormControl('')
    });
  }
  constructor() { }

  onSubmit(){
    console.log(JSON.stringify(this.servicio.value))
  }
}
