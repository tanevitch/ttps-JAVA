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
  id= window.location.pathname.split("/").pop()
  servicio: FormGroup;
  tiposervicios: any
  tipoActual: any

  ngOnInit() {
    this.tipoServicioService.getCategorias().subscribe(res =>{
      this.tiposervicios= res;
    })
    
    this.servicio = new FormGroup({
      nombre: new FormControl('', [Validators.required]),
      tipoServicio: new FormControl('', [Validators.required]),
      descripcion: new FormControl('', [Validators.required]),
      whatsapp: new FormControl('', [Validators.required]),
      facebook: new FormControl(''),
      instagram: new FormControl(''),
      twitter: new FormControl(''),
      foto: new FormControl(''),
      web: new FormControl('')
    });

    this.servicioService.getServicioConId(this.id).subscribe( res => {
      this.tipoActual = res.tipoServicio
      this.servicio.patchValue(res)
    })
  }
  constructor(private authService: AuthService, private tipoServicioService: TipoServicioService, private servicioService: ServicioService) { }

  onSubmit(){
    var datos= this.servicio.value
    datos["id"]= this.id
    datos["usuario"] = {
      id: this.authService.obtenerIdUsuario()
    }
    datos["tipoServicio"]={
      id: datos["tipoServicio"].id  
    }
    console.log(datos)
    this.servicioService.editarServicio(datos).subscribe(
      (res: any) => {
        console.log(res)
      }
    )

  }
}
