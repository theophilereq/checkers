<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/semantic.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-2.2.0.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/game.js"></script>
    </head>

    <body id="example" class="site">

        <div class="navbar navbar-static-top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-offset-4 col-lg-4">
                        <a class="navbar-brand">CHECKERS GAME</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="main container">

            <div class="row">
                <c:if test="${game.winner != null}">
                    <div id="div-winner" class="col-md-2 col-md-offset-4 col-xs-offset-3">
                        <div id="winner" class="massive circular ui icon ${game.winner.cssColor} button">WINS</div>
                    </div>
                </c:if>
            </div>

            <div class="row">
                <p>${game.gameExceptionMessage}</p>
                <c:if test="${game.gameExceptionMessage == null}">
                    <p>Exception null</p>
                </c:if>
            </div>

            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div style="display: none" id="emptyCell" class="alert alert-warning alert-dismissible fade in" role="alert">
                        <strong>Please select a block with a piece on it!</strong>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div id="board" class="ui ten row padded grid">
                        <c:forEach items="${game.columns}" var="col">
                            <div id="checkers" class="column">
                                <c:forEach items="${col.cells}" var="cell">
                                    <div id="boxGame" class="row">
                                        <a id="${col.index},${cell.index}" onclick="selectCell(${col.index},${cell.index},'${cell.cssColor}','${game.turn}')" class="massive circular ui icon ${cell.cssColor}  button"></a>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-3 col-md-offset-3 col-sm-6 col-xs-6">
                    <div id="turn" class="massive circular ui icon ${game.turn} button large" >Turn</div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-6">
                    <a id="reset" href="?reset" class="massive circular icon ui red button" id="reset">Reset game</a>
                </div>
            </div>
        </div>
    </body>
</html>
