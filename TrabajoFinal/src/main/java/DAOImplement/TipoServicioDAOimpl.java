package DAOImplement;

import DAO.BaseDAO;
import model.TipoServicio;
import model.Usuario;

public class TipoServicioDAOimpl extends BaseDAOimpl<TipoServicio> {
	static Class<TipoServicio> clase;
	public TipoServicioDAOimpl() {
		super(clase);
	}
}
