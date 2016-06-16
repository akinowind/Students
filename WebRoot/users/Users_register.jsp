<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="restyle/bootstrap.css">
<link rel="stylesheet" type="text/css" href="restyle/register.css">
<link rel="stylesheet" type="text/css" href="restyle/font-awesome.min.css">
</head>
<body>
	<div class="head">
		<div class="logo">
			<h1>博客<small>用户注册</small></h1>
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
						注&nbsp;&nbsp;&nbsp;&nbsp;册
						</div>
						<s:form action="register.action" method="post">
						<div id="error-login" class="login-error" style="display: none"></div>
						<div class="user">
							<div class="user-tittle"><span>*</span>用户名:</div>
							<div class="user-margin">
							<label class="static-font">
							<i class="icon-user"></i>
							</label>
							<input name="uname" type="text" class="login-user">
							</div>
						</div><br/>
						<div class="username">
							<div class="user-tittle"><span>*</span>密&nbsp;&nbsp;&nbsp;&nbsp;码:</div>
							<div class="user-margin">
							<label class="static-font">
							<i class="icon-lock"></i>
							</label>
							<input type="password" name="upasswd" class="login-user">
							</div>
						</div><br/>
						<div class="username">
							<div class="user-tittle" style="margin-left: -14px;"><span>*</span>确认密码:</div>
							<div class="user-margin">
							<label class="static-font">
							<i class="icon-lock"></i>
							</label>
							<input name="upasswd2" type="password" class="login-user">
							</div>
						</div><br/>
						<div class="login-link">
							
						</div>
						<input type="submit" class="btn btn-info" value="注册" />
						</s:form>
					</div>
				</div>
			</div>
		</div>


	</div>
</body>