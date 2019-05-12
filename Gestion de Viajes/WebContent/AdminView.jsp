<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="templates/head.jsp" %>
	<style>
            #elegirSupervisor {
                display: none;
            }
        </style>
</head>
<body>
<shiro:lacksRole name="admin">
	No tienes permiso para ver el contenido de esta página
</shiro:lacksRole>
<div class="wrapper">
		<header>
    		<%@ include file="templates/adminSidebar.jsp" %>
    	</header>
    <main id="content">
    
    	<%@ include file="templates/navbar.jsp" %>
    	
    	

        <section class="text-center mt-3">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-5 centerVertical">
                        <div class="line"></div>
                    </div>
                    <div class="col-2">
                        <img src="assets/manageUser.svg" alt="Icono usuario" class="page-icon">
                    </div>
                    <div class="col-5 centerVertical">
                        <div class="line"></div>
                    </div>
                </div>
            </div>
        </section>

        <div class="container">
            <div class="position-relative">

                <div class="fontBig text-center headText my-3">
                    Crear Empleado
                </div>
            </div>

            <section class="col-8 centerHorizontal">
                <form action="CreateEmpleadoServlet" method="post">
                    <div class="form-row">
                        <div class="form-group col-12 col-md-5">
                            <div class="fontBig info-header">Nombre:</div>
                            <input id="name" name="name" type="text" class="form-control" placeholder="Nombre" required>
                        </div>
                        <div class="col-md-2"></div>
                        <div class="form-group col-12 col-md-5">
                            <div class="fontBig info-header">DNI:</div>
                            <input id="dni" name="dni" type="text" class="form-control" placeholder="DNI" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-12 col-md-5">
                            <div class="fontBig info-header">Contraseña:</div>
                            <input id="password1" name="password" type="password" class="form-control" placeholder="Introduce la contraseña" required>
                        </div>
                        <div class="form-group col-12 col-md-5">
                            <div class="fontBig info-header">Correo:</div>
                            <input id="password1" name="email" type="text" class="form-control" placeholder="Introduce la contraseña" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-12 col-md-5">
                            <div class="fontBig info-header">Empresa:</div>
                            <input  id="firm" name="empresa" type="text" class="form-control" placeholder="Empresa" required>
                        </div>
                        <div class="col-md-2"></div>
                        <div class="form-group col-12 col-md-5">
                            <div class="fontBig info-header">Departamento:</div>
                            <input id="department" name="departamento" type="text" class="form-control" placeholder="Departamento" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-12">
                            <div class="fontBig info-header">Cuenta Bancaria:</div>
                            <input id="account" name="cuenta" type="text" class="form-control" placeholder="Cuenta bancaria" required>
                        </div>
                    </div>
                    <div class="form-row">
                    	<div class="form-group col-12">
                    		<div class="fontBig info-header">¿Va supervisar viajes?
                    		<input type="checkbox" checked onclick="showHide()" id="isSupervisor" name="isSupervisor" value="1"/>                 		
                    		</div>   
                    	</div>
                    </div>
                    <div class="form-row" id="elegirSupervisor">
                        <div class="form-group col-12">
                            <div class="fontBig info-header">Supervisor:</div>
							<select name="supervisor">
								<option value="" disabled selected>Elija un supervisor</option>
								<c:forEach items="${supervisor_list}" var="supi">
									<option value="${supi.email}">
										${supi.name }-${supi.email }
									</option>
								</c:forEach>
							</select>                        
						</div>
                    </div>
                    <div class="form-row">
                        <div class="form-group text-center col-12">
                            <button type="submit" class="btn btn-save fontBig mr-3">Crear Empleado</button>
                        </div>
                    </div>
                </form>
            </section>

        </div>
        <div class="container">
                <div class="fontBig text-center headText my-3">
                    Lista de Supervisores
                </div>

                <section>
                    <div id="table-viajes">
                        <table class="table table-hover table-white text-center" id="table">
                            <thead>
                                <tr>
                                    <th scope="col" class="col-bill-regular">Nombre</th>
                                    <th scope="col" class="col-bill-regular">Correo</th>
                                    <th scope="col" class="col-bill-regular">DNI</th>
                                    <th scope="col" class="col-bill-regular">Empleados asignados</th>
                                    <th scope="col" class="col-bill-price">Editar</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items="${supervisor_list}" var="sup">
									<tr>
										<td>${sup.name }</td>
										<td>${sup.email }</td>
										<td>${sup.dni }</td>
										<td>${fn:length(sup.empleados) }</td>
										<td>
                                        <a href="">
                                            <span class="glyphicon glyphicon-cog black-icon"></span>
                                        </a>
                                    </td>
									</tr>
								</c:forEach>                                              
                            </tbody>
                        </table>
                    </div>
                </section>
            </div>
            <div class="container">
                <div class="fontBig text-center headText my-3">
                    Lista de Empleados
                </div>

                <section>
                    <div id="table-viajes">
                        <table class="table table-hover table-white text-center" id="table">
                            <thead>
                                <tr>
                                    <th scope="col" class="col-bill-regular">Nombre</th>
                                    <th scope="col" class="col-bill-regular">Correo</th>
                                    <th scope="col" class="col-bill-regular">DNI</th>
                                    <th scope="col" class="col-bill-regular">Supervisor</th>
                                    <th scope="col" class="col-bill-regular">Viajes</th>                                   
                                    <th scope="col" class="col-bill-price">Editar</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items="${empleado_list}" var="empl">
									<tr>
										<td>${empl.name }</td>
										<td>${empl.email }</td>
										<td>${empl.dni }</td>
										<td>${empl.supervisor}</td>
										<td>${fn:length(empl.requestedViajes) }</td>
										<td>
                                        <a href="">
                                            <span class="glyphicon glyphicon-cog black-icon"></span>
                                        </a>
                                    </td>
									</tr>
								</c:forEach>                                              
                            </tbody>		
                        </table>
                    </div>
                </section>
            </div>
       <%@ include file="templates/footer.jsp" %>
    </main>
</div>

<!-- Web page main Scripts -->
<%@ include file="templates/scripts.jsp" %>

<script>
function showHide(){
    let checkBox = document.getElementById("isSupervisor");
    let selection = document.getElementById("elegirSupervisor");

    if (checkBox.checked == false){
        selection.style.display = "block";
    } else {
        selection.style.display = "none";
    }
}
</script>
<!-- Script changing html title -->
<script>
    $('title').html("Solicitar viaje");
</script>

<!-- Script changing active sidenav li -->

</body>
</html>