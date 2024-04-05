let alertValidacionesTexto = document.getElementById("alertValidacionesTexto");
let alertValidaciones = document.getElementById("alertValidaciones");
let textErrores = "";

document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById('Login');
    form.addEventListener("submit", function(event) {
        event.preventDefault(); // Evitar que el formulario se envíe automáticamente

        // Obtener los valores del formulario
        var email = document.getElementById('user').value.trim();
        var contraseña = document.getElementById('contrasena').value;

        // Validar el campo de email
        if (email === "") {
            Swal.fire('Por favor ingresa tu correo electrónico.');
            return; // Detener la ejecución del código si el campo de email está vacío
        }

        // Validar el formato del email utilizando una expresión regular
        let pattern = new RegExp("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$");
        if (!pattern.test(email)) {
            Swal.fire('Por favor ingresa un correo electrónico válido.');
            return; // Detener la ejecución del código si el formato del email es inválido
        }
        let contrasenaern = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[\u0021-\u002b\u003c-\u0040])[A-Za-z0-9\u0021-\u002b\u003c-\u0040]{8,}$");
        if (!contrasenaern.test(contraseña)) {
            Swal.fire('Por favor ingresa una contraseña válida.');
            return; // Detener la ejecución del código si el formato del email es inválido
        }
         // Almacenar temporalmente los valores ingresados por el usuario antes de mostrar la alerta
         var valoresFormulario = {
            email: email,
            contraseña: contraseña
        };

        // Obtener los datos del usuario almacenados en localStorage
        var currentIndex = localStorage.getItem('currentIndex');
        var usuarioEncontrado = false;

        alertValidacionesTexto.innerHTML="";
        alertValidaciones.style.display="none";

        // Verificar si hay usuarios almacenados en localStorage
        if (currentIndex) {
            currentIndex = parseInt(currentIndex);
            for (var i = 1; i <= currentIndex; i++) {
                var claveUsuario = 'usuario_' + i;
                var usuarioJSON = localStorage.getItem(claveUsuario);
                var usuario = JSON.parse(usuarioJSON);
                
                // Comprobar si los datos coinciden con algún usuario almacenado
                if (usuario.email === email && usuario.contraseña === contraseña) {
                    usuarioEncontrado = true;
                    // Guardar el estado de sesión iniciada en localStorage
                    localStorage.setItem('sesionIniciada', 'true');
                    // Realizar acciones después de iniciar sesión, como redireccionar a otra página
                    // Por ejemplo, window.location.href = "página de inicio.html";
                    Swal.fire('Inicio de sesión exitoso');
                    window.location.href = "../index.html";
                    return;
                }
            }
        }
        // Si no se encontró el usuario, mostrar un mensaje de error
        if (!usuarioEncontrado) {
            Swal.fire('Correo electrónico y/o contraseña incorrectas. Por favor, inténtalo de nuevo.');
        }

        // Limpiar el formulario después de intentar iniciar sesión
        //form.reset();
        // Restaurar los valores ingresados por el usuario después de mostrar la alerta
        document.getElementById('user').value = valoresFormulario.email;
        document.getElementById('contrasena').value = valoresFormulario.contraseña;
    });
});
/*document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById('Login');

    form.addEventListener("submit", function(event) {
        event.preventDefault(); // Evitar que el formulario se envíe automáticamente

        // Obtener los valores del formulario
        var email = document.getElementById('user').value.trim();
        var contraseña = document.getElementById('contrasena').value;

        // Validar el campo de email
        if (email === "") {
            Swal.fire('Por favor ingresa tu correo electrónico.');
            return; // Detener la ejecución del código si el campo de email está vacío
        }

        // Validar el formato del email utilizando una expresión regular
        let pattern = new RegExp("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$");
        if (!pattern.test(email)) {
            Swal.fire('Por favor ingresa un correo electrónico válido.');
            return; // Detener la ejecución del código si el formato del email es inválido
        }

        // Almacenar temporalmente los valores ingresados por el usuario antes de mostrar la alerta
        var valoresFormulario = {
            email: email,
            contraseña: contraseña
        };

        // Obtener los datos del usuario almacenados en localStorage
        var currentIndex = localStorage.getItem('currentIndex');
        var usuarioEncontrado = false;

        alertValidacionesTexto.innerHTML="";
        alertValidaciones.style.display="none";

        // Verificar si hay usuarios almacenados en localStorage
        if (currentIndex) {
            currentIndex = parseInt(currentIndex);
            for (var i = 1; i <= currentIndex; i++) {
                var claveUsuario = 'usuario_' + i;
                var usuarioJSON = localStorage.getItem(claveUsuario);
                var usuario = JSON.parse(usuarioJSON);
                
                // Comprobar si los datos coinciden con algún usuario almacenado
                if (usuario.email === email && usuario.contraseña === contraseña) {
                    usuarioEncontrado = true;
                    // Guardar el estado de sesión iniciada en localStorage
                    localStorage.setItem('sesionIniciada', 'true');
                    // Realizar acciones después de iniciar sesión, como redireccionar a otra página
                    Swal.fire('Inicio de sesión exitoso');
                    window.location.href = "../index.html";
                    break;
                }
            }
        }

        // Si no se encontró el usuario, mostrar un mensaje de error
        if (!usuarioEncontrado) {
            Swal.fire('Correo electrónico y/o contraseña incorrectas. Por favor, inténtalo de nuevo.');
        }

        // Restaurar los valores ingresados por el usuario después de mostrar la alerta
        document.getElementById('user').value = valoresFormulario.email;
        document.getElementById('contrasena').value = valoresFormulario.contraseña;
    });
});*/
