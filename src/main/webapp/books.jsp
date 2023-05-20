<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"> 
<!-- <link rel="stylesheet"href="./css/styles.css" type="text/css"/> 
<link rel ="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css">
<link rel= "stylesheet" href= "https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css">

 -->



<meta charset="ISO-8859-1">
<title>Insert title here</title>
<nav class="navbar navbar-light bg-light">
  <span class="navbar-brand mb-0 h1"><a href="addBook.jsp">Add Book</a></span>
</nav>
</head>
<body>




<table id="mainTable" class="table table-bordered table-striped">
<thead class= "table-dark">
<tr>
<th scope="col">ID</th>
<th scope="col">Title</th>
<th scope="col">Author</th>
<th scope="col">Date</th>
<th scope="col">Genres</th>
<th scope="col">Characters</th>
<th scope="col">Synopsis</th>
<!--<th colspan="2">Action</th>  -->
<th > Action </th>

</thead>
<tbody>
<c:forEach items="${books}" var="b">
<tr class="justify-content-center">

<td >${b.id}</td>
<td ><b>${b.title}</b></td>
<td >${b.author}</td>
<td >${b.date}</td>
<td ><b>${b.genres}</b></td>
<td >${b.characters}</td>
<td >${b.synopsis}</td>
<td ><a href="./edit?id=${b.id}" >edit</a>
<a href="./delete?id=${b.id}" >delete</a></td>

</tr>
</c:forEach>
</tbody>

</table>


</body>
</html>