package com.xy.example;

import com.xy.utils.baidu.Base64Util;
import com.xy.utils.baidu.FileUtil;
import com.xy.utils.baidu.HttpUtil;

import java.net.URLEncoder;

/**
 * 表格文字识别(异步接口)
 */
public class FormOcrRequest {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     *
     * 下载
     */

    /**
     * return success
     * {
     *     "result" : [
     *         {
     *             "request_id" : "1234_6789"
     *         }
     *     ],
     *     "log_id":149689853984104
     * }
     */

    /**
     * return failed
     * {
     *     "log_id": 149319909347709,
     *     "error_code": 282000
     *     "error_msg":"internal error"
     * }
     *
     */
    public static String formOcrRequest() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/solution/v1/form_ocr/request";
        try {
            // 本地文件路径
            String filePath = "[本地文件路径]";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "[调用鉴权接口获取的token]";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FormOcrRequest.formOcrRequest();
    }
    /**
     * 当request_type为json时，result_data格式样例为：
     * {
     * 	"result": {
     * 		"result_data":"{
     * 				"form_num": 1,
     * 				"forms": [
     *                                {
     * 					"footer": [],
     * 					"header": [
     *                    {
     * 						"column": [
     * 							1,
     * 							2
     * 							],
     * 						"probability":0.925165,
     * 						"rect":{"left":1138.0,"top":127.0},
     * 						"row": [
     * 							1
     * 							],
     * 						"word": "表头信息1",
     *                        }
     * 						],
     * 					"body": [
     *                    {
     * 						"column": [
     * 							1,
     * 							2
     * 							],
     * 						"probability":0.999275,
     * 						"rect":{"left":171.0,"top":26.0},
     * 						"row": [
     * 							1
     * 							],
     * 						"word": "单元格文字",
     *                        }
     * 						],
     *                    }
     * 				]
     * 	}
     * }
     */
}