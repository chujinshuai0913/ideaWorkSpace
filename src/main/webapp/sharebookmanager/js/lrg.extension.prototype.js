var tipsInfo =tipsInfo|| {
	atLeastSelectOneRow:"此操作至少要选择一行数据哦！<br/>请先去选择数据吧...我等您哦！",
	dataFillError:"太心急啦！<br/>红色代表数据填写有误哦！<br/>请填写完整（正确）试试吧...",
	ajaxDanger:"出错啦...请检查网络或联系管理员！",
	maxItemLen:"已达到最多可同时编辑的数量啦！<br/>最多编辑条数：",
	selectEnableDisable:"请选择您想要禁用或启用的数据啦！"
};

/**
 * 获取字符串的值
 * @param param
 * @returns {String}
 */
String.prototype.val = function(param) {
	var result="";
	var obj=param||{
		maxLen:-1,
		maxIntLen:-1,
		pattern:undefined,
		number:false,
		excl:undefined
	}
	var strMatchReg="";
	if(obj.pattern){
		strMatchReg=obj.pattern+"";
		if(strMatchReg.indexOf("^")==1){
			strMatchReg=strMatchReg.replace("^",'');
		}
		if(strMatchReg.indexOf("$")>0){
			strMatchReg=strMatchReg.replace("$",'');
		}
		//strMatchReg=strMatchReg.replace(new RegExp(/\\/g),'\\\\');
	}
	if(this.length>0){
		if(strMatchReg){//to get valid data
			try{
				result=this.trim().match( eval("/"+strMatchReg+"/g") )+"";
				if(result==null || result=="null"){
					result="";
				}else{
					result=result.replace(new RegExp(/(,)/g),'');
				}
			}catch(matchOrReplace){
				console.log("js fn val get match or replace  error:"+matchOrReplace);
			}
		}else{
			result=this.trim();
		}
		if(result && result!=null && obj.excl){//to excluded data
			try{
				result=result.replace(new RegExp( eval("/("+obj.excl+")/g") ),'');
			}catch(excl){
				console.log("js fn val to excl  error:"+excl);
			}
		}
	}
	//to substring length
	if(obj.maxIntLen && obj.maxIntLen>0 && result.length >1){
		if(result.indexOf(".")>-1){
			var resultArr=result.split("", 2);
			var intVal=resultArr[0];
			if(intVal.length>obj.maxIntLen){
				result=intVal.substring(0,obj.maxIntLen)+"."+(resultArr[1]||"");
			}
		}else{
			result=result.substring(0,obj.maxIntLen);
		}
	}
	if(obj.maxLen && obj.maxLen>0 && result.length > obj.maxLen){
		result=result.substring(0,obj.maxLen);
	}
	return result;
};
HTMLElement.prototype.getFormData=function(_result,fnSubmit,_o){
	var result=_result||{};
	var o={
		hasd:true
	};
	for(var p in _o){
		if(typeof o[p] != undefined){
			o[p]=_o[p];
		}
	}
	for(i=0;i<this.length;i++){
		var el=this[i];
		if(!o.hasd){
			if(el.disabled){
				continue;
			}
		}
		if(el.name){
			var value='';
			if(el.value){
				value=Number(el.value);
			}else{
				try{
					if(el.value==0){
						value=el.value;
					}
				}catch(e){console.log("if(el.value==0){ error");}
			}
			if(value || value==0){
				
			}else{
				value=el.value.trim();
			}
			if(value===""){
				try{
					el.value="";
				}catch(e){
					
				}
				continue;
			}
			switch(el.tagName){
			case "SELECT":
				if(value||value==0){
					result[el.name]=value;
				}
				break;
			case "INPUT":
				switch(el.type){
				case "radio":
					if(el.checked){
						result[el.name]=value;
					}
					break;
				case "checkbox":
					if(el.checked){
						if(result[el.name]){
							result[el.name].push(value);
						}else{
							result[el.name]=[];
							result[el.name].push(value);
						}
					}
					break;
				default:
					result[el.name]=value;
					break;
				}
				break;
			}
		}
	}
	if(fnSubmit){
		fnSubmit(this,result);
	}
	return result;
};
HTMLElement.prototype.setFormData=function(data){
	var data=data||{};
	for(i=0;i<this.length;i++){
		var el=this[i];
		if(el.name){
			var dataValue=data[el.name];
			if(dataValue==undefined || dataValue==null){
				dataValue="";
			}
			switch(el.tagName){
			case "SELECT":
				el.value=dataValue;
				break;
			case "INPUT":
				switch(el.type){
				case "radio":
					if(el.value==(dataValue+"")){
						el.checked=true;
					}else{
						el.checked=false;
					}
					break;
				case "checkbox":
					if(dataValue){
						var checked=false;
						for(var j=0;j<dataValue.length;j++){
							if((dataValue[j]+"")==el.value){
								checked=true;
								break;
							}
						}
						el.checked=checked;
					}else{
						el.checked=false;
					}
					break;
				default:
					el.value=dataValue;
					break;
				}
				break;
			}
		}
	}
	return this;
};
HTMLElement.prototype.ladda=function(bool){
	if(!this.laddaObj){
		if(Ladda){
			this.laddaObj=Ladda.create(this);
		}
	}
	if(this.laddaObj){
		if(bool){
			this.laddaObj.start();
		}else{
			this.laddaObj.stop();
		}
	}
	return this;
};
var fns={
	copyObj:function(source,destination) {
		var getType=function(o){
	        var _t;
	        return ((_t = typeof(o)) == "object" ? o==null && "null" || Object.prototype.toString.call(o).slice(8,-1):_t).toLowerCase();
	    };
	    if(!destination){
	    	var type=getType(source);
	    	 if(type=="array"){
	    		 destination=[];
	         }else if(type=="object"){
	        	 destination={};
	         }else{
	        	 return;
	         }
		}
	    for(var p in source)
	    {
	        if(getType(source[p])=="array"||getType(source[p])=="object")
	        {
	            destination[p]=getType(source[p])=="array"?[]:{};
	            arguments.callee(source[p],destination[p]);
	        }
	        else
	        {
	            destination[p]=source[p];
	        }
	    }
	    return destination;
	    //测试
	    /* var test={a:"ss",b:"dd",c:{d:"css",e:"cdd",c:{id:'id1'}}};
	    var test1=copyObjOrArr(test);
	    test1.c.d="change"; //改变test1的c属性对象的d属性
	    test1.c.c.id="change";
	    alert(test.c.c.id);  //不影响test
	    alert(test1.c.c.id);  */
	},
	alert:function(_o,is){
		var options= $.extend({
			title: '温馨提示',confirmButton: '确认',confirmButtonClass: 'btn-primary'
		},_o);
		if(is){
			$.alert(options);
		}
		return options;
	},
	confirm:function(_o,is){
		var options= $.extend({
			title: '温馨提示',
		    confirmButton: '确认',
		    cancelButton: '取消',
		    confirmButtonClass: 'btn-primary',
		    cancelButtonClass: 'btn-danger'
		},_o);
		if(is){
			$.confirm(options);
		}
		return options;
	},
	ajax:function(_ajax,is,_always){
		var options={
	            type : "POST",
	            error:function(XMLHttpRequest, textStatus, errorThrown){
	            	if(this.laddaEls){
	            		$.each(this.laddaEls,function(i,el){
	            			el.ladda(false);
	            		});
	            	}
	            	var msg="<span class='label label-danger'>"+textStatus+"</span><br/>"+tipsInfo.ajaxDanger;
	        		fns.notify("d",msg);
	            },
	            statusCode : {
	                404 : (function(){
	                	fns.notify("d","Error:404,"+tipsInfo.ajaxDanger);
	                }),
	                415 : (function(){
	                	fns.notify("d","Error:415,"+tipsInfo.ajaxDanger);
	                }),
	                500 : (function(){
	                	fns.notify("d","Error:500,"+tipsInfo.ajaxDanger);
	                }),
	                515 : (function(){
	                	fns.notify("d","Error:515,"+tipsInfo.ajaxDanger);
	                })
	            }
	        };
		if(_ajax){
			$.extend(options,_ajax);
		}
		if(options.contentType && options.contentType.indexOf("text")>=0){
			options.contentType = "text/html;charset=utf-8";
			if(typeof options.data!="string"){
				options.data= JSON.stringify(options.data);
			}
		}
		var fnAs=options.success;
		options.success=function(result){
			var type=typeof result;
	    	if(type=="string"){
	    		try{
	    			result=eval('(' + result + ')');
	        	}catch(r){
	        		console.log("$.elAjax success eval Error:"+r);
	        	}
	    	}
	    	if(typeof fnAs=="function"){
	    		fnAs(result);
	    	}else{
	    		if(typeof result=="string"){
	    			fns.notify("i",result);
	    		}else{
		    		var n_type="",msg="";
	    			if(result.error_code==0){
	    				if(typeof this.success0=="function"){
	    					this.success0(result.data);
	    				}
	    				n_type="s";
	    				if(typeof result.data=="string"){
	    					msg="<span class='label label-success pull-left'>成功</span><br/>"+result.data;
	    				}else{
	    					msg="<span class='label label-success pull-left'>成功</span>";
	    				}
	    			}else{
	    				n_type="w";
	    				if(result.error){
	    					if(result.error.msg){
	    						msg="<span class='label label-warning pull-left'>失败</span><br/>"+result.error.msg;
	    					}
	    				}else{
	    					msg="<span class='label label-warning pull-left'>失败</span>";
	    				}
	    			}
	    			fns.notify(n_type,msg);
	    		}
	    	}
	    	if(this.laddaEls){
        		$.each(this.laddaEls,function(i,el){
        			el.ladda(false);
        		});
        	}
		};
		if(is){
			if(options.laddaEls){
        		$.each(options.laddaEls,function(i,el){
        			el.ladda(true);
        		});
        	}
			$.ajax(options).always(function(){
				if(_always){
					_always();
				}
			});
		}
		return options;
	}
};

