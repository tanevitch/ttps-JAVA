package DAO;

import java.util.List;

public interface BaseDAO<T> {
	public T guardar(T base);
	
	public List<T> listar();
	
	public T editar(T base);
	
	public void eliminar(long id);
	
	public void recuperar(long id);
	
}
