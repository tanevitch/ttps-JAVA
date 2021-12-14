import { ServicioService } from '../../../services/servicio.service';
import { Component, OnInit } from '@angular/core';

import { Servicio } from '../../../models/servicio/servicio';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mis-servicios',
  templateUrl: './mis-servicios.component.html',
  styleUrls: ['../../../app.component.css'],
})
export class MisServiciosComponent implements OnInit {

  public existenServ: boolean = false;
  public listServicios: Array<Servicio> = [];
  

  constructor(private servicioService: ServicioService, private router: Router) { }

  ngOnInit(): void {
    this.obtenerMisServicios();
  }

  obtenerMisServicios(){
    this.servicioService.getMisServicios().subscribe(res =>{
      this.listServicios = res;
    })
    if(this.listServicios.length > 0){
      this.existenServ = true
    }
}

  borrarServicio(serv: Servicio){
    if (confirm('¿Está seguro que desea borrar el servicio?')){
      this.servicioService.borrarServicio(serv).subscribe(()=> {this.obtenerMisServicios()})
    }


  }

  editarServicio(serv: Servicio){
    this.router.navigate([`servicios/editar/${serv.id}`])
  }

}
