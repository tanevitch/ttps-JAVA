import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { ServicioService } from 'src/app/services/servicio.service';
import { TipoServicioService } from 'src/app/services/tiposervicio.service';

@Component({
  selector: 'app-nuevo-servicio',
  templateUrl: './nuevo-servicio.component.html',
  styleUrls: ['../../../app.component.css'],
})
export class NuevoServicioComponent implements OnInit {
  servicio: FormGroup;
  tiposervicios: any

  ngOnInit() {
    this.tipoServicioService.getCategorias().subscribe(res =>{
      this.tiposervicios= res;
    })
    this.servicio = new FormGroup({
      nombre: new FormControl('', [Validators.required]),
      tipoServicio: new FormControl(this.tiposervicios, [Validators.required]),
      descripcion: new FormControl('', [Validators.required]),
      whatsapp: new FormControl('', [Validators.required]),
      facebook: new FormControl(''),
      instagram: new FormControl(''),
      twitter: new FormControl(''),
      foto: new FormControl(''),
      web: new FormControl('')
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
    this.servicioService.nuevoServicio(datos).subscribe(res =>{
      console.log(res)
    })
  }
}
