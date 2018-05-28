/**
 * Copyright (C), 2018-2018
 * FileName: ImgController
 * Author:   jinshuai
 * Date:     2018/5/21 18:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package sharebookmanager.controller;

import com.alibaba.fastjson.JSON;
import common.model.ResponseResult;
import common.util.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Random;
import java.io.File;
import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/21
 * @since 1.0.0
 */
@RestController("ImgController")
@RequestMapping("/img")
public class ImgController {

    private static  final Logger logger = Logger.getLogger(ImgController.class);
    @ResponseBody
    @RequestMapping("/uploadImgSimple")
    public String uploadPicture(@RequestParam(value="file",required=false)MultipartFile file,
                                HttpServletRequest request){

        File targetFile=null;
        String msg="";//返回存储路径
        int code=1;
        String fileName=file.getOriginalFilename();//获取文件名加后缀
        if(fileName!=null&&fileName!=""){
            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/sharebook/img/shareactivity/";//存储路径
            String path = request.getSession().getServletContext().getRealPath("sharebook/img/"); //文件存储位置
            // String path = "F:\\study\\code\\idea\\workspace\\ideaWorkSpace\\src\\main\\webapp\\sharebook\\img\\shareactivity";
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName= DateUtils.getNowTimeStamp()+"_"+new Random().nextInt(1000);//新的文件名

            //先判断文件是否存在
            File file1 =new File(path);
            File file2 =new File(path+fileName+fileF);
            //如果文件夹不存在则创建
            if(!file1.exists()  && !file1 .isDirectory()){
                file1.mkdir();
            }
            while(file2.exists()||file2.isDirectory()){
               fileName=fileName+1;
            }
            targetFile = new File(file1, fileName+fileF);
            try {
                file.transferTo(targetFile);
                msg=fileName+fileF;
                code=0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return JSON.toJSONString(ResponseResult.result(code, msg));
    }

}
