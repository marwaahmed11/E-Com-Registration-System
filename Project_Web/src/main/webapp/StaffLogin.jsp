<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
		<h1>Login </h1>
		<h2>Staff</h2>
		<br><br><br><br>
	  <div style="background-color: grey; width: 500px;">
	  	<br><br>

	  	<form action="ServeletLoginStaff" method="POST"> 
		<div>
			<label>ID</label>
			<input type="text" name="StaffID" required>
		</div>
		<br><br>

		<div>
			<label>Password</label>
			<input type="password" name="StaffPassword" required>
		</div>
		<br><br>

		<div>
			
			<input type="submit" value="Login">
		</div>
		</form>
		<br><br>


       </div>
	</center>
</body>
</html>