$.fn.btableDelete=function(el,_o){
	var $t=this;
	var selected = $t.bootstrapTable("getSelections");
	var options=$.extend({
		url:"del",
		pksField:"ids",
		pk:"id",
		fields:[],
		status:[0,1],
		selectedErrorMsg:"请选择可以删除的数据（禁用或启用的数据才可以此操作）！",
		submit:function(el,$t,obj){
			$(el).elAjax({
				url:"del",
				data:data,
				success:function(result){
					if(result.error_code==0){
						fns.alert({content:result.data},true);
						$t.btable(true);
					}else{
						fns.alert({
							title: '删除失败',
						    content: result.error.msg
						},true);
					}
				}
			},{isStrParam:true});
		},
		filter:function(selected){
			var ids=[];
			var obj={};
			var options=this;
			var hasStatus=this.status.length>0;
			var hasField=this.fields.length>0
			$.each(selected,function(i,row){
				if(hasStatus){
					$.each(options.status,function(i,statu){
						if(row.status==statu){
							ids.push(row[options.pk]);
							return false;
						}
					});
				}else{
					ids.push(row[options.pk]);
				}
			});
			if(hasField){
				var row=selected[0];
				$.each(this.fields,function(i,field){
					obj[field]=row[field];
				});
			}
			if(ids.length>0){
				obj[this.pksField]=ids;
			}
			return obj;
		}
	},_o);
	var data=options.filter(selected);
	var pks=data[options.pksField];
	if (!pks) {
		fns.alert({
		    content: options.selectedErrorMsg
		},true);
	} else {
		fns.confirm({
		    title: "<span style='color:red;'>刪除</span>",
		    content: "确认要删除选中的<span style='color:red;font-size:150%;'>"+pks.length+"</span>条数据吗？删除后不可恢复。",
		    confirm: function(){
		    	options.submit(el,$t,data);
		    }
		},true);
	}
};

