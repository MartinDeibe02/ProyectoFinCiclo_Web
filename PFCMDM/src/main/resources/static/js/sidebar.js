/**
 * 
 */
         window.onload = function () {
            const sidebar = document.querySelector(".sidebar");
            const closeBtn = document.querySelector("#btn");

            closeBtn.addEventListener("click", function () {
                sidebar.classList.toggle("open")
            })

        }