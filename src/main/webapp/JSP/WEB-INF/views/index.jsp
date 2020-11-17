<%@ page import="ru.geekbrains.persist.ToDo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>
    <title>ToDo list application</title>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">ToDo</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">List</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <a class="btn btn-primary" href="todo.html">Add Todo</a>
        </div>

        <div class="col-12">
            <table class="table table-bordered my-2">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Description</th>
                    <th scope="col">Item</th>
                    <th scope="col">Price,rub</th>
                    <th scope="col">Quantity date</th>
                    <th scope="col">Description</th>
                </tr>
                </thead>
                <tbody>


                <c:forEach var="todo" items="${requestScope.todos}">
<%--                <% for (ToDo todo : (List<ToDo>) request.getAttribute("todos")) { %>--%>

                <tr>
                    <th scope="row">
                        <c:out value="${todo.id}"/>
<%--                        <%= todo.getId() %>--%>
                    </th>
                    <td>
                        <c:out value="${todo.description}"/>
<%--                        <%= todo.getDescription() %>--%>
                    </td>
                    <td>
                        Cristina
                    </td>
                    <td>
                        <c:out value="${todo.targetDate}"/>
<%--                        <%= todo.getTargetDate() %>--%>
                    </td>
                    <td>
                        <c:url value="/todo" var="todoUrl">
                            <c:param name="id" value="${todo.id}"/>
                        </c:url>
                        <a class="btn btn-success" href="${todoUrl}"><i class="fas fa-edit"></i></a>
                        <a class="btn btn-danger" href="#"><i class="far fa-trash-alt"></i></a>
                    </td>
                </tr>

<%--                <% } %>--%>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
