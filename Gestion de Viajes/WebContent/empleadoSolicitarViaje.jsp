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
                <div class="fontBig text-center headText my-4">
                    Solicitar Viaje
                  
                </div>

                <section class="col-8 centerHorizontal">
                    <form action="EmpleadoSolicitarViajeServlet" method="post">
                        <div class="form-row">
                            <div class="form-group col-12 col-md-6">
                                <div class="fontBig info-header">Origen del viaje:</div>
                                <input id="origin" name="origen" type="text" class="form-control" placeholder="Ciudad origen" required>
                            </div>
                            <div class="form-group col-12 col-md-6">
                                <div class="fontBig info-header">Destino del viaje:</div>
                                <input id="destination" name="destino" type="text" class="form-control" placeholder="Ciudad destino" required>
                            </div>
                        </div>
                         <div class="form-row">
                            <div class="form-group col-12 col-md-6">
                                <div class="fontBig info-header">Fecha Inicio:</div>
                                <input id="fechaInicio" name="fechaInicio" type="date" class="form-control" placeholder="dd/mm/yyyy" required>
                            </div>
                            <div class="form-group col-12 col-md-6">
                                <div class="fontBig info-header">Fecha Fin:</div>
                                <input id="fechaFin" name="fechaFin" type="date" class="form-control" placeholder="dd/mm/yyyy" required>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-12">
                                <div class="fontBig mb-2 info-header">Descripción del viaje:</div>
                                <textarea id="description" name="descripcion" class="form-control" placeholder="Describe brevemente el objetivo del viaje" rows="5" required></textarea>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-12 col-md-6">
                                <div class="fontBig info-header">Precio Aproximado:</div>
                                <small>Introduce el precio aproximado del traslado y estancia de tu viaje.</small>
                                <div class="input-group">
                                    <input id="price" name="precio" type="number" class="form-control" placeholder="Coste del viaje en euros" required>
                                    <span class="input-group-addon form-right-icon">
                                        <i class="glyphicon glyphicon-euro black-icon my-1 ml-1 mr-2"></i>
                                    </span>
                                </div>

                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group text-center col-12">
                                <button type="submit" class="btn fontBig">Enviar</button>
                            </div>
                        </div>
                    </form>
                </section>
            </div>
          <%@ include file="templates/footer.jsp" %>  
        </main>
    </div>
    <!-- Web page main Scripts -->
    <%@ include file="templates/scripts.jsp" %>

    <!-- Script changing html title -->
    <script>
        $('title').html("Solicitar viaje");
    </script>

    <!-- Script changing active sidenav li -->
    <script>
        $("#sidebar ul li:second-child").addClass('active');
    </script>
</body>
</html>