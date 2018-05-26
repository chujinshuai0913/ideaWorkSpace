/**
 * Copyright (C), 2018-2018
 * FileName: CatQuery
 * Author:   jinshuai
 * Date:     2018/5/25 20:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.query;

import java.math.BigDecimal;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/25
 * @since 1.0.0
 */
public class CatQuery extends QueryParam {

    private Integer bookId;

    private  Integer num;

    private Integer  userId;

    private Integer  status;

    private BigDecimal price;

    private Integer bookFatherId;

    public Integer getBookFatherId() {
        return bookFatherId;
    }

    public void setBookFatherId(Integer bookFatherId) {
        this.bookFatherId = bookFatherId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