/**
 * 数据导入，只导入表格中的一个有数据的工作表
 * 支持多个文件域同时绑定。一个文域绑定一个请求
 *@Controller	RequestMapping(value = "/import", method = RequestMethod.POST) public Map<String, ?>
 *@Controller	imports(HttpServletRequest request,String strJson)
 *@jsCall	$(imfile).elExcelImport({file2:{
 *@jsCall		params:{strJson:function(){return "108055000";}}
 *@jsCall	}});
 */
$.fn.elExcelImport=function(_fos){
	if(this.length<=0){
		return this;
	}
	var $btn="",$file="",$submit="";
	this.each(function(index,el){
		var $btn=$(el);
		var $file=$(el).find("input[type='file']");
		var $text=$file.next();
		var $submit=$text.next();
		var fileName=$file.attr("name");
		if(!fileName){
			$file.attr("name","file"+index);
		}
		var eiObj={
				el:el,
				text:"导入",
				$btn:$btn,
				$file:$file,
				$text:$text,
				$submit:$submit
		};
		$btn[0].eiObj=$file[0].eiObj=$text[0].eiObj=eiObj;
		$file.change(function(){
			if( (!this.value) || (this.value.indexOf(".xls")<0&&this.value.indexOf("xlsx")<0) ){
				this.value="";
				fns.alert({content:"请选择Excel文件类型的数据进行导入操作！"},true);
			}else{
				this.eiObj.$text.text(this.eiObj.text+"-->"+this.value);
				this.eiObj.el.ladda(true);
				this.eiObj.$submit.click();
			}
		});
		$text.click(function(event){
			if(this.eiObj.$file.val()){//有文件
				this.eiObj.el.ladda(true);
				this.eiObj.$submit.click();
			}else{//无文件
				this.eiObj.$file.click();
			}
			//$(this).elCancelBubble(event);
		});
		var fo={
				action           : 'import',
				submit_button    : eiObj.$submit,
				valid_extensions : ['xls', 'xlsx'],
				dataType         : 'json',
				onComplete       : function(result) {
					var elFile=this[0];
					if(result.error_code==0){
						elFile.value="";
						elFile.eiObj.$text.text(elFile.eiObj.text);
						fns.alert({content:result.data},true);
					}else{
						fns.alert({content:result.error.msg},true);
					}
					elFile.eiObj.el.ladda(false);
				}
		};
		if(_fos){
			if(fileName){
				var _fo=_fos[fileName];
				if(_fo){
					$.extend(fo,_fo);
				}
			}
		}
		$file.ajaxfileupload(fo);
	});
};
/**
 * 取消元素的冒泡方法
 */
$.fn.elCancelBubble=function(event) {
	var e = window.event|| event;
	if ( e.stopPropagation ){ /*如果提供了事件对象，则这是一个非IE浏览器*/
		e.stopPropagation();
	}else{
		/*兼容IE的方式来取消事件冒泡*/
		window.event.cancelBubble = true;
	}
}
/**
 * 元素数据设置
 */
$.fn.elDataSet=function(data){
	var result=data||undefined;
	var objName="result";
	if (this.length <= 0) {
		return result;
	}
	var $entityEl=this.find("[name]");
	if($entityEl.length<=0){
		$entityEl=this;
	}
	$entityEl.each(function(index,el){
		var $this=$(el);
		var name=$this.attr("name");
		var value=$this.attr("value");
		var defaultValue=$this.attr("default-value")||"";
		if(name){
			var dataVal="";
			if(result){
				if(name.indexOf(".")>0){
					dataVal=eval(objName+"."+name);
				}else{
					dataVal=result[name];
				}
			}else{
				dataVal=defaultValue;
			}
			switch (el.tagName) {
			case "INPUT":case "TEXTAREA":
				switch ($this.attr("type")) {
				case "radio":case "checkbox":
					$this.attr("checked",false);
					if(dataVal==$this.val()){
						$this.attr("checked",true);
						$this.prop("checked",true);
					}
					break;
				default:
					$this.val(dataVal);
					break;
				}
				break;
			case "SELECT":
				$this.find("option").attr("selected",false);
				$this.val(dataVal);
				/*if(dataVal || dataVal==0 ){
					$this.find("option[value='"+dataVal+"']").attr("selected",true);
				}*/
				break;
			default:
				switch ($this.attr("type")) {
				case "radio":
					$this.find("input[type='radio'],input[type='checkbox']").attr("checked",false);
					$this.find("label").css("color","");
					var $thisRadio=$this.find("[value='"+dataVal+"']");
					if($thisRadio.length>0){
						$thisRadio.attr("checked",true);
						$thisRadio.prop("checked",true);
						$thisRadio.parents("label").css("color","blue");
					}
					break;
				case "checkbox":
					$this.find("input[type='radio'],input[type='checkbox']").attr("checked",false);
					$this.find("label").css("color","");
					try{
						for(var c=0;c<dataVal.length;c++){
							var $thisCheckbox=$this.find("[value='"+dataVal[c]+"']");
							if($thisCheckbox.length>0){
								$thisCheckbox.attr("checked",true);
								$thisCheckbox.prop("checked",true);
							}
						}
					}catch(elDataSet){
						console.log("call $.elDataSet() error:"+elDataSet+"\n dataVal:"+dataVal);
					}
					break;
				default:
					$this.text(dataVal);
					break;
				}
				break;
			}
		}
	});
};
/**
 * 元素数据获取
 */
