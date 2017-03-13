package com.handsure.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Arvin.Cao
 * @version 2.0
 * @time 17/01/03 下午16:43
 * @Description 响应操作, 用于请求完成后, 对响应数据的操作
 */
public class Response {
    private final static String MESSAGE = "msg";//消息名称常量
    private final static String CODE = "code";//状态码名称常量
    private final static String DATA = "data";//数据名称常量
    private final static String ERROR = "error";//错误处理的常量键值


    /**
     * 请求成功,无需返回结果集
     */
    public static ResponseEntity<Object> success() {
        return getEntity(null, "success", HttpStatus.NO_CONTENT);
    }

    private static ResponseEntity<Object> getEntity(Object body, String msg,
                                                    HttpStatus statusCode) {
        MultiValueMap<String, String> headers = new HttpHeaders();
        List<String> contentType = new ArrayList<String>();
        contentType.add("application/json;charset=utf-8");
        headers.put("Content-Type", contentType);
        Map<String, Object> data = new HashMap<>();
        data.put(CODE, statusCode.value());
        //错误信息
        if (statusCode.value() >= 400) {
            data.put(ERROR, body);
        } else {
            data.put(DATA, body);
        }
        return new ResponseEntity(data, headers, statusCode);
    }

    /**
     * 请求成功,并返回请求结果集
     *
     * @param object 返回到客户端的对象
     * @return Spring mvc ResponseEntity
     */
    public static ResponseEntity<Object> success(Object object, String msg) {
        return getEntity(object, msg, HttpStatus.OK);
    }

    /**
     * 201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。
     *
     * @param msg
     * @return
     */
    public static ResponseEntity<Object> created_201(String msg) {
        return getEntity(null, msg, HttpStatus.CREATED);
    }

    /**
     * 202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）
     *
     * @param msg
     * @return
     */
    public static ResponseEntity<Object> accepted_202(String msg) {
        return getEntity(null, msg, HttpStatus.ACCEPTED);
    }

    /**
     * 204 NO CONTENT - [DELETE]：用户删除数据成功。
     *
     * @param msg
     * @return
     */
    public static ResponseEntity<Object> noContent_204(String msg) {
        return getEntity(null, msg, HttpStatus.NO_CONTENT);
    }

    /**
     * 400 INVALID REQUEST - [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。
     *
     * @param msg
     * @return
     */
    public static ResponseEntity<Object> badRequest_400(String msg) {
        return getEntity(null, msg, HttpStatus.BAD_REQUEST);
    }

    /**
     * 401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。
     *
     * @param msg
     * @return
     */
    public static ResponseEntity<Object> unauthorized_401(String msg) {
        return getEntity(null, msg, HttpStatus.UNAUTHORIZED);
    }

    /**
     * 403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
     *
     * @param msg 请求失败的错误信息
     * @return Spring mvc ResponseEntity
     */
    public static ResponseEntity<Object> authorityFailed_403(String msg) {
        return getEntity(null, msg, HttpStatus.FORBIDDEN);
    }

    /**
     * 404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
     *
     * @return Spring mvc ResponseEntity
     */
    public static ResponseEntity<Object> notFound_404(String msg) {
        return getEntity(null, msg, HttpStatus.NOT_FOUND);
    }


    /**
     * 406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
     *
     * @param msg
     * @return Spring mvc ResponseEntity
     */
    public static ResponseEntity<Object> notAccepted_406(
            String msg) {
        return getEntity(null, msg, HttpStatus.NOT_ACCEPTABLE);
    }


    /**
     * 410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的
     *
     * @param msg
     * @return
     */
    public static ResponseEntity<Object> gone_410(String msg) {
        return getEntity(null, msg, HttpStatus.GONE);
    }

    /**
     * 422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
     *
     * @param msg
     * @return
     */
    public static ResponseEntity<Object> unprocesableEntity_420(String msg) {
        return getEntity(null, msg, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * 500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。
     *
     * @param msg 请求失败的错误信息 500
     * @return Spring mvc ResponseEntity
     */
    public static ResponseEntity<Object> serverError_500(String msg) {
        return getEntity(null, msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
