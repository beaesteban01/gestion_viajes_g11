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
                            <img src="assets/profile.svg" alt="Icono perfil" class="page-icon">
                        </div>
                        <div class="col-5 centerVertical">
                            <div class="line"></div>
                        </div>
                    </div>
                </div>
            </section>

            <div class="container">
                <div class="fontBig text-center headText my-4">
                    Datos de Usuario
                </div>

                <section class="col-8 centerHorizontal">
                    <form action="SupervisorServlet" method="post">
                        <div class="form-row mb-3">
                            <div class="form-group col-12 col-md-5">
                                <div class="fontBig info-header">Nombre:</div>
                                <input type="text" class="form-control" id="name" name="name" placeholder="Nombre y apellidos" required value="${name}">
                            </div>
                            <div class="form-group col-12 col-md-5">
                                <div class="fontBig info-header">Email:</div>
                                <input type="text" class="form-control" id="email" name="email" placeholder="Correo electronico" required value="${email}">
                            </div>
                            <div class="col-md-2"></div>
                            <div class="form-group col-12 col-md-5">
                                <div class="fontBig info-header">DNI:</div>
                                <input type="text" class="form-control" id="dni" name="dni" placeholder="Documento Nacional de Identidad" required value="${dni}">
                            </div>
                        </div>
                        <div class="form-row mb-3">
                            <div class="form-group col-12 col-md-5">
                                <div class="fontBig info-header">Empresa:</div>
                                <input type="text" class="form-control" id="firm" name="empresa" placeholder="Nombre de la empresa" required value="${empresa}">
                            </div>
                            <div class="col-md-2"></div>
                            <div class="form-group col-12 col-md-5">
                                <div class="fontBig info-header">Departamento:</div>
                                <input type="text" class="form-control" id="department" name="departamento" placeholder="Nombre del departamento" required value="${departamento}">
                            </div>
                        </div>
                        <div class="form-row mb-3">
                            <div class="form-group col-12 col-md-12">
                                <div class="fontBig info-header">Cuenta Bancaria:</div>
                                <input type="text" class="form-control" id="account" name="cuenta" placeholder="Cuenta bancaria en la que se realizará el reembolso" required value="${cuenta}">
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

    <%@ include file="templates/scripts.jsp" %>
    <script>
        $('title').html("Autorizar viaje");
    </script>


</body>
</html>