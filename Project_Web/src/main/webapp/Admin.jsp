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
		<h1>Admin Services</h1>
		<br><br><br><br>
	  <div >
	  	<br><br>

	  	<form action="ServeletAdminServices_1" method="POST"> 
		<div>	
			<input type="submit" value="Create New Student Account">
		</div>
		</form>
		<br><br>
		
		<form action="ServeletAdminServices_3" method="POST"> 
		<div>
			<label>Staff ID</label>
			<input type="text" name="StaffId" required>
		</div>
		<br><br>
		<div>
			<label>Course ID</label>
			<input type="text" name="CourseId" required>
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
			<input type="submit" value="Create New Staff Account">
		</div>
		<br><br>
		</form>
		
		<form action="ServeletAdminServices_2" method="POST"> 
		<div>
			<label>Course ID</label>
			<input type="text" name="CourseId" required>
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
			<input type="submit" value="Create New Course">
		</div>
		<br><br>
		</form>
		
		<form action="ServeletAdminServices_1" method="GET"> 
		<div>
			<label>Student ID</label>
			<input type="text" name="StudentID" required>
		</div>
		<br><br>
		
		<div>	
			<input type="submit" value="View Student Courses">
		</div>
		<br><br>
		</form>
		
		<form action="ServeletAdminServices_2" method="GET"> 
		<div>	
			<input type="submit" value="View All Students ">
		</div>
		<br><br>
		</form>
		<form action="ServeletAdminServices_3" method="GET"> 
		<div>	
			<input type="submit" value="View All Courses ">
		</div>
		<br><br>
		
		</form>
		<br><br>


       </div>
	</center>
</body>
</html>