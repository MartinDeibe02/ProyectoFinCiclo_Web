/**
 * 
 */
          window.addEventListener("DOMContentLoaded", function(event) {
            const sidebar = document.querySelector(".sidebar");
            const closeBtn = document.querySelector("#btn");

            closeBtn.addEventListener("click", function () {
                sidebar.classList.toggle("open")
            })

        });