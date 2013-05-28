
/*
 * Included in file listNotice.jsp
 * Copyrights: KJLink
 * Author: zhanggj
 * Created at 2011.2.23
 */

		var noticeId = "";
		
		function add() {
			var loadContentUrl = "info/notice_add.action?pageNo=" + pageNo + "&t=" + new Date().getTime();;
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function show(id) {
			var loadContentUrl = "info/notice_show.action?id=" + id + "&pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_close");
		}
		
		function edit(id) {
			var loadContentUrl = "info/notice_editReq.action?id=" + id + "&pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function del(id) {
			noticeId = id;
			showConfirm("确定删除该条记录吗？", "doConfirmDelete()");
		}
		
		function doConfirmDelete(id) {
			location.href = "info/notice_delete.action?pageNo=" + pageNo + "&id=" + noticeId;
		}
		
		var validator_config = {
				notice_title: {
					text: "请输入公告标题",
					validators: {
						required: {
							failmsg:"公告标题不能为空"
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
	
