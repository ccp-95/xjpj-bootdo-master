var prefix = "/xjpj/pingdingxinxi"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/search", // 服务器数据的加载地址
						// showRefresh : true,
						// showToggle : true,
						// showColumns : true,
						striped : false, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : true, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						// search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
													// "server"
						queryParams : function(params) {
							return {
								// 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								deptId : $("#deptId").val(),
								cheJian : $("#cheJian").val(),
								banZu : $("#banZu").val(),
								sfzh : $("#sfzh").val(),
								xingJi : $("#xingJi").val(),
								gangWei : $("#gangWei").val(),
								limit : params.limit,
								offset : params.offset
							// name:$('#searchName').val(),
							// username:$('#searchName').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									field : 'id',
									title : '序号'
								},
								{
									field : 'khzq',
									title : '考核周期'
								},
								{
									field : 'deptName',
									title : '单位',
									width : '12%'
								},
								{
									field : 'zgxm',
									title : '姓名',
									width : '8%'
								},
								{
									field : 'nl',
									title : '年龄'
								},
								{
									field : 'xb',
									title : '性别',
									formatter : function(value, row, index) {
										if (value == '1')
											return '男';
										else
											return '女';
									}
								},
								{
									field : 'cheJian',
									title : '车间'
								},
								{
									field : 'banZu',
									title : '班组'
								},
								{
									field : 'gangWei',
									title : '岗位',
									width : '8%'
								},
								{
									field : 'sfzh',
									title : '身份证号',
									formatter : function(value, row, index) {
										var a = value.substr(0,10);
										var b = value.substr(15,17);
										return a +'*****' + b;
									}
								},
								{
									field : 'xingJi',
									title : '星级',
									width : '10%',
									formatter : function(value, row, index) {
										if(value=='0'){
											return '失格';
										}
										else{
											var stars = '';
											for(var i=0;i<value;i++){
												stars += '<span class="glyphicon glyphicon-star"></span>';
											}
											return stars;
											//return '<span class="glyphicon glyphicon-star"></span>';
										}
									}
								},
								{
									field : 'zhdf',
									title : '综合得分'
								},
								{
									field : 'ywjn',
									title : '业务技能'
								},
								{
									field : 'zzsj',
									title : '遵章守纪'
								},
								{
									field : 'aqjx',
									title : '安全绩效'
								},
								{
									field : 'wcgz',
									title : '完成工作'
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

function reset(){
	$("#deptId").val(null);
	$("#deptName").val("");
	
	$("#cheJian").val("");
	$("#banZu").val("");
	$("#gangWei").val("");
	$("#sfzh").val("");
	$("#xingJi").val("");
}

var openDept = function(){
	layer.open({
		type:2,
		title:"选择部门",
		area : [ '300px', '450px' ],
		content:"/system/sysDept/treeView"
	})
}
function loadDept( deptId,deptName){
	$("#deptId").val(deptId);
	$("#deptName").val(deptName);
}
