/**
 * 
 */
$(document).ready(function () {
    function handleScreenResize() {
        var windowWidth = $(window).width();
        if (windowWidth >= 1000) {
            $('.nba-store').removeClass('d-none');
            $('.navbar-collapse').removeClass('show');
            $('.navbar-toggler').attr('aria-expanded', 'false');

        } else {

            $('.navbar-toggler').click(function () {
                if ($(this).attr('aria-expanded') == 'true') {

                    setTimeout(function () {
                        
                        $('.nba-store').removeClass('d-none');
                    }, 200);
                } else {

                    $('.nba-store').addClass('d-none');
                }
            });
        }
    }

    handleScreenResize(); 

    $(window).resize(handleScreenResize); 
});