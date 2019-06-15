<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
	<link type="text/css" href="resources/css/tasks.css" rel="stylesheet" />
	<script type="text/javascript" src="resources/js/jquery.js"></script>

	<meta charset="ISO-8859-1">
	<title>Get tasks</title>
</head>
<body>

<script type="text/javascript">
	function finalizar(id) {
		$.post("finalizatask", {'id':id}, function() {
			$("#task_"+id).html("Finalizada")
		});
	}
</script>

	<h3><a href="novatask">Inserir nova Task</a></h3>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizada</th>
			<th>Data de finalização</th>
			<th colspan="2">Ações</th>
		</tr>
		<c:forEach var="task" items="${tasks}">
			<tr>
				<td>${task.id}</td>
				<td>${task.descricao}</td>
			
				<c:if test="${task.finalizada eq false}">
					<td id="task_${task.id}"><a href="#" onclick="finalizar(${task.id})">Finalizar</a></td>
				</c:if>
				<c:if test="${task.finalizada eq true}">
					<td>Finalizada</td>
				</c:if>

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