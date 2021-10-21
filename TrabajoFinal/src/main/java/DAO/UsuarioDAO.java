package DAO;

import java.util.List;

import model.Servicio;
import model.Usuario;

public interface UsuarioDAO {
	public void guardar(Usuario usuario);
	
	public List<Usuario> listar();
	
	public void editar(Usuario usuario);
	
	public void eliminar(Usuario usuario);
	
}
