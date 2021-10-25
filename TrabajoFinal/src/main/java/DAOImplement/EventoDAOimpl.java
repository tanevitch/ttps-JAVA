package DAOImplement;
import DAO.EventoDAO;
import model.Evento;


public class EventoDAOimpl extends BaseDAOimpl<Evento> implements EventoDAO{
	
	static Class<Evento> clase;
	public EventoDAOimpl() {
		super(clase);
	}
}
