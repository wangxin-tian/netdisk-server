package com.dhx.config;

import java.util.HashMap;

/**
 * 自定义返回数据（我们通过AjaxResult类返回的都是hashmap格式的对象
 * 之后还有通过@ResponseBody将java对象转成json格式的数据
 */
public class AjaxResult {
    /**
     * 操作成功（无msg）
     * @param data
     * @return
     */
    public static Object  success(Object data) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", 200);
        result.put("msg", "");
        result.put("data", data);
        return result;
    }

    /**
     * 操作成功，有msg
     * @param msg
     * @param data
     * @return
     */
    public static Object success(Object msg, Object data) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", 200);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    /**
     * 操作失败（无data
     * @param state
     * @param msg
     * @return
     */
    public static Object fail(int state, Object msg) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", state);
        result.put("msg", msg);
        result.put("data", "");
        return result;
    }

    /**
     * 操作失败（有data)
     * @param state
     * @param msg
     * @param data
     * @return
     */
    public static Object fail(int state, Object msg,  Object data) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", state);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }
}
