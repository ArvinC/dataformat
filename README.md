响应数据格式化规范示例
========
暨信信息科技后端Restful数据格式定义,请往后严格遵照此示例

- _下方会给出状态码对照表._


数据格式
========
```JSON
{
  "msg": "请求成功",
  "code": 200,
  "data": {
    "list": [
      "handsure0",
      "handsure1",
      "handsure2",
      "handsure3",
      "handsure4",
      "handsure5",
      "handsure6",
      "handsure7",
      "handsure8",
      "handsure9"
    ],
    "username": "caojiawei"
  }
}
```
说明:

    [msg]:响应说明
    [code]:响应状态码,一般此处以Http状态码.
    [data]:响应数据主体
    
状态码
========
    - _说明:此处根据HTTP状态码,一般204状态,返回的数据为空白页,此处进行了调整,HTTP请求头状态码为200,code显示204,方便前端判断_
    
    请求成功
        200 Success  请求成功
        204 No content 返回数据为空
    
    
    请求错误
        400 Bad Request 错误的参数 
        401 Unauthorized 用户没有权限
        403 Forbidden 无法执行该请求，应用级别的权限失败
        404 Not Found 找不到请求，检查URL
        405 Method Not Allowed 方法不允许
        408 Request Timeout 请求超时
        415 Unsupported Media Type 不支持的数据格式类型
        
    
    响应错误
        500 Server Error 服务器错误