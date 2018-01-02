var webroot=$('basePath').val();

$(function() {
	var tags = new Array();
	var page = (function() {
		var infScroll;
		var msnry;
		// 查询标签
		return {
			loadTag : function() {
				var fileId=$('input[name="fileId"]').val();
				$.ajax({
					type : "POST",
					url : webroot + "/vkan/getTagListByFile",
					dataType : "json",
					data:{fileId:fileId},
					success : function(data) {
						if (!!data) {
							for (var i = 0; i < data.length; i++) {
								var tag = data[i];
								if (tag.level == 1) {
									var container = $(".tags-container.list");
									var ul = $('<ul class="tags-box"></ul>')
											.attr('pid', tag.tagId);
									ul.append(page.getTagLi(tag));
									container.append(ul);
								}
								if (tag.level == 2) {
									var ul = $('.tags-box[pid=' + tag.parentId
											+ ']');
									if (!!ul) {
										ul.append(page.getTagLi(tag));
									}
								}
							}
						}
					},
					error : function(info) {
						alert(info.responseText);
						alert(info);
					}
				});
			},
			/** 添加tag标签 */
			getTagLi : function(tag) {
				var li = $("<li></li>").addClass("hot-1");
				var a = $('<a href="javascript:void(0)" class="tag-font-size-14" >'
						+ tag.name + '</a>');
				if (tag.level == 1) {
					li.addClass('fenlei');
				} else {
					a.attr('tid', tag.tagId);
				}
				var type=$('input[name="type"').val()
				if(type==1&&!!tag.selected){
					li.addClass('curr');
					page.pushTag(tag.tagId);
				}
				li.append(a);
				this.addTagClick(a);
				return li;
			},
			/**给标签添加事件*/
			addTagClick:function(a){
				a.click(function() {
					var tid = this.attributes.tid.value;
					$this = $('a[tid=' + tid + ']');
					var parent = $this.parent();
					if (parent.hasClass('curr')) {
						page.deleteTag(tid);
						parent.removeClass('curr');
					} else {
						parent.addClass('curr');
						page.pushTag(tid);
					}
				})
			},
			pushTag : function(tagId) {
				tags.push(tagId*1);
			},
			deleteTag : function(tagId) {
				var index;
				for (var i = 0; i < tags.length; i++) {
					var temp = tags[i];
					if (tagId == temp) {
						index = i;
					}
				}
				tags.splice(index, 1);
			},
			initBtn:function(){
				var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
				var fileId=$('input[name="fileId"]').val();
				$('#operation_ok').click(function(){
					page.ajax(webroot + "/vkan/saveTag.html",fileId,index);
				})
				
				
				$('#operation_zadd').click(function(){
					page.ajax(webroot + "/vkan/saveChildTag.hmtl",fileId,index,{'type':1});
				})
				
				$('#operation_zdel').click(function(){
					page.ajax(webroot + "/vkan/saveChildTag.hmtl",fileId,index,{'type':2});
				})
				
				$('#operation_cancel').click(function(){
					parent.layer.close(index);
				})
			},
			/**
			 * 发送ajax请求
			 */
			ajax:function(url,fileId,index,data){
				if(!data){
					data={};
				}
				data.fileId=fileId;
				data.index=index;
				data.tagIds=tags;
				$.ajax({
					type : "POST",
					url : url,
					dataType : "json",
					data:data,
					success : function(result) {
						if (result.success) {
							parent.layer.close(index);
							/*
							layer.msg("保存成功", {
								  offset: 't',
								  anim: 6,
								  time: 500,
								  end: function(){
									  //关闭窗口
										parent.layer.close(index);
									  }
							});*/
							
						}else{
							layer.msg('错误：'+result.message, {
								  offset: 't',
								  anim: 6
							});
						}
					},
					error : function(info) {
						console.log(info.responseText);
						console.log(info);
					}
				});
			},
			init : function() {
				this.loadTag();
				this.initBtn();
			}
		}
	})();
	page.init();
})