<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Information</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container mt-5">
    <h1 class="text-center">User Information</h1>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Profile Details</h5>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">
                    <strong>Email:</strong> ${user.email}
                </li>
                <li class="list-group-item">
                    <strong>Username:</strong> ${user.username}
                </li>
            </ul>
            <a href="User?id=${user.id}&action=update&type=user" class="btn btn-primary mt-3">Edit Profile</a>
            <a href="User?id=${user.id}&action=delete&type=user" class="btn btn-danger mt-3">Delete Account</a>
            <a href="User?action=logout" class="btn btn-secondary mt-3">Logout</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
