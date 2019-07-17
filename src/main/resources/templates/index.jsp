<!DOCTYPE html>
<html xmls:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
	pageEncoding="UTF-8">
<link rel="stylesheet" th:href="@{/css/bootstrap.min.css}">
<script th:src="@{/js/jquery.min.js}"></script>
<script th:src="@{/js/bootstrap.min.js}"></script>
<title>订单用户信息</title>

</head>
<body style="margin-left: 100px; margin-right: 100px;">
	<table class="table">
		<div class="input-group" style="margin-top: 20px;margin-bottom: 20px;">
			<form action="index" method="post">
			<label>昵称：</label>
			
			<input type="text" class="input-large" name="nickname">
			<button class="btn btn-primary" type="submit" style="margin-left: 10px;">查询</button>
			<a th:href="@{/user/toAddUser}" class="btn btn-primary" style="margin-left: 10px;">添加用户</a>
			</form>
		</div>

		<thead>
			<tr>
				<th>序号</th>
				<th>昵称</th>
				<th>生日</th>
				<th>性别</th>
				<th>地址</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<tr th:each="user : ${userList}">
				<td th:text="${userStat.count}"></td>
				<td th:text="${user.username}"></td>
				<td th:text="${user.birthday}"></td>
				<td th:text="${user.sex}"></td>
				<td th:text="${user.address}"></td>
				<td><a th:href="@{'/user/toUpdate?id=' + ${user.id}}">修改</a> <a
					th:href="@{'/user/delete?id=' + ${user.id}}">删除</a></td>
			</tr>

			<tr style="text-align: center;">
				<td colspan="6">
					<span th:if="${curPage <= 1}"> 首页 上一页 </span> 
					<span th:if="${curPage > 1}"> <a th:href="@{/index?curPage=1}">首页</a>
						<a th:href="@{'/index?curPage=' + ${curPage-1}}">上一页</a>
					</span> 
				<span th:if="${curPage == totalPages}"> 下一页 尾页 </span> 
				<span th:if="${curPage < totalPages}"> 
					<a th:href="@{'/index?curPage=' + ${curPage+1}}">下一页</a> 
					<a th:href="@{'/index?curPage=' + ${totalPages}}">尾页</a>
				</span>
				</td>
		</tbody>
	</table>

</body>

</html>