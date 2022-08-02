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
		<h1>Staff Services</h1>
		<br><br><br><br>
	  <div >
	  	<br><br>

	  	<form action="ServeletStaffServices" method="POST"> 
		<div>
			<label>Staff ID</label>
			<input type="text" name="StaffID" required>
		</div>
		<br><br>
		<div>
			<label>Student ID</label>
			<input type="text" name="StudentID" required>
		</div>
		<br><br>
		<div>
			<label>Course ID</label>
			<input type="text" name="CourseID" required>
		</div>
		<br><br>

		<div>
			<label>Grade</label>
			<input type="password" name="grade" required>
		</div>
		<br><br>

		<div>
			<input type="submit" value="Set Grade">
		</div>
		<br><br>
		</form>
		
		<form action="ServeletStaffServices" method="GET"> 
		<div>
			<label>Staff ID</label>
			<input type="text" name="StaffID" required>
		</div>
		<br><br>
			<div>
			<input type="submit" value="View All Student In My Courses">
		</div>
		<br><br>
		
		</form>
		<br><br>


       </div>
	</center>
</body>
</html>