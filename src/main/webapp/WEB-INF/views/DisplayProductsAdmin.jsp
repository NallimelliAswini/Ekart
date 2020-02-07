<%@page import="com.aswini.Ecommerce.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"  %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="x" %>
  <%@ include file= "UserHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="3" align="center">
<tr><th>productID</th>
<th>productName</th>
<th>productPrice</th>
<th>productDescription</th>
<th>DeleteOption</th>

</tr>
<x:forEach  items= "${prolist}" var="prod">
<tr>
<td>${prod.productId}</td>
<td>${prod.productName}</td>
<td>${prod.productPrice}</td>
<td>${prod.productDescription}</td>
<td><a href ="delete?proid=${prod.productId}">delete</a></td>
</tr>
</x:forEach>
</table>
</body>
</html>