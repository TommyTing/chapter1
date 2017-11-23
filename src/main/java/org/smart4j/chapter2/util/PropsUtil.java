package org.smart4j.chapter2.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性文件工具类
 * Created by admin on 2017/11/23.
 */
public class PropsUtil {

    private static  final Logger LOGGER= LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     */
    public static Properties loadProps(String fileName){
        Properties props=null;
        InputStream is=null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(is==null){
                throw new FileNotFoundException(fileName+"file is not found");
            }
            props=new Properties();
            props.load(is);
        }catch (IOException e){
            LOGGER.error("load properties file failure",e);
        }finally {
            if(is!=null){
                try {
                    is.close();
                }catch (IOException e){
                    LOGGER.error("close file stream failure",e);
                }
            }
        }
        return  props;
    }


}
