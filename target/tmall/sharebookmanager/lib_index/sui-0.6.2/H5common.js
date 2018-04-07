/**
 * H5的RF页面公用方法
 * 
 * @author zhaoziming
 * 
 */


/**
 * 根据日期自动生成流水号
 * 
 * @param index
 * @returns {String}
 */
function curDateTime(index) {
	var d = new Date();
	var year = d.getFullYear() + "";
	var month = d.getMonth() + 1;
	var date = d.getDate();
	var day = d.getDay();
	var Hours = d.getHours(); //获取当前小时数(0-23)
	var Minutes = d.getMinutes(); //获取当前分钟数(0-59)
	var Seconds = d.getSeconds(); //获取当前秒数(0-59)
	var curDateTime = year;
	if (month > 9) {
		curDateTime = curDateTime + month;
	} else {
		curDateTime = curDateTime + "0" + month;
	}
	if (date > 9) {
		curDateTime = curDateTime + date;
	} else {
		curDateTime = curDateTime + "0" + date;
	}
	if (Hours > 9) {
		curDateTime = curDateTime + Hours;
	} else {
		curDateTime = curDateTime + "0" + Hours;
	}
	if (Minutes > 9) {
		curDateTime = curDateTime + Minutes;
	} else {
		curDateTime = curDateTime + "0" + Minutes;
	}
	if (Seconds > 9) {
		curDateTime = curDateTime + Seconds;
	} else {
		curDateTime = curDateTime + "0" + Seconds;
	}
	return index + curDateTime;
}

/**
 * 判断是否存在数组中
 * 
 * @param arr
 * @param val
 * @returns {Boolean}
 */
function contains(arr, val) {
    if (arr.indexOf(val) !== -1) {
        return true;
      } else {
        return false;
      }
}		
/**
 * 数组索引
 */
Array.prototype.indexOf = function(val) {
	for (var i = 0; i < this.length; i++) {
		if (this[i] == val)
			return i;
	}
	return -1;
};
/**
 * 从数组中移除
 */
Array.prototype.remove = function(val) {
	var index = this.indexOf(val);
	if (index > -1) {
		this.splice(index, 1);
	}
};

/**
 * 获取页面传入的参数
 * 
 * @returns {Object}
 */
function GetRequest() {
	var url = location.search; //获取url中"?"符后的字串
   	var theRequest = new Object();
   	if (url.indexOf("?") != -1) {
   		var str = url.substr(1);
      	strs = str.split("&");
      	for(var i = 0; i < strs.length; i ++) {
        	theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
      	}
   	}
   	return theRequest;
}