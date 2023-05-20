<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
                var date = "${books.date}";
                console.log(date);
                $("#datepicker").datepicker('setDate', date);
            });
        </script>


</head>
<body>
<div>


<form action="./edit" method ="post">
<div class="form-group">
<input type ="hidden" name="id" value='${books.id}'>
</div>
  <div class="form-group">
    <label for="title">Title</label>
    <input type="text" class="form-control" id="title" name="title" value='${books.title}'>
  </div>
  <div class="form-group">
    <label for="author">Author</label>
    <input type="text" class="form-control" name="author" id="author" value='${books.author}'>
  </div>
  <div class="form-group">
    <label for="date">Date</label>
    <input type="text" class="form-control" name="date" id="datepicker" value='${books.date}' />
  </div>
  <div class="form-group">
    <label for="genres">Genres</label>
    <input type="text" class="form-control" name="genres" id="genres" value='${books.genres}'>
  </div>
  <div class="form-group">
    <label for="characters">Characters</label>
    <textarea class="form-control" name="characters" id="characters" rows="3">${books.characters}</textarea>
    </div>
  <div class="form-group">
    <label for="synopsis">Synopsis</label>
    <textarea class="form-control" name="synopsis" id="synopsis" rows="3">${books.synopsis}</textarea>
  </div>
  <button type="submit" class="btn btn-primary">Save</button>
</form>
</div>
</body>
</html>