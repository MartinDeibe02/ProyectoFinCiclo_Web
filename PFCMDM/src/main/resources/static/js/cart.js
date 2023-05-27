/**
 * 
 */
$(document).ready(function() {
        $(".buy").click(function() {
            var productId = $(this).data("product-id");
            comprarProducto(productId);
        });
        
        $(".completeCart").click(function() {
            complete();
        });
    });

    function comprarProducto(productId) {
        $.ajax({
            type: "POST",
            url: "/buy",
            data: productId.toString(),
            contentType: "text/plain",
            success: function() {
            	console.log("Producto comprado: " + productId);
            },
            error: function() {
                console.log("Error al comprar el producto");
            }
        });
    }
    
