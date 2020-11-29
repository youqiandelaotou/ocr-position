package com.xy.requests;

public class SmartReq {
    /*
      request body:
      image	和url二选一	string	-	图像数据，base64编码后进行urlencode，要求base64编码和urlencode后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式
      url	和image二选一	string	-	图片完整URL，URL长度不超过1024字节，URL对应的图片base64编码后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式，当image字段存在时url字段失效
      请注意关闭URL防盗链
      detect_direction	否	string	true/false	是否进行方向检测及矫正，默认为 false，可缺省
      - false：不进行方向矫正，返回参数 direction 固定为 0
      - true：开启自动方向矫正功能，可识别旋转90/180/270度的图片，并返回 direction 检测数值
      detect_null_word	否	string	true/false	是否返回未成功匹配的Key/Value值，缺少的对应 Value/Key 置为 NULL，默认为 false，可缺省
      - false：不返回未匹配成功的单独 Key/Value，仅返回成功匹配的 KV 结果组
      - true：返回未匹配成功的单独 Key/Value，缺少的对应 Value/Key 置为 NULL
      probability	否	string	true/false	是否返回字段识别结果的置信度，默认为 false，可缺省
      - false：不返回字段识别结果的置信度
      - true：返回字段识别结果的置信度，包括字段识别结果中各字符置信度的平均值（average）、最小值（min）和方差（variance）
     */

    /*
      response body:
      log_id	是	uint64	调用日志id，用于问题定位
      direction	是	int	图片旋转角度，当请求参数 detect_direction=true 时，返回图片方向检测结果 0/1/2/3 分别代表 不旋转、逆时针旋转 90/180/270度
      words_result_num	是	uint32	识别结果数，表示words_result的元素个数
      words_result	是	array	识别结果数组
      + key	是	object	关键词信息，与 value 一一对应，形成 key：value 结构化识别结果组
      ++ word	是	string	识别结果
      ++ location	是	object	字段位置信息
      +++ top	是	int	字段的上边距
      +++ left	是	int	字段的左边距
      +++ height	是	int	字段的高度
      +++ width	是	int	字段的宽度
      ++ probability	否	object	字段识别结果置信度，当请求参数 probability=true 时，以上各字段均包含此参数
      +++ average	否	float	字段识别结果中各字符的置信度平均值
      +++ min	否	float	字段识别结果中各字符的置信度最小值
      +++ variance	否	float	字段识别结果中各字符的置信度方差
      + value	是	object	字段内容，与 key 一一对应，形成 key：value 结构化识别结果组
      ++ word	是	string	识别结果
      ++ location	是	object	字段位置信息
      +++ top	是	int	字段的上边距
      +++ left	是	int	字段的左边距
      +++ height	是	int	字段的高度
      +++ width	是	int	字段的宽度
      ++ probability	否	object	字段识别结果置信度，当请求参数 probability=true 时，以上各字段均包含此参数
      +++ average	否	float	字段识别结果中各字符的置信度平均值
      +++ min	否	float	字段识别结果中各字符的置信度最小值
      +++ variance	否	float	字段识别结果中各字符的置信度方差

     */

