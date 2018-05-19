package common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: <br>
 * Description: 退正库单状态<br>
 * Copyright: Copyright (c) 2016<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 * 
 * @author fanggang
 * @time 2017-10-27 10:31:25 周五
 */

public enum ReturnTaskStatusEnum {

    UNDELIVERED(0, "未发运"),
    DELIVERED(1, "已发运"),
    FINISH(2, "关闭"); // 完成

    private static Map<Integer, String> nameMap;
    private static Map<String, Integer> keyMap;


    private Integer value;

    private String name;

    ReturnTaskStatusEnum(Integer value, String name){
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
        ReturnTaskStatusEnum[] returnTaskStatusEnumList = ReturnTaskStatusEnum.values();
        for (ReturnTaskStatusEnum returnTaskStatusEnum : returnTaskStatusEnumList) {
            nameMap.put(returnTaskStatusEnum.getValue(), returnTaskStatusEnum.getName());
        }

        if (keyMap == null) {
            keyMap = new HashMap<>();
            for (ReturnTaskStatusEnum enumOne : ReturnTaskStatusEnum.values()) {
                keyMap.put(enumOne.toString(), enumOne.getValue());
            }
        }
    }
}
