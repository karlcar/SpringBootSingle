<!DOCTYPE html>
<html xmls:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
	pageEncoding="UTF-8">
<link rel="stylesheet" th:href="@{/css/bootstrap.min.css}">
<script th:src="@{/js/jquery.min.js}"></script>
<script th:src="@{/js/bootstrap.min.js}"></script>
<title>订单用户信息</title>
<style>
	.form-group{
		margin-top:20px;
		margin-bottom:20px;
	}
</style>
</head>
<body style="margin-left: 100px; margin-right: 100px; margin-top: 40px;">
	<form class="form-horizontal" role="form" th:action="@{/user/updateUser}" th:method="post">
		<div class="form-group">
			<label for="id" class="col-sm-2 control-label">序号</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="id" name="id" th:value="${user?.id}" placeholder="请输入序号">
			</div> 
		</div>
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">姓名</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="username" name="username" th:value="${user?.username}" placeholder="请输入姓名">
			</div>
		</div>
		<div class="form-group">
			<label for="birthday" class="col-sm-2 control-label">生日</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="birthday" name="birthday" th:value="${user?.birthday}" placeholder="请输入生日">
			</div>
		</div>
		<div class="form-group">
			<label for="sex" class="col-sm-2 control-label">性别</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="sex" name="sex" th:value="${user?.sex}" placeholder="请输入性别">
			</div>
		</div>
		<div class="form-group">
			<label for="address" class="col-sm-2 control-label">地址</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="address" name="address" th:value="${user?.address}" placeholder="请输入地址">
			</div>
		</div>
		
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<!-- 隐藏的用户id -->
				<input type="hidden" id="id" name="id" th:value="${user?.id}">
				<button type="submit" class="btn btn-default">提  交</button>
				&nbsp; &nbsp; &nbsp;
				<a th:href="@{/index}" class="btn btn-default">返   回</a>
				
			</div>
		</div>
	</form>

</body>
</html>