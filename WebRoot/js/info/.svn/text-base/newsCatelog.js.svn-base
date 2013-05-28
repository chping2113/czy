
/*
 * Included in file listNewsCatelog.jsp
 * Copyrights: KJLink
 * Author: zhanggj
 * Created at 2011.2.23
 */

		var newsCatelogId = "";
		
		function add() {
			var loadContentUrl = "info/newsCatelog_addReq.action?parentId=" + parentId + "&pageNo=" + pageNo + "&t=" + new Date().getTime();
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function show(id) {
			var loadContentUrl = "info/newsCatelog_show.action?parentId=" + parentId + "&id=" + id + "&pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_close");
		}
		
		function edit(id) {
			var loadContentUrl = "info/newsCatelog_editReq.action?parentId=" + parentId + "&id=" + id + "&pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function del(id) {
			newsCatelogId = id;
			showConfirm("确定删除该条记录吗？", "doConfirmDelete()");
		}
		
		function doConfirmDelete(id) {
			location.href = "info/newsCatelog_delete.action?parentId=" + parentId + "&pageNo=" + pageNo + "&id=" + newsCatelogId;
		}
		
		var validator_config = {
				newsCatelog_title: {
					text: "在此输入栏目的标题",
					validators: {
						required: {
							failmsg:"栏目的标题不能为空!"
						}
					}
				},
				showOrder: {
					text: "在此输入栏目的显示顺序",
					validators: {
						required: {
							failmsg:"栏目的显示顺序不能为空!"
						},
						digit: {
							failmsg:"栏目的显示顺序必须是一个整数!"
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
	
