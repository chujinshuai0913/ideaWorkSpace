function print(url,param,printerName){
	var data = '{"url":"'+url+'","params":"'+param+'","printer": "'+printerName+'"}';
    $.ajax({
    	type: "post",
        async: false,
        url: "http://192.168.134.48:8080/print",
        dataType: "json",
        data:data,
        jsonp: "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
        jsonpCallback:"flightHandler",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名，也可以写"?"，jQuery会自动为你处理数据
        success: function(json){
        	
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            alert('fail');
        }
    });
    } 