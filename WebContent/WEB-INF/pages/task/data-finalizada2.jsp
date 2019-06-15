<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<td>${task.id}</td>
<td>${task.descricao}</td>

<c:if test="${task.finalizada eq false}">
	<td><a href="#" onclick="finalizar(${task.id})">Finalizar</a></td>
</c:if>
<c:if test="${task.finalizada eq true}">
	<td>Finalizada</td>
</c:if>

<td>
	<fmt:formatDate value="${task.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
</td>

<td><b><a href="deletartask?id=${task.id}">Deletar</a></b>
<td><b><a href="buscartask?id=${task.id}">Editar</a></b>