//<script th:inline="javascript">
//    $(document).ready(function() {
//        $("#searchForm").submit(function(e) {
//            e.preventDefault(); // Evita el envío del formulario por defecto
//
//            var query = $("#searchQuery").val(); // Obtiene el valor del campo de búsqueda
//
//            $.ajax({
//                type: "POST",
//                url: "/buscar",
//                data: { query: query },
//                success: function(response) {
//                    // Maneja la respuesta del servidor
//                    console.log("Respuesta del servidor:", response);
//                    // Otro código de manejo de la respuesta
//                },
//                error: function(xhr, status, error) {
//                    // Maneja el error en la solicitud AJAX
//                    console.error("Error en la solicitud AJAX:", error);
//                }
//            });
//        });
//    });
//</script>
