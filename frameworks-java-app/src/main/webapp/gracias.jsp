<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Actualización exitosa</title>
</head>
<body>

    <h1>Información actualizada con éxito!</h1>
    <p>Tu información: <s:property value="persona"/></p>
    <p><a href="<s:url action='index'/>">Regresar al inicio</a></p>

</body>
</html>