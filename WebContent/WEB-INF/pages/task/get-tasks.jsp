<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
	<link type="text/css" href="resources/css/tasks.css" rel="stylesheet" />
	
	<meta charset="ISO-8859-1">
	<title>Get tasks</title>
</head>
<body>
	<h3><a href="novatask">Inserir nova Task</a></h3>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Descri��o</th>
			<th>Finalizada</th>
			<th>Data de finaliza��o</th>
			<th colspan="2">A��es</th>
		</tr>
		<c:forEach var="task" items="${tasks}">
			<tr>
				<td>${task.id}</td>
				<td>${task.descricao}</td>
				
				<td>
					<c:if test="${task.finalizada eq false}">
						N�o finalizada
					</c:if>
					<c:if test="${task.finalizada eq true}">
						Finalizada
					</c:if>
				</td>
				<td>
					<fmt:formatDate value="${task.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
				</td>
				
				<td><b><a href="deletartask?id=${task.id}">Deletar</a></b>
				<td><b><a href="buscartask?id=${task.id}">Editar</a></b>
			</tr>
		</c:forEach>
	</table>
	<h3><a href="novatask">Inserir nova Task</a></h3>
</body>
</html>