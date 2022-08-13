<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Book Directory</title>

<jsp:include page="head.jsp" />

</head>


<body>

	<jsp:include page="navBar.jsp"></jsp:include>
	
	<main class="container-fluid">
		<h1>Welcome to the book directory!</h1>
		<form action="getTitle.do" method="GET">
			Search by Title: <input class="form-control" type="text"
				name="title" /><br> <input class="btn btn-primary" type="submit"
				value="Show Books" />
		</form><br><br>
		
		<form action="getAuthor.do" method="GET">
			Search by Author: <input class="form-control" type="text"
				name="author" /><br> <input class="btn btn-primary" type="submit"
				value="Show Books" />
		</form><br><br>
		
		<form action="getGenre.do" method="GET">
			Search by Genre: <input class="form-control" type="text"
				name="genre" /><br> <input class="btn btn-primary" type="submit"
				value="Show Books" />
		</form><br><br>
		
		<form action="getSeriesName.do" method="GET">
			Search by Series Name: <input class="form-control" type="text"
				name="series_name" /><br> <input class="btn btn-primary" type="submit"
				value="Show Books" />
		</form><br><br>
		
		<form action="getDescription.do" method="GET">
			Search by Book Description: <input class="form-control" type="text"
				name="book_description" /><br> <input class="btn btn-primary" type="submit"
				value="Show Books" />
		</form>
		
		<c:choose>
			<c:when test="${not empty books }">
				<table class="table table-striped table-hover">
					<thead class="table-dark">
						<tr>
							<th>ID</th>
							<th>Title</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${books }">
							<tr>
								<td>${book.id}</td>
								<td><a href="getBook.do?title=${book.id}"> ${book.title }
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
		</c:choose>
	</main>




	<jsp:include page="foot.jsp" />

</body>
</html>