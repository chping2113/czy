
/*
 * Included in file listNotice.jsp
 * Copyrights: KJLink
 * Author: zhanggj
 * Created at 2011.2.23
 */

		var newsId = "";
		
		function checkFileName() {
			$("#msg_filename_panel").hide();
			
			var imageNews = $(":radio[checked]").val();
			if(imageNews == "1") {
				var filename = $("#imageFileName").val();
				if($.trim(filename) == "") {
					$("#msg_filename_panel").html("标题图片文件名必须输入！");
					$("#msg_filename_panel").show();
					return false;
				}
			}
			return true;
		}
		
		function del(id) {
			newsId = id;
			showConfirm("确定删除该条记录吗？", "doConfirmDelete()");
		}
		
		function doConfirmDelete(id) {
			location.href = "info/news_delete.action?pageNo=" + pageNo + "&id=" + newsId + "&catelogId=" + catelogId;
		}
		
		var validator_config = {
				news_title: {
					text: "在此输入标题",
					validators: {
						required: {
							failmsg:"标题不能为空!"
						}
					}
				}
		};
		
		function doSave() {
			var f = checkFileName();
			if($.brady.validator.validateForm("addForm", validator_config) && f) {
				$("#addForm").get(0).submit();
			}
		}
	
