<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Details Confirmation</title>
</head>
<body>
<form name="StudentEnrollConfirmForm"  method="post">
<label>First Name :</label><input type="text"  name="firstName" id="firstName" value="<%=request.getAttribute("firstName") %>"/><br>
<label> Last Name :</label><input type="text" name="lastName" id="lastName" value="<%=request.getAttribute("lastName") %>"/><br>
<input type="button" name="Submit" value="Submit" onclick="onConfirm();"/>
<input type="hidden" name="handleId" value="INSERT">
</form>
</body>

<script type="text/javascript">
function onConfirm(){
	document.StudentEnrollConfirmForm.action="${pageContext.request.contextPath}/StudentEnrollmentServlet";
	alert(document.StudentEnrollConfirmForm.action);
	document.StudentEnrollConfirmForm.submit();
}
</script>
</html>