    /**
     * response example
     */
    String response = "{\n" +
            "\t\"words_result\": [\n" +
            "\t\t{\n" +
            "\t\t\t\"value\": {\n" +
            "\t\t\t\t\"probability\": {\n" +
            "\t\t\t\t\t\"average\": 0.99977076053619,\n" +
            "\t\t\t\t\t\"min\": 0.99970018863678,\n" +
            "\t\t\t\t\t\"variance\": 4.9803929869086e-9\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"location\": {\n" +
            "\t\t\t\t\t\"top\": 146,\n" +
            "\t\t\t\t\t\"left\": 365,\n" +
            "\t\t\t\t\t\"width\": 50,\n" +
            "\t\t\t\t\t\"height\": 25\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"word\": \"丛齐\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"key\": {\n" +
            "\t\t\t\t\"probability\": {\n" +
            "\t\t\t\t\t\"average\": 0.99997997283936,\n" +
            "\t\t\t\t\t\"min\": 0.99997985363007,\n" +
            "\t\t\t\t\t\"variance\": 1.4210854715202e-14\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"location\": {\n" +
            "\t\t\t\t\t\"top\": 149,\n" +
            "\t\t\t\t\t\"left\": 311,\n" +
            "\t\t\t\t\t\"width\": 40,\n" +
            "\t\t\t\t\t\"height\": 20\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"word\": \"姓名\"\n" +
            "\t\t\t}\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"value\": {\n" +
            "\t\t\t\t\"probability\": {\n" +
            "\t\t\t\t\t\"average\": 0.9999588727951,\n" +
            "\t\t\t\t\t\"min\": 0.9999588727951,\n" +
            "\t\t\t\t\t\"variance\": 0\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"location\": {\n" +
            "\t\t\t\t\t\"top\": 190,\n" +
            "\t\t\t\t\t\"left\": 366,\n" +
            "\t\t\t\t\t\"width\": 20,\n" +
            "\t\t\t\t\t\"height\": 21\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"word\": \"男\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"key\": {\n" +
            "\t\t\t\t\"probability\": {\n" +
            "\t\t\t\t\t\"average\": 0.99983507394791,\n" +
            "\t\t\t\t\t\"min\": 0.99969410896301,\n" +
            "\t\t\t\t\t\"variance\": 1.9871126966109e-8\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"location\": {\n" +
            "\t\t\t\t\t\"top\": 192,\n" +
            "\t\t\t\t\t\"left\": 312,\n" +
            "\t\t\t\t\t\"width\": 39,\n" +
            "\t\t\t\t\t\"height\": 19\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"word\": \"性别\"\n" +
            "\t\t\t}\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"value\": {\n" +
            "\t\t\t\t\"probability\": {\n" +
            "\t\t\t\t\t\"average\": 0.99964165687561,\n" +
            "\t\t\t\t\t\"min\": 0.99964165687561,\n" +
            "\t\t\t\t\t\"variance\": 0\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"location\": {\n" +
            "\t\t\t\t\t\"top\": 228,\n" +
            "\t\t\t\t\t\"left\": 366,\n" +
            "\t\t\t\t\t\"width\": 22,\n" +
            "\t\t\t\t\t\"height\": 20\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"word\": \"汉\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"key\": {\n" +
            "\t\t\t\t\"probability\": {\n" +
            "\t\t\t\t\t\"average\": 0.99994975328445,\n" +
            "\t\t\t\t\t\"min\": 0.99993216991425,\n" +
            "\t\t\t\t\t\"variance\": 3.0917490789761e-10\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"location\": {\n" +
            "\t\t\t\t\t\"top\": 228,\n" +
            "\t\t\t\t\t\"left\": 310,\n" +
            "\t\t\t\t\t\"width\": 41,\n" +
            "\t\t\t\t\t\"height\": 20\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"word\": \"民族\"\n" +
            "\t\t\t}\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"value\": {\n" +
            "\t\t\t\t\"probability\": {\n" +
            "\t\t\t\t\t\"average\": 0.99989211559296,\n" +
            "\t\t\t\t\t\"min\": 0.9996235370636,\n" +
            "\t\t\t\t\t\"variance\": 1.0301564046244e-8\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"location\": {\n" +
            "\t\t\t\t\t\"top\": 262,\n" +
            "\t\t\t\t\t\"left\": 356,\n" +
            "\t\t\t\t\t\"width\": 158,\n" +
            "\t\t\t\t\t\"height\": 21\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"word\": \"1989年7月28日\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"key\": {\n" +
            "\t\t\t\t\"probability\": {\n" +
            "\t\t\t\t\t\"average\": 0.99828881025314,\n" +
            "\t\t\t\t\t\"min\": 0.99683433771133,\n" +
            "\t\t\t\t\t\"variance\": 0.0000021154903606657\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"location\": {\n" +
            "\t\t\t\t\t\"top\": 264,\n" +
            "\t\t\t\t\t\"left\": 312,\n" +
            "\t\t\t\t\t\"width\": 40,\n" +
            "\t\t\t\t\t\"height\": 19\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"word\": \"出生\"\n" +
            "\t\t\t}\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"value\": {\n" +
            "\t\t\t\t\"probability\": {\n" +
            "\t\t\t\t\t\"average\": 0.99985313415527,\n" +
            "\t\t\t\t\t\"min\": 0.99945932626724,\n" +
            "\t\t\t\t\t\"variance\": 1.7040544975089e-8\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"location\": {\n" +
            "\t\t\t\t\t\"top\": 315,\n" +
            "\t\t\t\t\t\"left\": 343,\n" +
            "\t\t\t\t\t\"width\": 297,\n" +
            "\t\t\t\t\t\"height\": 25\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"word\": \"370441198907287001\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"key\": {\n" +
            "\t\t\t\t\"probability\": {\n" +
            "\t\t\t\t\t\"average\": 0.99995613098145,\n" +
            "\t\t\t\t\t\"min\": 0.99990141391754,\n" +
            "\t\t\t\t\t\"variance\": 1.089595969006e-9\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"location\": {\n" +
            "\t\t\t\t\t\"top\": 320,\n" +
            "\t\t\t\t\t\"left\": 191,\n" +
            "\t\t\t\t\t\"width\": 140,\n" +
            "\t\t\t\t\t\"height\": 21\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"word\": \"社会保障号码\"\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\t\"log_id\": \"8733452781125821952\",\n" +
            "\t\"words_result_num\": 5,\n" +
            "\t\"direction\": 0\n" +
            "}";

}
