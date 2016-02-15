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
        <div class="ui fixed inverted main menu">
            <div class="container">
                <div class="title item">
                    <b>Checkers</b>
                </div>
            </div>
        </div>


        <div class="main container">

            <div id="emptyCell" class="alert alert-warning alert-dismissible fade in" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <strong>Please select a block with a piece on it!</strong>
            </div>
            <div id="sameColor" class="alert alert-warning alert-dismissible fade in" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <strong>Same Color</strong>
            </div>

            <div id="board" class="ui ten row padded grid">
                <c:forEach items="${game.columns}" var="col">
                    <div id="checkers" class="column">
                        <c:forEach items="${col.cells}" var="cell">
                        	<div id="boxGame" class="row">
                        		<a id="${col.index},${cell.index}" onclick="selectCell(${col.index},${cell.index},'${cell.cssColor}')" class="massive circular ui icon ${cell.cssColor}  button"></a>
                        	</div>
                        </c:forEach>
                    </div>
                </c:forEach>
            </div>
            <div class="massive circular ui icon ${game.turn}  button large" >Turn</div>
            <a id="reset" href="?reset" class="ui red button" id="reset">Reset game</a>
        </div>
</body>
</html>
