<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Enrollment</title>
</head>
<body>
<form name="StudentsEnrollForm"  action="../StudentEnrollmentServlet" method="post">
First Name<input type="text" name="firstName" id="firstName"  >
Last Name<input type="text" name="lastName" id="lastName"  >
<input type="button" name="Submit"  value="Submit" onclick="onSubmit();"/>
<input type="hidden" name="handleId" value="ENROLL">
</form>
</body>

<script>
function onSubmit(){
	//alert(document.StudentsEnrollForm.firstName.value);
	//alert(document.StudentsEnrollForm.lastName.value);
	document.StudentsEnrollForm.action="../StudentEnrollmentServlet";
	document.StudentsEnrollForm.submit();
}
</script>
</html>

