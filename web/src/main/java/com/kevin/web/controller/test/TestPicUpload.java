package com.kevin.web.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * Created by spirit on 2016/2/25.
 */
@Controller
public class TestPicUpload {

    @RequestMapping(value="/upload",method= RequestMethod.POST)
    private String fildUpload(@RequestParam(value="file",required=false) MultipartFile file,
                              HttpServletRequest request)throws Exception{
        //基本表单
        System.out.println("-----");

        //获得物理路径webapp所在路径
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path2 = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path2+"/";
        System.out.println(pathRoot);
        System.out.println(basePath);
        String urlPath = "";
        String path="";
        if(!file.isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=file.getContentType();
            //获得文件后缀名称
            String imageName=contentType.substring(contentType.indexOf("/")+1);
            path="/WEB-INF/img/"+uuid+"."+imageName;
            urlPath = "/img/"+uuid+"."+imageName;
            file.transferTo(new File(pathRoot+path));
        }
        System.out.println(path);

        request.setAttribute("imagesPathList", urlPath);
        return "jsp/show";
    }

    @RequestMapping(value="/forward")
    private String forward(){
        return "jsp/upload";
    }
}