$.fn.elDataGet=function(entityClass){
	var result=entityClass||{};
	var objName=entityClass?"result":"";
	if (this.length <= 0) {
		return result;
	}
	var $entityEl=this.find("[name]");
	if($entityEl.length<=0){
		$entityEl=this;
	}
	$entityEl.each(function(index,el){
		var $this=$(el);
		var name=undefined;
		var value=undefined;
		switch (el.tagName) {
		case "INPUT":case "TEXTAREA":
			switch ($this.attr("type")) {
			case "radio":case "checkbox":
				if($this.attr("checked") || $this.is(':checked')){
					name=$this.attr("name");
					value=$this.attr("value");
				}
				break;
			default:
				name=$this.attr("name");
				value=$this.val();
				break;
			}
			break;
		case "SELECT":
			name=$this.attr("name");
			var $option=$this.find("option:selected");
			if($option.length>0){
				value=$option.val();
			}else{
				value=$this.val();
			}
			break;
		default:
			switch ($this.attr("type")) {
			case "radio":
				var value="";
				var $radio=$this.find("input[type='radio']:checked,input[type='checkbox']:checked");
				if($radio.length>0){
					$radio.each(function(){
						value=$(this).val().trim();
					});
				}
				value=(value!="")?value.val():"";
				$this.attr("value",value);
				break;
			case "checkbox":
				value=[];
				var $radio=$this.find("input[type='radio']:checked,input[type='checkbox']:checked");
				if($radio.length>0){
					$radio.each(function(index,item){
						value.push($(item).val().trim());
					});
				}
				if(value.length<=0){
					value=null;
				}
				name=$this.attr("name");
				$this.attr("value",JSON.stringify(value));
				break;
			default:
				name=$this.attr("name");
				value=$this.text();
				break;
			}
			break;
		}
		if(name){
			if(objName){
				if(name.indexOf(".")>0){
					var strName=objName+"."+name;
					var lastIndex=strName.lastIndexOf(".");
					eval(strName.substring(0,lastIndex))[strName.substring(lastIndex+1)]=value;
				}else{
					result[name]=value;
				}
			}else{
				result[name]=value;
			}
		}
	});
	return result;
};
/**
 * 元素数据检查
 */
$.fn.elDataCheck = function(paramData) {
	var isPass=true;
	if (this.length <= 0) {
		return;
	}
	var param =null;
	var $entityEl=this.find("[data-check]");
	if($entityEl.length<=0){
		$entityEl=this;
	}
	$entityEl.each(function(index, el) {
		param ={// Selector
			pcs : "tr",// parentContainer
			pcsFind:undefined,
			check : undefined,
			maxLen : 20,
			pattern:undefined
		};
		if(paramData){
			param=$.extend(param,paramData);
		}
		var checkPass=true;
		var $this=$(el);
		var tagName = el.tagName;
		var required= el.hasAttribute("required");
		param.pattern=$this.attr("pattern")||undefined;
		var elParam=undefined;
		try{
			elParam=eval('(' + $this.attr("data-check") + ')');
		}catch(evalE){
			console.log("$.checkElData error:"+evalE);
		}
		if(elParam && typeof elParam =='object'){
			$.extend(param,elParam);
		}
		switch (tagName) {
		case "INPUT":
			switch ($this.attr("type")) {
			case "text":case "password":
				var val=$this.val();
				if(val){
					val=val.val(param);
				}
				$this.val(val);
				if(!val && required ){
					isPass=false;
					checkPass=false;
				}else{
					if(param.minLen){
						if(val.length<param.minLen){
							isPass=false;
							checkPass=false;
						}
					}
				}
				break;
			case "radio":case "checkbox":
				if($this.attr("checked")){
					
				}else{
					param.check=false;
				}
				break;
			case "button":
				
				break;
			default:
				
				break;
			}
			break;
		case "TEXTAREA":
			var val=$this.val().val(param);
			if (param.check){
				isPass=$(check).checkElData();
			}
			if(!val && required ){
				isPass=false;
				checkPass=false;
			}
			break;
		case "SELECT":
			var val=$this.val();
			if(!val && required ){
				isPass=false;
				checkPass=false;
			}
			break;
		case "DIV":
			switch ($this.attr("type")) {
			case "radio":
				$this.attr("value","");
				var value="";
				var $radio=$this.find("input[type='radio']:checked,input[type='checkbox']:checked");
				if($radio.length>0){
					$radio.each(function(){
						value=$(this).val().trim();
					});
				}
				value=(value!="")?value.val(param):"";
				if(!value && required ){
					isPass=false;
					checkPass=false;
				}
				$this.attr("value",value);
				break;
			case "checkbox":
				$this.attr("value","");
				var value=[];
				var $radio=$this.find("input[type='radio']:checked,input[type='checkbox']:checked");
				if($radio.length>0){
					$radio.each(function(index,item){
						value[index]=$(item).val().trim();
					});
				}
				if(value.length<=0 && required ){
					isPass=false;
					checkPass=false;
				}
				$this.attr("value",JSON.stringify(value));
				break;
			default:
				$this.find("[name]").checkElData();
				break;
			}
			break;
		default:
			
			break;
		}
		var $toOPclassEl=$this.parents(param.pcs);
		if(param.pcsFind){
			$toOPclassEl=$toOPclassEl.find(param.pcsFind);
		}
		var opElClassLen=$toOPclassEl.length;
		if(checkPass){
			/*console.log("----has-success-----"+$this.attr("name"));*/
			if(opElClassLen==1){
				$toOPclassEl.removeClass("has-error").addClass("has-success");
			}else if(opElClassLen>=1){
				$toOPclassEl.each(function(index,el){
					var $this=$(el);
					$this.removeClass("has-error").addClass("has-success");
				});
			}
		}else{
			/*console.log("----has-error-----"+$this.attr("name"));*/
			isPass=false;
			if(opElClassLen==1){
				$toOPclassEl.removeClass("has-success").addClass("has-error");
			}else if(opElClassLen>=1){
				$toOPclassEl.each(function(index,el){
					var $this=$(el);
					$this.removeClass("has-success").addClass("has-error");
				});
			}
		}
		if (param.check){
			isPass=$(param.check).checkElData();
		}
	});
	return isPass;
};
/**
 * data item
 */
