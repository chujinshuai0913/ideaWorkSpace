package common.constant;

import java.util.HashMap;
import java.util.Map;


public enum BookTardeEnum {
    TRADE(ConstantsUtils.BookTradeCode.TRADE,"交易中"),
    TRADE_NOT(ConstantsUtils.BookTradeCode.TRADE_NOT,"未交易"),
    TRADE_STOP(ConstantsUtils.BookTradeCode.TRADE_STOP,"交易中");

    private static Map<Integer, String> nameMap;
    private static Map<String, Integer> keyMap;


    private Integer value;

    private String name;

    BookTardeEnum(Integer value, String name){
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
        BookTardeEnum[] returnTaskStatusEnumList = BookTardeEnum.values();
        for (BookTardeEnum returnTaskStatusEnum : returnTaskStatusEnumList) {
            nameMap.put(returnTaskStatusEnum.getValue(), returnTaskStatusEnum.getName());
        }

        if (keyMap == null) {
            keyMap = new HashMap<>();
            for (BookTardeEnum enumOne : BookTardeEnum.values()) {
                keyMap.put(enumOne.toString(), enumOne.getValue());
            }
        }
    }
}
