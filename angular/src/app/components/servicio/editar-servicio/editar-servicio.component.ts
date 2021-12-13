import { Component, OnInit } from '@angular/core';
import { FormControl,FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-editar-servicio',
  templateUrl: './editar-servicio.component.html',
  styleUrls: ['../../../app.component.css'],
})
export class EditarServicioComponent implements OnInit {
  servicioData = 
    {
      nombre: "Pipo y Pipa", 
      tipo: "Catering",
      descripcion: "lorem Ipsum",
      telefono: "2213334444", 
      facebook: "",
      twitter: "",
      instagram: "",
      web: ""
    }
  ;
  servicio: FormGroup;
  ngOnInit() {

    this.servicio = new FormGroup({
      nombre: new FormControl(this.servicioData.nombre, [Validators.required]),
      tipo: new FormControl(this.servicioData.tipo, [Validators.required]),
      descripcion: new FormControl(this.servicioData.descripcion, [Validators.required]),
      telefono: new FormControl(this.servicioData.telefono, [Validators.required]),
      facebook: new FormControl(this.servicioData.facebook),
      instagram: new FormControl(this.servicioData.instagram),
      twitter: new FormControl(this.servicioData.twitter),
      foto: new FormControl(''),
      web: new FormControl(this.servicioData.web)
    });
  }
  constructor(private fb: FormBuilder) { }

  onSubmit(){
    console.log(JSON.stringify(this.servicio.value))
  }
}
