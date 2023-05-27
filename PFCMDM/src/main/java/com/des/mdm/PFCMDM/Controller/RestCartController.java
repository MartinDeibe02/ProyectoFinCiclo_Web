package com.des.mdm.PFCMDM.Controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.des.mdm.PFCMDM.Service.ProductService;
import com.des.mdm.PFCMDM.model.Product;
import com.des.mdm.PFCMDM.model.Productos_pedidos;

@RestController
public class RestCartController {
	
	static List<Productos_pedidos> carrito = new ArrayList<>();
	
	@Autowired
	ProductService prodService;
	
    @PostMapping("/buy")
    public void buyProduct(@RequestBody String prodName) throws UnsupportedEncodingException {
        System.out.println(prodName);
        
        Product prod = prodService.findById(Integer.parseInt(prodName));
        
        System.out.println(prod);
        
        Productos_pedidos prod_ped = new Productos_pedidos();
        prod_ped.setProduct(prod);
        boolean productoRepetido = false;
        int contador = 1;
        
        for (Productos_pedidos prodRep : carrito) {
            if (prod.getId().equals(prodRep.getProduct().getId())) {
                productoRepetido = true;
                prod_ped = prodRep;
                contador++;
            }
        }

        if (productoRepetido) {
            	
                System.out.println("El producto ya está en el carrito " + contador);
                prod_ped.setCantidad(contador);
                System.out.println("CANT" + prod_ped.getCantidad());
            	prod_ped.setPrecio(prod.getPrecio()*contador);
        	
            }else {
            	System.out.println("El producto no está en el carrito.");
            	prod_ped.setCantidad(1);
            	prod_ped.setPrecio(prod.getPrecio());
                carrito.add(prod_ped);
            }
        
        System.out.println(carrito);
        }
        
        public static int totalPrice() {
        	int total = 0;
            for (Productos_pedidos prodRep : carrito) {
            	total += prodRep.getPrecio();
            }
            return total;
        }
    }

