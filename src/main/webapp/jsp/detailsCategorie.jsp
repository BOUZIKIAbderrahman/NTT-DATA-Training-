<%@ taglib prefix="s" uri="/struts-tags"%>
<table border="1" cellpadding="5" cellspacing="2">
	<tr bgcolor="#DEA254">
		<td>identifiant</td>
		<td>pseudo</td>
		<td>email</td>
		<td>code postal</td>
		<td>dateinscription</td>
	</tr>
	<s:if test="listContacts.size()>0">
		<s:iterator value="listContacts">
			<tr>
				<td><s:property value="identifiant" /><br /></td>
				<td><s:property value="pseudo" /><br /></td>
				<td><s:property value="mail" /><br /></td>
				<td><s:property value="codePostal" /><br /></td>
				<td><s:property value="dateInscription" /><br /></td>
			</tr>
		</s:iterator>
	</s:if>

</table>
<p></p>
<s:if test="!listContacts.size()>0">
	<center>
		<s:text name="annuaire.message.selectajaxlist"></s:text>
	</center>
</s:if>