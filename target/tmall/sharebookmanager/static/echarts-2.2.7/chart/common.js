/**
 * Created by yf on 2015/7/21.
 * 公共的js方法
 */
//设置内容取高度
(function(){
    $("#main").height(document.body.clientHeight-107);
}())
/*
* 渲染侧边栏菜单
* @param {object} element jquery元素对象
* @param {json} jsonData json数据
* */
function creationNav(element,jsonData){
    var html='',childrenData='',id= 0,menuJson={},topNavNode = $('.top-submenu');
    for(var i in jsonData){
    id = jsonData[i].id;
     html+='<div class="submenu panel">'+
        '<a data-toggle="collapse" data-parent="#accordion" href="#accordion-'+id+'" class="sub-a collapsed">'+
        ''+jsonData[i].menuName+'<span class="glyphicon pull-right"></span>'+
        '</a>';
      /*二级菜单*/
      html+= '<div id="accordion-'+id+'" class="panel-collapse collapse">'+
                '<ul class="list-unstyled panel-body">';
        childrenData = jsonData[i].children;
        for(var j in childrenData){
            //把三级菜单保存
            if(childrenData[j].children){
                menuJson[childrenData[j].id]=childrenData[j].children;
                html+='<li><a href="javascript:;" class="threeNav" menuId="'+childrenData[j].id+'">'+childrenData[j].menuName+'</a></li>';
            } else {
                html+='<li><a href="'+childrenData[j].menuUrl+'" menuId="'+childrenData[j].id+'">'+childrenData[j].menuName+'</a></li>';
            }
        }
      html+='</ul></div>';
     html+='</div>';
    }
    element.html(html);
    //给有三级菜单的绑定事件
    element.find('.panel-body a').on('click',function(){
        if($(this).hasClass('threeNav')){
            var menuHtml='';
            var id = parseInt($(this).attr('menuId'));
            var d = menuJson[id];
            menuHtml+='<ul class="nav nav-tabs">';
            for(var i in d){
                menuHtml+= '<li><a href="'+d[i].menuUrl+'" menuId="'+d[i].id+'">'+d[i].menuName+'</a></li>';
            }
            menuHtml+='</ul>';
            topNavNode.html(menuHtml);
        } else {
            topNavNode.html(' ');
        }
    });
    //顶部菜单当前状态
    topNavNode.on("click",'li',function(){
        $(this).siblings().removeClass('active');
        $(this).addClass('active');console
    })
}


/*
 * 修改
 * @param {string} 标题
 * @param {Array} area : ['500px','300px'] 弹窗宽和高
 * */
function layerEdit(argu){
    var opt = argu;
 layer.open({
        type: 1,
        title :opt.title,
        area: opt.area,
        skin: 'layer-fdlm', //样式类名
        closeBtn: true, //不显示关闭按钮
        shadeClose: true, //开启遮罩关闭
        content: '<div class="layer-container">'+
                '<div class="edit">'+
                    '<div><label>用户名：</label><input type="text" class="text" placeholder="请输入用户名"/></div>'+
                    '<div><label>密码：</label><input type="text" class="text" placeholder="请输入密码"/></div>'+
                    '<div><label>状态：</label><input type="text" class="text" placeholder="状态(1启用)"/></div>'+
                    '<div><label>姓名：</label><input type="text" class="text" placeholder="请输入姓名"/></div>'+
                    '<div class="clearfix">'+
                        '<label class="pull-left">性别：</label>'+
                        '<div class="input-group select-style1 pull-right ">'+
                            '<select class="form-control selectpicker sexSelect" >'+
                                '<option vlaue="0">请选择性别</option>'+
                                '<option value="1">男</option>'+
                                '<option value="2">女</option>'+
                            '</select>'+
                        '</div>'+
                    '</div>'+
                    '<div><label>年龄：</label><input type="text" class="text" placeholder="请输入年龄"/></div>'+
                    '<div><label>联系电话：</label><input type="text" class="text" placeholder="请输入联系电话"/></div>'+
                    '<div><label>地址：</label><input type="text" class="text" placeholder="请输入地址"/></div>'+
                    '<div><label>描述：</label><input type="text" class="text" placeholder="请输入描述"/></div>'+
                    '<div class="clearfix">'+
                        '<label class="pull-left">组别选项：</label>'+
                        '<div class="input-group select-style1 pull-right dropup">'+
                            '<select class="form-control selectpicker">'+
                                '<option>请选择组别</option>'+
                                '<option>组别选项一</option>'+
                                '<option>组别选项二</option>'+
        '<option>组别选项二</option>'+
        '<option>组别选项二</option>'+
        '<option>组别选项二</option>'+
        '<option>组别选项二</option>'+
        '<option>组别选项二</option>'+
                            '</select>'+
                        '</div>'+
                    '</div>'+
                    '<div class="clearfix">'+
                        '<label class="pull-left">区域选择：</label>'+
                        '<div class="input-group select-style1 pull-right dropup">'+
                            '<select class="form-control selectpicker areaSelect" data-hide-disabled="false">'+
                                    '<option vlaue="0">请选择区域</option>'+
                                    '<option value="1">区域一</option>'+
                                    '<option value="2">区域二</option>'+
                            '</select>'+
                        '</div>'+
                    '</div>'+
                    '<div class="btn-wrap"><a href="javascript:;" class="submit btn btn-warning">提交</a><a href="javascript:;" class="layui-layer-close btn btn-default">返回</a></div>'+
                '</div>'+
            '</div>'
    });
    $('.submit').click(function(){
        alert(1);
    })
}


