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
                            <img src="assets/bill.svg" alt="Icono facturas" class="page-icon">
                        </div>
                        <div class="col-5 centerVertical">
                            <div class="line"></div>
                        </div>
                    </div>
                </div>
            </section>

            <div class="container">
                <div class="position-relative">
                    <a class="back-container centerBoth" href="EmpleadoViajesServlet?email=${email}">
                        <img src="assets/back.svg" alt="Flecha atrás" class="back-icon">
                        <span class="ml-3">Volver atrás</span>
                    </a>

                    <div class="fontBig text-center headText my-3">
                        Detalle del Viaje
                    </div>
                </div>

                <section class="col-8 centerHorizontal">
                    <div class="row mb-2">
                        <div class="col-12 col-md-5">
                            <div class="fontBig info-header">Origen del viaje:</div>
                            <span>${origen}</span>
                        </div>
                        <div class="col-md-2"></div>
                        <div class="col-12 col-md-5">
                            <div class="fontBig info-header">Destino del viaje:</div>
                            <span>${destino}</span>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-12 col-md-5">
                            <div class="fontBig info-header">Fecha de inicio:</div>
                            <span>${fechaInicio}</span>
                        </div>
                        <div class="col-md-2"></div>
                        <div class="col-12 col-md-5">
                            <div class="fontBig info-header">Fecha de fin:</div>
                            <span>${fechaFin}</span>
                        </div>
                    </div>
                    
                </section>

                <section>
          
                    </div>
                    <div id="table-viajes">
                        <table class="table table-hover table-white text-center" id="table">
                            <thead>
                                <tr>
                                   <th></th>
                                    <th scope="col" class="col-bill-regular">Fecha</th>
                                    <th scope="col" class="col-bill-concept">Concepto</th>
                                    <th scope="col" class="col-bill-price">Precio</th>
                                    <th scope="col" class="col-bill-regular">Estado</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items="${facturas_list}" var="fact">
                            	
                            	<tr>
                                    <td></td>
                                    <td>${fact.fecha}</td>
                                    <td>${fact.descripcion}</td>
                                    <td>${fact.precio}</td>
                                    <c:if test="${fact.estado == 0 }"><td>Factura Aceptada</td></c:if>
                                    <c:if test="${fact.estado == 1 }"><td>Factura Rechazada</td></c:if>
                                   	<c:if test="${fact.estado == 2 }"><td>Pendiente de autorización</td></c:if>
                                   	<c:if test="${fact.estado == 1 }"><td>${fact.rechazo }</td></c:if>
                                </tr>
                            	             	
                                </c:forEach>
                                
                              
                              	
                         
                                <tr>
                                    <form id="billForm" action="EmpleadoSubirFacturaServlet?id=${idViaje}" method="post" enctype="multipart/form-data">
                                        <td>
                                        </td>
                                       
                                        <td>
                                            <input id="fecha" name="fecha" type="date" class="form-control required" placeholder="DD/MM/YYYY" required>
                                        </td>
                                        <td>
                                            <input id="descripcion" name="descripcion" type="text" class="form-control required" placeholder="Descripción" required>
                                        </td>
                                        <td>
                                            <input id="precio" name="precio" type="number" class="form-control required" placeholder="Precio en euros" required>
                                        </td>
                                        <td>
                                            <input id="factura" name="factura" type="file" class="form-control required" required>
                                        </td>
                                        <td>
                                    	   <input type="submit" form="billForm" class="btn" value="Agregar factura">
                                        	
                                        </td>
                                    </form>
                                </tr>
                               
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

    <!-- Script changing html title -->
    <script>
        $('title').html("Detalle del viaje");
    </script>

    <!-- Script changing active sidenav li -->
    <script>
        $("#sidebar ul li:first-child").addClass('active');
    </script>
</body>
</html>