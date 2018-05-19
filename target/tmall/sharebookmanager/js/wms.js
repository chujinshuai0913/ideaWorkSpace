//表单序列化成object对象
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (this.value && this.value != '') {
			if (o[this.name] !== undefined) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value);
			} else {
				o[this.name] = this.value;
			}
		}
	});
	return o;
};

/**
 * 日期格式化  
 * 格式 YYYY/yyyy/YY/yy 表示年份  
 * MM/M 月份  
 * W/w 星期  
 * dd/DD/d/D 日期  
 * hh/HH/h/H 时间  
 * mm/m 分钟  
 * ss/SS/s/S 秒
 */
Date.prototype.format = function(formatStr)   
{   
    var str = formatStr;   
    var Week = ['日','一','二','三','四','五','六'];  
  
    str=str.replace(/yyyy|YYYY/,this.getFullYear());   
    str=str.replace(/yy|YY/,(this.getYear() % 100)>9?(this.getYear() % 100).toString():'0' + (this.getYear() % 100));   
  
    str=str.replace(/MM/,this.getMonth()>=9?(this.getMonth()+1).toString():'0' + (this.getMonth()+1));   
    str=str.replace(/M/g,this.getMonth()+1);   
  
    str=str.replace(/w|W/g,Week[this.getDay()]);   
  
    str=str.replace(/dd|DD/,this.getDate()>9?this.getDate().toString():'0' + this.getDate());   
    str=str.replace(/d|D/g,this.getDate());   
  
    str=str.replace(/hh|HH/,this.getHours()>9?this.getHours().toString():'0' + this.getHours());   
    str=str.replace(/h|H/g,this.getHours());   
    str=str.replace(/mm/,this.getMinutes()>9?this.getMinutes().toString():'0' + this.getMinutes());   
    str=str.replace(/m/g,this.getMinutes());   
  
    str=str.replace(/ss|SS/,this.getSeconds()>9?this.getSeconds().toString():'0' + this.getSeconds());   
    str=str.replace(/s|S/g,this.getSeconds());   
  
    return str;   
}   

//根据日期format工具
function formatDate(datatime,formatStr){
	var date = new Date();
	date.setTime(datatime);
	return date.format(formatStr);
}

//转换select2 List工具方法
function getSelect2ArrayData(jsonStr,idField,textField){
	var list = JSON.parse(jsonStr);
	var items = [];
	for(var i=0;i<list.length;i++){
		var item = {};
		item.id = list[i][idField];
		item.text = list[i][textField];
		items.push(item);
	}
	return items;
}

//success提示
function successNotify(message){
	notify(message,{
		type:"success"
	});
}

//info提示
function infoNotify(message){
	notify(message,{
		type:"info"
	});
}

//warning提示
function warningNotify(message){
	notify(message,{
		type:"warning"
	});
}

//danger提示
function dangerNotify(message){
	notify(message,{
		type:"danger"
	});
}


//提示信息框
function notify(message,options){
	$.notify({
		//title:"提示",
		message:message
	},$.extend({
		//success,info,warning,danger
		type: "info",
		allow_dismiss: true,
		newest_on_top: true,
		//showProgressbar: true,
		placement: {
			from: "top",
			align: "center"
		},
		spacing: 10,
		offset:30,
		delay: 5000,
		timer: 1000,
		z_index:9999,
		mouse_over:"pause",
		animate: {
			enter: 'animated fadeInDown',
			exit: 'animated fadeOutUp'
		},
		template: '<div data-notify="container" class="col-xs-11 col-sm-3 alert alert-{0} text-center" style="font-size:16px" role="alert">' +
			'<button type="button" aria-hidden="true" class="close" data-notify="dismiss">×</button>' +
			'<span data-notify="icon"></span> ' +
			'<span data-notify="title">{1}</span> ' +
			'<span data-notify="message">{2}</span>' +
			'<div class="progress" data-notify="progressbar">' +
				'<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>' +
			'</div>' +
			'<a href="{3}" target="{4}" data-notify="url"></a>' +
		'</div>' 
	},options));
}

// create table and get data
function bootstrapTable(table, options, formatter) {
	// window.operateEvents = operateEvents;
	var url = "getListData";
	if(options && options.url){
		url = options.url;
	}
	var table = $(table).bootstrapTable($.extend({
		dataField : "data",
		totalField : "total_records",
		method : "post",
		contentType : "application/x-www-form-urlencoded",
		url : url,
		sidePagination : "server",
		pagination : true,
		pageList : [ 5, 10, 20, 50, 100, 200 ],
		pageSize : 10,
		queryParamsType : 'page',
		queryParams : function(params) {
			var formParams = $("#queryForm").serializeObject();
			$.extend(params, formParams)
			return params;
		},
		// search:true,
		// searchText:'',
		// showPaginationSwitch:true,
		columns : [],
		clickToSelect : false
	}, options));
	// table global
	/*if (typeof hideCol == "function"){
		hideCol(table);
	}*/
	window.table = table;
}

