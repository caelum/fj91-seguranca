<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>

<custom:template title="Cadastrar novo Processo">
	<jsp:body>
		<div class="container">
			<h1 class="text-center">Cadastrar novo Processo</h1>
			
			<form method="post" action="<c:url value='/processos' />">
				<div class="form-group">
					<label for="autor">Autor</label>
					<input id="autor" name="autor" class="form-control" required="required" />
				</div>
				
				<div class="form-group">
					<label for="descricao">Descrição</label>
					<textarea id="descricao" name="descricao" class="form-control" required="required"></textarea>
				</div>
				
				<input type="submit" value="Gravar" class="btn btn-primary">
				<a href="<c:url value='/processos' />" class="btn btn-default">Cancelar</a>
			</form>
		</div>
	</jsp:body>
</custom:template>
