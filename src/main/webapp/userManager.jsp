<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>User Management</title>
  <!-- Bootstrap 5 CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
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
      <th scope="col">Role</th>
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
        <td><c:out value="${user.manage}" /></td>
        <td>
          <a href="User?id=${user.id}&action=update&type=manager" class="btn btn-warning btn-sm">Update</a>
          <a href="User?id=${user.id}&action=delete&type=manager" class="btn btn-danger btn-sm">Delete User</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <button type="button" class="btn btn-primary mt-3" data-bs-toggle="modal" data-bs-target="#exampleModal">
    Create New User
  </button>

  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Create User</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form action="Register" method="post">
            <div class="form-group">
              <label for="username">Username</label>
              <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>
            </div>
            <div class="form-group">
              <label for="firstname">Firstname</label>
              <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Enter your first name" required>
            </div>
            <div class="form-group">
              <label for="lastname">Lastname</label>
              <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Enter your last name" required>
            </div>
            <div class="form-group">
              <label for="email">Email</label>
              <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
            </div>
            <div class="form-group">
              <label for="password">Password</label>
              <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
            </div>
            <div class="form-group">
              <label for="typeUser">User Type</label>
              <select class="form-select" id="typeUser" name="typeUser" aria-label="Default select example">
                <option value="USER">User</option>
                <option value="MANAGER">Manager</option>
              </select>
            </div>
            <button type="submit" name="submit" value="manager" class="btn btn-primary btn-block mt-3" data-bs-dismiss="modal">Register</button>
          </form>
        </div>
      </div>
    </div>
  </div>

  <a href="User?action=logout" class="btn btn-secondary mt-3">Logout</a>
</div>

<!-- Bootstrap 5 JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
