package DAOImplement;
import DAO.ReservaDAO;
import model.Reserva;

public class ReservaDAOimpl extends BaseDAOimpl<Reserva> implements ReservaDAO{
	
	static Class<Reserva> clase;
	public ReservaDAOimpl() {
		super(clase);
	}

}
