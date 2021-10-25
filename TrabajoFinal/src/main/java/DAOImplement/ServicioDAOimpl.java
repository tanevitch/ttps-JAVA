package DAOImplement;
import DAO.ServicioDAO;
import model.Servicio;


public class ServicioDAOimpl extends BaseDAOimpl<Servicio> implements ServicioDAO{
	
	static Class<Servicio> clase;
	public ServicioDAOimpl() {
		super(clase);
	}

}
