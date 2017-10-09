package com.imark.common.sysdic;
/**
* 类名: UserStateEnum
* 包名: com.imark.common.sysdic
* 描述: 用户状态枚举类
* 创建人: ycwu3
* 创建时间: 2017/9/30 11:03
**/
public enum  UserStateEnum {

    REGISTER("注册",1),USE("在用",2),LOCKED("锁定",3),DELETED("删除",4);

    // 成员变量
    private String name;
    private int code;

    //构造方法
    UserStateEnum(String name, int code) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    // 普通方法
    public static String getNameByCode(int code) {
        for (UserStateEnum state : UserStateEnum.values()) {
            if (state.getCode() == code) {
                return state.name;
            }
        }
        return null;
    }


}
