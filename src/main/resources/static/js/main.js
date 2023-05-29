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

