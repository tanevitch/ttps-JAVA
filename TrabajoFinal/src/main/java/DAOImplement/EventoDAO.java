package DAOImplement;

import DAO.BaseDAO;
import model.Evento;
import model.Usuario;

public class EventoDAO extends BaseDAOimpl<Evento>{
	static Class<Evento> clase;
	public EventoDAO() {
		super(clase);
	}
}
