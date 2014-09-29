<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>

<%
	Class.forName("com.mysql.jdbc.Driver");
%>

<%
	Connection connection = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/Myprofile", "root", "3009");

	Statement st = connection.createStatement();
	String obj = "All";
	session = request.getSession();
	if(null != session.getAttribute("job")){
		obj = (String)session.getAttribute("job");
	}
	

	ResultSet rs;
	if (obj.equals("All")) {
		rs = st.executeQuery("select * from user");
	} else if (obj.equals("Manager")) {
		rs = st.executeQuery("select * from user where job = 'Manager'");
	} else {
		rs = st.executeQuery("select * from user where job = 'Employee'");
	}
%>

<html>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/admin.css" />'>
<title>Admin Page</title>


<body>
	<div id="register">
		<div class="header">
			<a class="logo">Manage user</a> <a class="Login" href="/Profile/">Logout</a>
		</div>
		<div class="regis">
			<h> Manage user</h>

			<form name="form" method="POST" action="Admin">
				<TABLE BORDER="1">
				<!--  	<select id="map" name="map" onchange="Assign()">
						<option value="All">All</option>
						<option value="Manager">Manager</option>
						<option value="Employee">Employee</option>  
					</select>  -->
					<input type="button" id = "job1" value="All" onClick="Assign1()" />
					<input type="button" id = "job2" value="Manager" onClick="Assign2()" />
					<input type="button" id = "job3" value="Employee" onClick="Assign3()" />
					<br>
					<br>
					<TR>
						<TH>ID</TH>
						<TH>First name</TH>
						<TH>Last name</TH>
						<TH>About</TH>
						<TH>Location</TH>
						<TH>Contact</TH>
						<TH>Education</TH>
						<TH>Job</TH>
					</TR>
					<%
						while (rs.next()) {
					%>
					<TR>
						<TD><%=rs.getString(1)%></TD>
						<TD><%=rs.getString(4)%></TD>
						<TD><%=rs.getString(5)%></TD>
						<TD><%=rs.getString(6)%></TD>
						<TD><%=rs.getString(7)%></TD>
						<TD><%=rs.getString(8)%></TD>
						<TD><%=rs.getString(9)%></TD>
						<TD><select name="jobs">
								<option value="<%=rs.getString(1) + "-None"%>">None</option>
								<option value="<%=rs.getString(1) + "-Manager"%>"
									<%if ("Manager".equals(rs.getString(10)))
					out.print("selected");%>>Manager</option>
								<option value="<%=rs.getString(1) + "-Employee"%>"
									<%if ("Employee".equals(rs.getString(10)))
					out.print("selected");%>>Employee</option>
						</select></TD>
					</TR>
					<%
						}
					%>
				</TABLE>
				<br> <input type="submit" value="Save" size="7" />

			</form>

		</div>
	</div>
	</div>
</body>
<script type="text/javascript">
function Assign1(){
	window.location.href="/Profile/admin?map="+document.getElementById("job1").value;
}
function Assign2(){
	window.location.href="/Profile/admin?map="+document.getElementById("job2").value;
}
function Assign3(){
	window.location.href="/Profile/admin?map="+document.getElementById("job3").value;
}
</script>
</html>

















