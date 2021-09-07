<%--
  Created by IntelliJ IDEA.
  User: Zakaria
  Date: 16/09/2020
  Time: 11:03
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <title>Create User</title>
</head>

<body>
    ${message}
<div class="container">
<div class="row">
    <form class="col mt-3" method="POST">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
        <div class="form-group">
            <label for="role">Role :</label>
            <g:select class="form-control" name="role" id="role" from="${listRole}" optionKey="id" optionValue="authority">
            </g:select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</div>
</body>
</html>