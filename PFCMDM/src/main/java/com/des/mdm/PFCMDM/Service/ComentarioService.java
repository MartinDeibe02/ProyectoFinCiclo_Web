package com.des.mdm.PFCMDM.Service;

import java.util.List;

import com.des.mdm.PFCMDM.model.Comentarios;
import com.des.mdm.PFCMDM.model.Product;

public interface ComentarioService {
	List<Comentarios> findComentarios();
	void saveComent(Comentarios coment);
	List<Comentarios> findComentarios_Prod(Product product);

}
