/*
 * Included in file creditCompanyList.jsp
 * Copyrights: KJLink
 * Author: dingyong
 * Created at 2011.3.11
 */

		function show(id) {
			var loadContentUrl = "credit/creditCompany_show.action?id=" + id;
			showDialog(loadContentUrl, "btn_close");
		}
		
		function approve(id) {
			var loadContentUrl = "credit/creditCompany_approveReq.action?id=" + id;
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function doApprove(id, state) {
			var state = $(":radio[checked]").val();
			if(! state) {
				$("#errmsg").html("请确定一种审核状态！");
				$("#errmsg").show();
				return;
			}
			$("#addForm").get(0).submit();
		}