$.fn.elDataItem = function(paramData) {
	var data=null;
	var $entityEl=this.find("[data-item]");
	if($entityEl.length<=0){
		$entityEl=this;
	}
	$entityEl.each(function(index,el){
		data={
			url:undefined,
			data:undefined,
	        dataField:undefined,
	        name:undefined,
	        value:undefined,
	        text:undefined
		};
		if(paramData){
			data=$.extend(data,paramData||{});
		}
		var checkPass=true;
		var $this=$(el);
		var tagName = el.tagName;
		if(tagName=="BODY"){
			return true;
		}
		var elParam=undefined;
		try{
			elParam=eval('(' + $this.attr("data-item") + ')');
		}catch(evalE){
			console.log("$.elDataItem error:"+evalE);
		}
		if(elParam && typeof elParam =='object'){
			$.extend(data,elParam);
		}
		var dataObj=undefined;
		if(data.data){
			if(data.dataField){
				if(data.dataField.indexOf(".")>0){
					dataObj=eval('(' + ("data.data."+data.dataField) + ')');
				}else{
					dataObj=data.data[data.dataField];
				}
			}else{
				dataObj=data.data;
			}
		}else if(data.url){
			var ajaxOptions=$.extend({
				type : "POST",
                url : undefined,
                data : {},
                contentType:"text/html;charset=utf-8",
                success : function(results) {
                	data.data=results;
                	$this.attr("data-item",JSON.stringify(data));
                	$this.elDataItem();
                }
			},data.ajax);
			if(typeof ajaxOptions.data!="string"){
				ajaxOptions.data=JSON.stringify(ajaxOptions.data);
			}
			$.ajax(ajaxOptions);
			return true;
		}else{
			return false;
		}
		var objOrArr=true;
		if(dataObj.constructor === Array){
			objOrArr=false;
		}
		switch (tagName) {
		case "SELECT":
			$this.find("option").remove("[item]");
			var strOption="";
			if(objOrArr){
				$.each(dataObj,function(key,value){
					if(data.text){
						strOption+="<option item="+JSON.stringify(value)+" value='"+key+"'>"+value[data.text]+"</option>";
					}else{
						strOption+="<option item='' value='"+key+"'>"+value+"</option>";
					}
				});
			}else{
				$.each(dataObj,function(index,item){
					strOption+="<option item='"+JSON.stringify(item)+"' value='"+item[data.value]+"'>"+item[data.text]+"</option>";
				});
			}
			$this.append(strOption);
			break;
		case "DIV":
			switch (data.type) {
			case "radio":case "checkbox":
				$this.find("label").remove("[item]");
				var strOption="";
				if(objOrArr){
					$.each(dataObj,function(key,value){
						strOption+="<label item='' style='border-radius:3px;margin:0px 30px 0px 0px;min-width:65px;' ><input type='"+data.type+"' value='"+key+"' />"+value+"</label>";
					});
				}else{
					$.each(dataObj,function(index,item){//name='"+item[data.name]+"'
						strOption+="<label item='"+JSON.stringify(item)+"' style='border-radius:3px;margin:0px 30px 0px 0px;min-width:65px;' ><input type='"+data.type+"' value='"+item[data.value]+"' />"+item[data.text]+"</label>";
					});
				}
				$this.append(strOption);
				break;
			default:
				
				break;
			}
			break;
		default:
			
			break;
		}
	});
};
/*
 * 元素类样式（动画样式）
 * demo:http://www.dowebok.com/demo/2014/98/
 * github:https://github.com/daneden/animate.css
 */
