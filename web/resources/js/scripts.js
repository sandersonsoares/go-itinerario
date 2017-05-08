$(document).ready(function () {
    $(".button-collapse").sideNav();
    $('.slider').slider();
     $('.tooltipped').tooltip({delay: 50});
    $('select').material_select();
    $('.carousel.carousel-slider').carousel({ fullWidth: true });
    $('.carousel.carousel-slider').carousel({
        padding: 200
    });
    autoplay()
    function autoplay() {
        $('.carousel.carousel-slider').carousel('next');
        setTimeout(autoplay, 3500);
    }
})

jQuery(function($){
		$("#tele").mask("(99) 9999-9999");
		$("#cpf").mask("999.999.999-99");
		$("#cnpj").mask("99.999.999/9999-99");
		$("#datven").mask("99/99/9999");
		$("#valpri").maskMoney({symbol:"R$",decimal:",",thousands:"."});
		$("#valjur").maskMoney({symbol:"R$",decimal:",",thousands:"."});
		$("#valmul").maskMoney({symbol:"R$",decimal:",",thousands:"."});	
		});