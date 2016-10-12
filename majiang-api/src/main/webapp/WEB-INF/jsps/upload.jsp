<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
    
<%@ page import="java.lang.Math" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Upload</title>
</head>
<body>


<form method="post" enctype="multipart/form-data"
	action="/Archive.do?method=addArchive&qpCreditReportId=&archiveOperateMethod=archiveJSAddByArchiveNO&random=<%=Math.random() %>">

客户姓名：<input id="name" name="archiveVO.querierName" type="text"> <br>
证件号码：<input id="certNo" name="archiveVO.querierCertno" type="text"> <br>
证件类型：<input id="certype" name="archiveVO.querierCertype" type="text"> <br>
手机号码：<input id="telNum" name="archiveVO.telNum" type="text"> <br>
授权日期：<input id="authDate" name="archiveVO.authDate" type="text"> <br>
档案文件上传：	<input type="file" name="uploadfile" id="uploadfile" ><br>
	
	<button type="submit">确定</button>
	
</form>


<script type="text/javascript" src="/static/jquery-1.12.3.min.js"></script>



</body>
</html>