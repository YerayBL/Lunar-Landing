<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
		<title>Lunar Landing in HTML5</title>
		<link rel="stylesheet" href="css/style.css">
		<script src="js/jquery-3.1.1.min.js"></script>
		<script src="js/lunar.js"></script>
                <link href="../../css/estilos.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
            <div id="ranking">
                <p>RANKING</p>
                <%
                if (request.getAttribute("primero") != null) {
                    out.println("<p class='primero'>" + request.getAttribute("primero") + "</p>");
                }
                if (request.getAttribute("segundo") != null) {
                    out.println("<p class='segundo'>" + request.getAttribute("segundo") + "</p>");
                }
                if (request.getAttribute("tercero") != null) {
                    out.println("<p class='tercero'>" + request.getAttribute("tercero") + "</p>");
                }
            %>
            </div>
            <div id="lastCon">
                <p>Últimas partidas</p>
                <%
                if (request.getAttribute("last") != null) {
                    out.println("<p class='last'>" + request.getAttribute("last") + "</p>");
                }
                if (request.getAttribute("last2") != null) {
                    out.println("<p class='last2'>" + request.getAttribute("last2") + "</p>");
                }
                if (request.getAttribute("last3") != null) {
                    out.println("<p class='last3'>" + request.getAttribute("last3") + "</p>");
                }
            %>
            </div>
		<div id="state">
			<div class="container">
				<h1></h1>
				<h2></h2>
				<a href="#" onclick="reset();">Play again</a>
			</div>
		</div>
		<div id="game">
			<div id="gauge"><div></div></div>
			<div id="ship"></div>
			<div id="explode"></div>
			<div id="moon">
				<div id="landing-pad"><div id="ms">-</div></div>
			</div>
		</div>
	</body>
</html>