<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Login</title>
</head>
<body>

<h1>哈哈哈哈哈</h1>

<div>
	name:<input id="name" type="text" > <br>
	pws: <input id="pws" type="password"> <br>
	<button onclick="doLogon()">登录</button>
</div>

<script type="text/javascript" src="/static/jquery-1.12.3.min.js"></script>

<script type="text/javascript">

	function doLogon() {
		var name = $('#name').val();
		var pws = $('#pws').val();
		window.location.href = "/logon.do?method=login&name=" + name + "&pws=" + pws + "&time=" + '<%= new Date() %>';
	}

</script>

</body>
</html>