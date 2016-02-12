<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/semantic.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
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


        <div id="header" class="header segment">
            <div class="container">
                <h2 class="ui dividing header">Checkers</h2>
                <div class="introduction">
                    <p>Simple checkers app that makes use of JEE servlets</p>
                </div>

            </div>
        </div>

        <div class="main container">
            <div id="board" class="ui ten row padded grid">

                <c:forEach items="${game.columns}" var="col">
                    <div id="checkers" class="column">
                        <c:forEach items="${col.cells}" var="cell">
                        	<div id="boxGame" class="row">
                        		<a  onclick="test(${col.index},${cell.index})" class="massive circular ui icon ${cell.cssColor}  button"></a>
                        	</div>
                        </c:forEach>
                    </div>
                </c:forEach>
            </div>
            <div class="massive circular ui icon ${game.turn}  button" >Turn</div>
            <a href="?reset" class="ui red button" id="reset">Reset game</a>

        </div>
</body>
</html>
