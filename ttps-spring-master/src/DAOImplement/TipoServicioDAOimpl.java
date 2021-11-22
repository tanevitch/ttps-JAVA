package DAOImplement;
import org.springframework.stereotype.Repository;

import ttps.spring.model.TipoServicio;

@Repository
public class TipoServicioDAOimpl extends BaseDAOimpl<TipoServicio> {
		public TipoServicioDAOimpl() {
		super(TipoServicio.class);
	}
}
