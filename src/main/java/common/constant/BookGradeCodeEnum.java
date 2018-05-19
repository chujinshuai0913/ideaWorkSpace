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
public enum BookGradeCodeEnum {

    GRADE(ConstantsUtils.BookGradeCode.GRADE,"通用"),
    GRADE_A(ConstantsUtils.BookGradeCode.GRADE_A,"大一"),
    GRADE_B(ConstantsUtils.BookGradeCode.GRADE_B,"大二"),
    GRADE_C(ConstantsUtils.BookGradeCode.GRADE_C,"大三"),
    GRADE_D(ConstantsUtils.BookGradeCode.GRADE_D,"大四"),
    GRADE_E(ConstantsUtils.BookGradeCode.GRADE_E,"研一"),
    GRADE_F(ConstantsUtils.BookGradeCode.GRADE_F,"研二"),
    GRADE_G(ConstantsUtils.BookGradeCode.GRADE_G,"研三"),
    GRADE_H(ConstantsUtils.BookGradeCode.GRADE_H,"博士");

    private static Map<Integer, String> nameMap;
    private static Map<String, Integer> keyMap;


    private Integer value;

    private String name;

    BookGradeCodeEnum(Integer value, String name){
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
        BookGradeCodeEnum[] bookGradeCodeEnums = BookGradeCodeEnum.values();
        for (BookGradeCodeEnum bookGradeCodeEnum : bookGradeCodeEnums) {
            nameMap.put(bookGradeCodeEnum.getValue(), bookGradeCodeEnum.getName());
        }

        if (keyMap == null) {
            keyMap = new HashMap<>();
            for (BookGradeCodeEnum enumOne : BookGradeCodeEnum.values()) {
                keyMap.put(enumOne.toString(), enumOne.getValue());
            }
        }
    }
}
