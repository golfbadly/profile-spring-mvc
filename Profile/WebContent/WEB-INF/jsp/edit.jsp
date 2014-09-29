<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/edit.css" />'>
<title>Create profile</title>

<body>
<div id="register">
	<div class="header">
	   <a class="logo">Edit your profile</a>
	   <a class="Login" href="/Profile/menu">Menu</a>
	</div>
        <div class="regis">	
	   <h> Edit your profile</h>
	   <form name="form" method="POST" action="Edit"> 
<br>
		   <p>About me</p> <textarea name="about" cols="50" rows="5">

				  </textarea>
<br> 
	<p>Where you see me?</p> <textarea name="location" cols="50" rows="5">

                                  </textarea>
<br>
        <p>How to contact me?</p> <textarea name="contact" cols="50" rows="5"> 
				  </textarea>
<br>
        <p>Education</p> <textarea name="education" cols="50" rows="5">

				  </textarea>
<br><br><br>  
	<input type="Submit" value="Save" >
	</form>
</div>
</div>
</body>
</html>

















