function mostrarVistaPrevia(event) {
    var input = event.target;
    var reader = new FileReader();
    var imagen = input.nextElementSibling;

    reader.onload = function (e) {
        imagen.src = e.target.result;
    };

    if (input.files && input.files[0]) {
        reader.readAsDataURL(input.files[0]);
    }
}

var inputs = document.querySelectorAll('.imagenInput');
inputs.forEach(function (input) {
    input.addEventListener('change', mostrarVistaPrevia);
});





