<!DOCTYPE html>
<html>
<head lang="en">
	<meta charset="UTF-8" />
	<title>${title}</title>
	<script src="/plugins/jquery/jquery-1.12.4.min.js" type="text/javascript"></script>
</head>
<body>
	  <h1>demo演示界面</h1>
	  
	  <p>列表</p>
	  <#list data! as item>
		<p>${item.name}</p>
	  </#list>
	  
	  <p>新增</p>
	  <form id="form1">
	  	<input type="text" name="id"/>
	  	<input type="text" name="name"/>
	  	<button type="button">提交</button>
	  </form>
	  <script>
	  	$(function(){
	  		$('#form1 button').click(function(){
	  			var formdata = $("#form1").serialize();
	  			$.ajax({
					type : "POST",
					url : "./add",
					data:formdata,
					dataType : "json",
					success : function(data) {
						if (data) {
							alert('添加成功')
						}else{
							alert('添加失败')
						}
					},
					error:function(XMLHttpRequest, textStatus, errorThrown) {
						console.log(errorThrown)
						alert('系统错误');
					}
				});
	  		})
	  	})
	  
	  
	  </script>
</body> 
</html>
