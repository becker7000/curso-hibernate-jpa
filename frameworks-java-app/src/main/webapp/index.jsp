<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Bienvenidos a Frameworks Java</title>
</head>
<body>

    <h1>Bienvenidos a una app con frameworks para Java</h1>
    <h2>Ejemplos</h2>

    <ul>
        <li>
            <a href='<s:url action="editar"/>'>Editar mis datos</a>
        </li>
        <li>
            <a href='<s:url action="listar-productos"/>'>Listar productos (HB)</a>
        </li>
    </ul>

</body>
</html>