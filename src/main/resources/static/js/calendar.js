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
