<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/semantic.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    </head>

    <body id="example" class="site">
        <div class="ui fixed inverted main menu">
            <div class="container">
                <a class="launch item"><i class="content icon"></i></a>
                <div class="title item">
                    <b>Checkers</b>
                </div>
            </div>
        </div>


        <div id="header" class="header segment">
            <div class="container">
                <h2 class="ui dividing header">Checkers</h2>
                <div class="introduction">
                    <p>Simple checkers app that makes use of JEE servlets</p>
                </div>

            </div>
        </div>

        <div class="main container">
            <div id="board" class="ui ten column padded grid">

                <c:forEach items="${game.columns}" var="col">
                    <div class="blue column">
                        <c:forEach items="${col.cells}" var="cell">
                            <a href="?selectedCol=${col.index}&selectedRow=${cell.index}" class="massive circular ui icon ${cell.cssColor}  button"></a>
                        </c:forEach>
                    </div>
                </c:forEach>
            </div>

            <a href="?reset" class="ui red button" id="reset">Reset game</a>

        </div>
    </body>
</html>
