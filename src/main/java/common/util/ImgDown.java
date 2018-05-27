/**
 * Copyright (C), 2018-2018
 * FileName: ImgDown
 * Author:   jinshuai
 * Date:     2018/5/27 17:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/27
 * @since 1.0.0
 */

public class ImgDown {
    public static String getImgDwon(String url){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String type=url.substring(url.lastIndexOf(".")).trim();
        String url1= url.substring(0, url.indexOf("/")+1).trim();
        String url2= url.substring(url.indexOf("/")+1).trim();
        if(!url2.substring(0, url.indexOf("/")).trim().equals("/")){
            url=url1+"/"+url2;
        }
         String path = request.getSession().getServletContext().getRealPath("sharebook/img/").trim(); //文件存储位置
         String fileName=DateUtils.getNowTimeStamp()+"_"+new Random().nextInt(10000)+type;

        downloadPicture(url,path+fileName.trim());
        return fileName;
    }
    //链接url下载图片
    private static void downloadPicture(String urlList,String path) {
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
