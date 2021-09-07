<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <title></title>
</head>

<body>
<table>
    <div class="container">
        <div class="row justify-content-md-center" >
            <div class="col col-lg-2">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Username</th>
                    <th scope="col">Role</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${listUser}">
                    <tr>
                        <th scope="row">${it.id}</th>
                        <td>${it.username}</td>
                        <td><g:each in="${it.getAuthorities()}">${it.authority}</g:each></td>
                        <td>
                            <g:link controller="back" action="editUser" id="${it.id}">Edit user</g:link>
                            <g:link controller="back" action="deleteUser" id="${it.id}">Delete user</g:link>
                        </td>
                    </tr>
                </g:each>
                </tbody>
            </table>
            </div>
        </div>
    </div>
</body>
</html>