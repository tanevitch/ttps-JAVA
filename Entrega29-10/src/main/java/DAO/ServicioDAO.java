package DAO;

import java.util.List;

import model.Servicio;

public interface ServicioDAO extends BaseDAO<Servicio>{
	public List<Servicio> buscarServicioPorNombre(String nombre);
	public List<Servicio> buscarServicioPorCategoria(String categoria);
}
