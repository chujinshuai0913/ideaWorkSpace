var tableView=new TableView({clazzName:"tableView"});
var dataItem=undefined;
$(function(){
	/*获取数据项*/
	if(typeof dataItem=="object" && dataItem==null){
		$.ajax(tableView.ajaxOptions({url:"dataItem",success:function(result){
			try{
				dataItem=result;
				$("body").elDataItem();
			}catch(bodyDataItem){
				console.log("$('body').elDataItem(); error:"+bodyDataItem);
			}
		}}, {}));
	}else{
		try{
			$("body").elDataItem();
		}catch(bodyDataItem){
			console.log("$('body').elDataItem(); error:"+bodyDataItem);
		}
	}
	/*视图开始*/
	tableView.$root=$("#panel1");
	tableView.init();
	
	if(tableView.tableOptions && tableView.tableOptions.url && tableView.$table && tableView.$table.length>0){
		tableView.bootstrapTable(tableView.$table, tableView.tableOptions, false);
	}
	try{
		tableView.datepicker({});
	}catch(error_datepicker){
		console.log("Please join the bootstrap-datepicker-1.5.0.js. error:"+datepicker);
	}
	
	$("div.modal").on('hidden.bs.modal', function () {
		//多次绑定会出现多次操作，故不在这操作数据
		var $modal=$(this);
		var width=$modal.find(".modal-dialog").attr("dialog-width");
		$modal.find(".modal-dialog").css({
			"width":width||"95%"
		});
	});
	
	$("div[type='radio']").find("input[type='radio'],input[type='checkbox']").click(function(){
		var $this=$(this);
		var $parent=$this.parents("[type='radio']");
		$parent.find("input[type='radio'],input[type='checkbox']").attr("checked",false);
		$parent.find("label").css("color","");
		$this.parents("label").css("color","blue");
		$this.attr("checked",true);
		$this.prop("checked",true);
		$parent.attr("value",$this.val());
		$this.elDataCheck();
		
		if(typeof addRadioFn=="function"){
			addRadioFn(this);
		}
	});
});
function TableView(field){
	this.clazzName=field.clazzName||"";
	this.$root=field.$root||undefined;
	/*Container*/
	this.$main=field.$main||undefined;
	this.$table=undefined;
	/*Tabular query parameter container object*/
	this.$tableQP=undefined;
	this.$tableRefresh=undefined;
	this.tableOptions=undefined;
	this.columnOptions=undefined;
	this.tools={
			sync:{
				toolName:"sync",
				view:undefined,
				$btnTodo:undefined,
				$main:undefined,
				isModal:true,
				$requestBtn:undefined,
				$requestParam:undefined,
				requestBtnLadda:undefined,
				ajax:{url:"sync"},
				init:function(){
					var thisTool=this;
					this.$btnTodo.click(function(){
						thisTool.fnTodoBefore();
					});
				},
				fnTodoBefore:function(){
					var thisTool=this;
					try{
						if(Ladda){
							this.requestBtnLadda = Ladda.create( this.$btnTodo[0] );
						}
					}catch(e){
						
					}
					if(this.requestBtnLadda){
						this.requestBtnLadda.start();
					}
					$.ajax(this.view.ajaxOptions(this.ajax, {})).always(function() {
						if(thisTool.requestBtnLadda){
							thisTool.requestBtnLadda.stop();
						}
					});
					
					return true;
				}
			},
			insert:{
				toolName:"insert",
				//view:undefined,
				$btnTodo:undefined,
				$main:undefined,
				isModal:true,
				$requestBtn:undefined,
				$requestParam:undefined,
				ajax:{url:"insert"},
				fnTodoBefore:function(){
					return true;
				},
				fnRequestBefore:function(){
					this.ajax.data=this.$requestParam.elDataGet();
					var isPass=false;
					if(this.$main.find(".has-error").length>0){
						isPass=false;
						this.view.notify("danger",  this.view.TipsInfo.dataFillError);
					}else{
						isPass=true;
					}
					return isPass;
				}
			},
			del:{
				toolName:"del",
				//view:undefined,
				$btnTodo:undefined,
				$main:undefined,
				isModal:true,
				$requestBtn:undefined,
				$requestParam:undefined,
				ajax:{url:"del"},
				setModalInfo:function(el){
					this.$main.find(".modal-dialog").css({
						"width":"300px"
					});
				},
				fnTodoBefore:function(){
					var selected = [];
					selected = this.view.$table.bootstrapTable("getSelections");
					if (selected.length == 0) {
						this.view.notify("warning", this.view.TipsInfo.atLeastSelectOneRow);
						return;
					} else {
						var columnValueList=[];
						$.each(selected,function(index,item){
							columnValueList[index]=item.id
						});
						this.ajax.data={columnValueList:columnValueList};
						this.setModalInfo();
						this.$main.modal("show");
					}
					this.$main.find("[content-type*="+this.toolName+"]").elDataSet({delCount:selected.length});
					return true;
				},
				fnRequest:function(){
					var thisTool=this;
					if(this.ajax.data){
						if(this.requestBtnLadda){
							this.requestBtnLadda.start();
						}
						$.ajax(this.view.ajaxOptions(this.ajax, {})).always(function() {
							if(thisTool.requestBtnLadda){
								thisTool.requestBtnLadda.stop();
							}
							thisTool.$main.modal("hide");
							thisTool.$main.find(".modal-dialog").css({
								"width":"95%"
							});
						});
					}else{
						this.$main.modal("hide");
						this.$main.find(".modal-dialog").css({
							"width":"95%"
						});
					}
				}
			},
			update:{
				toolName:"update",
				//view:undefined,
				$btnTodo:undefined,
				$main:undefined,
				isModal:true,
				$requestBtn:undefined,
				$requestParam:undefined,
				ajax:{url:"update"},
				fnTodoBefore:function(){
					return true;
				},
				fnRequestBefore:function(){
					this.ajax.data=this.$requestParam.elDataGet();
					var isPass=false;
					if(this.$main.find(".has-error").length>0){
						isPass=false;
						this.view.notify("danger", this.view.TipsInfo.dataFillError);
					}else{
						isPass=true;
					}
					return isPass;
				}
			}
	};
	TableView.prototype.Attr = {
		labelData : "label-data",
		/*table attr*/
		tableView:"table-view",
		tableViewQueryParam : "table-query-param",
		/*tools attr*/
		btnSync : "btn-sync",
		btnInsert : "btn-insert",
		btnDel : "btn-del",
		btnSave:"btn-save",
		btnModify:"btn-modify",
		addContainer:"add-container",
		
		requestBtn:"request-btn",
		requestBtnAdd:"request-btn-add",
		requestBtnDel:"request-btn-del",
		requestBtnModify:"request-btn-modify",
		requestBtnUpdate:"request-btn-update",
		requestParam:"request-param",
		
		containerInsert:"container-insert",
		containerDel:"container-del",
		containerUpdate:"container-update",
		
		/*input attr*/
		inputDate : "input-date",
		inputIntDate : "input-int-date",
		/*???*/
		resetForm : "reset-form",
		resetValue : "reset-value",
		refreshTable : "refresh-table",
		exportTable : "export-table",
		exportTableAll : "export-table-all",
		ajaxToEditor:"ajax-to-editor"
	};
	TableView.prototype.TipsInfo = {
		atLeastSelectOneRow:"此操作至少要选择一行数据哦！<br/>请先去选择数据吧...我等您哦！",
		dataFillError:"太心急啦！<br/>红色代表数据填写有误哦！<br/>请填写完整（正确）试试吧..."
	};
	if (typeof this.init != "function") {
		TableView.prototype.init = function() {
			var clazz=this;
			if(!this.$root){
				return this;
			}
			if(!this.$main){
				this.$main=this.$root;
			}
			if(!this.$table){
				this.$table=this.$main.find("["+this.Attr.tableView+"]");
			}
			if(!this.$tableQP){
				this.$tableQP=this.$main.find("["+this.Attr.tableViewQueryParam+"]");
			}
			if(!this.$tableRefresh){
				this.$tableRefresh=this.$main.find("["+this.Attr.tableRefresh+"]");
			}
			/*sync-------------------------*/
			this.tools.sync.$btnTodo=this.$main.find("["+this.Attr.btnSync+"]");
			if(this.tools.sync.$btnTodo&&this.tools.sync.$btnTodo.length>0){
				this.tools.sync.view=this;
				this.tools.sync.init();
			}
			/*insert-------------------------*/
			this.tools.insert.$btnTodo=this.$main.find("["+this.Attr.btnInsert+"]");
			if(this.tools.insert.$btnTodo&&this.tools.insert.$btnTodo.length>0){
				this.tools.insert.$main=$("["+this.clazzName+"-"+this.Attr.containerInsert+"]");
				this.tools.insert.$requestBtn=this.tools.insert.$main.find("["+this.Attr.requestBtnAdd+"]");
				this.tools.insert.$requestParam=this.tools.insert.$main.find("["+this.Attr.requestParam+"]");
				this.tools.insert=this.buildTool(this.tools.insert, {view:this});
				this.tools.insert.init();
			}
			/*del-------------------------*/
			this.tools.del.$btnTodo=this.$main.find("["+this.Attr.btnDel+"]");
			if(this.tools.del.$btnTodo &&this.tools.del.$btnTodo.length>0){
				this.tools.del.$main=$("["+this.clazzName+"-"+this.Attr.containerDel+"]");
				this.tools.del.$requestBtn=this.tools.del.$main.find("["+this.Attr.requestBtnDel+"]");
				this.tools.del=this.buildTool(this.tools.del, {view:this});
				this.tools.del.init();
			}
			/*modify-------------------------*/
			this.tools.update.$main=$("["+this.clazzName+"-"+this.Attr.containerUpdate+"]");
			if(this.tools.update.$main &&this.tools.update.$main.length>0){
				this.tools.update.$requestBtn=this.tools.update.$main.find("["+this.Attr.requestBtnUpdate+"]");
				this.tools.update.$requestParam=this.tools.update.$main.find("["+this.Attr.requestParam+"]");
				this.tools.update=this.buildTool(this.tools.update, {view:this});
				this.tools.update.init();
			}
			return this;
		};
	}
	/**
	 * clear el data 2016-01-13 lrg 
	 */
	if (typeof this.clearElData != "function") {
		TableView.prototype.clearElData = function( $btn, firstQuery) {
			if($btn && $btn.length>0){
				$btn.elDataSet();
			}
			return this;
		};
	}
	/**
	 * query 2015-12-16 lrg firstQuery is true,to reset the page to the first page.
	 */
	if (typeof this.refreshTable != "function") {
		TableView.prototype.refreshTable = function(firstQuery) {
			if (firstQuery) {
				this.$table.bootstrapTable('refresh',{url:this.tableOptions.url});
			} else {
				this.$table.bootstrapTable('refresh');
			}
			return this;
		};
	}
	if (typeof this.bootstrapTable != "function") {
		TableView.prototype.bootstrapTable = function($table, options,isStrData) {
			if($table.length<=0){
				return;
			}
			var clazz = this;
			var tablePptions={
				dataField : "data",
				totalField : "total_records",
				method : "post",
				/*contentType : "application/x-www-form-urlencoded",*/
				contentType:"text/html;charset=utf-8",
				/*contentType : 'application/json',*/
				/*@ModelAttribute receive, similar to fastJson manual Rotary object*/
				//contentType : "application/x-www-form-urlencoded",
				sidePagination : "server",
				pagination : true,
				pageList : [ 5, 10, 20, 50, 100, 200, 500 ],
				pageSize : 10,
				queryParamsType : 'page',
				columns : [],
				clickToSelect : true,
				queryParams : function(params) {
					$.extend(params, clazz.$tableQP.elDataGet());
					params=JSON.stringify(params);
					return params;
				},
				onLoadSuccess:function(result){
					clazz.$table.find("[data-toggle='tooltip']").tooltip();
					if(result && result.queryParam){
						try{
							clazz.$tableQP.elDataSet(result.queryParam);
						}catch(error_elDataSet){
							console.log("bootstrapTable onLoadSuccess elDataSet $tableQP error:"+error_elDataSet);
						}
					}
					if(options && options.addOnLoadSuccess){
						options.addOnLoadSuccess(result);
					}
				}
			};
			$table.bootstrapTable($.extend(tablePptions,options));
			return this;
		};
	}
	/**
	 * Date selection 2015-12-16 lrg 
	 */
	if (typeof this.datepicker != "function") {
		TableView.prototype.datepicker = function(data) {
			var clazz=this;
			if (!data.$el) {
				data.$el = $("[" + this.Attr.inputDate + "]");
			}
			data.$el.datepicker($.extend({
				format : 'yyyy-mm-dd',
				autoclose : true,
				language : "zh-CN"
			}, data.data));
			data.$el.change(function(){
				var $this=$(this);
				var $next=$this.next();
				if($next.attr(clazz.Attr.inputIntDate)){
					if($this.val().trim()){
						var intDateTime=(new Date($this.val()).getTime())/1000;
						if($this.attr(clazz.Attr.inputDate)=='end'){
							/*Calculate the number of 24-hour second*/
							$next.val(16*60*60+intDateTime);
						}else {
							/*Calculation at 0 o'clock seconds*/
							$next.val(intDateTime-(8*60*60));
						}
					}else{
						$next.val("");
					}
				}
			});
		};
	}
	/**
	 * 提示
	 * 
	 * @param typeStr
	 *            提示框类型
	 * @param message
	 *            提示信息
	 * @param options
	 *            其它自定义
	 */
	if (typeof this.notify != "function") {
		TableView.prototype.notify = function(typeStr, message, options) {
			$.notify({
				// title:"提示",
				message : message
			}, $.extend({
				// success,info,warning,danger
				type : typeStr || "info",
				allow_dismiss : true,
				newest_on_top : true,
				// showProgressbar: true,
				placement : {
					from : "top",
					align : "center"
				},
				spacing : 10,
				offset : 30,
				delay : 5000,
				timer : 1000,
				z_index : 2000,
				mouse_over : "pause",
				animate : {
					enter : 'animated fadeInDown',
					exit : 'animated fadeOutUp'
				},
				template : '<div data-notify="container" class="col-xs-11 col-sm-3 alert alert-{0} text-center" style="font-size:16px" role="alert">' + '<button type="button" aria-hidden="true" class="close" data-notify="dismiss">×</button>' + '<span data-notify="icon"></span> ' + '<span data-notify="title">{1}</span> ' + '<span data-notify="message">{2}</span>' + '<div class="progress" data-notify="progressbar">' + '<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>' + '</div>' + '<a href="{3}" target="{4}" data-notify="url"></a>' + '</div>'
			}, options));
		};
	}
	if (typeof this.confirmModal != "function") {
		TableView.prototype.confirmModal = function(dataParam) {
			
			return this;
		};
	}
	
	if (typeof this.buildTool != "function") {
		TableView.prototype.buildTool = function(toolParam,other) {
			var tool={
					view:other.view||this,
					toolName:"",
					$btnTodo:undefined,
					$main:undefined,
					isModal:true,
					$requestBtn:undefined,
					requestBtnLadda:undefined,
					$requestParam:undefined,
					fnTodoInit:function(){
						var $disabled=this.$main.find("[disabled]");
						if($disabled.length>0){
							$disabled.removeAttr("disabled");
						}
						var $containerContent=this.$main.find("[content-type]");
						if($containerContent && $containerContent.length>0){
							$containerContent.hide();
							this.$main.find("[content-type*="+this.toolName+"]").show();
						}
						try{
							this.$main.find("[content-type*="+this.toolName+"]").elDataSet();
						}catch(elSet){
							console.log("tool "+this.toolName+" elDataSet errot:"+elSet);
						}
						try{
							if(Ladda){
								this.requestBtnLadda = Ladda.create( this.$requestBtn[0] );
							}
						}catch(e){
							
						}
						return true;
					},
					fnTodoBefore:function(){
						console.log("--fnRequestBefore:请重写要操作的内容--");
						return true;
					},
					fnBtnTodo:function(el,elData){
						var toTodo=true;
						if(typeof this.fnTodoInit=="function"){
							toTodo=this.fnTodoInit();
						}
						if(typeof this.fnTodoBefore=="function"){
							toTodo=this.fnTodoBefore();
						}
						if(toTodo){
							if(this.isModal){
								this.$main.modal("show");
							}else{
								this.$main.show();
							}
							if(elData && typeof elData=="object"){
								this.$main.elDataSet(elData);
							}
							try{
								this.$main.find("[content-type*="+this.toolName+"]").elDataCheck();
							}catch(elCheck){
								console.log("tool "+this.toolName+" elDataCheck errot:"+elCheck);
							}
						}
					},
					fnRequestBefore:function(){
						return true;
					},
					fnRequest:function(){
						var thisTool=this;
						var toRequest=true;
						if(typeof this.fnRequestBefore=="function"){
							toRequest=this.fnRequestBefore();
						}
						if(toRequest){
							if(this.requestBtnLadda){
								this.requestBtnLadda.start();
							}
							$.ajax(this.view.ajaxOptions(this.ajax, other)).always(function() {
								if(thisTool.requestBtnLadda){
									thisTool.requestBtnLadda.stop();
								}
							});
						}
					},
					ajaxSuccess:function(result){
						if(this.tool.isModal){
							this.tool.$main.modal("hide");
						}else{
							this.tool.$main.hide();
						}
					},
					init:function(){
						var thisTool=this;
						if(this.$main && this.$main.length>0){
							if(this.$btnTodo && this.$btnTodo.length>0){
								this.$btnTodo.click(function(){
									thisTool.fnBtnTodo(this);
								});
							}
							if(this.$requestBtn && this.$requestBtn.length>0){
								this.$requestBtn.click(function(){
									thisTool.fnRequest();
								});
							}
						}
					}
				};
			$.extend(tool,toolParam);
			other.ajaxSuccess=tool.ajaxSuccess;
			other.tool=tool;
			tool.ajax=this.ajaxOptions(tool.ajax, other);
			return tool;
		};
	}
	if (typeof this.ajaxOptions != "function") {
		TableView.prototype.ajaxOptions = function(ajaxParam,other) {
			var clazz=other.view||this;
			var ajax={
                type : "POST",
                url : undefined,
                data : {},
                contentType:"text/html;charset=utf-8",
                success : function(results) {
                	try{
                		results=eval('(' + results + ')');
                	}catch(r){
                		
                	}
                	if(results.error_code==0){
                		clazz.refreshTable(true);
                		clazz.notify("success",(typeof results.data=="string")?results.data:(other.successMsg||"成功！"));
                	}else{
                		try{
    						if(results.error){
    							clazz.notify("danger",results.error.msg||other.errorMsg||"失败！");
    						}else{
    							clazz.notify("danger",(typeof results.data=="string")?results.data:(other.errorMsg||"失败！"));
    						}
    					}catch(e){
    							clazz.notify("danger","操作失败啦，请重试或联系管理员吧！");
    					}
                	}
                	try{
                		if(typeof other.ajaxSuccess=="function"){
                			other.ajaxSuccess(results);
                		}
                	}catch(addSuccessFn){
                		console.log("ajax success addSuccessFn error:"+addSuccessFn);
                	}
                },
                statusCode : {
                    404 : (function(){
                    	clazz.notify("danger", "出错啦...请检查网络或联系管理员！");
                    })
                }
            };
			if(ajaxParam && ajaxParam!=null){
				$.extend(ajax,ajaxParam);
			}
			if(typeof ajax.data!="string"){
				ajax.data=JSON.stringify(ajax.data);
			}
			return ajax;
		};
	}
	/**
	 * 数据导出 2015-12-16 lrg
	 */
	if (typeof this.exportTable != "function") {
		TableView.prototype.exportTable = function($btn, dataParam) {
			var clazz = this;
			// 导出前准备工作
			var data = {
				url : 'export',
				all : false,
				primaryKey : "id",
				paramField : "columnValueList",
				$form : null,
				$table : null,
				data:undefined
			};
			var param={};
			try{
				if(dataParam && dataParam!=null){
					param=dataParam;
				}else{
					param=eval('(' + $btn.attr("["+this.Attr.exportTable+"]") + ')');
				}
			}catch(getExportTableData){
				
			}
			// 获取参数
			$.extend(data, param);
			if(!data.data){
				data.data={};
				if(data.all){
					if (data.$form == null) {
						clazz.notify("danger", "出错啦...（缺少表单对象数据）");
						return false;
					}
					data.$form.attr({
						"action" : data.url,
						"method" : "post"
					}).submit();
					data.$form.attr({
						"action" : ""
					});
					//data.data=data.$form.elDataGet();
				}else{
					if (data.$table == null) {
						clazz.notify("danger", "出错啦...（缺少表格对象数据）");
						return false;
					}
					var selected = data.$table.bootstrapTable("getSelections");
					if (selected.length == 0) {
						clazz.notify("warning", "至少选择一行数据");
						return;
					} else {
						data.$form = $("<form id='export_form'></form>");
						data.$form.attr({
							"style" : "display:none",
							"action" : data.url,
							"method" : "post",
						});
						var primaryKeyValue=-1;
						for (var i = 0; i < selected.length; i++) {
							primaryKeyValue = (selected[i][data.primaryKey]) || -1;
							var $idCheckbox = $("<input type='checkbox'checked='true' name='" + data.paramField + "' value='" + primaryKeyValue + "'/>");
							$idCheckbox.appendTo(data.$form);
						}
						
						$btn.parent().parent().append(data.$form);
						data.$form.submit();
						$btn.parent().parent().find("form[id='export_form']").remove();
						/*
						var longList=[];
						$.each(selected,function(index,item){
							longList[index]=item[data.primaryKey];
						});
						data.data[data.paramField]=longList;
						*/
					}
				}
			}
			//$.ajax(this.ajaxOptions({url:data.url,data:data.data}, {ajaxSuccess:data.ajaxSuccess}));
		};
	}
}