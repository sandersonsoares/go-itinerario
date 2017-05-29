$(document).ready(function () {
    $(".button-collapse").sideNav();
    $('.slider').slider();
    $('.tooltipped').tooltip({delay: 50});
    $('select').material_select();
    $('.modal').modal();
    $('.carousel.carousel-slider').carousel({fullWidth: true});
    $('.carousel.carousel-slider').carousel({
        padding: 200
    });
    autoplay()
    function autoplay() {
        $('.carousel.carousel-slider').carousel('next');
        setTimeout(autoplay, 3500);
    }

    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 15 // Creates a dropdown of 15 years to control year
    });



})


function abrirDialog($nomeDialog) {
    $($nomeDialog).modal('open');
}

function abrirDialog($nomeDialog) {
    $($nomeDialog).modal('close');
}