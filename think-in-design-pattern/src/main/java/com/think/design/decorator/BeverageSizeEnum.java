package com.think.design.decorator;

/**
 * @author Java男朋友
 * @date 2021-11-04 8:39
 */
public enum BeverageSizeEnum {
    TALL(1, "大杯"),MID(2, "中杯"),SMALL(3, "小杯"),;

    private Integer size;
    private String desc;

    BeverageSizeEnum(Integer size, String desc) {
        this.size = size;
        this.desc = desc;
    }

    public Integer getSize() {
        return size;
    }

    public String getDesc() {
        return desc;
    }
}