/*
 * 角色绑定
 * @param {string} 标题
 * @param {Array} area : ['500px','300px'] 弹窗宽和高
 * */
function layerBinding(argu){
    var opt = argu;
 layer.open({
        type: 1,
        title :opt.title,
        area: opt.area,
        skin: 'layer-fdlm layer-fdlm1', //样式类名
        closeBtn: true, //不显示关闭按钮
        shadeClose: true, //开启遮罩关闭
        content:  '<div class="layer-container" >'+
    '<div class="binding">'+
        '<div class="checkboxWrap">'+
            '<table class="table table-bordered">'+
                '<thead>'+
                    '<tr>'+
                        '<th col="5">全部</th>'+
                    '</tr>'+
                '</thead>'+
                '<tbody>'+
                    '<tr>'+
                        '<td><label><input type="checkbox" /> 暂不分配角色不可删除除</label></td>'+
                        '<td><label><input type="checkbox" /> 暂不分配角色不可删除</label></td>'+
                        '<td><label><input type="checkbox" /> 暂不分配角色不可删除</label></td>'+
                        '<td><label><input type="checkbox" /> 暂不分配角色不可删除</label></td>'+
                    '</tr>'+
                    '<tr>'+
                        '<td><label><input type="checkbox" /> PAUL</label></td>'+
                        '<td><label><input type="checkbox" /> 销售</label></td>'+
                        '<td><label><input type="checkbox" /> 全部权限</label></td>'+
                        '<td><label><input type="checkbox" /> 滑翔机</label></td>'+
                    '</tr>'+
                    '<tr>'+
                        '<td><label><input type="checkbox" /> 暂不分配角色不可删除</label></td>'+
                        '<td><label><input type="checkbox" /> 暂不分配角色不可删除</label></td>'+
                        '<td><label><input type="checkbox" /> 销售主管</label></td>'+
                        '<td><label><input type="checkbox" /> 测试</label></td>'+
                    '</tr>'+

                '</tbody>'+
            '</table>'+
        '</div>'+
        '<div class="btn-wrap"><a href="javascripr:;" class="submit btn btn-warning">提交</a><a href="javascripr:;" class="layui-layer-close btn btn-default">返回</a></div>'+
   '</div>'+
'</div>'
    });
}

/*确认提示框
* @param {Function} okCallback  确定回调
* @param {Function} offCallback 取消回调
* */
function confirm(option){
        if(option == undefined) return false;
        okCallback = option.okCallback || null,
        offCallback = option.offCallback || null,

        content = option.content;
        layer.confirm(content, {
            btn: ['确定','取消'], //按钮
            shade: false, //不显示遮罩
            'title':'提示',
            skin: 'layer-fdlm',
        }, function(index){
            if(typeof okCallback == 'function'){
                okCallback(index);
            }
        }, function(index){
            layer.close(index);
            if(typeof offCallback == 'Function'){
                offCallback();
            }
        });

}