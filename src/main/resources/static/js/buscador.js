function mostrarElements() {
  // Ocultar todos los botones y títulos del wrapper
  var contenidos = document.getElementById('wrapper');
  contenidos.style.display = 'none';
  
  // Mostrar el contenido deseado
  var contenidoMostrado = document.getElementsByClassName('query__elements');
  for (var i = 0; i < contenidoMostrado.length; i++) {
    contenidoMostrado[i].style.display = 'block';
  }
}

//Alerta
//document.getElementById("myButton").addEventListener("click", function() {
//  alert("¡Hola!");
//});


//				    $(document).ready(function() {
//				        $("#searchForm").submit(function(e) {
//				            e.preventDefault();
//
//				            var query = $("#searchQuery").val();
//
//				            $.ajax({
//				                type: "POST",
//				                url: "/buscar",
//				                data: { query: query },
//				                success: function(response) {
//				                    // Maneja la respuesta del servidor
//				                    console.log("Respuesta del servidor:", response);
//				                    // Realiza cualquier acción necesaria después de la redirección
//				                },
//				                error: function(xhr, status, error) {
//				                    // Maneja el error en la solicitud AJAX
//				                    console.error("Error en la solicitud AJAX:", error);
//				                }
//				            });
//				        });
//				    });
