<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/login.css" />'>
<title>Profile</title>

<body>
	<div id="blog">
		<table>
			<tr>
				<td>
					<form name="login" method="POST" action="Login">
						<input name="id" type="text" size="18" style="height: 50px;"
							placeholder="UserID" onkeypress="if (event.keyCode==13)">
				</td>
			</tr>
			<tr>
				<td><input name="pass" type="password" size="10"
					placeholder="Password" style="height: 50px;"
					onkeypress="if (event.keyCode==13)"> <input type="Submit"
					value="Login" style="height: 50px;" onClick="pasuser(form)">
					</form></td>
			</tr>
			<tr>
				<td><input type="button" value="Create your profile"
					onClick="window.location.href='/Profile/register'"
					style="margin-top: 5px;"></td>
			</tr>
		</table>
	</div>
	<div id="text">
		<h> <b>Welcome to my profile.</b></h>
		<p>
			<b>Please login. <br> If you want to know me.
			</b>
		</p>
	</div>


</body>
</html>