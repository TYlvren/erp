package com.cskaoyan.erp.util;


import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Flying Elephant
 * Date 2019/4/6 0006 Time 9:23
 */

public class DeviceUtils {

    private DeviceUtils() {
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
            map.put("msg", "操作失败");
        }
        return map;
    }

    public static Map<String, Object> returnPageInfo(List list) {
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;

    }
}
