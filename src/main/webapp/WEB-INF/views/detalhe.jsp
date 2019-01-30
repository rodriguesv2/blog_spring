<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="/WEB-INF/views/cabecalho.jsp" %>
	
	<div class="container">
		<h2 class="display-4" >${post.titulo}</h2>
		<ul class="list-inline">
			<li class="list-inline-item"><h3>Autor:</h3></li>
			<li class="list-inline-item"><h4 class="text-muted">Nome do autor</h4></li> 
			<li class="list-inline-item"><h3>Categoria:</h3></li>
			<li class="list-inline-item"><h4 class="text-muted">${post.categoria}</h4></li>
		</ul>
		<ul class="list-inline">
			<li class="list-inline-item"><h5>Data De Criação:</h5></li>
			<li class="list-inline-item"><h6 class="text-muted"><fmt:formatDate value="${post.dataCriacao.time}" pattern="dd/MM/yyyy HH:mm"/></h6></li>
		</ul>
		
		<p>
			${post.texto.replaceAll("\\n","<br>")}
		</p>
	</div>
</body>
</html>