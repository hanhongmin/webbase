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
	href="static/jqui/jquery-ui-1.10.1.custom.min.css" />
<link rel="stylesheet" type="text/css"
	href="static/jqGird/ui.jqgrid.css" />
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#uploadify').uploadify({
							'swf' : './static/uploadify/uploadify.swf',//上传所用swf地址
							'uploader' : 'upload',//上传地址
							/**
							'formData' : {//表单参数
								'name' : '1',
								'info' : '2',
								'type' : 0
							},*/
							//'checkScript':'fileUploadAction.do?method=resFileExistCheck',
							'auto' : false,//不自动上传
							'multi' : true,//一次只能选择一个文件
							'uploadLimit' : 99,//累计上传文件限制数
							'queueSizeLimit' : 99,
							'queueID' : 'some_file_queue',
							'buttonText' : '点我选择文件，可选择多个哟',
							//'buttonImg':'../jquery/images/button.jpg',
							'width' : 365,
							'height' : 20,
							'fileObjName' : 'filedata',//二进制数据的名字
							'fileTypeDesc' : '资源文件',//选择框打开文件类型的描述
							/**
							'onUploadStart' : function(file) {
								$("#uploadify").uploadify("settings",
										"formData", {
											'name' : $("#name").val(),
											'info' : $("#info").val(),
											'type' : $("#type").val()
										});
							}*/
							'onUploadSuccess' : function(file, data, response) {
								//alert('The file ' + file.name + ' was successfully uploaded with a response of ' + response + ':' + data);
								$('#rowed2').trigger("reloadGrid");
							},
							'fileTypeExts' : '*.txt;*.avt;*.ent'//选择框打开文件类型的格式
						});
						$("#btupload").click(function() {
							jQuery('#uploadify').uploadify('upload', '*');
						});

						//jqGird
						var lastsel;
						$("#rowed2")
								.jqGrid(
										{
											url : 'manager',//请求数据的地址
											datatype : "json",
											jsonReader : {
												root : "rows",
												page : "page",
												total : "total",
												records : "records",
												repeatitems : false,
												id : "0"
											},
											height : 230,
											colNames : [ 'ID', '文件名称', '商品名称',
													'类型', '商品说明', '上传时间',
													'更新时间', '价格类型', '价格', '商店',
													'售', '性别'],
											colModel : [ {
												name : 'id',
												index : 'id',
												align : 'right',
												width : 80
											}, {
												name : 'uploadFileName',
												index : 'uploadFileName',
												width : 160,
												sortable : false,
												editable : false
											}, {
												name : 'itemName',
												index : 'itemName',
												width : 160,
												sortable : false,
												editable : true
											}, {
												name : 'itemType',
												index : 'itemType',
												width : 40,
												align : 'right',
												formatter : 'select',
												editable : true,
												edittype : 'select',
												editoptions : {
													value : {
														100 : '上衣',
														101 : '鞋子',
														102 : '裤子',
														103 : '头发',
														104 : '帽子',
														105 : '饰品',
														200 : '家具',
														201 : '家电',
														202 : '地板',
														203 : '窗户',
														204 : '墙面',
														205 : '摆件',
														206 : '地表',
														207 : '墙纸',
														208 : '门门',
														209 : '其它',
														300 : '派对'
													}
												}
											}, {
												name : 'itemComment',
												index : 'itemComment',
												width : 155,
												sortable : false,
												editable : true
											}, {
												name : 'uploadTime',
												index : 'uploadTime',
												width : 130,
												align : 'right',
												editable : false,
												formatter : 'date',
												formatoptions : {
													srcformat : 'U',
													newformat : 'y-m-d H:i:s'
												}
											}, {
												name : 'lastOptTime',
												index : 'lastOptTime',
												width : 130,
												align : 'right',
												editable : false,
												formatter : 'date',
												formatoptions : {
													srcformat : 'U',
													newformat : 'y-m-d H:i:s'
												}
											}, {
												name : 'priceType',
												index : 'priceType',
												width : 70,
												align : 'right',
												editable : true,
												edittype : 'select',
												formatter : 'select',
												editoptions : {
													value : {
														1 : '豆豆',
														2 : '币币',
														3 : '鱼鱼',
														4 : '晶晶',
														5 : '点点'
													}
												}
											}, {
												name : 'priceNum',
												index : 'priceNum',
												width : 45,
												align : 'right',
												editable : true
											}, {
												name : 'shopKey',
												index : 'shopKey',
												width : 50,
												align : 'right',
												editable : true
											}, {
												name : 'isSell',
												index : 'isSell',
												width : 50,
												editable : true,
												edittype : 'select',
												formatter : 'select',
												editoptions : {
													value : {
														0 : '否',
														1 : '是'
													}
												}
											}, {
												name : 'sexLimit',
												index : 'sexLimit',
												width : 50,
												editable : true,
												edittype : 'select',
												formatter : 'select',
												editoptions : {
													value : {
														0 : '无',
														1 : '男',
														2 : '女'
													}
												}
											}/**, {
												name : 'act',
												index : 'act',
												width : 175,
												sortable : false
											}*/ ],
											rowNum : 10,
											rowList : [ 10, 20, 30, 50, 100 ],
											pager : '#prowed2',
											sortname : 'lastOptTime',
											viewrecords : true,
											sortorder : "desc",
											/**
											gridComplete : function() {
												var ids = $("#rowed2").jqGrid(
														'getDataIDs');
												for ( var i = 0; i < ids.length; i++) {
													var cl = ids[i];
													be = "<input style='height:22px;width:40px;' type='button' value='编辑' onclick=\"$('#rowed2').editRow('"
															+ cl + "');\" />";
													se = "<input style='height:22px;width:40px;' type='button' value='保存' onclick=\"$('#rowed2').saveRow('"
															+ cl + "');\" />";
													ce = "<input style='height:22px;width:40px;' type='button' value='重置' onclick=\"$('#rowed2').restoreRow('"
															+ cl + "');\" />";
													$("#rowed2").jqGrid(
															'setRowData',
															ids[i],
															{
																act : be + se
																		+ ce
															});
												}
											},*/
											editurl : "updateresource",
											caption : "商品列表&nbsp;&nbsp;<font style='color:red;font-size:12px;'>(编辑后按回车键保存)</font>",
											onSelectRow : function(id) {
												if (id && id !== lastsel) {
													jQuery('#rowed2').jqGrid(
															'restoreRow',
															lastsel);
													jQuery('#rowed2')
															.jqGrid('editRow',
																	id, true);
													lastsel = id;
												}
											},
										});
						$("#rowed2").jqGrid('navGrid', "#prowed2", {
							edit : false,
							add : false
						});
					});
</script>
</head>
<body>
	<h2>新增商品↓：</h2>
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
</body>
</html>
