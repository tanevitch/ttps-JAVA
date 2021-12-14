import { Component, OnInit } from '@angular/core';
import { FormControl,FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { ServicioService } from 'src/app/services/servicio.service';
import { TipoServicioService } from 'src/app/services/tiposervicio.service';

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
    this.servicioService.getServicioConId(1).subscribe( res => console.log(res))
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
  constructor(private authService: AuthService, private tipoServicioService: TipoServicioService, private servicioService: ServicioService) { }

  onSubmit(){
    var datos= this.servicio.value
    datos["usuario"] = {
      id: this.authService.obtenerIdUsuario()
    }
    datos["tipoServicio"]={
      id: datos["tipoServicio"]
    }
    this.servicioService.editarServicio(datos).subscribe(
      (      res: any) => {
        console.log(res)
      }
    )

  }
}
