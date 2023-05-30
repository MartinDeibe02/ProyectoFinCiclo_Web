package com.des.mdm.PFCMDM.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.des.mdm.PFCMDM.Service.PermisosService;
import com.des.mdm.PFCMDM.model.Pedidos;
import com.des.mdm.PFCMDM.model.Permisos;
import com.des.mdm.PFCMDM.repository.PermisosRepository;

@Service
public class PermisosServiceImpl implements PermisosService{
	
	@Autowired
	PermisosRepository permisosrepository;
	
	@Override
	public Permisos findById(int perm) {
		Optional<Permisos> pedidodOp = permisosrepository.findById(perm);
		Permisos permiso = new Permisos();
		if(pedidodOp.isPresent()) {
			permiso = pedidodOp.get();
		}
		return permiso;
	}

}
