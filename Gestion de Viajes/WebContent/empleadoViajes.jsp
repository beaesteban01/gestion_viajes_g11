<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="templates/head.jsp" %>
</head>
<body>
    <div class="wrapper">
        <header>
        	<%@ include file="templates/empleadoSidebar.jsp" %>
        </header>
        <main id="content">
        	<%@ include file="templates/navbarEmpleado.jsp" %>

           
            <section class="text-center mt-3">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-5 centerVertical">
                            <div class="line"></div>
                        </div>
                        <div class="col-2">
                            <img src="assets/plane.svg" alt="Icono viajes" class="page-icon">
                        </div>
                        <div class="col-5 centerVertical">
                            <div class="line"></div>
                        </div>
                    </div>
                </div>
            </section>

            <div class="container">
                <div class="fontBig text-center headText mt-2">
                    Mis Viajes
                </div>

                <div id="table-viajes">
                    <table class="table table-hover table-white text-center" id="table">
                        <thead>
                            <tr>
                                <th scope="col" class="col-icons"></th>
                                <th scope="col" class="col-employee-regular">Destino</th>
                                <th scope="col" class="col-employee-regular">Fecha de Inicio</th>
                                <th scope="col" class="col-employee-regular">Fecha de Fin</th>
                                <th scope="col" class="col-employee-regular">Estado</th>
                                <th scope="col" class="col-icons">Facturas</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${viajes_list}" var="viaje">
									<tr>
										<td><span class="glyphicon glyphicon-plane black-icon"></span></td>
										<td>${viaje.destino}</td>
										<td>${viaje.fechaInicio }</td>
										<td>${viaje.fechaFin }</td>
										<c:if test="${viaje.estado == 2}"> 
										<td style="color: orange">En espera</td>
										</c:if>
										<c:if test="${viaje.estado == 0 }">
										<td style="color: green">Aceptado</td>
										</c:if>
										<c:if test="${viaje.estado == 1 }">
										<td style="color: red">Rechazado</td>
										</c:if>
										<c:if test="${viaje.estado == 3 }">
										<td style="color: green">Reembolso aceptado</td>
										</c:if>
										<c:if test="${viaje.estado == 4 }">
										<td style="color: red">Reembolso rechazado</td>
										</c:if>
										<c:if test="${viaje.estado == 0 }">	
										<td>
                                        <a href="EmpleadoDetalleViajeServlet?id=${viaje.id}">
                                            <span class="glyphicon glyphicon-eye-open black-icon"></span>
                                        </a>
                                    	</td>
                                    	</c:if>
									</tr>
								</c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
          <%@ include file="templates/footer.jsp" %>  
        </main>
    </div>
    <!-- Web page main Scripts -->
    <%@ include file="templates/scripts.jsp" %>

    <!-- Script changing html title -->
    <script>
        $('title').html("Lista de viajes");
    </script>
    

    <!-- Script changing active sidenav li -->
    <script>
        $("#sidebar ul li:first-child").addClass('active');
    </script>
</body>
</html>