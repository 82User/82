<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="fileupload.action" method="post" enctype="multipart/form-data">
	name : <input type="text" name="name"><br>
	age   : <input type="text" name="age"><br>
	photo : <input type="file" name="doc"><br>
	<input type="submit">
</form>

</body>
</html>