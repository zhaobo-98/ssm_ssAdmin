package com.imust.constant;

/**
 * 常量池类 存放固定信息 方便以后查询 好找
 */
public interface Constant {
    //异常信息 床位有人居住信息 此处还可以放置其他的静态内容信息
    //ctrl + shift + u 快速切换大小写
    public static String BEDROOM_HAVE_STUDENT="该床位有学生居住,请先让学生退住";

    public static String DORMITORY_HAVE_ROOM = "该宿舍楼下有宿舍,请先删除宿舍";

    public static String ROOM_HAVE_BEDROOM = "该宿舍下有的床位,请先删除床位";
}