$.fn.elClassAnimated = function(className,s,time) {
	var $El=undefined;
	var $el=undefined;
	className=className||"shake";
	if(s){
		$el=$(s);
		if($el.length<=0){
			$el=undefined;
		}
	}
	if(this.length==0){
		if($el){
			$El=$el;
		}else{
			return ;
		}
	}else{
		if($el){
			$El=this.find(s);
		}else{
			$El=this;
		}
	}
	$El.addClass('animated '+className);
	var to_animated=setTimeout(function(){$El.removeClass(className);clearTimeout(to_animated);}, time||350);
}
/**
 * 元素移动
 */
$.fn.elDragMousedown=function(e){
	var $drag=this;
	/*DIV在页面的位置*/
	var offset = $drag.offset();
	/*获得鼠标指针离DIV元素左边界的距离*/
	var x = e.pageX - offset.left;
	/*获得鼠标指针离DIV元素上边界的距离*/
	var y = e.pageY - offset.top;
	/*绑定鼠标的移动事件，因为光标在DIV元素外面也要有效果，所以要用doucment的事件，而不用DIV元素的事件*/
	$(document).bind("mousemove", function(ev){
		$drag.stop();//加上这个之后
		var _x = ev.pageX - x;//获得X轴方向移动的值
		var _y = ev.pageY - y;//获得Y轴方向移动的值
		if(_x<0){
			return ;
		}
		if(_y<0){
			return ;
		}
		var cwidth=Math.max(document.body.scrollWidth,document.documentElement.scrollWidth)||(window.innerWidth?window.innerWidth:((document.body) && (document.body.clientWidth)?document.body.clientWidth:0));
		var numW=$drag.width();
		if((_x+numW)==cwidth){
			return ;
		}else if((_x+numW)>cwidth){
			_x=cwidth-numW;
		}
		
		var numH=$drag.height();
		var cheight=Math.max(document.body.scrollHeight,document.documentElement.scrollHeight)||(window.innerHeight?window.innerHeight:((document.body) && (document.body.clientHeight)?document.body.clientHeight:0));
		if((_y+numH)==cwidth){
			return ;
		}else if((_y+numH)>cheight){
			_y=cheight-numH;
		}
		
		$drag[0].style.left = _x + "px";
		$drag[0].style.top = _y + "px";
		
//		$drag.animate({
//			left : _x + "px",
//			top : _y + "px"
//		}, 1);
	});
};
/**
 * build bootstrapTable
 * _to(table options)
 * 
 * bootstrap table refresh
 * if _to is false --> Refresh the current page.
 * if _to is true --> Refresh and load it to the first page.
 */
$.fn.btable=function(_to, param){
	if (this.length <= 0) {
		return undefined;
	}
	var type_to=typeof _to;
	if(type_to=="string" ){
		if(_to==""){
			_to="load";
		}
		if(param){
			return this.bootstrapTable(_to,param);
		}else{
			return this.bootstrapTable(_to);
		}
	}
	if(type_to =="boolean"){
		if (_to) {
			this.bootstrapTable('refresh',{url:this[0].url});
		} else {
			this.bootstrapTable('refresh');
		}
		return this;
	}
	var $this=this;
	var to={
		toolbar : "",
		//filter : true,
		//showExport : true,
		//filterControl : true,
		//filterShowClear : true,
		//fixedColumns:true,
		//fixedNumber:2,
		detailView:false,
		detailFormatter:function(index, row){
			 var html = [];
	        $.each(row, function (key, value) {
	            html.push('<p><b>' + key + ':</b> ' + value + '</p>');
	        });
	        return html.join('');
		},
		dataField : "data",
		totalField : "total_records",
		method : "post",
		sidePagination : "server",
		pagination : true,
		pageList : [ 5, 10, 20, 50, 100, 250, 500, "All" ],
		pageSize : 5,
		queryParamsType : "page",
		showColumns : true,
		//showRefresh : true,
		queryParamsForm:undefined,
		queryParams : function(params) {
			if(this.queryParamsForm){
				this.queryParamsForm.getFormData(params);
			}
			if (this.isSP) {
				params= JSON.stringify(params);
			}
			return params
		},
		onLoadSuccess:function(result){
			$this.find("[data-toggle='tooltip']").tooltip();
			if(typeof this.addLoadSuccess=="function"){
				this.addLoadSuccess(result,$this);
			}
		}
		,formatNoMatches: function () {//error、statusCode 不走本方法
        	var showInfo="";
        	var result=undefined;
        	try{
        		result=this.ajaxOptions.successResult;
        		if(result){
        			if(result.error_code==0){
        				
        			}else{
        				showInfo+="<span style='color:red;'>"+result.error_code+":";
            			if(result.error){
            				if(result.error.msg){
            					showInfo+=result.error.msg;
            				}
            				showInfo+="</span>";
            				if(result.error.cause && result.error.cause.message){
            					showInfo+="<br/>"+result.error.cause.message;
            				}
            			}else{
            				showInfo+="</span>";
            			}
        			}
        		}
        	}catch(e){
        		console.error("bootstrap-table formatNoMatches try catch:",e);
        	}
        	if(!showInfo){
        		showInfo='没有找到相关数据';
        	}
            return showInfo;
        }
	};
	if(_to){
		$.extend(to, _to);
	}
	if(to.isSP){
		to.contentType = "text/html;charset=utf-8";
	}
	this[0].url=to.url;
	if(to.data){
		delete to.url;
	}
	this.bootstrapTable(to);
	return this;
};
$(document).ready(function() {
	$(document).mouseup(function() {
		$(this).unbind("mousemove");
	});
});
/**base 方法*/
fns.notify = function(typeStr, message, options) {
	switch (typeStr) {
	case "s":
		typeStr="success";
		break;
	case "i":
		typeStr="info";
		break;
	case "w":
		typeStr="warning";
		break;
	case "d":
		typeStr="danger";
		break;

	default:
		break;
	}
	try{
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
	}catch(e){
		console.log("请引入bootstrap notify文件！",e);
	}
	return this;
};

