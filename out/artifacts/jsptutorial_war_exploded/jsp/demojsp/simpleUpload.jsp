<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SimpleUpload</title>
</head>
<body>
<h3>File Upload:</h3>
Select a file to upload: <br />
<form action = "${pageContext.request.contextPath}/uploadServlet" method = "post" enctype = "multipart/form-data">
    <input type = "file" name = "file" size = "50" />
    <br />
    <input type = "submit" value = "Upload File" />
</form>
</body>
</html>