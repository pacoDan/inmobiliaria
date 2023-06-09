function funcC(usuarios){
    alert("i am box");
    var us=usuarios;
    usuarios.forEach(function(usuario) {
        console.log("ID: " + usuario.id);
        console.log("Nombre: " + usuario.nombre);
        console.log("Email: " + usuario.email);
    });
}

/*

document.addEventListener("DOMContentLoaded", function() {
/*
    console.log(usuarios); // Verifica si los datos de usuarios se están pasando correctamente

    usuarios.forEach(function(usuario) {
        console.log("ID: " + usuario.id);
        console.log("Nombre: " + usuario.nombre);
        console.log("Email: " + usuario.email);
    }); borrar
    // Establecer la cantidad de filas por defecto
    var elementosPorPagina = 10;

    // Obtener el elemento select
    var selectElement = document.getElementById("cantFilas");

    // Establecer el valor seleccionado por defecto en el select
    selectElement.value = elementosPorPagina;

    // Actualizar la tabla y los botones de navegación
    actualizarTabla();
    actualizarBotonesNavegacion();
});

function actualizarTabla() {


    // Obtener la cantidad de filas seleccionada
    var selectElement = document.getElementById("cantFilas");
    var elementosPorPagina = parseInt(selectElement.value);

    // Obtener el cuerpo de la tabla
    var tableBody = document.getElementById("tableBody");

    // Limpiar el cuerpo de la tabla
    tableBody.innerHTML = "";

    // Obtener la lista completa de elementos
    var listaElementos = obtenerListaElementos();

    // Obtener la página actual y la cantidad total de páginas
    var currentPage = parseInt(localStorage.getItem("currentPage")) || 1;
    var totalPages = Math.ceil(listaElementos.length / elementosPorPagina);

    // Calcular el índice de inicio y fin de los elementos en la página actual
    var startIndex = (currentPage - 1) * elementosPorPagina;
    var endIndex = Math.min(startIndex + elementosPorPagina, listaElementos.length);

    // Agregar las filas a la tabla
    for (var i = startIndex; i < endIndex; i++) {
        var elemento = listaElementos[i];
        var row = tableBody.insertRow();

        // Insertar las celdas con los datos del elemento
        var cellId = row.insertCell();
        cellId.innerText = elemento.id;

        var cellNombre = row.insertCell();
        cellNombre.innerText = elemento.nombre;

        var cellEmail = row.insertCell();
        cellEmail.innerText = elemento.email;

        var cellAcciones = row.insertCell();
        var editarLink = document.createElement("a");
        editarLink.href = "/editar/" + elemento.id;
        editarLink.innerText = "Editar";
        editarLink.className = "btn btn-editar";
        cellAcciones.appendChild(editarLink);

        var eliminarLink = document.createElement("a");
        eliminarLink.href = "/eliminar/" + elemento.id;
        eliminarLink.innerText = "Eliminar";
        eliminarLink.className = "btn btn-eliminar";
        cellAcciones.appendChild(eliminarLink);
    }
}

/*
function actualizarTabla() {
    // Obtener la cantidad de filas seleccionada
    var selectElement = document.getElementById("cantFilas");
    var elementosPorPagina = parseInt(selectElement.value);

    // Obtener el cuerpo de la tabla
    var tableBody = document.getElementById("tableBody");

    // Limpiar el cuerpo de la tabla
    tableBody.innerHTML = "";

    // Obtener la lista completa de elementos
    var listaElementos = obtenerListaElementos();

    // Obtener la página actual y la cantidad total de páginas
    var currentPage = parseInt(localStorage.getItem("currentPage")) || 1;
    var totalPages = Math.ceil(listaElementos.length / elementosPorPagina);

    // Calcular el índice de inicio y fin de los elementos en la página actual
    var startIndex = (currentPage - 1) * elementosPorPagina;
    var endIndex = Math.min(startIndex + elementosPorPagina, listaElementos.length);

    // Agregar las filas a la tabla
    for (var i = startIndex; i < endIndex; i++) {
        var row = tableBody.insertRow();
        var cell = row.insertCell();
        cell.innerHTML = "Elemento " + listaElementos[i];
    }
}
//Fin actualizartabla
function actualizarBotonesNavegacion() {
    // Obtener el contenedor de los botones de navegación
    var pagination = document.getElementById("pagination");

    // Limpiar los botones de navegación
    pagination.innerHTML = "";

    // Obtener la lista completa de elementos
    var listaElementos = obtenerListaElementos();

    // Obtener la cantidad de filas seleccionada
    var selectElement = document.getElementById("cantFilas");
    var elementosPorPagina = parseInt(selectElement.value);

    // Obtener la página actual y la cantidad total de páginas
    var currentPage = parseInt(localStorage.getItem("currentPage")) || 1;
    var totalPages = Math.ceil(listaElementos.length / elementosPorPagina);

    // Agregar botón de retroceso
    var backButton = document.createElement("button");
    backButton.innerText = "Anterior";
    backButton.disabled = currentPage === 1;
    backButton.addEventListener("click", function() {
        if (currentPage > 1) {
            currentPage--;
            localStorage.setItem("currentPage", currentPage);
            actualizarTabla();
            actualizarBotonesNavegacion();
        }
    });
    pagination.appendChild(backButton);

    // Agregar botón central con puntos suspensivos y label
    if (totalPages > 3) {
        var dotsButton = document.createElement("button");
        dotsButton.className = "dots-button";
        dotsButton.addEventListener("click", function() {
            var inputLabel = document.createElement("input");
            inputLabel.type = "number";
            inputLabel.min = 1;
            inputLabel.max = totalPages;
            inputLabel.value = currentPage;
            inputLabel.addEventListener("keydown", function(event) {
                if (event.keyCode === 13) { // Presionar Enter
                    var pageNumber = parseInt(this.value);
                    if (pageNumber >= 1 && pageNumber <= totalPages) {
                        currentPage = pageNumber;
                        localStorage.setItem("currentPage", currentPage);
                        actualizarTabla();
                        actualizarBotonesNavegacion();
                    }
                }
            });
            this.innerHTML = "";
            this.appendChild(inputLabel);
            inputLabel.focus();
        });
        dotsButton.innerText = "...";
        pagination.appendChild(dotsButton);
    }

    // Agregar botón de avance
    var nextButton = document.createElement("button");
    nextButton.innerText = "Siguiente";
    nextButton.disabled = currentPage === totalPages;
    nextButton.addEventListener("click", function() {
        if (currentPage < totalPages) {
            currentPage++;
            localStorage.setItem("currentPage", currentPage);
            actualizarTabla();
            actualizarBotonesNavegacion();
        }
    });
    pagination.appendChild(nextButton);
}

function obtenerListaElementos() {
    var listaElementos = [];

    usuarios.forEach(function(usuario) {
        var elemento = {
            id: usuario.id,
            nombre: usuario.nombre,
            email: usuario.email
        };

        listaElementos.push(elemento);
    });

    return listaElementos;
}

/*
function obtenerListaElementos() {
    usuarios.forEach(function(usuario) {
        console.log("ID: " + usuario.id);
        console.log("Nombre: " + usuario.nombre);
        console.log("Email: " + usuario.email);
    });
    // En este ejemplo, la lista completa de elementos es un array del 1 al 100
    return Array.from({ length: 100 }, (_, i) => i + 1);
}
*/
