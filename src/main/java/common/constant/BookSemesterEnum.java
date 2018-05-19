package common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/21 22:53 星期六
 */
public enum BookSemesterEnum {

    SEMESTER(ConstantsUtils.BookSemesterNameCode.SEMESTER,"通用"),
    SEMESTER_UP(ConstantsUtils.BookSemesterNameCode.SEMESTER_UP,"上学期"),
    SEMESTER_DOWN(ConstantsUtils.BookSemesterNameCode.SEMESTER_DOWN,"下学期");

    private static Map<Integer, String> nameMap;
    private static Map<String, Integer> keyMap;


    private Integer value;

    private String name;

    BookSemesterEnum(Integer value, String name){
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static Map<Integer, String> getNameMap(){
        return nameMap;
    }

    public static Map<String, Integer> getKeyMap() {
        return keyMap;
    }

    static{
        if (nameMap == null) {
            nameMap = new HashMap<>();
        }
        BookSemesterEnum[] bookSemesterEnums = BookSemesterEnum.values();
        for (BookSemesterEnum bookSemesterEnum : bookSemesterEnums) {
            nameMap.put(bookSemesterEnum.getValue(), bookSemesterEnum.getName());
        }

        if (keyMap == null) {
            keyMap = new HashMap<>();
            for (BookSemesterEnum enumOne : BookSemesterEnum.values()) {
                keyMap.put(enumOne.toString(), enumOne.getValue());
            }
        }
    }
}
