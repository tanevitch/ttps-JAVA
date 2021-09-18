<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.HashMap"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Chequear reserva</title>
</head>
<body>
<section>
<H1>Seleccione:</H1>

<form action="ServletChequearReserva" method="post">
<select name="actividades">
<%HashMap<String,Integer> actividades =(HashMap<String,Integer>)application.getAttribute("actividades");
 for (String act: actividades.keySet()){ %>
 <OPTION VALUE="<%=act%>"><%= "Cupos disponibles: "+actividades.get(act)+","+act%></OPTION>
 <%}%>
 </select>
 <input type="submit" >

 </form>
 </section>
</body>
</html>