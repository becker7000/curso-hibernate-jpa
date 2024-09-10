<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Usando Struts 2 tags</title>
</head>
<body>

    <h1>Actualizando información</h1>
    <p>Usa el formulario para actualizar tus datos.</p>

    <s:form action="guardar" method="post">
        <s:textfield key="persona.nombre" />
        <s:textfield key="persona.apellido" />
        <s:select key="persona.deporte" list="deportes" />
        <s:radio key="persona.genero" list="generos" />
        <s:select key="persona.residencia" list="estados" listKey="estadoAbreviado" listValue="nombreEstado" />
        <s:checkbox key="persona.mayorDe18" />
        <s:checkboxlist key="persona.modelosDeCoche" list="modelosDeCocheDisponibles" />
        <s:submit key="persona.enviar" />
    </s:form>

</body>
</html>