package DAOImplement;
import DAO.TipoServicioDAO;
import model.TipoServicio;

public class TipoServicioDAOimpl extends BaseDAOimpl<TipoServicio> implements TipoServicioDAO{
	
	static Class<TipoServicio> clase;
	public TipoServicioDAOimpl() {
		super(clase);
	}
}
