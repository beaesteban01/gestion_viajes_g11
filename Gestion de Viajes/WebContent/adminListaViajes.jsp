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
                            <img src="assets/bill.svg" alt="Icono facturas" class="page-icon">
                        </div>
                        <div class="col-5 centerVertical">
                            <div class="line"></div>
                        </div>
                    </div>
                </div>
            </section>

            <div class="container">
                <div class="fontBig text-center headText mt-2">
                    Revisión de Viajes
                </div>

                <div id="table-viajes">
                
                	
                    <table class="table table-hover table-white" id="table">
                        <thead>
                            <tr>
                                <th scope="col" class="col-icons"></th>
                                <th scope="col" class="col-names">Nombre</th>
                                <th scope="col" class="col-names">Inicio</th>
                                <th scope="col" class="col-names">Fin</th>
                                <th scope="col" class="col-names">Lugar</th>
                                <th scope="col" class="col-icons">Revisar</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach items="${viajes_list}" var="viaje">
                        		<c:if test="${ viaje.estado == 0 }">
								<tr>
								    <td class="text-center"><span class="glyphicon glyphicon-envelope black-icon"></span></td>
									<td>${viaje.empleado.name}</td>
									<td>${viaje.fechaInicio }</td>
									<td>${viaje.fechaFin }</td>
									<td>${viaje.destino }</td>
									<td class="text-center"><a href="AdminAutorizacionViajeServlet?id=${viaje.id}"><span class="glyphicon glyphicon-eye-open black-icon"></span></a></td>
								</tr>
								</c:if>
								
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
        $('title').html("Revisión de Viajes");
    </script>

    <!-- Script changing active sidenav li -->
    <script>
        $("#sidebar ul li:nth-child(4)").addClass('active');
    </script>
</body>
</html>