document.addEventListener("DOMContentLoaded", () => {

    const form = document.getElementById("loginForm");

    form.addEventListener("submit", async function(e){
        e.preventDefault();

        const email = document.getElementById("email").value.trim();
        const password = document.getElementById("password").value.trim();

        try {
            const res = await fetch("/usuarios");
            const usuarios = await res.json();

            const usuario = usuarios.find(u => u.email === email);

            if(!usuario){
                mostrarMensaje("❌ Usuario no encontrado", "error");
                return;
            }

            if(usuario.password !== password){
                mostrarMensaje("❌ Contraseña incorrecta", "error");
                return;
            }

            mostrarMensaje("✅ Bienvenido " + usuario.nombre, "success");

            setTimeout(() => {
                window.location.href = "/";
            }, 1500);

        } catch (error) {
            console.error(error);
            mostrarMensaje("⚠️ Error en el servidor", "error");
        }
    });

});


function mostrarMensaje(texto, tipo){

    const alerta = document.createElement("div");
    alerta.className = "alerta " + tipo;
    alerta.innerText = texto;

    document.body.appendChild(alerta);

    setTimeout(() => {
        alerta.remove();
    }, 3000);
}