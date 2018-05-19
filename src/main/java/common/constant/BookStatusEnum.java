package common.constant;

import java.util.HashMap;
import java.util.Map;



public enum BookStatusEnum {
    AUDIT(ConstantsUtils.BookAuditCode.AUDIT,"已审核"),
    AUDIT_NOT(ConstantsUtils.BookAuditCode.AUDIT_NOT,"未审核"),
    STOP(ConstantsUtils.BookAuditCode.STOP,"禁卖");

    private static Map<Integer, String> nameMap;
    private static Map<String, Integer> keyMap;


    private Integer value;

    private String name;

    BookStatusEnum(Integer value, String name){
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
        BookStatusEnum[] returnTaskStatusEnumList = BookStatusEnum.values();
        for (BookStatusEnum returnTaskStatusEnum : returnTaskStatusEnumList) {
            nameMap.put(returnTaskStatusEnum.getValue(), returnTaskStatusEnum.getName());
        }

        if (keyMap == null) {
            keyMap = new HashMap<>();
            for (BookStatusEnum enumOne : BookStatusEnum.values()) {
                keyMap.put(enumOne.toString(), enumOne.getValue());
            }
        }
    }
}
