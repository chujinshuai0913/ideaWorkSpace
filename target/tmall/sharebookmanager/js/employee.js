// 进入修改和添加页面初始化
$(document).ready(function(){
	setSelect();
});
// 用户类型点击事件
$('.userType').change(function(){
	setSelect();
})
// 用户类型点击事件方法，根据类型不同控制第三方显示和隐藏
function setSelect(){
	var type = $('.userType').val();
	if(type == 1){
		$("#carrierId").val(0);
		$("#carrierId").selectpicker('render');
		$("#carrierTr").hide();
	} else { 
		$("#carrierTr").show();
	}
}