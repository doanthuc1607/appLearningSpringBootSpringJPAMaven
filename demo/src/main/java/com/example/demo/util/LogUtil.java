package com.example.demo.util;

import org.slf4j.Logger;

//tái sử dụng pt khi nào cần sử dụng gì hoặc chỉnh sửa sẽ thông qua lớp này
public class LogUtil {
    //log debug
    //method receive a logger and a string message
    public static void logDebug(Logger logger, String message){//void as don't have no return result
            logger.debug(message);
    }

    //log error
    public static void logError(Logger logger, String message){
        logger.error(message);
    }
}
