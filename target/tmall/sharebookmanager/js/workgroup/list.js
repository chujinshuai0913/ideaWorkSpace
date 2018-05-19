var notSelectSkuView = new TableView({
	clazzName : "notSelectSkuView"
}), hasSelectSkuView = new TableView({
	clazzName : "hasSelectSkuView"
});
var notSelectStorageAreaView = new TableView({
	clazzName : "notSelectStorageAreaView"
}), hasSelectStorageAreaView = new TableView({
	clazzName : "hasSelectStorageAreaView"
});
var notSelectUserView = new TableView({
	clazzName : "notSelectUserView"
}), hasSelectUserView = new TableView({
	clazzName : "hasSelectUserView"
});
/* info 代指工作组信息 */
var infoSkuView = new TableView({
	clazzName : "infoSkuView"
}), infoStorageAreaView = new TableView({
	clazzName : "infoStorageAreaView"
}), infoUserView = new TableView({
	clazzName : "infoUserView"
});
dataItem=null;
$(function() {
	/* 视图开始 */
	notSelectSkuView.$root = $("#modal_bindSku");
	notSelectSkuView.$main = $("#modal_bindSku .not-select");
	notSelectSkuView.init();
	hasSelectSkuView.$root = $("#modal_bindSku");
	hasSelectSkuView.$main = $("#modal_bindSku .has-select");
	hasSelectSkuView.init();

	notSelectStorageAreaView.$root = $("#modal_bindStorageArea");
	notSelectStorageAreaView.$main = $("#modal_bindStorageArea .not-select");
	notSelectStorageAreaView.init();
	hasSelectStorageAreaView.$root = $("#modal_bindStorageArea");
	hasSelectStorageAreaView.$main = $("#modal_bindStorageArea .has-select");
	hasSelectStorageAreaView.init();

	notSelectUserView.$root = $("#modal_bindUser");
	notSelectUserView.$main = $("#modal_bindUser .not-select");
	notSelectUserView.init();
	hasSelectUserView.$root = $("#modal_bindUser");
	hasSelectUserView.$main = $("#modal_bindUser .has-select");
	hasSelectUserView.init();

	infoSkuView.$root = $("#modal_info");
	infoSkuView.$main = $("#modal_info .infoSku");
	infoSkuView.init();
	infoStorageAreaView.$root = $("#modal_info");
	infoStorageAreaView.$main = $("#modal_info .infoStorageArea");
	infoStorageAreaView.init();
	infoUserView.$root = $("#modal_info");
	infoUserView.$main = $("#modal_info .infoUser");
	infoUserView.init();

	/* 主视图单条数据的操作 */
	notSelectSkuView.$main.find(".add").click(function() {
		updateViewType1(notSelectSkuView, {
			url : "../workgroupSku/batchInsert",columnName:"skuId"
		}, [ notSelectSkuView, hasSelectSkuView ]);
	});
	notSelectSkuView.$main.find(".query-add").click(function() {
		querySkuAddOrDel(this,true);
	});
	hasSelectSkuView.$main.find(".del").click(function() {
		updateViewType1(hasSelectSkuView, {
			url : "../workgroupSku/del",columnName:"workgroupSkuId"
		}, [ notSelectSkuView, hasSelectSkuView ]);
	});
	hasSelectSkuView.$main.find(".query-del").click(function() {
		querySkuAddOrDel(this,false);
	});

	notSelectStorageAreaView.$main.find(".add").click(function() {
		updateViewType1(notSelectStorageAreaView, {
			url : "../workgroupStorageArea/batchInsert"
		}, [ notSelectStorageAreaView, hasSelectStorageAreaView ]);
	});
	hasSelectStorageAreaView.$main.find(".del").click(function() {
		updateViewType1(hasSelectStorageAreaView, {
			url : "../workgroupStorageArea/del",columnName:"workgroupStorageAreaId"
		}, [ notSelectStorageAreaView, hasSelectStorageAreaView ]);
	});

	notSelectUserView.$main.find(".add").click(function() {
		updateViewType1(notSelectUserView, {
			url : "../workgroupUser/batchInsert"
		}, [ notSelectUserView, hasSelectUserView ]);
	});
	hasSelectUserView.$main.find(".del").click(function() {
		updateViewType1(hasSelectUserView, {
			url : "../workgroupUser/del"
		}, [ notSelectUserView, hasSelectUserView ])
	});
});
tableView.tableOptions = {
	url : "listData",
	addOnLoadSuccess : function(data) {
		console.log("---listData---");
		console.log(data);
	},
	columns : [ {
		checkbox : true
	},defaultColumns.serialNumber,{
		field : "op",
		title : "操作",
		align : "center",
		formatter : function(value, row, index) {
			return [ "<span btn-modify class='update' style='cursor:pointer;' >[修改]</span>", 
			         "<span btn-bindStorageArea class='bindStorageArea' style='cursor:pointer;' >[绑定储区]</span>", 
			         row.isBindAllSku==0?"<span btn-bindSku class='bindSku'  data-toggle='modal' style='cursor:pointer;'>[绑定品类]</span>":"", 
			         "<span btn-bindUser class='bindUser' style='cursor:pointer;' >[绑定员工]</span>", 
			         "<span btn-info class='info' style='cursor:pointer;' >[查看]</span>" ].join('');
		},
		events : {
			'click .update' : function(e, value, row, index) {
				tableView.tools.update.fnBtnTodo(undefined, row);
				// tableView.tools.update.$main.find("[name='fSi']").attr("disabled","disabled");
			},
			'click .bindStorageArea' : function(e, value, row, index) {
				notSelectStorageAreaView.$main.find("input[name='fworkgroup']").val(row.id);
				hasSelectStorageAreaView.$main.find("input[name='fworkgroup']").val(row.id);
				clickViewRowOp1(notSelectStorageAreaView, row, [ notSelectStorageAreaView, hasSelectStorageAreaView ]);
			},
			'click .bindSku' : function(e, value, row, index) {
				notSelectSkuView.$main.find("input[name='fworkgroup']").val(row.id);
				hasSelectSkuView.$main.find("input[name='fworkgroup']").val(row.id);
				clickViewRowOp1(notSelectSkuView, row, [ notSelectSkuView, hasSelectSkuView ]);
			},
			'click .bindUser' : function(e, value, row, index) {
				notSelectUserView.$main.find("input[name='fwmsWorkgroup']").val(row.id);
				hasSelectUserView.$main.find("input[name='fwmsWorkgroup']").val(row.id);
				clickViewRowOp1(notSelectUserView, row, [ notSelectUserView, hasSelectUserView ]);
			},
			'click .info' : function(e, value, row, index) {
				infoStorageAreaView.$main.find("input[name='fworkgroup']").val(row.id);
				infoSkuView.$main.find("input[name='fworkgroup']").val(row.id);
				infoUserView.$main.find("input[name='fwmsWorkgroup']").val(row.id);
				clickViewRowOp1(infoStorageAreaView, row, [ infoStorageAreaView, infoSkuView, infoUserView ]);
			}
		}
	}, {
		align : "center",
		field : 'id',
		title : '工作组ID',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'name',
		title : '工作组名称',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'strType',
		title : '作业类型',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'strIsDefault',
		title : '是否绑定所有品类',
		formatter : function(value, row, index) {
			if(row.isBindAllSku==0){
				return "否";
			}else if(row.isBindAllSku==1){
				return "是";
			}else{
				return "";
			}
			
		}
	}, {
		align : "center",
		field : 'uu',
		title : '修改人',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'strUt',
		title : '修改时间',
		formatter : defaultColumns.formatterToTV
	} ]
};
/* 工作组与商品绑定--相关操作 */
var columns = {
	storageArea : [ {
		checkbox : true
	}, defaultColumns.serialNumber, {
		align : "center",
		field : 'name',
		title : '储区',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'strType',
		title : '储区类型',
		formatter : defaultColumns.formatterToTV
	} ],
	sku : [ {
		checkbox : true
	}, defaultColumns.serialNumber, {
		align : "center",
		field : 'skuId',
		title : '商品ID',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'skuCode',
		title : '商品编码',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'skuName',
		title : '商品名称',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'skuFormat',
		title : '规格',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'skuLevel',
		title : '产品等级',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'class1Name',
		title : '一级分类',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'class2Name',
		title : '二级分类',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'class3Name',
		title : '三级分类',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'skuDesc',
		title : '描述',
		formatter : defaultColumns.formatterToTV
	} ],
	user : [ {
		checkbox : true
	}, defaultColumns.serialNumber, {
		align : "center",
		field : 'fwmsUser',
		title : '员工ID',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'userName',
		title : '员工姓名',
		formatter : defaultColumns.formatterToTV
	} ]
};
notSelectSkuView.tableOptions = {
	url : "getUnBoundSkusByWorkgroup",
	addOnLoadSuccess : function(data) {
		console.log("not sku----");
		console.log(data);
		if(data.data && data.data.length>0){
			notSelectSkuView.$main.find(".query-add").show();
		}else{
			notSelectSkuView.$main.find(".query-add").hide();
		}
	},
	pageSize : 5,
	columns : columns.sku
};
hasSelectSkuView.tableOptions = {
	url : "getBoundSkusByWorkgroup",
	addOnLoadSuccess : function(data) {
	},
	pageSize : 5,
	columns : columns.sku
};
notSelectStorageAreaView.tableOptions = {
	url : "../workgroupStorageArea/getStorageAreaListByType",
	pageSize : 5,
	columns : columns.storageArea
};
hasSelectStorageAreaView.tableOptions = {
	url : "../workgroupStorageArea/getStorageAreaListByType",
	pageSize : 5,
	columns : columns.storageArea
};
notSelectUserView.tableOptions = {
	url : "../workgroupUser/bindUser",
	addOnLoadSuccess : function(data) {
		console.log("add onLoadSuccess---");
	},
	pageSize : 5,
	columns : columns.user
};
hasSelectUserView.tableOptions = {
	url : "../workgroupUser/bindUser",
	pageSize : 5,
	columns : columns.user
};
infoSkuView.tableOptions = {
	url : "getBoundSkusByWorkgroup",
	pageSize : 5,
	columns : getInfoColumns(columns.sku)
};
infoStorageAreaView.tableOptions = {
	url : "../workgroupStorageArea/getStorageAreaListByType",
	pageSize : 5,
	columns : getInfoColumns(columns.storageArea)
};
infoUserView.tableOptions = {
	url : "../workgroupUser/bindUser",
	pageSize : 5,
	columns : getInfoColumns(columns.user)
};
function getInfoColumns(columns) {
	var arrColumn = [];
	$.each(columns, function(index, item) {
		if (index > 0) {
			arrColumn.push(item);
		}
	});
	return arrColumn;
}
/* 其它相关方法 */
function clickViewRowOp1(view, rowData, views) {
	if (rowData && rowData != null) {
		view.$root.find(".modal-header").elDataSet();
		view.$root.find(".modal-header").elDataSet(rowData);
	}
	loadOrRefreshView1(views);
	view.$root.modal("show");
}
function loadOrRefreshView1(views) {
	for (var i = 0; i < views.length; i++) {
		try {
			var view = views[i];
			if (view.$table.attr("hasview")) {
				view.refreshTable(true);
			} else {
				view.bootstrapTable(view.$table, view.tableOptions, false);
				view.$table.attr("hasview", true)
			}
		} catch (e) {
			alert("loadOrUpdateView1 error:" + e);
		}
	}
}
function updateViewType1(view, ajax, refreshViews) {
	var selected = [];
	selected = view.$table.bootstrapTable("getSelections");
	if (selected.length == 0) {
		view.notify("warning", view.TipsInfo.atLeastSelectOneRow);
		return;
	} else {
		var workgroupId = view.$root.find(".modal-header input[name='id']").val();
		var warehouseId =undefined;
		try{
			warehouseId = view.$root.find(".modal-header [name='fwarehouse']").val();
		}catch(e){}
		if (!workgroupId) {
			alert("选择工作组错误啦，请联系管理员吧！"+workgroupId);
			return;
		}
		var columnValueList = [];
		console.log("----------selected-------------------");
		console.log(selected);
		$.each(selected, function(index, item) {
			var val=undefined;
			if(ajax.columnName){
				val=item[ajax.columnName];
			}else{
				val=item.id;
			}
			if(val){
				columnValueList.push(val);
			}
		});
		if(columnValueList.length<=0){
			view.notify("danger", "数据出错啦，请联系管理员吧！");
			return;
		}
		var dataParam={
				id : workgroupId
		}
		if(warehouseId){
			dataParam.fwarehouse=warehouseId;
		}
		if(ajax.columnValueList_0){
			dataParam[ajax.columnValueList_0]=ajax.columnValueList_0_value||columnValueList[0];
		}else{
			dataParam.columnValueList=columnValueList;
		}
		$.ajax({
			type : "POST",
			url : ajax.url,
			data : JSON.stringify(dataParam),
			contentType : "text/html;charset=utf-8",
			success : function(results) {
				try {
					results = eval('(' + results + ')');
				} catch (r) {

				}
				if (results.error_code == 0) {
					loadOrRefreshView1(refreshViews);
					view.notify("success", (typeof results.data == "string") ? results.data : (other.successMsg || "成功！"));
				} else {

				}
			},
			statusCode : {
				404 : (function() {
					view.notify("danger", "出错啦...请检查网络或联系管理员！");
				})
			}
		});
	}
}

