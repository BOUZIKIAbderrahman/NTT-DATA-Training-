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
<title><s:text name="categorie.form.newCategorie.title" /></title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
	<center>

		<div id="formulaire">

			<s:form method="post" action="upDateCategorie"
				enctype="multipart/form-data" validate="true">
				
				<div class="mb-3 mt-3" style="width: 500px">
					<label for="nomCategorie" class="form-label">Nom de
						Categorie:</label>
					<s:textfield name="nomCategorie" class="form-control" id="nomCategorie"
						labelposition="left">
					</s:textfield>
				</div>
				<div class="mb-3" style="width: 500px">
					<label for="description" class="form-label">Description:</label>
					<s:textfield name="description" class="form-control" id="description"
						labelposition="left">
					</s:textfield>
				</div>


				<s:submit type="button" name="Submit" class="btn btn-secondary" style="width: 500px" value="Envoyer"
					labelposition="left"></s:submit>

			</s:form>
			<script type="text/javascript" src="js/bootstrap.js"></script>
		</div>

	</center>
</body>
</html>
