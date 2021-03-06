<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
<div class="errors">${exception }</div>
<div id="formProd" class="cadre">
	<f:form modelAttribute="produit" action="saveProd" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID Produit</td>
				<td><f:input path="idProduit" /></td>
				<td><f:errors path="idProduit" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Désignation</td>
				<td><f:input path="designation" /></td>
				<td><f:errors path="designation" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><f:textarea path="description" /></td>
				<td><f:errors path="description" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Catégorie</td>
				<td><f:select path="categorie.idCategorie" items="${categories }"
						itemValue="idCategorie" itemLabel="nomCategorie"></f:select></td>
				<td><f:errors path="description" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Prix</td>
				<td><f:input path="prix" /></td>
				<td><f:errors path="prix" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Quantité</td>
				<td><f:input path="quantite" /></td>
				<td><f:errors path="quantite" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Sélectionner ?</td>
				<td><f:checkbox path="selected" /></td>
				<td><f:errors path="selected" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Photo</td>
				<c:if test="${produit.idProduit != null }">
					<td><img src="photoProd?idProd=${produit.idProduit}" /></td>
				</c:if>
				<td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save " /></td>
			</tr>
		</table>
	</f:form>
</div>
<div id="tabProduits" class="cadre">
	<table class="tab">
		<tr>
			<th>ID</th>
			<th>NOM PRODUIT</th>
			<th>DESIGNATION</th>
			<th>DESCRIPTION</th>
			<th>CATEGORIE</th>
			<th>PRIX</th>
			<th>QUANTITE</th>
			<th>SELECTED</th>
			<th>PHOTO</th>
		</tr>
		<c:forEach items="${produits }" var="prod">
			<tr>
				<td>${prod.idProduit }</td>
				<td>${prod.designation }</td>
				<td>${prod.description }</td>
				<td>${prod.categorie.nomCategorie }</td>
				<td>${prod.prix }</td>
				<td>${prod.quantite }</td>
				<td>${prod.selected }</td>
				<td><img src="photoProd?idProd=${prod.idProduit}" /></td>
				<td><a href="suppProd?idProd=${prod.idProduit }">Supprimer</a></td>
				<td><a href="editProd?idProd=${prod.idProduit }">Editer</a></td>
			</tr>
		</c:forEach>
	</table>
</div>