function querySkuAddOrDel(el,isAdd) {
	var refreshViews=[ notSelectSkuView, hasSelectSkuView ];
	var view=undefined;
	var strOp="";
	var ajax={};
	if(isAdd){
		view=notSelectSkuView;
		strOp="增加";
		ajax.url="../workgroupSku/batchInsert";
	}else{
		view=hasSelectSkuView;
		strOp="删除";
		ajax.url="../workgroupSku/del";
	}
	var query=view.$tableQP.elDataGet();
	query.pageNumber=-1;
	var isPass=false;
	if(query.class1Id){
		isPass=true;
	}else if(query.class2Id){
		isPass=true;
	}else if(query.fsku){
		isPass=true;
	}else if(query.skuName){
		isPass=true;
	}
	if(!query.fworkgroup){
		alert("选择工作组错误啦，请联系管理员吧！");
		return;
	}
	if(isAdd){
		query.id=query.fworkgroup;
		query.fworkgroup="";
	}
	if(isPass){
		if(confirm("确定查询并"+strOp+"所有查询的数据吗？")){
			var ladda=undefined;
			if(!ladda){
				try{
					if(Ladda){
						ladda = Ladda.create(el);
					}
				}catch(e){
					ladda=undefined;
				}
			}
			if(ladda){
				ladda.start();
			}
			$.ajax({
				type : "POST",
				url : ajax.url,
				data : JSON.stringify(query),
				contentType : "text/html;charset=utf-8",
				success : function(results) {
					try {
						results = eval('(' + results + ')');
					} catch (r) {

					}
					if (results.error_code == 0) {
						loadOrRefreshView1(refreshViews);
						view.notify("success", (typeof results.data == "string") ? results.data : (other.successMsg || "成功！"));
					} else {
						try{
							view.notify("danger", results.error.msg);
						}catch(e){
						}
					}
				},
				statusCode : {
					404 : (function() {
						view.notify("danger", "出错啦...请检查网络或联系管理员！");
					})
				}
			}).always(function(){
				if(ladda){
					ladda.stop();
				}
			});
		}else{
			
		}
	
	}else{
		view.notify("danger", "请输入查询条件！");
	}
}
