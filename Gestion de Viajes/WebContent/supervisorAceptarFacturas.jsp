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
            <%@ include file="templates/supervisorSidebar.jsp" %>
        </header>
        <main id="content">
            <%@ include file="templates/navbarSupervisor.jsp" %>

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
                    <a class="back-container centerBoth" href="supervisorRevisionViajes.jsp">
                        <img src="assets/back.svg" alt="Flecha atrás" class="back-icon">
                        <span class="ml-3">Volver atrás</span>
                    </a>

                    <div class="fontBig text-center headText my-3">
                        Aceptar facturas
                    </div>
                </div>

                <section class="col-8 centerHorizontal">
                    <div class="row mb-2">
                        <div class="col-12 col-md-5">
                            <div class="fontBig info-header">Nombre del empleado:</div>
                            <span>${ empleado }</span>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-12 col-md-5">
                            <div class="fontBig info-header">Origen del viaje:</div>
                            <span>${origen}</span>
                        </div>
                        <div class="col-md-2"></div>
                        <div class="col-12 col-md-5">
                            <div class="fontBig info-header">Destino del viaje:</div>
                            <span>${destino }</span>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-12 col-md-5">
                            <div class="fontBig info-header">Fecha de inicio:</div>
                          
                            <span>${fechaInicio } </span>
                        </div>
                        <div class="col-md-2"></div>
                        <div class="col-12 col-md-5">
                            <div class="fontBig info-header">Fecha de fin:</div>
                            <span>${fechaFin }</span>
                        </div>
                        <div class="col-12">
                            <div class="fontBig info-header">Facturas aceptadas:</div>
                            <div class="row">
                            <c:forEach items="${facturas_list_aceptadas }" var="fact_acept">
                            <span>${fact_acept.id }</span>
                            <div class="col-1"></div>
                            <form action="SupervisorDescargarFacturaServlet?id=${fact.id}" method="post" >
	                        	<button type="submit">Descargar</button>
	                        </form>
                            </c:forEach>
                            </div>
                            
                        </div>
                    </div>
                    <div class="row">
                        <div id="table-viajes" class="col-md-5">
                            <table class="table table-hover table-white text-center" id="table">
                                <thead>
                                <tr>
                                    <th scope="col" class="col-icons"></th>
                                    <th scope="col" class="col-bill-file">Facturas</th>
                                    <th scope="col" class="col-bill-file">Gestionar</th>
                                    <th scope="col"></th>
                                </tr>
                                </thead>
                                <tbody>
                                
                                <c:forEach items="${ facturas_list_pendientes }" var="fact">
                                	
                                	<tr>
	                                	 <td>
	                                        <span>Id: ${fact.id }</span>
	                                    </td>
	                                    <td>
	                                    <form action="SupervisorDescargarFacturaServlet?id=${fact.id}" method="post" >
	                                        <button type="submit" >Descargar</button>
	                                   </form>
	                                        
	                                    </td>
	                                    <form action="SupervisorAceptarFacturasServlet?id=${fact.id}" method="post">
	                                    <td>
	                                    <select name="estado">
	                                    	<option value="true">Aceptar</option>
	                                		<option value="false">Rechazar</option>
	                                    	
	                                    </select>
	                                    </td>
	                                    <td>
	                                    <textarea id="rechazo" name="rechazo" placeholder="Rellenar en caso de rechazo" rows="2"></textarea>
	                                    </td>
	                                    <td>
	                                    
	                                    	<button type="submit" class="btn">Enviar</button>
	                                    	
	                                    </td>
	                                    </form>
                                	</tr>
                                	
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
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
        $('title').html("Procesar viaje");
    </script>

    <!-- Script changing active sidenav li -->
    <script>
        $("#sidebar ul li:nth-child(2)").addClass('active');
    </script>
</body>
</html>
