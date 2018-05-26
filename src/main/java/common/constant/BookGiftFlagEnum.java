package common.constant;

import java.util.HashMap;
import java.util.Map;


public enum BookGiftFlagEnum {
    FLAG(ConstantsUtils.BookGiftFlag.FLAG,"是"),
    否(ConstantsUtils.BookGiftFlag.FLAG_NOT,"否");

    private static Map<Integer, String> nameMap;
    private static Map<String, Integer> keyMap;


    private Integer value;

    private String name;

    BookGiftFlagEnum(Integer value, String name){
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
        BookGiftFlagEnum[] returnTaskStatusEnumList = BookGiftFlagEnum.values();
        for (BookGiftFlagEnum returnTaskStatusEnum : returnTaskStatusEnumList) {
            nameMap.put(returnTaskStatusEnum.getValue(), returnTaskStatusEnum.getName());
        }

        if (keyMap == null) {
            keyMap = new HashMap<>();
            for (BookGiftFlagEnum enumOne : BookGiftFlagEnum.values()) {
                keyMap.put(enumOne.toString(), enumOne.getValue());
            }
        }
    }
}
