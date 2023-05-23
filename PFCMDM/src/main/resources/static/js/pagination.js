/**
 * 
 */
 
     document.addEventListener("DOMContentLoaded", function() {
        var urlParams = new URLSearchParams(window.location.search);
        var currentPage = urlParams.get("page");
        var prodElement = document.getElementById("prod");

        if (currentPage && prodElement) {
            setTimeout(function() {
                prodElement.scrollIntoView({ behavior: "smooth" });
            }, 1000);
        }
    });