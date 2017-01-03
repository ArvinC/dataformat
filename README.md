# 响应数据格式化规范示例
========
暨信信息科技后端Restful数据格式定义,请往后严格遵照此示例

# 数据格式
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