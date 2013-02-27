<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h2>上传文件</h2>
	<form method="post" action="upload" enctype="multipart/form-data">
		<input type="text" name="filename" /> <input type="file"
			name="filedata" /> <input type="submit" value="提交"/>
	</form>
</body>
</html>
