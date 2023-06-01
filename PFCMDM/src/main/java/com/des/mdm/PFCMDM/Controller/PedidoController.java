package com.des.mdm.PFCMDM.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.des.mdm.PFCMDM.Service.PedidosService;
import com.des.mdm.PFCMDM.Service.Productos_pedidosService;
import com.des.mdm.PFCMDM.model.Productos_pedidos;

@Controller
public class PedidoController {

	@Autowired
	PedidosService pedidoService;
	
	@Autowired
	Productos_pedidosService prodsPedidoService;
	

}
