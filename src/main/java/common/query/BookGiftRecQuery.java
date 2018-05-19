package common.query;

import java.util.List;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/15 16:04 星期日
 */
public class BookGiftRecQuery extends QueryParam {

    private String gTime;

    private Integer giftTime;

    public void setGiftTime(Integer giftTime) {
        this.giftTime = giftTime;
    }

    public Integer getGiftTime() {
        return giftTime;
    }

    public void setGTime(String gTime) {
        this.gTime = gTime;
    }

    public String getGTime() {
        return gTime;
    }
}
