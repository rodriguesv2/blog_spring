<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>


<%@ include file="/WEB-INF/views/cabecalho.jsp" %>		
		<div class="container">
			<c:forEach items="${lista}" var="post">
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
					<c:if test="${post.dataModificacao != null }">
						<li class="list-inline-item"><h5>Data De Modificação:</h5></li>
						<li class="list-inline-item"><h6 class="text-muted"><fmt:formatDate value="${post.dataModificacao.time}" pattern="dd/MM/yyyy HH:mm"/></h6></li>
					</c:if>
				</ul>
				
				<p>
					${post.amostraTexto}
				</p>
				<div>
					<ul class="list-inline">
						<li class="list-inline-item"><a href="${s:mvcUrl('PC#detalhe').arg(0, post.id).build()}">Detalhes</a></li> 
						<li class="list-inline-item"><a href="${s:mvcUrl('PC#formAlterar').arg(0, post.id).build()}">Alterar</a></li>
						<li class="list-inline-item"><a href="${s:mvcUrl('PC#remove').arg(0, post.id).build()}">Remover</a></li>
					</ul>
				</div>
				<hr style="width: 100%; color: black; height: 1px; background-color:black;" />
			</c:forEach>
		</div>
	</body>
</html>