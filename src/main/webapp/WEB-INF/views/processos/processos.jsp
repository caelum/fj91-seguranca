<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>

<custom:template title="Processos cadastradas">
	<jsp:body>
		<div class="container">
			<h1 class="text-center">Processos cadastradas</h1>
			
			<a href="<c:url value='/processos/form' />" class="btn btn-primary">Novo</a>
			
			<div class="table-responsive">
				<table class="table table-stripped table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>DATA DE CADASTRO</th>
							<th>AUTOR</th>
							<th>STATUS</th>
							<th>AÇÕES</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${processos}" var="processo">
							<tr>
								<td>
									${processo.id}
								</td>
								
								<td>
									${processo.dataDeCadastroFormatada()}
								</td>
								
								<td>
									${processo.autor}
								</td>
								
								<td>
									${processo.status.descricao}
								</td>
								
								<td>
									<c:if test="${processo.estaEmAnalise()}">
										<form method="post" action="<c:url value='/processos/${processo.id}/aceitar' />">
											<input type="hidden" name="_method" value="PATCH">
											
											<button type="submit" class="btn btn-success">
												<span class="glyphicon glyphicon-thumbs-up"></span> Aceitar
											</button>
										</form>
										
										<form method="post" action="<c:url value='/processos/${processo.id}/rejeitar' />">
											<input type="hidden" name="_method" value="PATCH">
											
											<button type="submit" class="btn btn-danger">
												<span class="glyphicon glyphicon-thumbs-down"></span> Rejeitar
											</button>
										</form>
									</c:if>
									
									<c:if test="${processo.estaEmAndamento()}">
										<form method="post" action="<c:url value='/processos/${processo.id}/encerrar' />">
											<input type="hidden" name="_method" value="PATCH">
											
											<button type="submit" class="btn btn-info">
												<span class="glyphicon glyphicon-check"></span> Encerrar
											</button>
										</form>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</jsp:body>
</custom:template>
