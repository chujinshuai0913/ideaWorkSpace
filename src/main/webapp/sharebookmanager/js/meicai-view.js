var defaultColumns={
	serialNumber:{
		field : "serialNumber",
		title : "序号",
		align : "center",
		formatter : function(value, row, index) {
			row.index=index;
			return index + 1;
		}
	},
	siName:{
		field : "siName",
		title : "名称",
		align : "center",
		formatter: function (value, row, index) {
			var title="<span class='pull-left'>品牌：<lable style='color:red;'>"+row.ownBrand+"</lable></span><br/>";
			    title+="<span class='pull-left'>等级：<lable style='color:green;'>"+row.level+"</lable></span><br/>";
			    title+="<span class='pull-left'>规格：<lable style='color:green;'>"+row.format+"</lable></span><br/>";
			return [
					"<span  data-toggle='tooltip' data-placement='right' data-html=true  title=\""+title+"\">"+value+"</span>"
            ].join('');
        }
	},
	surplusLossQuantity: {
		field : "quantity",
		title : "",//盈亏数量
		align : "center",
		formatter: function (value, row, index) {
			if(row.type==1){
				return "盘亏数量："+value;
			}else{
				return "盘盈数量："+value;
			}
		}
	},
	creater:{
		field : "creater",
		title : "操作人",
		align : "center"
	},
	cT: {
		field : "cT",
		title : "操作时间",
		align : "center",
		formatter: function (value, row, index) {
			if(value && value!=null){
				var date = new Date();
				date.setTime(value*1000);
				value=date.format("yyyy-MM-dd HH:mm:ss")
			}else{
				value="";
			}
			return value;
		}
	},
	updater:{
		field : "updater",
		title : "操作人",
		align : "center"
	},
	updaterName:{
		field : "updaterName",
		title : "操作人",
		align : "center"
	},
	uT: {
		field : "uT",
		title : "操作时间",
		align : "center",
		formatter: function (value, row, index) {
			if(value && value!=null){
				var date = new Date();
				date.setTime(value*1000);
				value=date.format("yyyy-MM-dd HH:mm:ss")
			}else{
				value="";
			}
			return value;
		}
	},
	formatterToTV : function(value, row, index) {
		if(value && value!=null && value!="0" && value !="1970"){
			
		}else{
			value="";
		}
		return value;
	},
	formaterDateTime : function (value, row, index) {
		if(value && value!=null){
			var date = new Date();
			date.setTime(value*1000);
			value=date.format("yyyy-MM-dd HH:mm:ss")
		}else{
			value="";
		}
		return value;
	}
};
$(function(){
	getWarehouse($("select[warehouse]"));
});
function getWarehouse($SWS){
	if((!$SWS) || $SWS.length<=0){
		return ;
	}
	$SWS.each(function(index,el){
		$(el).find("option").remove("[item]");
	});
	$.ajax({
        type : "POST",
        url : "../warehouse/listData",
        data : JSON.stringify({}),
        contentType:"text/html;charset=utf-8",
        success : function(results) {
			if(results.error_code==0){
				var objOrArr=true;
				if(results.data.constructor === Array){
					objOrArr=false;
				}
				var strOption="";
				if(objOrArr){
					$.each(results.data,function(key,value){
						strOption+="<option item='' value='"+key+"'>"+value+"</option>";
					});
				}else{
					$.each(results.data,function(index,item){
						strOption+="<option item='"+JSON.stringify(item)+"' value='"+item.id+"'>"+item.name+"</option>";
					});
				}
				$SWS.each(function(index,el){
					$(el).append(strOption);
				});
			}
        },
        statusCode : {
            404 : (function(){
            	tableView.notify("danger", "获取仓库出错啦...请检查网络或联系管理员！");
            })
        }
    });
}
function getSkuClass(class123,pid,$select){
	var url="";
	var param={};
	if(class123==1){
		url="../class1/listData";
	}else{
		pid=Number(pid);
	}
	if(pid){
		if(class123==2){
			url="../class2/listData";
			param.class1Id=pid;
		}else if(class123==3){
			url="../class3/listData";
			param.class2Id=pid;
		}
	}
	$select.find("option").remove("[item]");
	$.ajax({
        type : "POST",
        url : url,
        data : JSON.stringify(param),
        contentType:"text/html;charset=utf-8",
        success : function(results) {
			if(results.error_code==0){
				var objOrArr=true;
				if(results.data.constructor === Array){
					objOrArr=false;
				}
				var strOption="";
				if(objOrArr){
					$.each(results.data,function(key,value){
						strOption+="<option item='' value='"+key+"'>"+value+"</option>";
					});
				}else{
					$.each(results.data,function(index,item){
						strOption+="<option item='"+JSON.stringify(item)+"' value='"+item.id+"'>"+item.name+"</option>";
					});
				}
				$select.append(strOption);
			}
        },
        statusCode : {
            404 : (function(){
            	tableView.notify("danger", "获取商品分类"+class123+"出错啦...请检查网络或联系管理员！");
            })
        }
    });
}
function selectChageJoin1(el,joinElS,data){
	if((!data)||(!data.url)||(!data.key)){
		tableView.notify("danger", "获取["+$(el).find("option:selected").text()+"]相关数据出错啦...请检查网络或联系管理员！");
		return;
	}
	var $join=$(joinElS);
	$join.find("option").remove("[item]");
	var elVal=$(el).val();
	if(elVal){
		
	}else{
		$join.each(function(index,selectEl){
			try{
				$(this).elDataCheck();
			}catch(e){}
		});
		return;
	}
	var param=data.param||{};
	param[data.key]=$(el).val();
	$.ajax({
        type : "POST",
        url : data.url,
        data : JSON.stringify(param),
        contentType:"text/html;charset=utf-8",
        success : function(results) {
			if(results.error_code==0){
				var objOrArr=true;
				if(results.data.constructor === Array){
					objOrArr=false;
				}
				var strOption="";
				if(objOrArr){
					$.each(results.data,function(key,value){
						strOption+="<option item='' value='"+key+"'>"+value+"</option>";
					});
				}else{
					$.each(results.data,function(index,item){
						strOption+="<option item='"+JSON.stringify(item)+"' value='"+item[data.value||"id"]+"'>"+item[data.text||"code"]+"</option>";
					});
				}
				$join.each(function(index,selectEl){
					var $this=$(this);
					$this.append(strOption);
					try{
						$this.elDataCheck();
					}catch(e){}
					
				});
				if(typeof data.addSuccess =="function"){
					data.addSuccess(results);
				}
			}
        },
        statusCode : {
            404 : (function(){
            	tableView.notify("danger", "获取["+data.title+"]数据出错啦...请检查网络或联系管理员！");
            })
        }
    });
}
//**悬浮窗******************************************************************
var offset_x;
var offset_y;
function Milan_StartMove(oEvent, div_id) {
	var whichButton;
	if (document.all && oEvent.button == 1)
		whichButton = true;
	else {
		if (oEvent.button == 0)
			whichButton = true;
	}
	if (whichButton) {
		var oDiv = div_id;
		offset_x = parseInt(oEvent.clientX - oDiv.offsetLeft);
		offset_y = parseInt(oEvent.clientY - oDiv.offsetTop);
		document.documentElement.onmousemove = function(mEvent) {
			var eEvent;
			if (document.all)
				eEvent = event;
			else {
				eEvent = mEvent;
			}
			var oDiv = div_id;
			var x = eEvent.clientX - offset_x;
			var y = eEvent.clientY - offset_y;
			oDiv.style.left = (x) + "px";
			oDiv.style.top = (y) + "px";
			var d_oDiv = document.getElementById("disable_" + oDiv.id);
			try{
				d_oDiv.style.left = (x) + "px";
				d_oDiv.style.top = (y) + "px";
			}catch(e){
				
			}
		}
	}
}
function Milan_StopMove(oEvent) {
	document.documentElement.onmousemove = null;
}

