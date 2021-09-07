<%--
  Created by IntelliJ IDEA.
  User: Zakaria
  Date: 17/09/2020
  Time: 21:53
--%>

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
                        <th scope="col">Title</th>
                        <th scope="col">Desc</th>
                        <th scope="col">Price</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${listSalesAd}">
                        <tr>
                            <th scope="row">${it.id}</th>
                            <td>${it.title}</td>
                            <td>${it.descShort}</td>
                            <td>${it.price}</td>
                            <td>
                                <g:link controller="back" action="editAd" id="${it.id}">Edit ad</g:link>
                                <g:link controller="back" action="deleteAd" id="${it.id}">Delete ad</g:link>
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