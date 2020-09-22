<%@page import="proyecto.alchemilla.transferencias.Usuario"%>
<div id="encabezado">
	<div style="text-align: center; font-size: 35px; color: white;">Encabezado<%=((Usuario)session.getAttribute("USUARIO_ACTUAL")).getAlias()%></div>
	<div style="position: fixed; right: 10px; top: 10px;color: white;">Texto a desplegar</div>
	<div style="position: fixed; right: 10px; top: 30px; color: white;"><a href="#">Salir</a></div>
</div>