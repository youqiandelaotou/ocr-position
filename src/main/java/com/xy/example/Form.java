package com.xy.example;

import com.xy.utils.baidu.Base64Util;
import com.xy.utils.baidu.FileUtil;
import com.xy.utils.baidu.HttpUtil;

import java.net.URLEncoder;

/**
 * 表格文字识别(同步接口)
 */
public class Form {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */

    /**
     * parameters:
     * log_id	是	long	唯一的log id，用于问题定位
     * forms_result_num	是	uint32	识别结果元素个数
     * forms_result	是	array[]	识别结果
     * -body	是	array[]	表格主体区域
     * -footer	是	array[]	表格尾部区域信息
     * header	是	array[]	表格头部区域信息
     * vertexes_location	是	array[]	表格边界顶点
     *
     */
    public static String form() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/form";
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
        Form.form();
    }
}
