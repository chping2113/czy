<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新建平台</title>
		<script type="text/javascript" src="js/info/scolumn.js"></script>

		<script type="text/javascript">
	var pageNo = "${empty pageNo ? 0 : pageNo}";
	
	$(function(){
		$.brady.validator.validate("addForm", validator_config); //初始化表单验证构架
	});
	
	function   DeleteRow(obj){//删除行 //index插入的位置  
		if(obj.rows.length>0) {  
		  obj.deleteRow(obj.rows.length-1);  
		} 
	}  
				
	function addRow(obj)
        {
        //添加一行
        var newTr = obj.insertRow(obj.rows.length);
        //var trId="properties"+obj.rowIndex; 
		//newTr.setAttribute("id",trId);
        //添加两列
        //var newTh0 = newTr.insertCell(0);
        //var newTd0 = newTr.insertCell(1);
        //设置列内容和属性
        newTr.innerHTML = '<th>属性名称:</th><td><input type="text" value="aaaa" id="properties" name="properties"/></td><th>属性内容:</th><td><input type="text" value="aaaa" id="contents" name="contents"/></td>'; 
        }
	</script> 
	</head>

	<body>
		<div class="add_news">
			<div class="add_top">
				当前位置:首页 > 栏目管理 >
				<c:if test="${id!=null}">编辑栏目</c:if>
       			<c:if test="${id == null}">新建栏目</c:if>	
			</div>
			<form id="addForm" action="info/scolumn_${id > 0 ? 'edit' : 'add'}.action"	method="post">
				<input type="hidden" name="id" value="${empty id ? '0' : id }" />${id }
				<input type="hidden" name="pageNo"
					value="${empty pageNo ? '1' : pageNo}" />

				<table cellpadding="0" cellspacing="0" class="table_add" id="table1">
					<s:if test="#parentScolumn != null">
						<tr>
							<th width="15%">
								上级栏目
							</th>
							<td>
								${parentScolumn.name }
								<input type="hidden" name="parentId"
									value="${parentScolumn.id }" />
							</td>
						</tr>
					</s:if>

					<tr>
						<th width="15%">
							所属平台
						</th>
						<td>
							${site.name }
							<input type="hidden" name="siteId" value="${site.id }" />
						</td>
					</tr>


					<tr>
						<th width="15%">
							栏目标题
						</th>
						<td>
							<input type="text" id="scolumn_name" name="name" value="${name }"
								class="input_text_big" maxlength="10" />
						</td>
					</tr>

					<tr>
						<th valign="top">
							有效
						</th>
						<td>
							<input type="radio" id="stateT" name="state" value="1" ${state==1 ? "checked" : ""} />
							有效
							<input type="radio" id="stateF" name="state" value="0" ${state!=1 ? "checked" : "" }/>
							无效
						</td>
					</tr
				
					
					</div>
				</table>
				
					<c:if test="${id!=null}">
					<table cellpadding="0" cellspacing="0" class="table_add" id="table2">
			     	 <tr>
						<th> 属性名称:</th>
						<td><input type="text" value="aaaa" id="properties" name="properties" /></td>
						<th> 属性内容:</th>
						<td><input type="text" value="aaaa" id="contents" name="contents" /></td>
					</tr> 
			 	</table>
					<a href="javascript:addRow(table2)">AddNew </a> <br>
					<a href="javascript:DeleteRow(table2)">remove </a> 
				</c:if>
			</form>	
			
			<div class="add_savebtn">
				<a href="javascript:doSave()"><img src="images/save.gif"
						border="0" />
				</a>
				<a href="javascript:history.back()"><img src="images/back00.gif"
						border="0" />
				</a>

			</div>
	</body>
</html>