function EntityView(v) {
	this.arrIndex = v.arrIndex;
	this.selector = v.selector;
	this.$root = v.$root || $(v.selector) || undefined;
	this.isModal=v.isModal||false;
	this.$formTable = v.$formTable || undefined;
	this.$formEditor = v.$formEditor || undefined;
	this.formEditorCheckFn = v.formEditorCheckFn || undefined;
	this.tableId = v.tableId || undefined;
	this.$table = v.$table || undefined;
	this.table = v.table || undefined;
	this.both = v.both || false;
	this.toptions = v.toptions || {};
	this.url = v.url;
	this.exportUrl=v.exportUrl||undefined;
	this.exportAllUrl=v.exportAllUrl||undefined;
	this.childArrIndex = v.childArrIndex || undefined;
	this.ajaxBtn={
			add:{url:'add',$form:undefined},
			del:{url:'delete',$form:undefined},
			modify:{url:'update',$form:undefined},
			query:{url:'getListData',$form:undefined}
	};
	EntityView.prototype.clazzName = "View";
	EntityView.prototype.arrView = new Array();
	EntityView.prototype.Attr = {
		labelData : "label-data",
		refreshTable : "refresh-table",
		tableView:"table-view",
		formTable : "form-table",
		formEditor : "form-editor",
		resetForm : "reset-form",
		resetValue : "reset-value",
		inputDate : "input-date",
		inputIntDate : "input-int-date",
		exportTable : "export-table",
		exportTableAll : "export-table-all",
		ajaxToEditor:"ajax-to-editor"
	};
	if (typeof this.init != "function") {
		EntityView.prototype.init = function() {
			var clazz=this;
			if(!this.$root){
				this.$root=$(this.selector);
			}
			if (!this.$table) {
				this.$table = this.$root.find("table["+this.Attr.tableView+"]");
			}
			if (!this.$formTable) {
				this.$formTable = this.$root.find("form[" + this.Attr.formTable + "]");
			}
			if (!this.$formEditor) {
				this.$formEditor = this.$root.find("form[" + this.Attr.formEditor + "]");
			}
			if (this.both) {
				this.toptions.paginationVAlign = 'both';
			}
			try {
				if(this.isModal){
					this.$root.on('hidden.bs.modal', function () {
						clazz.$formEditor.find("option").attr("selected",false);
						clazz.$formEditor.find("input[type='text'],input[type='hidden'],input[type='number'],textarea").val("");
						clazz.$formEditor.find("input[type='radio'],input[type='checkbox']").prop("checked",false);
						clazz.$formEditor.find("tr").removeClass("has-error");
						clazz.$root.find("["+clazz.Attr.labelData+"] [name]").text("");
					});
				}
				if(this.$formEditor){
					this.$root.find("#addOrUpdateModal").on('hidden.bs.modal', function () {
						clazz.$formEditor.find("option").attr("selected",false);
						clazz.$formEditor.find("input[type='text'],input[type='hidden'],input[type='number'],textarea").val("");
						clazz.$formEditor.find("input[type='radio'],input[type='checkbox']").prop("checked",false);
						clazz.$formEditor.find("["+clazz.Attr.labelData+"] [name]").each(function(index,item){
							$(this).html("");
						});
					});
				}
			} catch (formEditorHiddenBsModal) {
				console.log(this.clazzName + " call formEditorHiddenBsModal e:" + formEditorHiddenBsModal);
			}
			try {
				this.datepicker({});
			} catch (datepicker) {
				console.log(this.clazzName + " call datepicker e:" + datepicker);
			}
			// 生成表格
			try {
				if(!this.toptions.url){
					this.toptions.url=this.url;
				}
				if(this.toptions.data ){
					delete this.toptions.url;
				}
				this.table = this.bootstrapTable(this.$table, this.toptions,true);
				// 表格刷新
				try {
					this.$root.find("["+this.Attr.refreshTable+"]").click(function(){
						clazz.refreshTable(undefined, true);
					});
				} catch (refreshTable) {
					console.log(this.clazzName + " call refreshTable e:" + refreshTable);
				} 
			} catch (bt) {
				console.log(this.clazzName + " call bootstrapTable error:" + bt);
			}
			//数据编辑（如增加或修改）
			try{
				var $ajaxToEditor=this.$root.find("["+this.Attr.ajaxToEditor+"]");
				if($ajaxToEditor.length>0){
					$($ajaxToEditor[0]).click(function(){
						var ladda=undefined;
						try{
							if(Ladda){
								ladda = Ladda.create( this );
							}
						}catch(e){
							
						}
						if(ladda){
							ladda.start();
						}
						clazz.ajaxToEditor(clazz,{},clazz.formEditorCheckFn,ladda);
					});
				}
			}catch(ajaxToEditor){
				console.log(this.clazzName + " call ajaxToEditor error:" + ajaxToEditor);
			}
			// 数据导出
			try {
				this.exportTable(undefined, {
					$form : this.$formTable,
					$table : this.$table,
					url:this.exportUrl
				});
				this.exportTable(undefined, {
					$form : this.$formTable,
					$table : this.$table,
					url:this.exportAllUrl,
					all:true
				});
			} catch (exportTable) {
				console.log(this.clazzName + " call exportTable e:" + exportTable);
			}
			this.arrView[this.arrIndex || this.arrView.length] = this;
			return this;
		};
	}
	if (typeof this.setContainerData != "function") {
		EntityView.prototype.setContainerData = function($container,data,clear) {
			if(!$container){
				$container=this.$root.find("["+this.Attr.labelData+"]");
			}
			$container.find("[name]").each(function(){
				var $this=$(this);
				var tagName=$this[0].tagName;
				var name=undefined;
				var val="";
				if(clear){
					$("#addOrUpdateModal").find(".radio label").css("color","");
				}else{
					name=$this.attr("name");
					val=data[name];
					if(!val){
						if(val==0){
							
						}else{
							val="";
						}
					}
				}
				if(tagName=="INPUT" || tagName=="TEXTAREA" ){
					var type=$this.attr("type");
					switch (type) {
					case "radio":case "checkbox":
						if(clear){
							$this.attr("checked",false);
							$this.prop("checked",false);
							$this.parents("label").css("color","");
						}else if($this.val()==(val+"")){
							$this.attr("checked",true);
							$this.prop("checked",true);
							$this.parents("label").css("color","red");
						}
						break;
					default:
						$this.val(val);
						break;
					}
				}else if(tagName=="SELECT"){
					$this.find("option").attr("selected",false);
					$this.val(val);
				}else{
					$this.html(val);
				}
			});
		};
	}
	if (typeof this.ajaxToEditor != "function") {
		EntityView.prototype.ajaxToEditor = function(clazz,ajaxData,checkFn,ladda) {
			var clazz=clazz||this;
			var checkPass=true;
			if(!ajaxData.data){
				this.$formEditor.find("[name='fSi']").removeAttr("disabled");
				ajaxData.data=this.$formEditor.serializeObject(clazz.$formEditor.find("["+clazz.Attr.labelData+"]"),clazz.$formEditor.find("[label-label-data]"));
				if(!ajaxData.data){
					return this;
				}
			}
			if(checkFn){
				checkPass=checkFn(ajaxData.data);
			}
			console.log("ajaxToEditor param ---------------");
			console.log(ajaxData.data);
			if(checkPass){
				var ajax=$.extend({
	                type : "POST",
	                url : "editor",
	                data : undefined,
	                isStrData:true,
	                contentType:"text/html;charset=utf-8",
	                //contentType :ajax.contentType|| "application/json",
	                success : function(results) {
	                	try{
	                		results=eval('(' + results + ')');
	                	}catch(r){
	                		
	                	}
						if (results.error_code== 1211) {
							view.notify("warning", results.error.msg);
						} 
	                	if(results.error_code==0){
	                		/*
	                		try{
	                			if( results.data && results.data!=null && typeof results.data=="object"){
	                				if(results.data.constructor!=Array){
		                				results.data=[results.data];
		                			}
		                			$.each(results.data,function(index,item){
		                				if(item.index<0){
				                			clazz.table.bootstrapTable('insertRow',{index:0,row:item});
				                		}else{
				                			clazz.table.bootstrapTable('updateRow',{index:item.index,row:item});
				                		}
		                			});
	                			}
	                		}catch(opRow){
	                			console.log(clazz.clazzName + " call ajaxToEditor-->opRow e:" + opRow);
	                		}
	                		*/
	                		try{
	                			clazz.refreshTable('', false);
	                		}catch(refreshTable){
	                			console.log(clazz.clazzName + " call ajaxToEditor-->refreshTable e:" + refreshTable);
	                		}
	                		
	                   		try{
	                   			if(clazz.isModal){
	                   				clazz.$root.modal("hide");
	                   			}
	                		}catch(e){}
	                		try{
	                   			clazz.$root.find("#addOrUpdateModal").modal("hide");
	                		}catch(e){}
	                		try{
	                			view.refreshTable('', false);
	                		}catch(e){}
	                		
	                		if(typeof results.data=="string"){
	                			clazz.notify("success",results.data||"保存成功");
	                		}else{
	                			clazz.notify("success","保存成功");
	                		}
						}else{
							clazz.notify("danger",results.error.msg);
						}
	                },
	                statusCode : {
	                    404 : (function(){
	                    	clazz.notify("danger", "出错啦...请检查网络或联系管理员！");
	                    })
	                }
	            },ajaxData);
				if(ajax.data.url){
					ajax.url=ajax.data.url;
				}
				try{
					delete ajax.data.url;
				}catch(del){
					
				};
				try{
					delete ajax.data.index;
				}catch(del2){
					
				};
				if(ajax.isStrData){
					ajax.data=JSON.stringify(ajax.data);
				}
				$.ajax(ajax).always(function(){
					if(ladda){
						ladda.stop();
					}
				});
			}
			return this;
		};
	}
	if (typeof this.ajax != "function") {
		EntityView.prototype.ajax = function(ajaxData) {
			var clazz=this;
			var ajax=$.extend({
                type : "POST",
                url : undefined,
                data : {},
                isStrData:true,
                successMsg:"保存成功！",
                errorMsg:"保存失败！",
                contentType:"text/html;charset=utf-8",
                //contentType :ajax.contentType|| "application/json",
                success : function(results) {
                	try{
                		results=eval('(' + results + ')');
                	}catch(r){
                		
                	}
					if (results.error_code== 1211) {
						clazz.notify("warning", results.error.msg);
					}
					if(results.error_code==0){
						try{
                			clazz.refreshTable('', false);
                		}catch(refreshTable){
                			console.log(clazz.clazzName + " call ajaxToEditor-->refreshTable e:" + refreshTable);
                		}
                   		try{
                			clazz.$root.modal("hide");
                		}catch(e){}
                		try{
                			view.refreshTable('', false);
                		}catch(e){}
                		
                		clazz.notify("success",this.successMsg);
					}else{
						try{
							if(results.error){
								clazz.notify("danger",results.error.msg);
							}else{
								clazz.notify("danger",results.data||this.errorMsg);
							}
						}catch(e){
								clazz.notify("danger","操作失败啦，请重试或联系管理员吧！");
						}
					}
					try{
						if(typeof this.ajaxResultInit=="function"){
							this.ajaxResultInit(results);
						}
					}catch(ajaxResultInit){
						console.log("ajax call ajaxResultInit error :"+ajaxResultInit);
					}
					
                },
                statusCode : {
                    404 : (function(){
                    	clazz.notify("danger", "出错啦...请检查网络或联系管理员！");
                    })
                }
            },ajaxData);
			if(!ajax.url){
				return this;
			}
			if(ajax.isStrData){
				ajax.data=JSON.stringify(ajax.data);
			}
			$.ajax(ajax);
			return this;
		};
	}
	if (typeof this.bootstrapTable != "function") {
		EntityView.prototype.bootstrapTable = function($table, options,isStrData) {
			var clazz = this;
			return $table.bootstrapTable($.extend({
				dataField : "data",
				totalField : "total_records",
				method : "post",
				//contentType : "application/x-www-form-urlencoded",
				contentType:isStrData?"text/html;charset=utf-8":"application/json",
				//contentType : 'application/json',
				sidePagination : "server",
				pagination : true,
				pageList : [ 5, 10, 20, 50, 100, 200, 500 ],
				pageSize : 10,
				queryParamsType : 'page',
				columns : [],
				clickToSelect : true,
				queryParams : function(params) {
					var formParams = clazz.$formTable.serializeObject();
					$.extend(params, formParams);
					return isStrData?JSON.stringify(params):params;
				},
				onLoadSuccess:function(data){
					clazz.$table.find("[data-toggle='tooltip']").tooltip();
				}
			}, options));
		};
	}
	/**
	 * 时间选择 2015-12-16 lrg 
	 */
	if (typeof this.datepicker != "function") {
		EntityView.prototype.datepicker = function(data) {
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
							$next.val(16*60*60+intDateTime);//计算24小时秒数
						}else {
							$next.val(intDateTime-(8*60*60));//计算0时秒数
						}
					}else{
						$next.val("");
					}
				}
			});
		};
	}
	/**
	 * 查询 2015-12-16 lrg firstQuery为true时,将分页重置到第一页
	 */
	if (typeof this.refreshTable != "function") {
		EntityView.prototype.refreshTable = function( $table, firstQuery) {
			// 刷新表
			if (firstQuery) {
				($table || this.$table).bootstrapTable('refresh',{url:this.url});
			} else {
				($table || this.$table).bootstrapTable('refresh');
			}
			return this;
		};
	}
	/**
	 * 数据导出 2015-12-16 lrg
	 */
	if (typeof this.exportTable != "function") {
		EntityView.prototype.exportTable = function($click, dataParam) {
			var clazz = this;
			// 导出前准备工作
			var data = {
				url : 'export',
				all : false,
				primaryKey : "id",
				paramField : "columnValueList",
				$form : null,
				$table : null
			};
			// 获取参数
			$.extend(data, dataParam);
			($click || this.$root.find("[" + (data.all ? this.Attr.exportTableAll : this.Attr.exportTable) + "]")).click(function() {
				if (data.all) {
					if (data.$form == null) {
						clazz.notify("danger", "出错啦...（缺少表单对象数据）");
						return false;
					}
				} else {
					if (data.$table == null) {
						clazz.notify("danger", "出错啦...（缺少表格对象数据）");
						return false;
					}
				}
				// 开始导出-----------------------------------------------------
				var $exportForm = data.$form;
				if (data.all) {// 根据查询条件导出全部
					$exportForm.attr({
						"action" : data.url,
						"method" : "post"
					}).submit();
					$exportForm.attr({
						"action" : ""
					});
				} else {// 选择列导出
					$exportForm = $("<form></form>");
					$exportForm.attr({
						"style" : "display:none",
						"action" : data.url,
						"method" : "post",
					});
					var selected = data.$table.bootstrapTable("getSelections");
					if (selected.length == 0) {
						clazz.notify("warning", "至少选择一行数据");
						return;
					} else {
						var primaryKeyValue = -1;
						for (var i = 0; i < selected.length; i++) {
							primaryKeyValue = (selected[i][data.primaryKey]) || -1;
							var $idCheckbox = $("<input type='checkbox'checked='true' name='" + data.paramField + "' value='" + primaryKeyValue + "'/>");
							$idCheckbox.appendTo($exportForm);
						}
						$exportForm.submit();
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
		EntityView.prototype.notify = function(typeStr, message, options) {
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
};