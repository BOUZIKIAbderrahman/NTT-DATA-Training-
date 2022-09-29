<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des Produits</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="container mt-3">
		<center>
			<h2>Liste des Produits</h2>
		</center>
		<s:if test="%{listProduits.size()>0}">
			<table class="table" border="1">

				<thead class="table-success">

					<tr>
						<th>Id de Produit</th>
						<th>Nom de Produit</th>
						<th>Prix</th>
						<th>Quantite</th>
						<th>Photo</th>
						<th>Categorie</th>
						<th>Supprimer</th>
					</tr>

				</thead>
				<tbody>
					<s:iterator value="listProduits">
						<tr>
							<td><s:property value="idProduit" /></td>
							<td><s:property value="nomProduit" /></td>
							<td><s:property value="prix" /></td>
							<td><s:property value="quantite" /></td>
							<td><s:property value="Photo" /></td>
							<td><s:property value="Categorie.nomCategorie" /></td>
							<td><s:url action="supprimerProduit" var="actionUrl">
									<s:param name="idProduit" value="idProduit" />
								</s:url> <s:a class="btn btn-danger" href="%{actionUrl}">Delete</s:a></td>
						</tr>
					</s:iterator>

				</tbody>
			</table>
		</s:if>
		<s:else>
                  Aucun Produit dans la liste
                  
                </s:else>


		<script type="text/javascript" src="js/bootstrap.js"></script>
	</div>

</body>
</html>