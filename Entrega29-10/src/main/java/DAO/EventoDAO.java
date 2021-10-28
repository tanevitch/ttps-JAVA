package DAO;

import java.util.List;

import model.Evento;

public interface EventoDAO extends BaseDAO<Evento>{
	public List<Evento> buscarEventoPorNombre(String nombre); 
}
