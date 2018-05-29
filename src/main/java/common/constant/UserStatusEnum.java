package common.constant;

import java.util.HashMap;
import java.util.Map;


public enum UserStatusEnum {
    STAUS(ConstantsUtils.UserShareCode.STATUS,"可用"),
    STATUS_NOT(ConstantsUtils.UserShareCode.STATUS_NOT,"不可用"),
    USER_SELF_STATUS(ConstantsUtils.UserShareCode.USER_SELF_STATUS,"自营");

    private static Map<Integer, String> nameMap;
    private static Map<String, Integer> keyMap;


    private Integer value;

    private String name;

    UserStatusEnum(Integer value, String name){
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
        UserStatusEnum[] returnTaskStatusEnumList = UserStatusEnum.values();
        for (UserStatusEnum returnTaskStatusEnum : returnTaskStatusEnumList) {
            nameMap.put(returnTaskStatusEnum.getValue(), returnTaskStatusEnum.getName());
        }

        if (keyMap == null) {
            keyMap = new HashMap<>();
            for (UserStatusEnum enumOne : UserStatusEnum.values()) {
                keyMap.put(enumOne.toString(), enumOne.getValue());
            }
        }
    }
}
