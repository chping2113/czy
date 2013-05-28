
/*
 * Included in file listNotice.jsp
 * Copyrights: KJLink
 * Author: zhanggj
 * Created at 2011.2.23
 */

		var siteId = "";
		
		function add() {
			var loadContentUrl = "system/site_addRequest.action?pageNo=" + pageNo + "&t=" + new Date().getTime();;
			location.href = loadContentUrl;
			//showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function view(id) {
			var loadContentUrl = "system/site_viewRequest.action?id=" + id + "&pageNo=" + pageNo;
			location.href = loadContentUrl;
			//showDialog(loadContentUrl, "btn_close");
		}
		
		function edit(id) {
			var loadContentUrl = "system/site_editRequest.action?id=" + id + "&pageNo=" + pageNo;
			location.href = loadContentUrl;
			//showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function del(id) {
			siteId = id;
			showConfirm("确定删除该条记录吗？", "doConfirmDelete()");
		}
		
		function doConfirmDelete(id) {
			location.href = "system/site_delete.action?pageNo=" + pageNo + "&id=" + siteId;
		}
		
		var validator_config = {
				site_name: {
					select: "请选择平台",
					validators: {
						required: {
							failmsg:"平台不能为空!"
						}
					}
				}
		};
		
		function doSave() {
			if($.brady.validator.validateForm("addForm", validator_config)) {
				$("#addForm").get(0).submit();
				closeDialog();
			}
		}
	
