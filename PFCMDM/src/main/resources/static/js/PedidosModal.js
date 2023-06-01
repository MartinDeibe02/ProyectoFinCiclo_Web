/**
 * 
 */

  function openModal(link) {

			   var modalTotalElement = document.getElementById("modalTotal");
	 		  var pedidoId = link.getAttribute("data-id");
			  var modalIdElement = document.getElementById("modalId");
			  var modalTableBody = document.getElementById("modalTableBody");
			  
			   var xhr = new XMLHttpRequest();
			   xhr.open("GET", "/api/admin/pedido/" + pedidoId, true);
			   xhr.onreadystatechange = function() {
			      if (xhr.readyState === 4 && xhr.status === 200) {
			    	  
			    	  var total = "";
			         var productosPedidos = JSON.parse(xhr.responseText);
	
			         productosPedidos.forEach(function(productoPedido) {
					    var row = document.createElement("tr");
					
					    var productoCell = document.createElement("td");
					    productoCell.textContent = productoPedido.nombreProducto;
					    row.appendChild(productoCell);
					
					    var cantidadCell = document.createElement("td");
					    cantidadCell.textContent = productoPedido.cantidad;
					    row.appendChild(cantidadCell);
					
					    var precioCell = document.createElement("td");
					    precioCell.textContent = productoPedido.precio;
					    row.appendChild(precioCell);
								             total = productoPedido.totalPrice;

					    modalTableBody.appendChild(row);
					  });
			             
			         
			         modalTotalElement.textContent = "Total: " + total;

			         document.getElementById("myModal").style.display = "block";
			      }
			   };
			   xhr.send();
			}
		    function closeModal() {
		      var modal = document.getElementById("myModal");
		      modal.style.display = "none";
		    }