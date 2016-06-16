<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="style/bootstrap.css">
<link rel="stylesheet" type="text/css" href="style/login.css">
<link rel="stylesheet" type="text/css" href="style/font-awesome.min.css">
</head>
<body>
	<div class="head">
		<div class="logo">
			<h1>后台管理系统</h1>
		</div>
	</div>
	<div class="content">
		<div class="bg">
		</div>
		<div class="content-layout">
			<div class="login-box-wrap">
				<div class="login-box">
					<div class="bd">
						<div class="login-tittle">
						账户登录
						</div>
						<form name="loginForm" action="<%=path%>/users/Users_login.action" method="post">
						<div id="error-login" class="login-error" style="display: none"></div>
						<div class="user">
							<label class="static-font">
							<i class="icon-user"></i>
							</label>
							<input type="text" name="uname" class="login-user">
						</div>
						<div class="username">
							<label class="static-font">
							<i class="icon-lock"></i>
							</label>
							<input type="password" name="upasswd" class="login-user">
						</div>
						<div class="login-link">
							<a class="register" href="Users_register.jsp">注册</a>
						</div>
						<input type="submit" class="btn btn-info" value="登录"/>
						<input type="reset" class="btn" value="重置"/>
						<div>
					  		<s:fielderror/>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