/*-**new extension.prototype.js******************************************************************************************************************************************************-*/
/*-**new extension.prototype.js******************************************************************************************************************************************************-*/
if (typeof HTMLElement.prototype.xxx != "undefined") {
	console.error("HTMLElement.prototype exist function XXX , new custom . ");
}

if (typeof String.prototype.trueval != "undefined") {
	console.info("String.prototype exist function trueval , new custom . ");
}
/**
 * True value
 * 
 * @param p
 */
String.prototype.trueval = function(p) {
	var r = this;
	switch (typeof p) {
	case "undefined":
		return this.trim();
	case "string":
		p = p.trim();
		switch (p) {
		case "n":
		case "number":
			if (isNaN(this)) {
				r = (this.match(/[0-9,\-,\.]/g) || []).toString().replace(/[,]/g, "");
				var has_ = false;
				if (r.indexOf("-") == 0) {
					has_ = true;
				}
				r = r.replace(/[-]/g, "");
				console.log("r", r);
				if (r.indexOf(".") >= 0) {// has .
					r = r.split(".");
					r = (r[0] || "0") + "." + r[1];
				}
				if (has_) {
					r = "-" + r;
				}
				return Number(r);
			} else {
				return parseFloat(this);
			}
		case ",":
		case ".":
		case "|":
			var arr = this.split(p);
			r = [];
			for ( var i in arr) {
				if (arr[i]) {
					r.push(arr[i]);
				}
			}
			return r;
		default:
			/*
			 * if(p.search(/^([@]\d+[\^]{1})/)==0){//最大1位，不足位在后面补
			 * 
			 * }else if(p.search(/^([@]\d+[\$]{1})/)==0){ }
			 */
			switch (0) {
			case p.search(/^([@]\d+[\^]{1})/):
				var arr = [ p.substring(1, p.indexOf("^")), p.substring(p.indexOf("^") + 1) ];
				var max = Number(arr[0]);
				var len = r.length;
				while (len < max) {
					r = arr[1] + r;
					len = r.length;
				}
				return r;
			case p.search(/^([@]\d+[\$]{1})/):
				var arr = [ p.substring(1, p.indexOf("$")), p.substring(p.indexOf("$") + 1) ];
				var max = Number(arr[0]);
				var len = r.length;
				while (len < max) {
					r += arr[1];
					len = r.length;
				}
				return r;
			default:
				break;
			}

			break;
		}
		break;
	case "number":
		return this.length > p ? this.substring(0, p) : this;
	case "object":
		switch (p.constructor) {
		case RegExp:
			return (this.match(p) || []).toString().replace(/[,]/g, "");
		default:
			break;
		}
		break;

	default:

		break;
	}
	return this;
}

if (typeof Date.prototype.format != "undefined") {
	console.info("Date.prototype exist function format , new custom . ");
}
/**
 * Date formatting
 * 
 * @param formatStr
 *            YYYY/yyyy/YY/yy 年 MM/M The 月 W/w 星期 dd/DD/d/D 日 hh/HH/h/H 时 mm/m 分 ss/SS/s/S 秒
 * @return string datetime
 */
Date.prototype.format = function(formatStr, english) {
	var str = formatStr;
	var Week = undefined;
	if (english) {
		Week = [ '', '', '', '', '', '', '' ];
	} else {
		Week = [ '星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六' ];
	}

	str = str.replace(/yyyy|YYYY/, this.getFullYear());
	str = str.replace(/yy|YY/, (this.getYear() % 100) > 9 ? (this.getYear() % 100).toString() : '0' + (this.getYear() % 100));

	str = str.replace(/MM/, this.getMonth() >= 9 ? (this.getMonth() + 1).toString() : '0' + (this.getMonth() + 1));
	str = str.replace(/M/g, this.getMonth() + 1);

	str = str.replace(/w|W/g, Week[this.getDay()]);

	str = str.replace(/dd|DD/, this.getDate() > 9 ? this.getDate().toString() : '0' + this.getDate());
	str = str.replace(/d|D/g, this.getDate());

	str = str.replace(/hh|HH/, this.getHours() > 9 ? this.getHours().toString() : '0' + this.getHours());
	str = str.replace(/h|H/g, this.getHours());
	str = str.replace(/mm/, this.getMinutes() > 9 ? this.getMinutes().toString() : '0' + this.getMinutes());
	str = str.replace(/m/g, this.getMinutes());

	str = str.replace(/ss|SS/, this.getSeconds() > 9 ? this.getSeconds().toString() : '0' + this.getSeconds());
	str = str.replace(/s|S/g, this.getSeconds());

	return str;
}

if (typeof HTMLElement.prototype.ladda != "undefined") {
	console.info("HTMLElement.prototype exist function ladda , new custom . ");
}
/**
 * (Button) Load State
 * 
 * @param bool
 *            true:open;false/Empty parameter:close
 * @return Own elements
 */
