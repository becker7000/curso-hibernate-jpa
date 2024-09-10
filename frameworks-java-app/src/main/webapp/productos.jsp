<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Lista de productos</title>
</head>
<body>

    <h1>Listando productos</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Existencias</th>
                <th>Categoria</th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="productos" var="producto">
                <tr>
                    <td><s:property value="#producto.idproducto"/></td>
                    <td><s:property value="#producto.nombre"/></td>
                    <td><s:property value="#producto.precio"/></td>
                    <td><s:property value="#producto.existencias"/></td>
                    <td><s:property value="#producto.categoria"/></td>
                </tr>
            </s:iterator>
        </tbody>
    </table>

</body>
</html>