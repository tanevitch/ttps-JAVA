export class Servicio {
  public id: number;
  public borrado: boolean;
  public descripcion: string;
  public instagram: string;
  public nombre: string;
  public twitter: string;
  public url: string;
  public whatsapp: string;
  public tipoServicio_id: number;
  public usuario_id: number;

constructor (id: number, borrado: boolean, descripcion: string,
             instagram: string, nombre: string, twitter: string,
             url: string, whatsapp: string, tipoServicio_id: number, usuario_id: number,){
  this.id = id;
  this.borrado = borrado;
  this.descripcion = descripcion;
  this.instagram = instagram;
  this.nombre = nombre;
  this.twitter = twitter;
  this.url = url;
  this.whatsapp = whatsapp;
  this.tipoServicio_id = tipoServicio_id;
  this.usuario_id = usuario_id;
}
}
