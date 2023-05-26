package com.des.mdm.PFCMDM.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.des.mdm.PFCMDM.Service.ComentarioService;
import com.des.mdm.PFCMDM.model.Comentarios;
import com.des.mdm.PFCMDM.model.Product;
import com.des.mdm.PFCMDM.repository.ComentarioRepository;

@Service
public class ComentarioServiceImpl implements ComentarioService {

	@Autowired
	ComentarioRepository comentarioRepo;
	
	@Override
	public List<Comentarios> findComentarios() {
		return comentarioRepo.findAll();
	}

	@Override
	public void saveComent(Comentarios coment) {
		comentarioRepo.save(coment);
	}

	@Override
	public List<Comentarios> findComentarios_Prod(Product product) {
		return comentarioRepo.findByProducto(product);
	}
	
	

}
