// MENU
document.getElementById("hamburger").onclick = () => {
    document.getElementById("menu").classList.toggle("active");
};

// PRODUCTOS DESDE SPRING
async function cargarProductos() {
    const res = await fetch("/productos");
    const data = await res.json();

    const cont = document.getElementById("productos");

    data.forEach(p => {
        cont.innerHTML += `
      <div class="card-product">
        <img src="https://via.placeholder.com/300">
        <div class="info">
          <h3>${p.nombre}</h3>
          <p>${p.descripcion ?? ""}</p>
          <strong>S/ ${p.precio}</strong>
        </div>
      </div>
    `;
    });
}

cargarProductos();