package com.xy;

import com.xy.requests.OcrNormalReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loader {
    private final Logger logger = LoggerFactory.getLogger(Loader.class);

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println("please enter 3 parameters: image url & type[basic/table] & comment");
            System.out.println("example: java -jar ocr-position-1.0-SNAPSHOT.jar /Users/xy/Desktop/e.png normal comment");
            return;
        }
        String path = args[0];
        String typeStr = args[1];
        String comment = args[2];
        if (!typeStr.equals("normal")) {
            System.out.println("type should be in normal or table");
            return;
        }
        OcrType type = OcrType.valueOf(typeStr);
        Loader loader = new Loader();
        loader.run(path, type, comment);
    }

    public void run(String path, OcrType type, String comment) throws Exception {
        System.out.println("request path: " + path);
        System.out.println("request type: " + type.toString());
        System.out.println("comment " + type.toString());
        switch (type) {
            case table:
                throw new Exception("ocr type not support: " + type.name());
            case normal:
                OcrNormalReq req = new OcrNormalReq();
                String result = req.request1(path, comment);
                System.out.println("result: " + result);
                break;
            case frequency:
                throw new Exception("ocr type not support: " + type.name());
            default:
                throw new Exception("ocr type not support: " + type.name());
        }
    }
}
