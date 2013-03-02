<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="static/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="static/uploadify/jquery.uploadify-3.1.min.js"></script>
<script src="static/jqGird/grid.locale-cn.js" type="text/javascript"></script>
<script src="static/jqGird/jquery.jqGrid.min.js" type="text/javascript"></script>
<link href="static/uploadify/uploadify.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css"
	href="static/jqGird/ui.jqgrid.css" />
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#uploadify').uploadify(
								{
									'swf' : './static/uploadify/uploadify.swf',//上传所用swf地址
									'uploader' : 'upload',//上传地址
									'formData' : {//表单参数
										'name' : '1',
										'info' : '2',
										'type' : 0
									},
									//'checkScript':'fileUploadAction.do?method=resFileExistCheck',
									'auto' : false,//不自动上传
									'multi' : false,//一次只能选择一个文件
									'uploadLimit' : 1,//一次最多一个文件
									'queueSizeLimit' : 1,
									'queueID' : 'some_file_queue',
									'buttonText' : '文件：',
									//'buttonImg':'../jquery/images/button.jpg',
									'width' : 365,
									'height' : 20,
									'fileObjName' : 'filedata',//二进制数据的名字
									'fileTypeDesc' : '资源文件',//选择框打开文件类型的描述
									'fileTypeExts' : '*.txt;*.avt;*.ent',//选择框打开文件类型的格式
									'onUploadStart' : function(file) {
										$("#uploadify").uploadify("settings",
												"formData", {
													'name' : $("#name").val(),
													'info' : $("#info").val(),
													'type' : $("#type").val()
												});
									}
								});
						$("#btupload").click(function() {
							jQuery('#uploadify').uploadify('upload', '*');
						});

						//jqGird

						$("#rowed2")
								.jqGrid(
										{
											url : 'manager',
											datatype : "json",
											colNames : [ 'ID', '名称', '类型',
													'说明', '上传时间', '最后修改时间',
													'价格类型', '价格', '商店', '是否在售',
													'性别' ],
											colModel : [ {
												name : 'act',
												index : 'act',
												width : 75,
												sortable : false
											}, {
												name : 'id',
												index : 'id',
												width : 55
											}, {
												name : 'invdate',
												index : 'invdate',
												width : 90,
												editable : true
											}, {
												name : 'name',
												index : 'name',
												width : 100,
												editable : true
											}, {
												name : 'amount',
												index : 'amount',
												width : 80,
												align : "right",
												editable : true
											}, {
												name : 'tax',
												index : 'tax',
												width : 80,
												align : "right",
												editable : true
											}, {
												name : 'total',
												index : 'total',
												width : 80,
												align : "right",
												editable : true
											}, {
												name : 'note',
												index : 'note',
												width : 150,
												sortable : false,
												editable : true
											} , {
												name : 'note',
												index : 'note',
												width : 150,
												sortable : false,
												editable : true
											} , {
												name : 'note',
												index : 'note',
												width : 150,
												sortable : false,
												editable : true
											} , {
												name : 'note',
												index : 'note',
												width : 150,
												sortable : false,
												editable : true
											} ],
											rowNum : 10,
											rowList : [ 10, 20, 30 ],
											pager : '#prowed2',
											sortname : 'id',
											viewrecords : true,
											sortorder : "desc",
											gridComplete : function() {
												var ids = $("#rowed2").jqGrid(
														'getDataIDs');
												for ( var i = 0; i < ids.length; i++) {
													var cl = ids[i];
													be = "<input style='height:22px;width:20px;' type='button' value='编辑' onclick=\"$('#rowed2').editRow('"
															+ cl + "');\" />";
													se = "<input style='height:22px;width:20px;' type='button' value='保存' onclick=\"$('#rowed2').saveRow('"
															+ cl + "');\" />";
													ce = "<input style='height:22px;width:20px;' type='button' value='重置' onclick=\"$('#rowed2').restoreRow('"
															+ cl + "');\" />";
													$("#rowed2").jqGrid(
															'setRowData',
															ids[i],
															{
																act : be + se
																		+ ce
															});
												}
											},
											editurl : "updateresource",
											caption : "商品列表"
										});
						$("#rowed2").jqGrid('navGrid', "#prowed2", {
							edit : false,
							add : false,
							del : false
						});
					});
</script>
</head>
<body>
	<h2>新增一个商品：</h2>
	<!-- <form method="post" action="upload" enctype="multipart/form-data"> -->
	名称：
	<input type="text" id="name" name="name" maxlength="20"
		style="width: 320px;" />
	<br /> 信息：
	<input type="text" id="info" name="info" maxlength="100"
		style="width: 320px;" />
	<br /> 类别：
	<select name="type" id="type">
		<option value="100">上衣</option>
		<option value="101">鞋子</option>
		<option value="102">裤子</option>
		<option value="103">头发</option>
		<option value="104">帽子</option>
		<option value="105">饰品</option>
		<option value="200">家具</option>
		<option value="201">家电</option>
		<option value="202">地板</option>
		<option value="203">窗户</option>
		<option value="204">墙面</option>
		<option value="205">摆件</option>
		<option value="206">地表</option>
		<option value="207">墙纸</option>
		<option value="208">门门</option>
		<option value="209">其他</option>
		<option value="300">派对</option>
	</select>
	<br />
	<input id="uploadify" type="file" name="filedata" />
	<div id="some_file_queue"></div>
	<br />
	<input id="btupload" type="button" value="提交" />
	<br />
	<br />
	<br />


	<table id="rowed2"></table>
	<div id="prowed2"></div>
	<br />
	<!-- </form> -->
</body>
</html>
