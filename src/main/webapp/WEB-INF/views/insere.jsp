<%@page import="br.com.rubensrodrigues.blog_spring.models.Categoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/WEB-INF/views/cabecalho.jsp" %>
		
		<div class="container">
			<h1>Criar um novo Post</h1>
			<br><br><br><br>
			
			<form action="${s:mvcUrl('PC#gravar').build()}" method="POST">
				<div class="form-group">
					<label>Titulo:</label>
					<input class="form-control" type="text" name="titulo" value="${post.titulo}"/>
				</div>
				<div class="form-group">
					<label>Texto:</label>
					<textarea class="form-control" rows="20" name="texto">${post.texto}</textarea>
				</div>
				<div class="form-group">
					<label>Categoria:</label>
					<select class="form-control" name=categoria>
						<c:forEach items="${Categoria.values()}" var="categoria">
							<option value="${categoria}"
								<c:if test="${categoria == post.categoria}">selected</c:if>
							>
								${categoria}
							</option>
						</c:forEach>
					</select>
				</div>
				<input type="hidden" name="id" value="${post.id}"/>
				<input type="hidden" name="dataCriacao" value="<fmt:formatDate value='${post.dataCriacao.time}' pattern='dd/MM/yyyy HH:mm'/>"/>
				<button type="submit" name="Salvar">Salvar</button>
				
			</form>
		</div>
	</body>
</html>