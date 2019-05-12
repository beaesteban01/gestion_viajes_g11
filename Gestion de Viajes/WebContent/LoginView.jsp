<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="templates/head.jsp" %>
</head>
<body>
		
		<main class="bg centerBoth">
        <form id="formulario" class="bg-light" action="LoginServlet" method="post">
            <div class="form-group">
                <label for="email" class="fontBig" for="exampleInputEmail1">Dirección de correo</label>
                <input type="text" id="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="Introduce el correo...">
            </div>
            <div class="form-group">
                <label class="fontBig" for="exampleInputPassword1">Contraseña</label>
                <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Introduce la contraseña...">
            </div>
            
            <div class="centerBoth">
                <button type="submit" class="btn fontBig">Entrar</button>
            </div>
        </form>
    </main>
    
    <%@ include file="templates/scripts.jsp" %>
    <script>
        $('title').html("Gestión de Viajes - G11");
    </script>
    

</body>
</html>