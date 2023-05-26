/**
 * 
 */
 document.getElementById("archivo").addEventListener("change", function () {
            var archivo = this.files[0];
            if (!archivo || archivo.type.indexOf("image/png") === -1) {
                alert("File must be *.png");
                this.value = "";
            }
        });