<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:stylesheet src="bootstrap.css"/>

    <g:layoutHead/>
</head>
<body>

    <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand mb-0 h1" href="/">Le coin coin </a>

        <ul class="navbar-nav  navbar-expand-sm">
            <li class="nav-item mr-3">
                <a class="nav-link" href="/back/listUser">List Users</a>
            </li>
            <li class="nav-item mr-3">
                <a class="nav-link" href="/back/createUser">Add User</a>
            </li>
            <li class="nav-item mr-3">
                <a class="nav-link" href="/back/salesAd">List Sales Ad</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/back/createSalesAd">Add Sale Ad</a>
            </li>
        </ul>
        <g:if test="${g.isLoggedIn() == 'true'}">
            <div class="my-2 my-sm-0">
                <h4><span class="badge badge-secondary" style="padding: 10px 12px;"><g:username /></span>
                <a href="/logout" class="btn btn-danger" >Log out</a></h4>
            </div>
        </g:if>
        <g:else>
            <a href="/login" class="btn btn-outline-success my-2 my-sm-0" >Login</a>
        </g:else>

    </nav>

    <g:layoutBody/>
    <asset:javascript src="bootstrap.js"/>

</body>
</html>
