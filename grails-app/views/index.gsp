<!doctype html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>le coin coin</title>
</head>
<body>
    <div class="container">
        <g:each status="i" var="it" in="${ listSalesAd }">
            <g:if test="${ i % 3 == 0 }">
                <g:if test="${ i != 0 }">
                    </div>
                </g:if>
                <div class="card-deck mb-3">
            </g:if>
                <div class="card">
                    <img src="http://localhost:8080/assets/salesAd/filename.png" class="card-img-top">
                    <div class="card-body">
                        <h5 class="card-title">${ it.title } </h5>
                        <p class="card-text">${ it.descShort } </p>
                        <p class="card-text">Price : <b>${ it.price }$</b></p>
                    </div>
                </div>

            <g:if test="${ i == ( listSalesAd.size() - 1 ) }">
                </div>
            </g:if>
        </g:each>
    </div>
</body>
</html>
