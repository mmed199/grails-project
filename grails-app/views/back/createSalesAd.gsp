<%--
  Created by IntelliJ IDEA.
  User: Zakaria
  Date: 17/09/2020
  Time: 15:46
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <title></title>
</head>

<body>
<g:if test="${message != ''}">
    <div class="alert alert-primary" role="alert">
        ${message}
    </div>
</g:if>

<div class="container">
    <div class="row">
        <g:uploadForm name="myUpload" class="col mt-3" action="createSalesAd">
            <div class="form-group">
                <label for="title">Title :</label>
                <input type="text" class="form-control" id="title" name="title" placeholder="Enter title">
            </div>

            <div class="form-group">
                <label for="descShort">Short Description :</label>
                <input type="text" class="form-control" id="descShort" name="descShort" placeholder="Enter a short description">
            </div>

            <div class="form-group">
                <label for="descLong">Long Description :</label>
                <textarea class="form-control" id="descLong" name="descLong" placeholder="Enter a long description" rows="3"></textarea>
            </div>

            <div class="form-group">
                <label for="price">Price :</label>
                <input type="number" class="form-control" id="price" name="price" placeholder="Enter price">
            </div>

            <div class="form-group">
                <label for="illustration">Illustration :</label>
                <input type="file" class="form-control-file" id="illustration" name="illustration" accept="image/*"  multiple>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </g:uploadForm>
    </div>
</div>
</body>
</html>