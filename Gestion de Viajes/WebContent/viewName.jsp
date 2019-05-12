<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="centerBoth col-12" style="flex-direction: row;">
			<form action="AdminDecisionServlet" method="post" class="mr-1">
				<input type="hidden" name="id" value="">
				<input type="hidden" name="decision" value="1">
				<button type="submit" class="btn fontBig">Aceptar</button>
			</form>
			<form action="AdminDecisionServlet" method="post">
				<input type="hidden" name="id" value="">
				<input type="hidden" name="decision" value="0">
				<button type="submit" class="btn fontBig">Rechazar</button>
			</form>
		</div>
	</div>
</body>
</html>