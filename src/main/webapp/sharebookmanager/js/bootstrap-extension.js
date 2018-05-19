var common={
		columns:{
			serialNumber:{
				field : "serialNumber",
				title : "序号",
				align : "center",
				formatter : function(value, row, index) {
					row.index=index;
					return index + 1;
				}
			},
			statusHtml:{
				align : "center",
		        field: 'status',
		        title: '状态',
				formatter : function(value, row, index) {
					var arr=[{
						clazz:"label label-danger",
						text:"禁用"
					},{
						clazz:"label label-success",
						text:"启用"
					},{
						clazz:"label label-warning",
						text:"占用"
					}];
					return "<span class='"+arr[value].clazz+"'>"+arr[value].text+"</span>";
				}
			}
		}
};
//(function(){
	/**
	 * @class RowsInsert
	 * @name 增加
	 * @create 奕訢.lrg.2016-06
	 */
	function RowsInsert(_o){
		this.parent=undefined,
		this.className="insert",
		this.url="insert",
		this.s_root=".obj-i",
		this.s_row="form",
		this.$root=undefined,
		this.$table=undefined,
		this.$forms=undefined,
		this.$form0=undefined,
		this.maxLength=5,
		this.getFormDataOptions=undefined,
		this.length=0;
		
		$.extend(this,_o);
		
		if(typeof this.init!="function"){
			RowsInsert.prototype.init=function(){
				if(!this.$root){
					this.$root=this.parent.$root.find(this.s_root);
				}
				if(!this.$table){
					this.$table=this.parent.q.$table;
				}
				if(!this.$forms){
					this.$forms=this.$root.find(this.s_row);
				}
				return this;
			};
		}
		if(typeof this.open!="function"){
			RowsInsert.prototype.open=function(_o){
				var o=$.extend({rows:""},_o);
				this.$form0=$(this.$forms[0]);
				if(!o.rows){
					o.rows=this.$table.bootstrapTable("getSelections");
				}
				if(o.rows){
					this.length=o.rows.length;
				}
				if(this.length==0){
					this.length=1;
				}
				if(this.maxLength<this.length){
					this.maxLength=this.length;
				}
				if(this.length>0){
					this.$form0[0].setFormData(o.rows[0]);
					this.$form0[0].row=o.rows[0];
					var $form0=this.$form0;
					$.each(o.rows,function(i,row){
						if(i>0){
							//利用复制方法
							var $copy=$form0.clone();
							$copy[0].setFormData(row);//清空数据
							$copy[0].row=row;
							//复制元素
							$form0.after($copy);
							$form0=$copy;
						}
					});
				}else{
					this.$from0[0].setFormData();
					this.$from0[0].row=undefined;
				}
				if(this.parent){
					this.parent.toggleAction({i:true});
				}else{
					this.$root.show();
				}
				return this;
			};
		}
		if(typeof this.close!="function"){
			RowsInsert.prototype.close=function(_o){
				this.length=0;
				this.$root.find(this.s_row).each(function(i,elRow){
					var $row=$(elRow);
					if(i==0){
						$row[0].setFormData();
					}else{
						$row.remove();
					}
				});
				if(this.parent){
					this.parent.toggleAction({q:true});
				}else{
					this.$root.show();
				}
				return this;
			};
		}
		if(typeof this.add!="function"){
			RowsInsert.prototype.add=function(el,_o){
				var $el=$(el);
				if(this.maxLength==this.length){
					var content="最多可同时编辑"+maxLen+"条数据。";
					fns.alert({content:content},true);
				}else{
					var $row=$(el).parents(this.s_row);
					var $copy=$row.clone();
					$copy[0].setFormData();//清空数据
					$copy[0].row=undefined;
					//复制元素
					$row.after($copy);
					
					this.length++;
				}
				return this;
			};
		}
		if(typeof this.copy!="function"){
			RowsInsert.prototype.copy=function(el,_o){
				var $el=$(el);
				if(this.maxLength==this.length){
					var content="最多可同时编辑"+this.maxLength+"条数据。";
					fns.alert({content:content},true);
				}else{
					var $row=$(el).parents(this.s_row);
					var $copy=$row.clone();
					//复制元素
					$row.after($copy);
					
					this.length++;
				}
				return this;
			};
		}
		if(typeof this.remove!="function"){
			RowsInsert.prototype.remove=function(el,_o){
				if(this.length==1){
					this.close();
				}else{
					$(el).parents(this.s_row).remove();
					this.length--;
				}
				return this;
			};
		}
		if(typeof this.submit!="function"){
			RowsInsert.prototype.submit=function(el){
				var clazz=this;
				var $form=$(el);
				el.getFormData(undefined,
					function(el,data){
						fns.confirm({
						    title: '增加',
						    content: '确认要增加数据吗？',
						    confirm: function(){
						    	fns.ajax({
						    		url:clazz.url,
						    		contentType:'text',
						    		data:data,
						    		laddaEls:[$(el).find("[type='submit']")[0]],
						    		success0:function(data){
										clazz.$table.btable(true);
										if(clazz.length==1){
											clazz.close();
										}else{
											clazz.length--;
											$form.remove();
										}
									}
						    	},true);
						    }
						},true);
					},clazz.getFormDataOptions
				);
				return this;
			};
		}
	}
	/**
	 * @class RowsUpdate
	 * @name 更新
	 * @create 奕訢.lrg.2016-06
	 */
	function RowsUpdate(_o){
		this.parent=undefined,
		this.className="update",
		this.url="update",
		this.s_root=".obj-u",
		this.s_row="form",
		this.$root=undefined,
		this.$table=undefined,
		this.$forms=undefined,
		this.$form0=undefined,
		this.rows=undefined,
		this.maxLength=5,
		this.length=0,
		this.getFormDataOptions=undefined,
		this.selectedErrorMsg="请选择状态为【启用】的数据啦！";
		$.extend(this,_o);
		
		if(typeof this.init!="function"){
			RowsUpdate.prototype.init=function(){
				if(!this.$root){
					this.$root=this.parent.$root.find(this.s_root);
				}
				if(!this.$table){
					this.$table=this.parent.q.$table;
				}
				if(!this.$forms){
					this.$forms=this.$root.find(this.s_row);
				}
				return this;
			};
		}
		if(typeof this.open!="function"){
			RowsUpdate.prototype.open=function(rows){
				this.$form0=$(this.$forms[0]);
				this.rows=rows;
				if(!this.rows){
					this.rows=this.$table.bootstrapTable("getSelections");
				}
				this.filterRows();//过滤数据
				if(this.rows){
					this.length=this.rows.length;
				}
				if(this.length==0){
					fns.alert({content:this.selectedErrorMsg},true);
					return this;
				}
				if(this.maxLength<this.length){
					this.maxLength=this.length;
				}
				if(this.length>0){
					this.$form0[0].setFormData(this.rows[0]);
					this.$form0[0].row=this.rows[0];
					var $form0=this.$form0;
					$.each(this.rows,function(i,row){
						if(i>0){
							//利用复制方法
							var $copy=$form0.clone();
							$copy[0].setFormData(row);//清空数据
							$copy[0].row=row;
							//复制元素
							$form0.after($copy);
							$form0=$copy;
						}
					});
				}else{
					this.$form0[0].setFormData();
					this.$form0[0].row=undefined;
				}
				if(this.parent){
					this.parent.toggleAction({u:true});
				}else{
					this.$root.show();
				}
				return this;
			};
		}
		if(typeof this.filterRows!="function"){
			RowsUpdate.prototype.filterRows=function(){
				var rows=[];
				$.each(this.rows,function(i,row){
					if(row.status){
						if(row.status==1){
							rows.push(row);
						}
					}
				});
				this.rows=rows;
				return this;
			};
		}
		if(typeof this.close!="function"){
			RowsUpdate.prototype.close=function(_o){
				this.$root.find(this.s_row).each(function(i,elRow){
					var $row=$(elRow);
					if(i==0){
						$row[0].setFormData();
					}else{
						$row.remove();
					}
				});
				if(this.parent){
					this.parent.toggleAction({q:true});
				}else{
					this.$root.show();
				}
				return this;
			};
		}
		if(typeof this.reset!="function"){
			RowsUpdate.prototype.reset=function(el,_o){
				var $el=$(el);
				var form=$(el).parents(this.s_row)[0];
				form.setFormData(form.row);
				return this;
			};
		}
		if(typeof this.remove!="function"){
			RowsUpdate.prototype.remove=function(el,_o){
				if(this.length==1){
					this.close();
				}else{
					$(el).parents(this.s_row).remove();
					this.length--;
				}
				return this;
			};
		}
		if(typeof this.submit!="function"){
			RowsUpdate.prototype.submit=function(el,_o){
				var clazz=this;
				var $form=$(el);
				el.getFormData(undefined,
					function(el,data){
						fns.confirm({
						    title: '更新',
						    content: '确认要更新数据吗？',
						    confirm: function(){
						    	fns.ajax({
						    		url:clazz.url,
						    		contentType:'text',
						    		data:data,
						    		laddaEls:[$(el).find("[type='submit']")[0]],
						    		success0:function(data){
										clazz.$table.btable(false);
										if(clazz.length==1){
											clazz.close();
										}else{
											clazz.length--;
											$form.remove();
										}
									}
						    	},true);
						    }
						},true);
					},clazz.getFormDataOptions
				);
				return this;
			};
		}
	}
	/**
	 * @class RowsDelete
	 * @name 删除
	 * @create 奕訢.lrg.2016-06
	 */
	function RowsDelete(_o){
		this.parent=undefined,
		this.className="Delete",
		this.url="del",
		this.$table=undefined,
		this.pksField="ids",
		this.pk="id",
		this.fields=[],
		this.status=[0,1],
		this.confirm=true,
		this.selectedErrorMsg="请选择可以删除的数据（禁用或启用的数据才可以此操作）！",
		this.rows=undefined;
		
		$.extend(this,_o);
		
		if(typeof this.init!="function"){
			RowsDelete.prototype.init=function(){
				if(!this.$table){
					this.$table=this.parent.q.$table;
				}
				return this;
			};
		}
		if(typeof this.filterRows!="function"){
			RowsDelete.prototype.filterRows=function(){
				var clazz=this;
				var result=[];
				$.each(this.rows,function(i,row){
					$.each(clazz.status,function(i,statu){
						if(row.status==statu){
							result.push(row);
							return false;
						}
					});
				});
				this.rows=result;
				return this;
			};
		}
		if(typeof this.getData!="function"){
			RowsDelete.prototype.getData=function(){
				var result={},ids=[];
				var pk=this.pk;
				$.each(this.rows,function(i,row){
					ids.push(row[pk]);
				});
				result[this.pksField]=ids;
				var row=this.rows[0];
				$.each(this.fields,function(i,field){
					var value=row[field];
					if(value!=undefined){
						result[field]=value;
					}
				});
				return result;
			};
		}
		if(typeof this.submit!="function"){
			RowsDelete.prototype.submit=function(el,data){
				var clazz=this;
				if(data){
					this.rows=data;
				}else{
					this.rows=this.$table.bootstrapTable("getSelections");
				}
				this.filterRows();
				if(this.rows.length>0){
					if(this.confirm){
						fns.confirm({
						    title: "<span style='color:red;'>刪除</span>",
						    content: "确认要删除选中的<span style='color:red;font-size:150%;'>"+clazz.rows.length+"</span>条数据吗？删除后不可恢复。",
						    confirm: function(){
						    	clazz.ajax(el,clazz.getData());
						    }
						},true);
					}else{
						this.ajax(el,this.getData());
					}
				}else{
					fns.alert({
					    content: clazz.selectedErrorMsg
					},true);
				}
				return this;
			};
		}
		if(typeof this.ajax!="function"){
			RowsDelete.prototype.ajax=function(el,data){
				var clazz=this;
				fns.ajax({
					url:this.url,
					data:data,
					laddaEls:[el],
					contentType:"text",
					success0:function(data){
						clazz.$table.btable(false);
					}
				},true);
				return this;
			};
		}
	}
	/**
	 * @class RowsQuery
	 * @name 查询
	 * @create 奕訢.lrg.2016-06
	 */
	function RowsQuery(_o){
		this.parent=undefined,
		this.className="query",
		this.url="listData",
		this.s_root=".obj-q",
		this.s_form="form",
		this.$root=undefined,
		this.$table=undefined,
		this.$form=undefined,
		this.tos=undefined;
		
		$.extend(this,_o);
		
		if(typeof this.init!="function"){
			RowsQuery.prototype.init=function(){
				if(!this.$root){
					this.$root=this.parent.$root.find(this.s_root);
				}
				if(!this.$form){
					this.$form=this.$root.find(this.s_form);
				}
				if(!this.$table){
					this.$table=this.$root.find("table:eq(0)");
				}
				if(this.tos){
					if(!this.tos.url){
						this.tos.url=this.url;
					}
					this.$table.btable(this.tos);
				}
				return this;
			};
		}
		if(typeof this.query!="function"){
			RowsQuery.prototype.query=function(el,isOne){
				this.$table.btable(isOne);
				return this;
			};
		}
		
	}
	/**
	 * @class RowsEnableDisable
	 * @name Enable启用 Disable禁用
	 * @create 奕訢.lrg.2016-06
	 * @s 选择器
	 * @e enable
	 * @d disable
	 */
	function RowsEnableDisable(_o){
		this.parent=undefined,//ObjView
		this.className="EnableDisable",
		this.url="update",
		this.s_root=".obj-ed",
		this.s_enable=".ed-enable",
		this.s_disable=".ed-disable",
		this.$root=undefined,
		this.$disable=undefined,
		this.$enable=undefined,
		this.$table=undefined,
		this.$td=undefined,// disable table $
		this.$te=undefined,// enable table $
		this.etos=undefined,// enable table options
		this.dtos=undefined,// disable table options
		this.eRows=[],// enable rows
		this.dRows=[],// disable rows
		this.eLength=0,// enable rows length
		this.dLength=0,// disable rows length
		this.eValue=1,// enable value
		this.dValue=0,// disable value
		this.edField="status",// enable、disable field
		this.pk="id",
		this.confirm=true,
		this.selectedErrorMsg="请选择状态为【禁用】或【启用】的数据哦！";
		
		$.extend(this,_o);
		
		if(typeof this.init!="function"){
			RowsEnableDisable.prototype.init=function(_o){
				if(!this.$root){
					this.$root=this.parent.$root.find(this.s_root);
				}
				if(!this.$table){
					this.$table=this.parent.q.$table;
				}
				if(!this.$enable){
					this.$enable=this.$root.find(this.s_enable);
				}
				if(!this.$disable){
					this.$disable=this.$root.find(this.s_disable);
				}
				if(!this.$te){
					this.$te=this.$enable.find("table");
				}
				if(!this.$td){
					this.$td=this.$disable.find("table");
				}
				if(this.etos){
					this.$te.btable(this.etos);
				}
				if(this.dtos){
					this.$td.btable(this.dtos);
				}
				return this;
			};
		}
		if(typeof this.open !="function"){
			RowsEnableDisable.prototype.open =function(rows){
				var clazz=this;
				this.rows=rows;
				if(!this.rows){
					this.rows=this.$table.bootstrapTable("getSelections");
				}
				this.filterRows();
				if((this.eLength+this.dLength)<=0){
					fns.alert({content:clazz.selectedErrorMsg},true);
				}else{
					this.parent.toggleAction({ed:true});
					this.show();
				}
				return this;
			};
		}
		if(typeof this.filterRows!="function"){
			RowsEnableDisable.prototype.filterRows=function(){
				var eRows=[],dRows=[];
				var clazz=this;
				$.each(this.rows,function(i,row){
					var value=row[clazz.edField];
					if(value!=undefined){
						if(value==clazz.eValue){
							eRows.push(row);
						}else if(value==clazz.dValue){
							dRows.push(row);
						}
					}
				});
				this.eRows=eRows;
				this.dRows=dRows;
				this.eLength=eRows.length;
				this.dLength=dRows.length;
				return this;
			};
		}
		if(typeof this.close!="function"){
			RowsEnableDisable.prototype.close=function(_o){
				this.eRows=[];
				this.dRows=[];
				this.eLength=0;
				this.dLength=0;
				this.show();
				return this;
			};
		}
		if(typeof this.show!="function"){
			RowsEnableDisable.prototype.show=function(_o){
				if((this.eLength+this.dLength)<=0){
					this.parent.toggleAction({q:true});
				}
				this.$te.bootstrapTable("load",{data:this.eRows,total_records:this.eLength});
				this.$td.bootstrapTable("load",{data:this.dRows,total_records:this.dLength});
				if(this.eLength>0){
					this.$enable.show();
				}else{
					this.$enable.hide();
				}
				if(this.dLength>0){
					this.$disable.show();
				}else{
					this.$disable.hide();
				}
				return this;
			};
		}
		if(typeof this.submit!="function"){
			RowsEnableDisable.prototype.submit=function(el,logo){
				var clazz=this;
				if(this.confirm){
					fns.confirm({content:"确认要提交操作吗？",confirm:function(){
						clazz.ajax(el,logo);
					}},true);
				}else{
					clazz.ajax(el,logo);
				}
				return this;
			};
		}
		if(typeof this.ajax!="function"){
			RowsEnableDisable.prototype.ajax=function(el,logo){
				var clazz=this;
				var data=[],action="";
				if(logo==undefined){
					logo="";
				}
				if(logo=="e"){
					data=this.getToEnableData();
					action="启用";
				}else if(logo=="d"){
					data=this.getToDisableData();
					action="禁用";
				}else{
					data=this.getToEnableData();
					$.each(this.getToDisableData(),function(i,row){
						data.push(row);
					});
					action="禁用/启用"
				}
				fns.ajax({
					url:clazz.url,
					data:data,
					contentType:"text",
					success0:function(data){
						if(logo=="e"){
							clazz.dRows=[];
							clazz.dLength=0;
						}else if(logo=="d"){
							clazz.eRows=[];
							clazz.eLength=0;
						}else{
							clazz.eRows=[];
							clazz.eLength=0;
							clazz.dRows=[];
							clazz.dLength=0;
						}
						clazz.$table.btable(false);
						clazz.show();
					}
				},true);
				return this;
			};
		}
		if(typeof this.getToEnableData!="function"){
			RowsEnableDisable.prototype.getToEnableData=function(){
				var clazz=this;
				var result=[];
				$.each(this.dRows,function(i,row){
					var obj={};
					obj[clazz.pk]=row[clazz.pk];
					obj[clazz.edField]=clazz.eValue;
					result.push(obj);
				});
				return result;
			};
		}
		if(typeof this.getToDisableData!="function"){
			RowsEnableDisable.prototype.getToDisableData=function(){
				var clazz=this;
				var result=[];
				$.each(this.eRows,function(i,row){
					var obj={};
					obj[clazz.pk]=row[clazz.pk];
					obj[clazz.edField]=clazz.dValue;
					result.push(obj);
				});
				return result;
			};
		}
	}
	/**
	 * @class RowsExport
	 * @name 导出
	 */
	function RowsExport(_o){
		this.parent=undefined,
		this.className="export",
		this.url="export",
		this.$table=undefined,
		this.$form=undefined,
		this.pk="id",
		this.pksField="ids";
		
		$.extend(this,_o);
		
		if(typeof this.init!="function"){
			RowsExport.prototype.init=function(){
				if(!this.$table){
					this.$table=this.parent.q.$table;
				}
				if(!this.$form){
					this.$form=this.parent.q.$form;
				}
				return this;
			};
		}
		if(typeof this.submit!="function"){
			RowsExport.prototype.submit=function(el,isAll){
				var $el=$(el);
				$el.prop("disabled",true);
				if(isAll){
					this.submitByForm($el);
				}else{
					this.submitByRows($el);
				}
				return this;
			};
		}
		if(typeof this.submitByRows!="function"){
			RowsExport.prototype.submitByRows=function($el){
				var clazz=this;
				var selected = this.$table.bootstrapTable("getSelections");
				
				var len=0;
				if(selected){
					len=selected.length;
				}
				if(len>0){
					setTimeout(function(){
						$el.removeAttr("disabled","");
					},5000);
					var $form = $("<form></form>");
					$form.attr({
						"style" : "display:none",
						"action" : clazz.url,
						"method" : "post",
					});
					var idValue=-1;
					$.each(selected,function(i,row){
						idValue=row[clazz.pk];
						var $idCheckbox = $("<input type='checkbox' checked='true' name='" + clazz.pksField + "' value='" + idValue + "'/>");
						$idCheckbox.appendTo($form);
					});
					$form.submit();
					$form.remove();
				}else{
					$el.removeAttr("disabled","");
					fns.alert({content:tipsInfo.atLeastSelectOneRow},true);
				}
				return this;
			};
		}
		if(typeof this.submitByForm!="function"){
			RowsExport.prototype.submitByForm=function($el){
				setTimeout(function(){
					$el.removeAttr("disabled","");
				},5000);
				var clazz=this;
				if (this.$form == null) {
					fns.alert({content:"出错啦...（缺少表单对象数据）"},true);
					return this;
				}
				this.$form.attr({
					"action" : clazz.url,
					"method" : "post"
				}).submit();
				this.$form.attr({
					"action" : ""
				});
				return this;
			};
		}
		
	}
	/**
	 * @class RowsImport
	 * @name 导入
	 */
	function RowsImport(_o){
		this.parent=undefined,
		
		$.extend(this,_o);
	}
	/**
	 * @class RowsPrint
	 * @name 打印
	 */
	function RowsPrint(_o){
		this.parent=undefined,
		
		$.extend(this,_o);
	}
	/**
	 * @class ObjView
	 * @name 实体视图
	 * @create 奕訢.lrg.2016-06
	 * @i class:RowsInsert（增加）
	 * @d class:RowsDelete（删除）
	 * @u class:RowsUpdate（更新）
	 * @q class:RowsQuery（查询）
	 * @ed class:RowsEnableDisable（启用、禁用）
	 * @ex class:RowsExport（导出）
	 * @im class:RowsImport（导入）
	 * @print class:RowsPrint（打印）
	 */
	function ObjView(_o){
		this.className="obj",
		this.s_root="body>.panel:eq(0)",
		this.s_action=">.panel-body"
		this.$root=undefined,
		this.$action=undefined,
		this.has={
			i:false,//新增
			d:false,//删除
			u:false,//更新
			q:true,//查询
			ed:false,//启用/禁用
			ex:false,//导出
			im:false,//导入
			print:false//打印
		},
		this.i=undefined,
		this.u=undefined,
		this.d=undefined,
		this.q=undefined,
		this.ed=undefined,
		this.ex=undefined,
		this.im=undefined,
		this.print=undefined;
		
		$.extend(this,_o);
		
		if(typeof this.init!="function"){
			ObjView.prototype.init=function(_o){
				if(!this.$root){
					this.$root=$(this.s_root);
				}
				if(!this.$action){
					this.$action=this.$root.find(this.s_action);
				}
				if(!this.$table){
					this.$table=this.$root.find("."+this.className+"-table");
				}
				if(this.q){
					this.has.q=true;
					this.q.parent=this;
					this.q=new RowsQuery(this.q).init();
				}
				if(this.i){
					this.has.i=true;
					this.i.parent=this;
					this.i=new RowsInsert(this.i).init();
				}
				if(this.d){
					this.has.d=true;
					this.d.parent=this;
					this.d=new RowsDelete(this.d).init();
				}
				if(this.u){
					this.has.u=true;
					this.u.parent=this;
					this.u=new RowsUpdate(this.u).init();
				}
				if(this.ed){
					this.has.ed=true;
					this.ed.parent=this;
					this.ed=new RowsEnableDisable(this.ed).init();
				}
				if(this.ex){
					this.has.ex=true;
					this.ex.parent=this;
					this.ex=new RowsExport(this.ex).init();
				}
				if(this.im){
					this.has.im=true;
					this.im.parent=this;
					this.im=new RowsImport(this.im).init();
				}
				if(this.print){
					this.has.print=true;
					this.print.parent=this;
					this.print=new RowsPrint(this.print).init();
				}
				return this;
			};
		}
		if(typeof this.toggleAction!="function"){
			ObjView.prototype.toggleAction=function(_show){
				var show=$.extend({
					//i:false
					//... 可用默认值为false，故不必再写相关代码
				},_show);
				this.$action.hide();
				for(var a in show){
					if(show[a]){
						var action=this[a];
						if(action){
							action.$root.show();
						}
					}
				}
				return this;
			};
		}
	}
//})()