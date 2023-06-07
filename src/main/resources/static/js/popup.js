/*
// Función para abrir el popup y mostrar un alert
function openPopup() {
    alert("¡Se abrió el popup!");
    // Aquí puedes agregar la lógica adicional para abrir el popup si es necesario
    // ...
}*/

// Obtener el elemento del popup
var popup = document.querySelector('.oferta__popup');

// Obtener el botón de ofertar
var btnOfertar = document.querySelector('.btn__Oferta');

// Función para abrir el popup
function openPopup() {
    popup.style.display = 'block';
}

// Función para cerrar el popup
function closePopup() {
    popup.style.display = 'none';
}

// Agregar el evento de clic al botón de ofertar
btnOfertar.addEventListener('click', openPopup);

// Agregar el evento de clic al botón de enviar dentro del popup (opcional)
var btnEnviar = popup.querySelector('button');
btnEnviar.addEventListener('click', function(event) {
    event.preventDefault();
    // Lógica para enviar la oferta (puedes agregar tu propia lógica aquí)
    // ...
    // Cerrar el popup después de enviar la oferta
    closePopup();
});

// Agregar el evento de clic al área exterior del popup para cerrarlo (opcional)
popup.addEventListener('click', function(event) {
    if (event.target === popup) {
        closePopup();
    }
});


/*
// Obtener el elemento del popup
var popup = document.getElementById('popup');

// Función para abrir el popup
function openPopup() {
    oferta__popup.style.display = 'block';
}

// Función para cerrar el popup
function closePopup() {
    popup.style.display = 'none';
}

// Agregar el evento de clic al botón de cerrar el popup
popup.addEventListener('click', function(event) {
    if (event.target === popup) {
        closePopup();
    }
});




/*
var buttons = document.getElementsByClassName("myButton");
var popups = document.getElementsByClassName("myPopup");

for (var i = 0; i < buttons.length; i++) {
  buttons[i].addEventListener("click", function() {
    var popup = this.nextElementSibling;
    popup.style.display = "block";
  });
}

var closeButtons = document.getElementsByClassName("close");

for (var i = 0; i < closeButtons.length; i++) {
  closeButtons[i].addEventListener("click", function() {
    var popup = this.parentNode.parentNode;
    popup.style.display = "none";
  });
}
//Hasta aca es para ocultar el popput



// Obtenemos el elemento de fecha
var fechaTurno = document.querySelector(".fecha-turno");

// Función para verificar si una fecha es sábado o domingo
function esFinDeSemana(fecha) {
  var dia = fecha.getDay();
  return dia === 6 || dia === 0; // 6 representa sábado, 0 representa domingo
}

// Función para verificar y deshabilitar fechas pasadas y fines de semana
function verificarFecha() {
  var fechaSeleccionada = new Date(fechaTurno.value);
  var fechaActual = new Date();
  fechaActual.setHours(0, 0, 0, 0); // Establecemos la hora actual a las 00:00:00
  
  if (fechaSeleccionada <= fechaActual || esFinDeSemana(fechaSeleccionada)) {
    fechaTurno.value = ""; // Limpiamos la fecha seleccionada
  }
}

// Establecemos la fecha mínima para seleccionar (mañana)
var fechaMinima = new Date();
fechaMinima.setDate(fechaMinima.getDate() + 1);
var mes = fechaMinima.getMonth() + 1; // Se suma 1 al mes, ya que en JavaScript los meses van de 0 a 11
var dia = fechaMinima.getDate();
if (mes < 10) mes = "0" + mes; // Agregamos un cero al mes si es necesario
if (dia < 10) dia = "0" + dia; // Agregamos un cero al día si es necesario
var fechaMinimaFormato = fechaMinima.getFullYear() + "-" + mes + "-" + dia;

// Recorremos todos los elementos con la clase "fecha-turno"
var elementosFechaTurno = document.querySelectorAll(".fecha-turno");
elementosFechaTurno.forEach(function(elemento) {
  elemento.min = fechaMinimaFormato;
  elemento.onchange = verificarFecha;
});
*/
