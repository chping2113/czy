
/*
 * Included in file setPower.jsp
 * Copyrights: KJLink
 * Author: zhanggj
 * Created at 2011.2.23
 */

	jQuery(function() {
		//一级资源
		$(".firstLevel").each(function(index, domEle) {
			$(domEle).click(function() {
				var checked = $(domEle).attr("checked");
				var firstLevelId = $(domEle).val();
				var childs = $("input[firstLevelId='" + firstLevelId + "']").attr("checked", checked);
			});
		});
		
		//二级资源
		$(".secondLevel").each(function(index, domEle) {
			var val = $(domEle).val();
			
			$(domEle).click(function() {
				var checked = $(domEle).attr("checked");
				var childs = $(".secondLevel_" + val).attr("checked", checked);

				//处理一级资源的选中状态
				var firstLevelId = $(domEle).attr("firstLevelId");
				if(checked) {
					$("#first_" + firstLevelId).attr("checked", checked)
				} else {
					var selLength = $(".fl_" + firstLevelId + ":checked").length;
					if(selLength == 0) { //所有下级资源都取消选中状态，则二级资源也取消选中状态
						$("#first_" + firstLevelId).attr("checked", checked);
					}
				}
			});

			//给它下一级加上click事件处理函数
			$(".secondLevel_" + val).click(function(evt) {
				var src = $(evt.target);
				var firstLevelId = src.attr("firstLevelId");
				
				if(src.attr("checked")) {
					$(domEle).attr("checked", true);
					$("#first_" + firstLevelId).attr("checked", true);
				} else {
					var selLength = $(".secondLevel_" + val+":checked").length;
					if(selLength == 0) { //所有下级资源都取消选中状态，则二级资源也取消选中状态
						$(domEle).attr("checked", false);
					}

					selLength = $(".firstLevel_" + firstLevelId+":checked").length;
					if(selLength == 0) { //所有下级资源都取消选中状态，则一级资源也取消选中状态
						$("#first_" + firstLevelId).attr("checked", false);
					}
				}
			});
		});
		
		//当权限设置保存成功后，给一个提示
//		if(actionType == "setPower") {
//			alert("角色权限配置保存成功！");
//		}
	});
	
	function doSave() {
		alert("角色权限配置保存成功！");
		$("#addForm").get(0).submit();
	}
