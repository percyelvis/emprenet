document.getElementById("formRegistro").addEventListener("submit", async (e) => {
    e.preventDefault();

    const usuario = {
        nombre: document.getElementById("nombre").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
        rol: document.getElementById("rol").value
    };

    try {
        const response = await fetch("/usuarios", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(usuario)
        });

        if (response.ok) {
            document.getElementById("mensaje").innerText = "✅ Usuario registrado correctamente";
            document.getElementById("mensaje").style.color = "green";
        } else {
            document.getElementById("mensaje").innerText = "❌ Error al registrar";
            document.getElementById("mensaje").style.color = "red";
        }

    } catch (error) {
        console.error(error);
    }
});