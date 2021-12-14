import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../../services/usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['../../../app.component.css'],
})
export class PerfilComponent implements OnInit {
  usuarioData = 
  {
    nombre: "", 
    apellido: "",
    mail: "",
    contrasena:""
  }

  constructor(private usuarioService: UsuarioService, private router: Router) { }

  ngOnInit(): void {
    this.usuarioService.getDatos().subscribe(data => {
      this.usuarioData.nombre = data.nombre;
      this.usuarioData.apellido = data.apellido;
      this.usuarioData.mail = data.mail;
    })

    console.log(this.usuarioData);
  }

  onSubmit(data: string) {
    this.usuarioService.editarDatos(data).subscribe(
      res => {
        alert("Usuario editado correctamente");
        this.router.navigate(["dashboard"])
      },
      error => {
        alert("Ocurrió un error, intente nuevamente")
      }
    )
  }
}
