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