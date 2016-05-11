package com.kevin.web.controller.community;

import com.kevin.framework.common.ResultCode;
import com.kevin.model.info.BaseGroupInfo;
import com.kevin.model.info.UniversityInfo;
import com.kevin.service.ClubInfoService;
import com.kevin.service.UniversityInfoService;
import com.kevin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by spirit on 2016/3/4.
 */
@Controller
public class CommunityController {

    @Autowired
    private UniversityInfoService universityInfoService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ClubInfoService clubInfoService;

    @RequestMapping(value = "/university_info.json",method = RequestMethod.GET)
    public @ResponseBody
    ResultCode getUniversityInfo(
            @RequestParam("userId") int userId,
            @RequestParam("universityId") int universityId){
        ResultCode<UniversityInfo> result = new ResultCode();
        UniversityInfo universityInfo = universityInfoService.getUniversityInfo(universityId);
        result.setData(universityInfo);
        return result;
    }


    @RequestMapping(value = "/user_joined_group.json",method = RequestMethod.GET)
    public @ResponseBody
    ResultCode getJoinedGroup(@RequestParam("userId") int userId){

        ResultCode<List<BaseGroupInfo>> result = new ResultCode();
        List<BaseGroupInfo> list = userInfoService.queryUserJoined(userId);
        result.setData(list);
        return result;
    }

    @RequestMapping(value = "/user_in_group.json",method = RequestMethod.GET)
    public @ResponseBody
    ResultCode userJoinGroup(@RequestParam("userId") int userId,
                             @RequestParam("groupId") int groupId){

        ResultCode<Integer> result = new ResultCode();
        int ret = userInfoService.userJoinClub(userId, groupId);
        result.setData(ret);
        return result;
    }


    @RequestMapping(value = "/create_group.json",method = RequestMethod.GET)
    public @ResponseBody
    ResultCode userCreateGroup(@RequestParam("name") String clubName,
                               @RequestParam("desc") String clubDescribe,
                               @RequestParam(value="file",required=false) MultipartFile file,
                               @RequestParam("categoryId") int categoryId,
                               HttpServletRequest request,
                               @RequestParam("userId") int userId){

        ResultCode<Integer> result = new ResultCode();
        String path = storePic(request, file);
        int ret = clubInfoService.userCreateClub(userId,clubName,clubDescribe,categoryId,path);
        if (ret == -1){
            result.setErrMsg("已存在相同名称的组织,创建失败");
            result.setErrCode(-1);
        }
        result.setData(ret);
        return result;
    }

    private String storePic(HttpServletRequest request,MultipartFile file){
        //获得物理路径webapp所在路径
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path2 = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path2+"/";
        System.out.println(pathRoot);
        System.out.println(basePath);
        String urlPath = "";
        String path="";
        String uuid = null;
        if(!file.isEmpty()){
            //生成uuid作为文件名称
            uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=file.getContentType();
            //获得文件后缀名称
            String imageName=contentType.substring(contentType.indexOf("/")+1);
            path="/WEB-INF/img/"+uuid+".jpg";
            urlPath = "/img/"+uuid+"."+imageName;
            try {
                file.transferTo(new File(pathRoot+path));
                return "img/"+uuid+".jpg";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
