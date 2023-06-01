/**
 * 
 */
 window.addEventListener("DOMContentLoaded", function(event) {
	     	  var selectedId = null;

    	  $('.table tbody tr').click(function () {
    		$('.table tbody tr').removeClass('table-dark');
    	    selectedId = $(this).find('td').data('id');
    	    $(this).addClass('table-dark');
    	    console.log('ID ', selectedId);
    	  });

    	  $('.crud').click(function () {
    	    var action = $(this).data('action');
    	    var url = '';

    	    if (selectedId !== null) {
    	      	if (action === 'edit') {
    	        url = '/admin/editBrand/' + selectedId;
    	      } else if (action === 'delete') {
    	        url = '/admin/deleteBrand/' + selectedId;
    	      }
    	    }
    	     window.location.href = url;
    	    console.log('URL ', url);
    	  });
    	});