package com.des.mdm.PFCMDM.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.des.mdm.PFCMDM.Service.PedidosService;
import com.des.mdm.PFCMDM.Service.Productos_pedidosService;
import com.des.mdm.PFCMDM.Service.UserService;
import com.des.mdm.PFCMDM.model.Pedidos;
import com.des.mdm.PFCMDM.model.Productos_pedidos;

@Controller
public class CarritoController {

	@Autowired
	UserService userService;
	
	@Autowired
	PedidosService pedidosService;
	
	@Autowired
	Productos_pedidosService prodsPedService;
	
	@GetMapping("/cart")
	public String register(Model model) {
		List<Productos_pedidos> prodPed = RestCartController.carrito;
		
		model.addAttribute("prods", prodPed);
		model.addAttribute("total", RestCartController.totalPrice());
		return "products/cart";
	}
	
	@GetMapping("/completeCart")
	public String completeCart(Authentication authentication) {
		Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatedDate = dateFormat.format(date);

        String orderNumber = formatedDate.replace(" ", "").replace("-", "").replace(":", "");
        
		Pedidos pedido = new Pedidos();
		pedido.setNumero_de_orden(orderNumber);
		pedido.setUsuario(userService.findUser(authentication.getName()));
		pedido.setFecha_de_compra(date);
		pedidosService.savePedido(pedido);
		
		
		List<Productos_pedidos> prodPed = RestCartController.carrito;
		for(Productos_pedidos peds : prodPed) {
			peds.setPedido(pedido);
			prodsPedService.savePedProd(peds);
		}
		
		
		
		return "redirect:/cart";
	}
}
