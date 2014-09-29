<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/p_education.css" />'>
<title>Profile</title>

<body>
<div id="aboutme">
	<div class="header">
	   <a class="logo">Profile</a>
	   <a class="menu" href="/Profile/menu">Menu</a>
	</div>
	<div id="content">
	   <div id="ctn_about"> 
		<ul id="c2">	
		   <li class="about">
<p>
<strong>Education</strong>
<br>

<p>${education}</p>

<!-- <canvas id="Canvas" width="420" height="100" 
style="border:1px solid #d3d3d3;">
Your browser does not support the HTML5 canvas tag.</canvas> -->
</p>
		   </li>
		</ul>
           </div>
	</div>

</div>
</body>
</html>

















