function splitDataListToGroup(listData, groupSize) {
    groupSize = groupSize || 15;
    var groupData = [];
    if (listData.length <= groupSize) {
        groupData.push(listData);
        return groupData;
    }
    var groupOne = [];
    var matchGroup = listData.length % groupSize === 0;
    $.each(listData, function (i, item) {
        groupOne.push(item);
        var groupIndex = ((i + 1) % groupSize);
        if (groupIndex === 0 || (!matchGroup && i === (listData.length - 1))) {
            groupData.push(groupOne);
            groupOne = [];
        }
    });
    return groupData;
}

//console.log(splitDataListToGroup(printData[0]['returnTaskList']));

function generatePrintHeader(item, $printDeliveredPaperTemplate) {
    var $geDomWrap = $($printDeliveredPaperTemplate.html());
    var $printHeader = $geDomWrap.find('.print-paper-header');

    $printHeader.find('.self-warehouse-name').text(item.xrLabRow1_2.value);
    $printHeader.find('.company-info').text(item.xrLabRow2_1_1.value);
    $printHeader.find('.receiver-info').text(item.xrLabRow2_1.value);
    $printHeader.find('.receive-address-info').text(item.xrLabRow3_1.value);

    $printHeader.find('.delivery-type').text(item.xrLabRow2_1_2.value);
    $printHeader.find('.delivery-info').text(item.xrLabRow2_2.value);
    $printHeader.find('.seller-info').text(item.xrLabRow3_2.value);
    $printHeader.find('.delivery-batch-info').text(item.xrLabRow2_1_3.value);
    $printHeader.find('.order-no').text(item.xrLabRow2_3.value);
    $printHeader.find('.delivery-date').text(item.deliveryDate.value);
    $printHeader.find('.print-time').text(item.printTime.value);
    return $printHeader;
}

function generateDataTable(data, $printDeliveredPaperTemplate) {
    var $geDomWrap = $($printDeliveredPaperTemplate.html());
    var $dataTable = $geDomWrap.find('.receipts-data-table');
    // 单据数据
    var $receiptsDataTable = $dataTable.find('table');
    var $receiptsDataTableTbody = $receiptsDataTable.find('tbody').empty();
    $.each(data, function (i, row) {
        // 数据预处理
        var $dispatchDataTr = $('<tr>');
        var $dispatchDataTds =
            '<td>' + row.column1 + '</td>\n' +
            '<td>' + row.column2 + '</td>\n' +
            '<td>' + row.column3 + '</td>\n' +
            '<td>' + row.column6 + '</td>\n' +
            '<td>' + row.column7 + '</td>\n' +
            '<td>' + row.column8 + '</td>\n' +
            '<td>' + row.column11 + '</td>\n' +
            '<td>' + row.column12 + '</td>';
        $dispatchDataTr.append($dispatchDataTds);
        $receiptsDataTableTbody.append($dispatchDataTr);
    });
    return $dataTable;
}

function generatePrintFooter(item, $printDeliveredPaperTemplate) {
    var $geDomWrap = $($printDeliveredPaperTemplate.html());
    var $printFooter = $geDomWrap.find('.print-paper-footer');
    $printFooter.find('.discounted-total-money').text(item.xrLabRow5_1.value);
    $printFooter.find('.after-discounted-money').text(item.xrLabRow5_2.value);
    $printFooter.find('.delivery-money').text(item.xrLabRow5_3.value);
    $printFooter.find('.pre-pay-money').text(item.xrLabRow5_4.value);
    $printFooter.find('.should-get-money').text(item.xrLabRow5_5.value);
    $printFooter.find('.customer-need-pay-money').text(item.xrLabRow5_6.value);
    $printFooter.find('.receiver-mark-date').text(item.xrLabRow6_1.value);
    $printFooter.find('.deliveryman-mark-date').text(item.xrLabRow6_4.value);
    $printFooter.find('.replenishment-money').text(item.xrLabRow6_4.value);
    $printFooter.find('.return-goods-money').text(item.xrLabRow6_4.value);
    $printFooter.find('.return-package-money').text(item.xrLabRow6_4.value);
    $printFooter.find('.locale-get-money').text(item.xrLabRow6_6.value);
    $printFooter.find('.remark1').text(item.xrLabRow7_1.value);
    $printFooter.find('.remark2').text(item.xrLabRow8_1.value);
    return $printFooter;
}

function generatePrintHandle($geDomWrap, callback, callbackParam) {
    //var $geDomWrap = $($printDeliveredPaperTemplate.html());
    // 绑定打印按钮事件
    var $printHandle = $geDomWrap.find('.print-handle'), $printPaper = $geDomWrap.find('.print-paper-content');
    $printHandle.find('.print-one').on('click', function () {
        $printPaper.printArea({});
        if (typeof callback === 'function') callback(callbackParam);
    });
    return $printHandle;
}