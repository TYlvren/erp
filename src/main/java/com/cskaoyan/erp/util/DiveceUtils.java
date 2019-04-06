package com.cskaoyan.erp.util;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Flying Elephant
 * Date 2019/4/6 0006 Time 9:23
 */

public class DiveceUtils {

    private DiveceUtils() {
    }


    /**
     * 这是一个用于返回状态码的方法
     * @param i 更新或者修改操作传入的修改行数
     * @return 返回指定的状态
     */
    public static  Map<String, String> returnStatus(int i) {
        Map<String, String> map = new HashMap<>();
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "添加失败");
        }
        return map;
    }
}
