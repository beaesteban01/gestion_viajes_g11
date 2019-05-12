<nav class="navbar navbar-dark bg-dark justify-content-between orangeColor font-weight-bold">
    <div class="container-fluid">
        <div id="sidebarCollapse" class="nav-icon3">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>
        <div>
            <img id="userIcon" src="assets/user.svg">
            <a href="EmpleadoServlet?email=${email} ">${name}</a>
            <img id="logoutIcon" class="mx-3" src="assets/logout.svg">
            <a href="LogoutServlet">Cerrar Sesión</a>
        </div>
    </div>
</nav>