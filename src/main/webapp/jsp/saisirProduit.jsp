<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<sx:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="categorie.form.newProduit.title" /></title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
	<center>

		<div id="formulaire">

			<s:form method="post" action="enregistrerProduit"
				enctype="multipart/form-data" validate="true">

				<div class="mb-3 mt-3" style="width: 500px">
					<label for="nomProduit" class="form-label">Nom de Produit:</label>
					<s:textfield name="nomProduit" class="form-control" id="nomProduit"
						labelposition="left">
					</s:textfield>
				</div>
				<div class="mb-3" style="width: 500px">
					<label for="description" class="form-label">Prix:</label>
					<s:textfield name="prix" class="form-control" id="prix"
						labelposition="left">
					</s:textfield>
				</div>

				<div class="mb-3" style="width: 500px">
					<label for="quantite" class="form-label">Quantite:</label>
					<s:textfield name="quantite" class="form-control" id="quantite"
						labelposition="left">
					</s:textfield>
				</div>
				<div class="mb-3" style="width: 500px">
					<label for="photo" class="form-label">Photo:</label>
					<s:textfield name="photo" class="form-control" id="photo"
						labelposition="left">
					</s:textfield>
				</div>
				<div class="mb-3" style="width: 500px">
					<label for="Categorie" class="form-label">Categorie:</label>
					<s:select label="Selectioner Categorie"
						headerValue="--- Select ---" list="listCategories"
						name="idCategorie" listKey="idCategorie" listValue="nomCategorie" />

				</div>


				<s:submit type="button" name="Submit" class="btn btn-secondary"
					style="width: 500px" value="Envoyer" labelposition="left"></s:submit>

			</s:form>
			<script type="text/javascript" src="js/bootstrap.js"></script>
		</div>

	</center>
</body>
</html>
