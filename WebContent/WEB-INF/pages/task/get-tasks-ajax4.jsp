<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		$.post("finalizatask", {'id':id}, function(response) {
			$("#task_"+id).html(response)
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
			<tr id="task_${task.id}" bgcolor="#${task.id % 2 == 0 ? 'ffffff' : 'F0F8FF'}">

				<c:set var="task" value="${task}" scope="request"/>
				<c:import url="data-finalizada2.jsp" />

			</tr>
		</c:forEach>
	</table>
	<h3><a href="novatask">Inserir nova Task</a></h3>
</body>
</html>