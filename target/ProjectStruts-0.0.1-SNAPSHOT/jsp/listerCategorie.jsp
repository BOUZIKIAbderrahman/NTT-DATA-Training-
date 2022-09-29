<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des Categories</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-blue text-white"
		style="background-color: #e3f2fd;">

	<div class="container-fluid">
		<!-- Links -->
		<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link"
				href="listerCategorie.action" type="button"
				class="btn btn-secondary">Liste des categories</a></li>
			<li class="nav-item"><a class="nav-link"
				href="saisirCategorie.action" type="button"
				class="btn btn-secondary">Ajouter un Categorie</a></li>
				<li class="nav-item"><a class="nav-link"
				href="listerProduitAll.action" type="button"
				class="btn btn-secondary">Liste des produits</a></li>
			<li class="nav-item"><a class="nav-link"
				href="saisirProduit.action" type="button" class="btn btn-secondary">Ajouter
					un Produit</a></li>

		</ul>
	</div>

	</nav>
	<div class="container mt-3">
		<center>
			<h2>Liste des Categories</h2>
		</center>
		<s:if test="%{listCategories.size()>0}">
			<table class="table" border="1">

				<thead class="table-success">

					<tr>
						<th>Id de Catégorie</th>
						<th>Nom de Catégorie</th>
						<th>Description</th>
						<th>Liste des produits</th>
						<th>Modifier</th>
						<th>Supprimer</th>
					</tr>

				</thead>
				<tbody>
					<s:iterator value="listCategories">
						<tr>
							<td><s:property value="idCategorie" /></td>
							<td><s:property value="nomCategorie" /></td>
							<td><s:property value="description" /></td>
							<td><s:url action="listerProduit" var="actionUrl">
									<s:param name="idCategorie" value="idCategorie" />
								</s:url> <s:a class="btn btn-secondary" href="%{actionUrl}">Produits</s:a>

							</td>

							<td><s:form method="get" action="saisirProduit"
									enctype="multipart/form-data" validate="true">
									<s:submit type="button" name="Submit" value="UpDate"
										class="btn btn-info" labelposition="left">
									</s:submit>
								</s:form></td>




							<td><s:url action="supprimerCategorie" var="actionUrl">
									<s:param name="idCategorie" value="idCategorie" />
								</s:url> <s:a class="btn btn-danger" href="%{actionUrl}">Delete</s:a></td>
						</tr>
					</s:iterator>

				</tbody>
			</table>
		</s:if>
		<s:else>
                  Aucun Categorie dans la liste
                </s:else>


		<script type="text/javascript" src="js/bootstrap.js"></script>
	</div>

</body>
</html>