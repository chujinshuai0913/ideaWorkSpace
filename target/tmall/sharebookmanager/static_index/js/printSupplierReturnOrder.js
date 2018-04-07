function splitDataListToGroup(listData, groupSize) {
    groupSize = groupSize || 15;
    var groupData = [];
    if(listData.length <= groupSize){
        groupData.push(listData);
        return groupData;
    }
    var groupOne = [];
    var matchGroup = listData.length % groupSize === 0;
    $.each(listData, function (i, item) {
        groupOne.push(item);
        var groupIndex = ((i + 1) % groupSize);
        if(groupIndex === 0 || (!matchGroup && i === (listData.length - 1))){
            groupData.push(groupOne);
            groupOne = [];
        }
    });
    return groupData;
}

function generatePrintHeader(item, $printDeliveredPaperTemplate) {
    var $geDomWrap = $($printDeliveredPaperTemplate.html());
    var $printHeader = $geDomWrap.find('.print-paper-header');
    // 二维码
    /*var $qrcodeWrap = $printHeader.find('.qrcode-wrap');
    renderQrCode($qrcodeWrap.find('.qrcode-show'), item.returnOrderNo);*/

    var $barCodeWrap = $printHeader.find('.barcode-wrap');
    renderBarCode($barCodeWrap.find('.barcode-show'), item.returnOrderNo);

    $printHeader.find('.text-task-no').text(item.returnOrderNo);
    $printHeader.find('.warehouse-name-from').text(item.warehouseNameFrom);
    $printHeader.find('.warehouse-name-to').text(item.warehouseNameTo);
    $printHeader.find('.out-warehouse-date').text(item.outWarehouseDate);
    $printHeader.find('.out-warehouse-time').text(item.outWarehouseTimeFormative);
    $printHeader.find('.print-time').text(item.printTimeFormative);
    return $printHeader;
}

function generateDataTable(data, $printDeliveredPaperTemplate) {
    var $geDomWrap = $($printDeliveredPaperTemplate.html());
    var $dataTable = $geDomWrap.find('.dispatch-data-table');
    // 单据数据
    var $dispatchDataTable = $dataTable.find('table');
    var $dispatchDataTableTbody = $dispatchDataTable.find('tbody');
    $.each(data, function (i, row) {
        // 数据预处理
        var $dispatchDataTr = $('<tr>');
        var $dispatchDataTds = '<td>' + row.index + '</td>\n' +
            '<td>' + row.containerCode + '</td>\n' +
            '<td>' + (row.skuId === 0 ? '' : row.skuId) + '</td>\n' +
            '<td>' + row.name + '</td>\n' +
            '<td>' + row.returnAmountStr + '</td>\n' +
            '<td>' + row.remark + '</td>';
        $dispatchDataTr.append($dispatchDataTds);
        $dispatchDataTableTbody.append($dispatchDataTr);
    });
    return $dataTable;
}

function generatePrintFooter(item, $printDeliveredPaperTemplate) {
    var $geDomWrap = $($printDeliveredPaperTemplate.html());
    var $printFooter = $geDomWrap.find('.print-paper-footer');
    $printFooter.find('.ship-user-name').text(item.despatchUname);
    $printFooter.find('.out-warehouse-time').text(item.outWarehouseTimeFormative);
    return $printFooter;
}
function generatePrintHandle($geDomWrap, callback, callbackParam) {
    //var $geDomWrap = $($printDeliveredPaperTemplate.html());
    // 绑定打印按钮事件
    var $printHandle = $geDomWrap.find('.print-handle'), $printPaper = $geDomWrap.find('.print-paper-content');
    $printHandle.find('.print-one').on('click', function () {
        $printPaper.printArea({
        });
        if(typeof callback === 'function') callback(callbackParam);
    });
    return $printHandle;
}

function renderQrCode($qrCodeContainer, text) {
    $qrCodeContainer.empty().qrcode({
        // render method: 'canvas', 'image' or 'div'
        render: 'image',
        // version range somewhere in 1 .. 40
        minVersion: 4,
        maxVersion: 40,

        // error correction level: 'L', 'M', 'Q' or 'H'
        ecLevel: 'H',

        // offset in pixel if drawn onto existing canvas
        left: 0,
        top: 0,
        // size in pixel
        size: 60,
        // code color or image element
        fill: '#000',
        // background color or image element, null for transparent background
        background: '#fff',
        // content
        text: text,
        // corner radius relative to module width: 0.0 .. 0.5
        radius: 0,
        // quiet zone in modules
        quiet: 2,
        // modes
        // 0: normal
        // 1: label strip
        // 2: label box
        // 3: image strip
        // 4: image box
        mode: 0,

        mSize: 0.2,
        mPosX: 0.5,
        mPosY: 0.5,

        label: '',
        fontname: 'sans',
        fontcolor: '#000'
    });
}
function renderBarCode($barCodeContainer, text, barcodeConfigOption) {
    var barcodeConfigDefaultOption = {
        format: 'code128',
        width: 1.2,                 //设置条之间的宽度
        height: 40,                 //高度
        displayValue: false,         //是否在条形码下方显示文字
        fontOptions: "bold",        //使文字加粗体或变斜体
        font: "sans-serif",         //设置文本的字体
        text: '',                   //覆盖显示的文本
        textAlign: "center",        //设置文本的水平对齐方式
        textPosition: "bottom",     //设置文本的垂直对齐方式
        textMargin: 0,              //设置条形码和文本之间的间距
        fontSize: 24,               //设置文本的大小
        background: "#fff",         //设置条形码的背景
        lineColor: "#000",          //设置条和文本的颜色。
        margin: 0                   //设置条形码周围的空白边距
    };
    barcodeConfigOption = barcodeConfigOption || barcodeConfigDefaultOption;
    $barCodeContainer.empty().JsBarcode(text, barcodeConfigOption);
}