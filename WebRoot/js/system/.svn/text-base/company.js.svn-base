
/*
 * Included in file organTree.jsp
 * Copyrights: KJLink
 * Author: zhanggj
 * Created at 2011.2.23
 */
		
		function show(id) {
			var loadContentUrl = "system/company_show.action?id=" + id;
			showDialog(loadContentUrl, "btn_close");
		}
		
		function approve(id) {
			var loadContentUrl = "system/company_approveReq.action?id=" + id + "&pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function valid(id) {
			var loadContentUrl = "system/company_validReq.action?id=" + id + "&pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function doApprove() {
			var state = $(":radio[checked]").val();
			if(! state) {
				$("#errmsg").html("请确定一种审核状态！");
				$("#errmsg").show();
				return;
			}
			$("#addForm").get(0).submit();
		}
		
		function doDelete(id) {
			showConfirm("确定删除该条记录吗？", "doConfirmDelete(" + id + ")");
		}
		
		function doConfirmDelete(id) {
			location.href = "system/company_delete.action?pageNo=" + pageNo + "&id=" + id;
		}
		

