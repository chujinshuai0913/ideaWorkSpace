package common.query;

import java.math.BigDecimal;
import java.util.List;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/14 17:23 星期六
 */
public class RecordSellingQuery extends QueryParam {
    private Integer id;

    private Integer sellingId;

    private List<Integer> buyers;

    private  String  buyerName;

    private Integer total;

    private Integer orderTime;

    private Integer status;

    private Integer buyer;

    private String failureReason;

    private Integer completeTime;

    private BigDecimal totalPrice;

    private String priceunit;

    private Integer scompleteTime;

    private Integer ecompleteTime;

    private String startCompleteTime;

    private String eneCompleteTime;

    //异常量界限
    private Integer num;

    public Integer getBuyer() {
        return buyer;
    }

    public void setBuyer(Integer buyer) {
        this.buyer = buyer;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPriceunit() {
        return priceunit;
    }

    public void setPriceunit(String priceunit) {
        this.priceunit = priceunit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSellingId() {
        return sellingId;
    }

    public void setSellingId(Integer sellingId) {
        this.sellingId = sellingId;
    }

    public List<Integer> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Integer> buyers) {
        this.buyers = buyers;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Integer orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public Integer getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Integer completeTime) {
        this.completeTime = completeTime;
    }

    public Integer getScompleteTime() {
        return scompleteTime;
    }

    public void setScompleteTime(Integer scompleteTime) {
        this.scompleteTime = scompleteTime;
    }

    public Integer getEcompleteTime() {
        return ecompleteTime;
    }

    public void setEcompleteTime(Integer ecompleteTime) {
        this.ecompleteTime = ecompleteTime;
    }

    public String getStartCompleteTime() {
        return startCompleteTime;
    }

    public void setStartCompleteTime(String startCompleteTime) {
        this.startCompleteTime = startCompleteTime;
    }

    public String getEneCompleteTime() {
        return eneCompleteTime;
    }

    public void setEneCompleteTime(String eneCompleteTime) {
        this.eneCompleteTime = eneCompleteTime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
}
