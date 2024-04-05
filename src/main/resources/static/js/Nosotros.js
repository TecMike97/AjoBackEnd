document.addEventListener("DOMContentLoaded", function() {
    // Verificar si el usuario ya ha iniciado sesión en sesiones anteriores
    var sesionIniciada = localStorage.getItem('sesionIniciada');
    if (sesionIniciada && sesionIniciada === 'true') {
        // Mostrar el botón de cerrar sesión si la sesión está iniciada
        var btnCerrarSesion = document.getElementById('btnCerrarSesion');
        if (btnCerrarSesion) {
            btnCerrarSesion.style.display = 'block';

            // Agregar un evento clic al botón de cerrar sesión
            btnCerrarSesion.addEventListener('click', function() {
                // Eliminar la marca de sesión iniciada en localStorage
                localStorage.removeItem('sesionIniciada');
                // Redirigir al usuario a la página de inicio de sesión
                window.location.href = "../index.html";
            });
        }
    }
});