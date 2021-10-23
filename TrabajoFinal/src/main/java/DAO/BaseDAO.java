package DAO;

import java.util.List;

public interface BaseDAO<T> {
	public T guardar(T base);
	
	public List<T> listar();
	
	public void editar(T base);
	
	public void eliminar(T base);
	
	public void recuperar(int id);
	
}
