package DAO;

import model.Usuario;

public interface UsuarioDAO extends BaseDAO<Usuario> {
	public Usuario buscarUsuarioPorMail(String email);
	public Usuario buscarUsuarioPorId(long id);
}
