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
		<h1>Student Services</h1>
		<br><br><br><br>
	  <div >
	  	<br><br>

	  	<form action="ServeletStudentServices" method="POST"> 
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
			<label>Course Name</label>
			<input type="text" name="CourseName" required>
		</div>
		<br><br>
		<div>
			<label>Course Year</label>
			<input type="text" name="CourseYear" required>
		</div>
		<br><br>

		<div>
			<input type="submit" value="Register In Course">
		</div>
		<br><br>
		</form>
		
		<form action="ServeletStudentServices" method="GET"> 
		<div>
			<label>Student ID</label>
			<input type="text" name="StudentID" required>
		</div>
		<br><br>
		<div>
			<input type="submit" value="View All Past and Currently Courses">
		</div>
		<br><br>
		
		
		</form>
		<br><br>


       </div>
	</center>
</body>
</html>