HTMLElement.prototype.ladda = function(bool) {
	if (!this.laddaObj) {
		if (typeof Ladda != "undefined") {
			this.laddaObj = Ladda.create(this);
		} else {
			console.error("Please introduce the relevant files (ladda):-->dist/ ladda.min.css、spin.min.js、ladda.min.js .");
			return this;
		}
	}
	if (this.laddaObj) {
		if (bool) {
			this.laddaObj.start();
		} else {
			this.laddaObj.stop();
		}
	}
	return this;
};

if (typeof HTMLElement.prototype.bubble != "undefined") {
	console.info("HTMLElement.prototype exist function bubble , new custom . ");
}
/**
 * Block elements bubbling
 * 
 * @desc Recommend the use of el.stopBubble() .
 * @param bool
 *            true:bubble , false:stop bubble
 * 
 * @return Own elements
 */
HTMLElement.prototype.bubble = function(bool) {
	(window.event || this.event).cancelBubble = !bool;
	return this;
}

if (typeof HTMLElement.prototype.stopBubble != "undefined") {
	console.info("HTMLElement.prototype exist function stopBubble , new custom . ");
}
/**
 * Block elements bubbling
 * 
 * @return Own elements
 */
HTMLElement.prototype.stopBubble = function() {
	var e = window.event || this.event;
	if (e.stopPropagation) { /* 如果提供了事件对象，则这是一个非IE浏览器 */
		e.stopPropagation();
	} else {
		/* 兼容IE的方式来取消事件冒泡 */
		window.event.cancelBubble = true;
	}
	return this;
}

if (typeof jQuery == "function") {
	if (typeof $.fn.serializeObject != "undefined") {
		console.info("$.fn exist function serializeObject , new custom . ");
	}
	/**
	 * Encapsulates the data into the form {} object
	 * 
	 * @attention A depth of 1
	 * @attention Only used for form elements
	 */
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
} else {
	console.error("Please introduce the relevant files (jQuery):jquery.min.js .");
}
/*-********************************************************************************************************************************************************-*/
var fns = fns || {};

if (typeof fns.$formPost != "undefined") {
	console.info("fns exist function $formPost , new custom . ");
}
/**
 * $form.submit();$form.remove();
 */
fns.$formPost = function(url) {
	return $("<form></form>").attr({
		"action" : url,
		"method" : "post",
		"style" : "display:none"
	});
}

if (typeof fns.alert != "undefined") {
	console.info("fns exist function alert , new custom . ");
}
/**
 * Alert
 * 
 * @param _o
 *            typeof is string : Tips info ; typeof is object : Alert options .
 * @param is
 *            true : Play box and return ; false : Returns the options .
 * @param _confirm
 *            (optional) OK,the method body
 * @return Alert object or Alert options
 */
fns.alert = function(_o, is, _confirm) {
	var o = {
		title : '温馨提示',
		confirmButton : '确认',
		confirmButtonClass : 'btn-primary'
	};
	if (typeof _o == "string") {
		o.content = _o;
	} else {
		$.extend(o, _o);
	}
	if (_confirm) {
		o.confirm = _confirm;
	}
	if (is) {
		return $.alert(o);
	}
	return o;
};

if (typeof fns.confirm != "undefined") {
	console.info("fns exist function confirm , new custom . ");
}
/**
 * Confirm
 * 
 * @param _o
 *            typeof is string : Tips info ; typeof is object : Confirm options .
 * @param is
 *            true : Play box and return ; false : Returns the options .
 * @param _confirm
 *            (optional) OK,the method body
 * @param _cancel
 *            (optional) The Cancel button, the method body
 * @return Confirm object or Confirm options
 */
fns.confirm = function(_o, is, _confirm, _cancel) {
	var o = {
		title : '温馨提示',
		confirmButton : '确认',
		cancelButton : '取消',
		confirmButtonClass : 'btn-primary',
		cancelButtonClass : 'btn-danger'
	};
	if (typeof _o == "string") {
		o.content = _o
	} else {
		$.extend(o, _o);
	}
	if (_confirm) {
		o.confirm = _confirm;
	}
	if (_cancel) {
		o.cancel = _cancel;
	}
	if (is) {
		return $.confirm(o);
	}
	return o;
}

if (typeof fns.copy != "undefined") {
	console.info("fns exist function copy , new custom . ");
}
/**
 * Copy object
 * 
 * @param source
 *            Source object
 * @return Target object
 */
fns.copy = function(source, destination) {
	var getType = function(o) {
		var _t;
		return ((_t = typeof (o)) == "object" ? o == null && "null" || Object.prototype.toString.call(o).slice(8, -1) : _t).toLowerCase();
	};
	if (!destination) {
		var type = getType(source);
		if (type == "array") {
			destination = [];
		} else if (type == "object") {
			destination = {};
		} else {
			return;
		}
	}
	for ( var p in source) {
		if (getType(source[p]) == "array" || getType(source[p]) == "object") {
			destination[p] = getType(source[p]) == "array" ? [] : {};
			arguments.callee(source[p], destination[p]);
		} else {
			destination[p] = source[p];
		}
	}
	return destination;
};

if (typeof fns.setClipboard != "undefined") {
	console.info("fns exist function setClipboard , new custom . ");
}
/**
 * Set to clipboard
 * 
 * @param _val
 *            copy value
 * 
 * @return
 */
fns.setClipboard = function(_val) {
	var val=_val;
	if (window.clipboardData) {
		window.clipboardData.setData('Text', val);
	} else {
		alert("请使用IE浏览器！");
	}
};
