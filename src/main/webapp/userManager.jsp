<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>User Management</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container mt-5">
  <h1 class="text-center">User Management</h1>
  <table class="table table-striped">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Email</th>
      <th scope="col">Username</th>
      <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}">
      <tr>
        <th scope="row">${user.id}</th>
        <td><c:out value="${user.firstname}" /></td>
        <td><c:out value="${user.lastname}" /></td>
        <td><c:out value="${user.email}" /></td>
        <td><c:out value="${user.username}" /></td>
        <td>
          <a href="User?id=${user.id}&action=update&type=manager" class="btn btn-warning btn-sm">Update</a>
          <a href="User?id=${user.id}&action=delete&type=manager" class="btn btn-danger btn-sm">Delete User</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <a href="createUser.jsp" class="btn btn-primary">Add New User</a>
  <a href="User?action=logout" class="btn btn-secondary mt-3">Logout</a>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
