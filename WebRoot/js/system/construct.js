
/*
 * Included in file organTree.jsp
 * Copyrights: KJLink
 * Author: zhanggj
 * Created at 2011.2.23
 */

		function show(id) {
			var loadContentUrl = "system/construct_show.action?id=" + id;
			showDialog(loadContentUrl, "btn_close");
		}
		
		function approve(id) {
			var loadContentUrl = "system/construct_approveReq.action?id=" + id + "&pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function valid(id) {
			var loadContentUrl = "system/construct_validReq.action?id=" + id + "&pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function doApprove(id, state) {
			var state = $(":radio[checked]").val();
			if(! state) {
				$("#errmsg").html("��ȷ��һ�����״̬��");
				$("#errmsg").show();
				return;
			}
			$("#addForm").get(0).submit();
		}
		
		function doDelete(id) {
			constructId = id;
			showConfirm("ȷ��ɾ��������¼��", "doConfirmDelete()");
		}
		
		function doConfirmDelete(id) {
			location.href = "system/construct_delete.action?pageNo=" + pageNo + "&id=" + constructId;
		}
		
		