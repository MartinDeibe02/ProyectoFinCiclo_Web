package com.des.mdm.PFCMDM.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.des.mdm.PFCMDM.Service.Productos_pedidosService;
import com.des.mdm.PFCMDM.model.ProductoPedidoDTO;
import com.des.mdm.PFCMDM.model.Productos_pedidos;

@RestController
@RequestMapping("/api")
public class RestPedidosAdmin {

	
	@Autowired
	Productos_pedidosService prodsPedidoService;
	
	@GetMapping("/admin/pedido/{idPedido}")
	public List<ProductoPedidoDTO> obtenerProductosPorIdPedido(@PathVariable("idPedido") int idPedido, Model model) {
	    List<Productos_pedidos> pedido = prodsPedidoService.findByIdPed(idPedido);
        List<ProductoPedidoDTO> productoPedidoDTOs = new ArrayList<>();
        int total=0;
        
        if(pedido.isEmpty()){
            ProductoPedidoDTO dto = new ProductoPedidoDTO();
        	dto.setNombreProducto("Empty order or deleted products");
            productoPedidoDTOs.add(dto);

        }{
        
	    for (Productos_pedidos productoPedido : pedido) {
	    	System.out.println(productoPedido);
	    	

	    	
            ProductoPedidoDTO dto = new ProductoPedidoDTO();
            dto.setId(productoPedido.getId());
            dto.setNombreProducto(productoPedido.getProduct().getNombre());
            dto.setCantidad(productoPedido.getCantidad());
            dto.setPrecio(productoPedido.getPrecio());
        	total += dto.getPrecio();
        	dto.setTotalPrice(total);
            productoPedidoDTOs.add(dto);
            
        }
	    }

        return productoPedidoDTOs;
	}
}
