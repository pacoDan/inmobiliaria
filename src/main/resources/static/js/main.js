//Para que se despliegue el menu
let listElements = document.querySelectorAll('.list__button--click');

listElements.forEach(listElement => {
    listElement.addEventListener('click', ()=>{
        
        listElement.classList.toggle('arrow');

        let height = 0;
        let menu = listElement.nextElementSibling;
        if(menu.clientHeight == "0"){
            height=menu.scrollHeight;
        }

        menu.style.height = `${height}px`;

    })
});

  function mostrarContMenu(opcion) {
    // Ocultar todos los contenidos
    var contenidos = document.getElementsByClassName('element');
    for (var i = 0; i < contenidos.length; i++) {
      contenidos[i].style.display = 'none';
    }
  
    // Mostrar el contenido correspondiente a la opción seleccionada
    var contenidoMostrado = document.getElementById('element__' + opcion);
    contenidoMostrado.style.display = 'block';
  }



// Obtén el botón de edición
var editButton = document.getElementById('editButton');

// Obtén el modal y los elementos relacionados
var modal = document.getElementById('myModal');
var closeButton = document.getElementsByClassName('close')[0];
var nameInput = document.getElementById('nameInput');
var ageInput = document.getElementById('ageInput');

// Agrega un manejador de eventos al botón de edición
editButton.addEventListener('click', function() {
  // Obtén los valores de la fila actual
  var row = this.parentNode.parentNode;
  var name = row.cells[0].innerText;
  var age = row.cells[1].innerText;
  
  // Actualiza los campos del modal con los valores de la fila
  nameInput.value = name;
  ageInput.value = age;
  
  // Muestra el modal
  modal.style.display = 'block';
});

// Agrega un manejador de eventos al botón de cerrar
//closeButton.addEventListener('click', function() {
  // Oculta el modal
  //modal.style.display = 'none';
//});

// Agrega un manejador de eventos al botón de guardar
document.getElementById('saveButton').addEventListener('click', function() {
  // Obtiene los nuevos valores de los campos
  var newName = nameInput.value;
  var newAge = ageInput.value;
  
  // Actualiza la fila actual con los nuevos valores
  var row = editButton.parentNode.parentNode;
  row.cells[0].innerText = newName;
  row.cells[1].innerText = newAge;
  
  // Oculta el modal
  modal.style.display = 'none';
});

