dataItem=null;
var notSelectLocationView = new TableView({
	clazzName : "notSelectLocationView"
}), hasSelectLocationView = new TableView({
	clazzName : "hasSelectLocationView"
});
var notSelectWorkgroupView = new TableView({
	clazzName : "notSelectWorkgroupView"
}), hasSelectWorkgroupView = new TableView({
	clazzName : "hasSelectWorkgroupView"
});
/* info 代指工作组信息 */
var infoLocationView = new TableView({
	clazzName : "infoLocationView"
}),infoWorkgroupView = new TableView({
	clazzName : "infoWorkgroupView"
});
$(function() {
	/* 视图开始 */
	notSelectLocationView.$root = $("#modal_bindLocation");
	notSelectLocationView.$main = $("#modal_bindLocation .not-select");
	notSelectLocationView.init();
	hasSelectLocationView.$root = $("#modal_bindLocation");
	hasSelectLocationView.$main = $("#modal_bindLocation .has-select");
	hasSelectLocationView.init();

	notSelectWorkgroupView.$root = $("#modal_bindWorkgroup");
	notSelectWorkgroupView.$main = $("#modal_bindWorkgroup .not-select");
	notSelectWorkgroupView.init();
	hasSelectWorkgroupView.$root = $("#modal_bindWorkgroup");
	hasSelectWorkgroupView.$main = $("#modal_bindWorkgroup .has-select");
	hasSelectWorkgroupView.init();

	infoLocationView.$root = $("#modal_info");
	infoLocationView.$main = $("#modal_info .infoLocation");
	infoLocationView.init();
	infoWorkgroupView.$root = $("#modal_info");
	infoWorkgroupView.$main = $("#modal_info .infoWorkgroup");
	infoWorkgroupView.init();

	/* 主视图单条数据的操作 */
	notSelectLocationView.$main.find(".add").click(function() {
		updateViewType1(notSelectLocationView, {
			url : "updateLocationBind",columnValueList_0:"flocPicking",fnSuccess0:function(){
				tableView.refreshTable(true);
				notSelectLocationView.$root.modal("hide");
			}
		}, [ notSelectLocationView, hasSelectLocationView ]);
	});
	hasSelectLocationView.$main.find(".del").click(function() {
		updateViewType1(hasSelectLocationView, {
			url : "updateLocationBind",columnValueList_0:"flocPicking",columnValueList_0_value:-1,fnSuccess0:function(){
				tableView.refreshTable(true);
				hasSelectLocationView.$root.modal("hide");
			}
		}, [ notSelectLocationView, hasSelectLocationView ])
	});

	notSelectWorkgroupView.$main.find(".add").click(function() {
		updateViewType1(notSelectWorkgroupView, {
			url : "../workbenchWorkgroup/insert"
		}, [ notSelectWorkgroupView, hasSelectWorkgroupView ]);
	});
	hasSelectWorkgroupView.$main.find(".del").click(function() {
		updateViewType1(hasSelectWorkgroupView, {
			url : "../workbenchWorkgroup/del",columnName:"workbenchWorkgroupId"
		}, [ notSelectWorkgroupView, hasSelectWorkgroupView ])
	});

});
tableView.tableOptions = {
	url : "listData",
	addOnLoadSuccess : function(data) {
	},
	columns : [/* {
		checkbox : true
	},*/defaultColumns.serialNumber, {
		field : "op",
		title : "操作",
		align : "center",
		width :'300px',
		formatter : function(value, row, index) {
			var operationArr = "";
			switch (row.status = 1) {
			case 1:
				operationArr = [ "<span btn-modify class='update' style='cursor:pointer;' >[编辑]</span>", "<span btn-bindLocation class='bindLocation'  data-toggle='modal' style='cursor:pointer;'>[维护成品拣选位]</span>", "<span btn-bindWorkgroup class='bindWorkgroup' style='cursor:pointer;' >[维护工作组]</span>", "<span btn-info class='info' style='cursor:pointer;' >[查看]</span>" ].join('');
				break;
			}
			return operationArr;
		},
		events : {
			'click .update' : function(e, value, row, index) {
				tableView.tools.update.fnBtnTodo(undefined, row);
				// tableView.tools.update.$main.find("[name='fSi']").attr("disabled","disabled");
			},
			'click .bindLocation' : function(e, value, row, index) {
				hasSelectLocationView.$main.find("input[name='id']").val(row.flocPicking);
				notSelectLocationView.$main.find("input[name='id']").val(row.flocPicking);
				clickViewRowOp1(notSelectLocationView, row, [ notSelectLocationView, hasSelectLocationView ]);
			},
			'click .bindWorkgroup' : function(e, value, row, index) {
				hasSelectWorkgroupView.$main.find("input[name='fworkbench']").val(row.id);
				notSelectWorkgroupView.$main.find("input[name='fworkbench']").val(row.id);
				clickViewRowOp1(notSelectWorkgroupView, row, [ notSelectWorkgroupView, hasSelectWorkgroupView ]);
			},
			'click .info' : function(e, value, row, index) {
				infoLocationView.$main.find("input[name='id']").val(row.flocPicking);
				infoWorkgroupView.$main.find("input[name='fworkbench']").val(row.id);
				clickViewRowOp1(infoLocationView, row, [  infoLocationView, infoWorkgroupView ]);
			}
		}
	}, {
		align : "center",
		field : 'code',
		title : '加工台编号',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'name',
		title : '加工台名称',
		formatter : defaultColumns.formatterToTV
	} ]
};
/* 工作组与商品绑定--相关操作 */
var columns = {
	location :  [ {
		checkbox : true
	},defaultColumns.serialNumber
    ,{
		align : "center",
        field: 'systemCode',
        title: '系统货位编码',
		formatter : defaultColumns.formatterToTV
	},{
		align:"center",
		field:"code",
		title:"货位编码",
		formatter : defaultColumns.formatterToTV
	}
    ,{
		align : "center",
        field: 'showCode',
        title: '显示货位编码',
		formatter : defaultColumns.formatterToTV
	}
    ,{
		align : "center",
        field: 'strType',
        title: '货位类型',
		formatter : defaultColumns.formatterToTV
	}
    ,{
		align : "center",
        field: 'warehouseName',
        title: '仓库编码',
		formatter : defaultColumns.formatterToTV
	}
    ,{
		align : "center",
        field: 'strRegion',
        title: '大区',
		formatter : defaultColumns.formatterToTV
	}
    ,{
		align : "center",
        field: 'storageAreaName',
        title: '小区',
		formatter : defaultColumns.formatterToTV
	}
    ,{
		align : "center",
        field: 'passagewayName',
        title: '通道',
		formatter : defaultColumns.formatterToTV
	}
    ,{
		align : "center",
        field: 'layer',
        title: '层',
		formatter : defaultColumns.formatterToTV
	}
    ,{
		align : "center",
        field: 'line',
        title: '列',
		formatter : defaultColumns.formatterToTV
	}
    ,{
		align : "center",
        field: 'reservedBit',
        title: '保留位',
		formatter : defaultColumns.formatterToTV
	}
    ,{
		align : "center",
        field: 'sortingOrder',
        title: '拣货顺序',
		formatter : defaultColumns.formatterToTV
	}
    ,{
		align : "center",
        field: 'specification',
        title: '货位规格/cm',
		formatter : defaultColumns.formatterToTV
	}
    ,{
		align : "center",
        field: 'bearingWeight',
        title: '承重量',
		formatter : defaultColumns.formatterToTV
	}
    ,{
		align : "center",
        field: 'strStatus',
        title: '状态',
		formatter : defaultColumns.formatterToTV
	}
    ],
	workgroup : [ {
		checkbox : true
	},defaultColumns.serialNumber,{
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
		field : 'updateName',
		title : '修改人',
		formatter : defaultColumns.formatterToTV
	}, {
		align : "center",
		field : 'strUt',
		title : '修改时间',
		formatter : defaultColumns.formatterToTV
	} ]
};
notSelectLocationView.tableOptions = {
	url : "../location/listNoHaveLocData",
	addOnLoadSuccess : function(data) {
	},
	pageSize : 5,
	columns : columns.location
};
hasSelectLocationView.tableOptions = {
	url : "../location/listHaveLocData",
	pageSize : 5,
	columns : columns.location
};
notSelectWorkgroupView.tableOptions = {
	url : "../workbenchWorkgroup/listNoHaveWgData",
	pageSize : 5,
	addOnLoadSuccess : function(data) {
	},
	columns : columns.workgroup
};
hasSelectWorkgroupView.tableOptions = {
	url : "../workbenchWorkgroup/listHaveWgData",
	pageSize : 5,
	addOnLoadSuccess : function(data) {
	},
	columns : columns.workgroup
};
infoLocationView.tableOptions = {
	url : "../location/listHaveLocData",
	pageSize : 5,
	columns : getInfoColumns(columns.location)
};
infoWorkgroupView.tableOptions = {
	url : "../workbenchWorkgroup/listHaveWgData",
	pageSize : 5,
	columns : getInfoColumns(columns.workgroup)
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
		var workgroupId = view.$root.find(".modal-header [name='id']").val();
		var warehouseId =undefined;
		try{
			warehouseId = view.$root.find(".modal-header [name='fwarehouse']").val();
		}catch(e){}
		if (!workgroupId) {
			view.notify("danger", "选择工作组错误啦，请联系管理员吧！");
			return;
		}
		var columnValueList = [];
		var isReturn=false;
		$.each(selected, function(index, item) {
			var val=undefined;
			if(ajax.columnName){
				val=item[ajax.columnName];
			}else{
				val=item.id;
			}
			if(val){
				columnValueList[index] =val;
			}else{
				view.notify("danger", "数据出错啦，请联系管理员吧！");
				isReturn=true;
				return false;
			}
		});
		if(isReturn){
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
					if(typeof ajax.fnSuccess0=="function"){
						ajax.fnSuccess0();
					}
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
