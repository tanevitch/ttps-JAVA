import { Servicio } from './../../../models/servicio/servicio';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { ServicioService } from 'src/app/services/servicio.service';
import { TipoServicioService } from 'src/app/services/tiposervicio.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

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
  constructor(private authService: AuthService, private tipoServicioService: TipoServicioService, private servicioService: ServicioService,  private router: Router) { }


  confirmTest(datos: any){

    Swal.fire({
      title: '¿Está seguro que desea crear este servicio?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Crear',
      cancelButtonText: 'Cancelar',
      reverseButtons: false
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          '¡Listo!',
          'Tu servicio ha sido creado.',
          'success'
        )
        this.servicioService.nuevoServicio(datos).subscribe(res =>{
          this.router.navigate(["servicios"]);

          });
      }
    })
  }


  confirmNew(datos: any){
    Swal.fire({
      title: '¿Está seguro que desea crear este servicio?',
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: 'Save',
      denyButtonText: `Don't save`,
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        this.servicioService.nuevoServicio(datos).subscribe(res =>{
          this.router.navigate(["servicios"]);

          });
      } else if (result.isDenied) {
        Swal.fire('Changes are not saved', '', 'info')
      }
    })
  }
  onSubmit(){
    var datos= this.servicio.value
    datos["usuario"] = {
      id: this.authService.obtenerIdUsuario()
    }
    datos["tipoServicio"]={
      id: datos["tipoServicio"]
    }
    this.confirmTest(datos)

    }

  }

