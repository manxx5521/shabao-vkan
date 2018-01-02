<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"  xmlns="http://www.w3.org/1999/xhtml">
<head>
<#assign ctx=${pageContext.request.contextPath}>
<basePath value="${ctx}"></basePath>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="format=xhtml;url=/e/wap/" name="mobile-agent">
<meta name="keywords" content="标签选择">
<meta name="description" content="标签选择 ">
<title>标签选择</title>
<link rel="shortcut icon"href="${ctx}/vkan/image/favicon.ico" type="image/x-icon">
<link href="${ctx}/vkan/index.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="warp">
		<!-- 标签 -->
		<div class="tags-container list">
		</div>
		<div class="tags-container operation">
			 <ul class="tags-box">
			 	<c:if test="${type==1}">
			 	<li class="hot-1 curr"><a id="operation_ok" href="javascript:void(0)" class="tag-font-size-14">确定</a></li>
			 	</c:if>
				<c:if test="${type==2}">
				<li class="hot-1 curr"><a id="operation_zadd" href="javascript:void(0)" class="tag-font-size-14">子项添加</a></li>
				<li class="hot-1 curr"><a id="operation_zdel" href="javascript:void(0)" class="tag-font-size-14">子项去除</a></li>
				</c:if>
				<li class="hot-1 curr">
					<a id="operation_cancel" href="javascript:void(0)" class="tag-font-size-14">返回</a></li>
			</ul>
		</div>
		<div class="tips"></div>
		<input type="hidden" name="fileId" value="${fileId}">
		<input type="hidden" name="type" value="${type}">
	</div>
	<script src="${ctx}/plugins/jquery/jquery-1.12.4.min.js" type="text/javascript"></script>
	<script src="${ctx}/plugins/layer/layer.js" type="text/javascript"></script>
	<script src="${ctx}/vkan/tagselect.js" type="text/javascript"></script>
</body>
</html>