// table default operate formatter
function operateFormatter(value, row, index) {
	return [ '<a class="edit" href="javascript:void(0)" style="margin-right:5px;" title="编辑">',
			'<i class="glyphicon glyphicon-pencil"></i>', '</a>  ',
			'<a class="remove" href="javascript:void(0)" style="margin-left:5px;" title="删除">',
			'<i class="glyphicon glyphicon-remove"></i>', '</a>' ].join('');
}

// refresh table
function refreshTable(table) {
	$(table).bootstrapTable('refresh');
}

//refresh table
function refreshTable(table, firstQuery) {
	if (!firstQuery) {
		$(table).bootstrapTable('refresh');
	} else {
		$(table).bootstrapTable('refresh', {
			query : {
				pageNumber : 1
			}
		});
	}
}

(function($) {
	window.Ewin = function() {
		var html = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel">'
				+ '<div class="modal-dialog modal-sm">'
				+ '<div class="modal-content">'
				+ '<div class="modal-header">'
				+ '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>'
				+ '<h4 class="modal-title" id="modalLabel">[Title]</h4>'
				+ '</div>'
				+ '<div class="modal-body">'
				+ '<p>[Message]</p>'
				+ '</div>'
				+ '<div class="modal-footer">'
				+ '<button type="button" class="btn btn-default cancel" data-dismiss="modal">[BtnCancel]</button>'
				+ '<button type="button" class="btn btn-primary ok" data-dismiss="modal">[BtnOk]</button>'
				+ '</div>' + '</div>' + '</div>' + '</div>';

		var dialogdHtml = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel">'
				+ '<div class="modal-dialog">'
				+ '<div class="modal-content">'
				+ '<div class="modal-header">'
				+ '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>'
				+ '<h4 class="modal-title" id="modalLabel">[Title]</h4>'
				+ '</div>'
				+ '<div class="modal-body">'
				+ '</div>'
				+ '</div>'
				+ '</div>' + '</div>';
		var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');
		var generateId = function() {
			var date = new Date();
			return 'mdl' + date.valueOf();
		}
		var init = function(options) {
			options = $.extend({}, {
				title : "操作提示",
				message : "提示内容",
				btnok : "确定",
				btncl : "取消",
				width : 200,
				auto : false
			}, options || {});
			var modalId = generateId();
			var content = html.replace(reg, function(node, key) {
				return {
					Id : modalId,
					Title : options.title,
					Message : options.message,
					BtnOk : options.btnok,
					BtnCancel : options.btncl
				}[key];
			});
			$('body').append(content);
			$('#' + modalId).modal({
				width : options.width,
				backdrop : 'static'
			});
			$('#' + modalId).on('hide.bs.modal', function(e) {
				$('body').find('#' + modalId).remove();
			});
			return modalId;
		}

		return {
			alert : function(options) {
				if (typeof options == 'string') {
					options = {
						message : options
					};
				}
				var id = init(options);
				var modal = $('#' + id);
				modal.find('.ok').removeClass('btn-success').addClass(
						'btn-primary');
				modal.find('.cancel').hide();

				return {
					id : id,
					on : function(callback) {
						if (callback && callback instanceof Function) {
							modal.find('.ok').click(function() {
								callback(true);
							});
						}
					},
					hide : function(callback) {
						if (callback && callback instanceof Function) {
							modal.on('hide.bs.modal', function(e) {
								callback(e);
							});
						}
					}
				};
			},
			confirm : function(options) {
				var id = init(options);
				var modal = $('#' + id);
				modal.find('.ok').removeClass('btn-primary').addClass(
						'btn-success');
				modal.find('.cancel').show();
				return {
					id : id,
					on : function(callback) {
						if (callback && callback instanceof Function) {
							modal.find('.ok').click(function() {
								callback(true);
							});
							modal.find('.cancel').click(function() {
								callback(false);
							});
						}
					},
					hide : function(callback) {
						if (callback && callback instanceof Function) {
							modal.on('hide.bs.modal', function(e) {
								callback(e);
							});
						}
					}
				};
			},
			dialog : function(options) {
				options = $.extend({}, {
					title : 'title',
					url : '',
					width : 800,
					height : 550,
					onReady : function() {
					},
					onShown : function(e) {
					}
				}, options || {});
				var modalId = generateId();

				var content = dialogdHtml.replace(reg, function(node, key) {
					return {
						Id : modalId,
						Title : options.title
					}[key];
				});
				$('body').append(content);
				var target = $('#' + modalId);
				target.find('.modal-body').load(options.url);
				if (options.onReady())
					options.onReady.call(target);
				target.modal();
				target.on('shown.bs.modal', function(e) {
					if (options.onReady(e))
						options.onReady.call(target, e);
				});
				target.on('hide.bs.modal', function(e) {
					$('body').find(target).remove();
				});
			}
		}
	}();
})(jQuery);