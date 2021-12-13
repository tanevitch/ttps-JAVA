import { ServicioService } from '../../../services/servicio.service';
import { Component, OnInit } from '@angular/core';

import { Servicio } from '../../../models/servicio/servicio';

@Component({
  selector: 'app-mis-servicios',
  templateUrl: './mis-servicios.component.html',
  styleUrls: ['../../../app.component.css'],
})
export class MisServiciosComponent implements OnInit {

  public listServicios: Array<Servicio> = [];

  constructor(private servicioService: ServicioService) { }

  ngOnInit(): void {
    this.obtenerMisServicios();
  }

  obtenerMisServicios(){
    this.servicioService.getMisServicios().subscribe(res =>{
        this.listServicios = res;
        console.log(res)
    })
  }

}
