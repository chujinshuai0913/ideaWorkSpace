/**
 * @doc 框架脚本
 * @author Heanes
 * @time 2016-11-29 10:16:42 周二
 */
$(function () {
    /**
     * @doc 左侧菜单点击在tab中载入
     * @author Heanes
     * @time 2016-11-29 20:20:57 周二
     */
    var $tabsContainer = $('#tabsContainer');
    $tabsContainer.jqxTabs({
        theme: 'bootstrap',
        height: '100%',
        autoHeight: true,
        showCloseButtons: true,
        reorder: true,
        scrollPosition: 'both' // 标签太多时允许滚动
    });//.jqxTabs('hideCloseButtonAt', 0); //隐藏首页删除按钮

    var $tabsTitleContainer = $('#tabsTitleContainer');
    var tabsLength = $tabsTitleContainer.length;
    var tabsAddCount = 0;
    // tab关闭后处理
    $tabsContainer.on('removed', function (event) {
        tabsAddCount--;
    });
    var selectedTab = 0;
    $tabsContainer.on('selected', function (event){
        selectedTab = event.args.item;
    });
    // 刷新标签
    $('#refreshTab').on('click', function () {
        var tabContent = $tabsContainer.jqxTabs('getContentAt', selectedTab);
        var $tabIframe = $(tabContent).find('iframe').first();
        $tabIframe.attr('src', $tabIframe.attr('src'));
    });
    // 关闭全部标签
    $('#closeAllTabs').on('click', function () {
        if(confirm('你确定关闭全部标签吗？')){
            var tabsCount = tabsAddCount;
            for(tabsCount; tabsCount >= 0; tabsCount--){
                $tabsContainer.jqxTabs('removeAt', tabsCount);
            }
        }
    });

    /**
     * @doc a标签点击后添加新的tab（覆写的简便方法）
     * @param $aNode a标签jQuery对象
     * @returns {boolean}
     */
    function addJqxTabFromANode($aNode){
        var placeIndex = tabsLength + tabsAddCount;
        addJqxTabFromANodeAtIndex($aNode, $tabsContainer, placeIndex);
    }

    /**
     * @doc a标签点击后添加新的tab
     * @param $aNode a标签jQuery对象
     * @param $tabsContainer tab放置的容器
     * @param index 序号
     * @returns {boolean}
     */
    function addJqxTabFromANodeAtIndex($aNode, $tabsContainer, index){
        var tabId = 'tabsIframe' + $aNode.attr('data-nodeId');
        var tabTitleId = 'tabsTitle' + $aNode.attr('data-nodeId');
        // 查找是否已经存在此tab（支持tab头被拖动后的定位）
        var $existTabs = $tabsContainer.find('#' + tabTitleId);
        if($existTabs.length > 0){
            // 存在则定位
            var existIndex = $existTabs.parent().parent().index();
            $tabsContainer.jqxTabs('select', existIndex);
            return false;
        }
        var tabTitle = $aNode.html();
        var $tabTitleWrap = '<div class="tab-title-wrap" id="' + tabTitleId + '">' + tabTitle + '</div>';
        var tabSrc = $aNode.attr('href');
        if(tabSrc == undefined || tabSrc == '' || tabSrc == 'javascript:;' || tabSrc == 'javascript:;' || tabSrc == 'javascript:void(0)'){
            return false;
        }
        // 否则创建
        var tabContent = '<iframe src="' + tabSrc + '" id="' + tabId + '"></iframe>';
        $tabsContainer.jqxTabs('addAt', index, $tabTitleWrap, tabContent);

        tabsAddCount++;
        return true;
    }
    /**
     * @doc 获取菜单数据
     * @author Heanes
     * @time 2016-11-29 16:40:18 周二
     */
    var getMenuData = function(){
        var menuDataJsonUrl = '/ideaWorkSpace/sharebookmanager/static/menu/menu.json';
        $.getJSON(menuDataJsonUrl, function(data){
            //renderMenu($menuLeftBlock, data);
            var $treeView = $('.left-block').treeView({
                data: data,
                iconCollapse: 'triangle-right', // 合上时的图标
                iconExpand: 'triangle-down',    // 展开时的图标
                enableLink: true,               // 开启链接
                enableTopSwitch: true,          // 开启顶部切换标识
                enableIndentLeft: true,         // 允许向左缩进
                enableTreeSearch: true,         // 开启树菜单搜索
                treeSearchPlaceholder: '搜索(名称及链接)',// 树菜单搜索的提示字符
                showTopNavIcon: false,          // 顶部导航是否显示图标
                topSwitcherTarget: $('.menu-top'),// 开启了顶部切换后，根节点展示在此处，根节点展示在此处(填写jQuery Dom)
                showSingleNodeIcon: true,       // 无子树节点是否显示图标
                style: {
                    topActive: {
                        bgColor: '#254f7b',     // 顶部切换的激活后背景色 topActive.bgColor
                        color: '#fff'           // 顶部切换的激活后字体色 topActive.color
                    },
                    topHover: {
                        bgColor: '#254f7b',     // 侧边树的鼠标浮上背景色 topHover.bgColor #E7E7E7
                        color: '#fff'           // 侧边树的鼠标浮上字体色 topHover.color
                    },
                    left: {
                        bgColor: '#f2f2f2',     // 侧边树的背景色 left.Bg.Color
                        color: '#353535'        // 侧边树的字体色 left.color
                    },
                    leftSelected: {
                        bgColor: '#666',        // 侧边树的选中后的背景色 leftSelected.bgColor
                        color: '#fff'           // 侧边树的选中后的字体色 leftSelected.color
                    },
                    leftHover: {
                        bgColor: '#666',        // 侧边树的鼠标浮上背景色 leftHover.bgColor
                        color: '#fff'           // 侧边树的鼠标浮上字体色 leftHover.color
                    },
                    leftNodeExpanded: {
                        bgColor: '#eee',        // 侧边树的节点展开时背景色 leftNodeExpanded.bgColor
                        color: '#353535'        // 侧边树的节点展开时字体色 leftNodeExpanded.color
                    }
                },                              // 样式相关

                onNodeClick: function (event, node) {
                    if(node.target && node.target === '_blank'){
                        window.open(node.href);
                        return false;
                    }
                    var $aNode = $('<a></a>').attr('href', node.href).attr('data-nodeId', node.nodeId)
                        .append('<i class="tab-title-icon ' + node.nodeIcon + '"></i>')
                        .append('<span class="tab-title">' + node.text + '</span>');
                    addJqxTabFromANode($aNode);
                    return false;
                },
                onTopSwitch: function (event) {
                    if(lapHandleClick){
                        $('#lapLeftMenu').trigger('click');
                    }
                    if(leftTreeIndentFlag){
                        $('.tree-list-lap').trigger('click');
                    }
                    //console.log('顶部被点击，左侧会切换');
                },
                onLeftTreeContract: function (event) {
                    leftTreeIndent(leftBlockDraggedWidth);
                    //console.log('左侧树缩进');
                },
            });

            //@Todo url带子树路径
            /*var hash =window.location.hash;
            var menuHash = hash.match(/menu=(\d+|,){1,}/g);
            var nodeIdsStr = menuHash[0].replace('menu=', '');
            var nodeIdArr = nodeIdsStr.split(',');
            console.log(nodeIdArr);*/


            return data;
        });
    };
    var menuDataJson = getMenuData();


    var $leftBlock = $('.left-block');
    var $centerBlock = $('.center-block');
    /**
     * @doc 全屏的处理
     * @author Heanes
     * @time 2016-12-16 10:37:27 周五
     */
    $('#fullScreen').on('click', function () {
        var $icon = $(this).find('.fa');
        $icon.toggleClass(function() {
            if ($icon.hasClass('fa-arrows-alt')) {
                $icon.removeClass('fa-arrows-alt');
                return 'fa-compress';
            } else {
                $icon.removeClass('fa-compress');
                return 'fa-arrows-alt';
            }
        });
        $(this).closest('.layout-handle').toggleClass('effected');
        $('.main-top-block').toggleClass('full-screen');
        $leftBlock.toggleClass('full-screen');
        $centerBlock.toggleClass('full-screen');
    });

    /**
     * @doc 左侧菜单缩进
     * @author Heanes
     * @time 2016-12-21 16:39:46 周三
     * @type {*}
     */
    var $leftWrap = $('.left-wrap');
    var leftWrapWidth = $leftWrap.css('width');
    var lapHandleClick = false;
    var $lapLeftMenu = $('.lap-left-menu');
    $lapLeftMenu.on('click', function () {
        if(lapHandleClick){
            $leftBlock.animate({
                'width': leftWrapWidth
            });
            $centerBlock.animate({
                'padding-left': leftWrapWidth
            });
            lapHandleClick = false;
        }else{
            leftWrapWidth = $leftWrap.css('width');
            $leftBlock.animate({
                'width': '0'
            });
            $centerBlock.animate({
                'padding-left': '0'
            });
            lapHandleClick = true;
        }
        return false;
    });

    var leftTreeIndentFlag = false;
    function leftTreeIndent(width) {
        if(leftTreeIndentFlag){
            $leftBlock.animate({
                'width': width
            });
            $centerBlock.animate({
                'padding-left': width
            });
            leftTreeIndentFlag = false;
        }else{
            $leftBlock.animate({
                'width': '40px'
            });
            $centerBlock.animate({
                'padding-left': '40px'
            });
            leftTreeIndentFlag = true;
        }
    }


    /**
     * @doc 右上角宽度适应
     */
    var $userInfoWrap = $('.user-info-wrap')
        , $userInfoCell = $('.user-info-cell');
    $userInfoCell.css('width', $userInfoWrap.outerWidth(true));


    /**
     * @doc 获取页面最大z-index值
     * @author Heanes
     * @time 2017年12月15日16:59:43 周五
     */
    function getMaxZIndex() {
        var
            maxZ = 0,
            divs = document.getElementsByTagName("*");

        for(var i = 0; i < divs.length; i++) {
            maxZ = Math.max(maxZ,parseInt(getClass(divs[i],'z-index')) || 0);
        }

        //兼容获取非行间样式
        function getClass(obj, name)
        {
            if(obj.currentStyle)
            {
                return obj.currentStyle[name]; //IE下获取非行间样式
            } else{
                return getComputedStyle(obj, false)[name]; //FF、Chorme下获取非行间样式
            }
        }
        console.log(maxZ);
        return maxZ;
    }


    /**
     * @doc 拖拽功能
     * @type {*|jQuery|HTMLElement}
     * @time 2017-12-18 18:16:59 周一
     */
    var $vSplitBar = $('.v-split-bar'),
        $vSplitBarPlaceholder = $('.v-split-bar-placeholder'),
        inSplitBarFlag = false,
        startX = 0, barOldX = 0,
        leftBlockOldWidth = $leftWrap.outerWidth(true),
        leftBlockDraggedWidth = leftBlockOldWidth,
        centerBlockOldPaddingLeft = 0;

    $vSplitBar.on('mousedown', function (event) {
        var e = event ? event : window.event;
        inSplitBarFlag = true;
        $vSplitBar.addClass('dragged');
        $vSplitBarPlaceholder.addClass('dragged');
        barOldX = getTargetPosition($vSplitBar)['left'];
        startX = e.clientX;
        leftBlockOldWidth = $leftWrap.outerWidth(true);
        centerBlockOldPaddingLeft = $centerBlock.css('padding-left');
    });

    $(document).on('mousemove', function (event) {
        var e = event ? event : window.event;
        if(inSplitBarFlag){
            var offsetX = e.clientX - startX;
            var targetPosition = {
                left: barOldX + offsetX
            };
            moveTargetPosition($vSplitBar, targetPosition);
            vSplitBarDragChangeHandle(offsetX)
        }
    });

    $(document).on('mouseup', function (event) {
        inSplitBarFlag = false;
        $vSplitBar.removeClass('dragged');
        $vSplitBarPlaceholder.removeClass('dragged')
    });

    
    function vSplitBarDragChangeHandle(offset) {
        leftBlockDraggedWidth = parseInt(leftBlockOldWidth) + offset;
        $leftBlock.css('width', leftBlockDraggedWidth);
        $centerBlock.css('padding-left', parseInt(centerBlockOldPaddingLeft) + offset);
    }

    /**
     * @doc 获取目标dom的定位值
     * @param $target
     * @returns {{top: number, left: number}}
     */
    function getTargetPosition($target) {
        var positionTop = 0;
        var positionLeft = 0;
        if ($target) {
            positionTop = $target.offset().top;
            positionLeft = $target.offset().left;
        }
        return {top: positionTop, left: positionLeft};
    }

    /**
     * @doc 移动目标dom到指定位置
     * @param $target
     * @param position
     */
    function moveTargetPosition($target, position) {
        if (position.top || position.left) {
            $target.css({
                position: 'absolute',
            });
        }
        if (position.top) {
            $target.css({
                top: position.top + 'px',
            });
        }
        if (position.left) {
            $target.css({
                left: position.left + 'px'
            });
        }
    }
});