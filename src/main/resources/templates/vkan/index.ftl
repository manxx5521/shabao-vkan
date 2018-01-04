<!DOCTYPE html>
<html lang="en"  xmlns="http://www.w3.org/1999/xhtml">
<head>
<#assign ctx=request.contextPath>
<basePath value="${request.contextPath}"></basePath>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="format=xhtml;url=/e/wap/" name="mobile-agent">
<meta name="keywords" content="资源管理">
<meta name="description" content="资源管理 ">
<title>资源管理</title>
<link rel="shortcut icon"href="${ctx}/static/vkan/image/favicon.ico" type="image/x-icon">
<link href="${ctx}/static/vkan/index.css" rel="stylesheet" type="text/css">
<style>
/**控制瀑布流宽度和高度*/
.grid__col-sizer,
.photo-item {
  width: 23%;
}

.grid__gutter-sizer {
  width: 2%;
}
</style>
</head>
<body>
	<div class="head-wrap">
		<div class="warp ovv">
			<div class="logo">
				<a href="./index.html" title="我的网站"> 
					<img width="180" height="45" src="${ctx}/static/vkan/logo.png">
				</a>
			</div>
			<div class="m-nav">
				<ul>
					<li class="menu-item current-menu-item"><a href="./index.html">全部</a></li>
					<li class="menu-item "><a href="javascript:void(0)">视频</a></li>
					<li class="menu-item "><a href="javascript:void(0)">图</a></li>
					<li class="menu-item "><a href="javascript:void(0)">|</a></li>
					<!--
					<li class="menu-item "><a href="http://ecms060.99yuanma.net:8888/qingchun/">清纯</a></li>
					<li class="menu-item "><a href="http://ecms060.99yuanma.net:8888/mengmeizi/">萌妹</a></li>
					<li class="menu-item "><a href="http://ecms060.99yuanma.net:8888/nvshen/">女神</a></li>
					<li class="menu-item">
						<a href="http://ecms060.99yuanma.net:8888/more/">更多</a>
						<ul class="sub-menu">
							<li class="menu-item"><a href="http://ecms060.99yuanma.net:8888/more/qizhimeinv/">气质</a></li>
							<li class="menu-item"><a href="http://ecms060.99yuanma.net:8888/more/nenmo/">嫩模</a></li>
							<li class="menu-item"><a href="http://ecms060.99yuanma.net:8888/more/bijini/">比基尼</a></li>
							<li class="menu-item"><a href="http://ecms060.99yuanma.net:8888/more/zuqiubaobei/">足球宝贝</a></li>
							<li class="menu-item"><a href="http://ecms060.99yuanma.net:8888/more/luoli/">萝莉</a></li>
							<li class="menu-item"><a href="http://ecms060.99yuanma.net:8888/more/90hou/">90后</a></li>
							<li class="menu-item"><a href="http://ecms060.99yuanma.net:8888/more/rihanmeinv/">日韩</a></li>
						</ul>
					</li>
					<li><a href="http://ecms060.99yuanma.net:8888/hot/" class="tab">最热</a></li>
					<li><a href="http://ecms060.99yuanma.net:8888/best/" class="tab">推荐</a></li>
					-->
					<li class="menu-item "><a id="searchId"  href="javascript:void(0)" >${data.projectName}<div class="searchBtn"></div></a><!-- <div class="searchBtn"><a name="search"></a></div> --></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="warp">
		<!-- 标签 -->
		<div class="tags-container list">
		</div>
		<div class="tags-container operation">
			 <ul class="tags-box">
				<li class="hot-1 curr"><a id="operation_search" href="javascript:void(0)" class="tag-font-size-14">查询</a></li>
				<li class="hot-1"><a id="operation_all" href="javascript:void(0)" class="tag-font-size-14">全部</a></li>
				<li class="hot-1"><a id="operation_set" href="javascript:void(0)" class="tag-font-size-14">设置</a></li>
				<li class="hot-1"><a id="operation_setvodie" href="javascript:void(0)" class="tag-font-size-14">设为视频</a></li>
				<li class="hot-1"><a id="operation_resml" href="javascript:void(0)" class="tag-font-size-14">更新目录</a></li>
				<li class="hot-1 curr"><a id="shangji" href="javascript:void(0)" title="去上级目录" class="tag-font-size-14">上级</a></li>
				<li class="hot-1"><p id="currml">目录：</p></li>
			</ul>
		</div>
		<div class="tips"></div>
		<!--图片展示begin-->
		<div id="body-container">
			<span id="dataGroup">
				<!--  style="position: relative; height: 2417px;" -->
				<div id="img-container" class="masonry">
					<div class="grid__col-sizer"></div>
  					<div class="grid__gutter-sizer"></div>
					<!-- 
					<div class="border-img-box masonry-brick">
						<div class="img_inner_wrapper">
							<div class="inner_wrapper_img inner_wrapper_img1">
								<div>
									<a href="http://ecms060.99yuanma.net:8888/more/nenmo/1658.html"
										target="_blank"> <img title="2014车展上靓丽车模写真"
										class="img-min-height" alt="2014车展上靓丽车模写真"
										src="./妹子图_files/b20872116a242e36ff2fe74bbc652c0f.jpg"></a>
								</div>
								<div class="mid_img_count">
									<span class="num"> <label>9</label>
									</span> <span class="mid_img_count_font"> <label>张</label>
									</span>
								</div>
								<div class="img_inner_wrapper_tag">
									<div class="title">
										<a
											href="http://ecms060.99yuanma.net:8888/more/nenmo/1658.html"
											target="_blank">2014车展上靓丽车模写真</a>
									</div>
									<div class="tag curr">
										<label>分类：</label> <a
											href="http://ecms060.99yuanma.net:8888/more/nenmo/">嫩模</a>
									</div>
									<div class="tag curr">
										<label>标签：</label> <a
											href="http://ecms060.99yuanma.net:8888/e/tags/?tagname=%E6%A8%A1%E7%89%B9"
											target="_blank" rel="tag">模特</a> <a
											href="http://ecms060.99yuanma.net:8888/e/tags/?tagname=%E5%86%99%E7%9C%9F"
											target="_blank" rel="tag">写真</a> <a
											href="http://ecms060.99yuanma.net:8888/e/tags/?tagname=%E8%BD%A6%E6%A8%A1"
											target="_blank" rel="tag">车模</a>
									</div>
								</div>
							</div>
						</div>
					</div>
 -->
				</div>
			</span>
		</div>
		<!--图片展示end-->
		<!-- 下拉分页 -->
		<div class="page-load-status">
			<div class="loader-ellips infinite-scroll-request">
				<span class="loader-ellips__dot"></span> 
				<span class="loader-ellips__dot"></span> 
				<span class="loader-ellips__dot"></span>
				<span class="loader-ellips__dot"></span>
			</div>
			<p class="infinite-scroll-request">Loading...</p>
			<p class="infinite-scroll-last">没有更多记录了</p>
			<!-- <p class="infinite-scroll-error">No more pages to load</p> -->
		</div>
	</div>
	
	<div style="" id="gotoTop">
		<a class="goto-top" rel="nofollow" title="返回顶部" onclick="javascript:scroll(0,0);" href="javascript:scroll(0,0)"></a>
	</div>
	<div class="warp" id="friendlyLink">
		<div class="link_title">
			<span class="title">友情链接</span>
		</div>
		<div class="links">
			<a href="./index.html" target="_blank">友链1</a> 
		</div>
	</div>
	<div class="warp" id="footer">
		<div class="remark">
			©2015 <a href="./index.html">我的网站</a> 版权所有
			*ICP-*号 联系邮箱：382752556@qq.com
			<!--统计代码放到这里-->
		</div>
	</div>
	<div id="simplemodal-container"></div>
	<div id="searchbar">
		<p>全站搜索</p>
		<form method="post" name="searchform">
			<select name="projectPrefix">
				<#list data.prefixs! as item>
				<option value ="${item}" <#if item==data.projectPrefix> selected="selected" </#if>>${item}</option>
				</#list>
			</select>
			<select name="projectId">
				<#list data.projectList! as r>
				<option value ="${r.projectId}" <#if r.projectId==data.projectId> selected="selected"</#if>>${r.projectName}</option>
				</#list>
			</select>
			<input type="text" name="keyboard" id="edtSearch" class="text" value=""> 
			<input type="hidden" name="parentId" value="${data.parentId}"/> 
			<input type="hidden" name="projectPath" value="${data.projectPath}"/> 
			<input type="button" id="btnPost" value="确定">
		</form>
	</div>
	<script src="${ctx}/static/plugins/jquery/jquery-1.12.4.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/plugins/layer/layer.js" type="text/javascript"></script>
	<script src="${ctx}/static/plugins/masonry/masonry.pkgd.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/plugins/infinite-scroll/infinite-scroll.pkgd.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/vkan/index.js" type="text/javascript"></script>
</body>
</html>