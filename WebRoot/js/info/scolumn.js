/*
*
*
*
*/

		var scolumnId = "";
		
		function add() {
			var loadContentUrl = "info/scolumn_addRequest.action?parentId=" + parentId + "&pageNo=" + pageNo + "&siteId=" + siteId + "&t=" + new Date().getTime();
			location.href = loadContentUrl;
			//showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function view(id) {
			var loadContentUrl = "info/scolumn_view.action?parentId=" + parentId + "&id=" + id + "&pageNo=" + pageNo + "&siteId=" + siteId;
			location.href = loadContentUrl;
			//showDialog(loadContentUrl, "btn_close");
		}
		
		function edit(id) {
			var loadContentUrl = "info/scolumn_editRequest.action?parentId=" + parentId + "&id=" + id + "&pageNo=" + pageNo + "&siteId=" + siteId;
			location.href = loadContentUrl;
			//showDialog(loadContentUrl, "btn_ok_close");
		}
		function del(id) {
			scolumnId = id;
			showConfirm("确定删除该条记录吗？", "doConfirmDelete()");
		}
		
		function doConfirmDelete(id) {
			location.href = "info/scolumn_delete.action?parentId=" + parentId + "&pageNo=" + pageNo + "&id=" + scolumnId + "&siteId=" + siteId;
		}
		
		
		
		var validator_config = {
				scolumn_name: {
					text: "在此输入栏目的标题",
					validators: {
						required: {
							failmsg:"栏目的标题不能为空!"
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