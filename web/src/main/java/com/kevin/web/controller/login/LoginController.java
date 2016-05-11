package com.kevin.web.controller.login;

import com.kevin.framework.common.ResultCode;
import com.kevin.framework.utils.MD5Util;
import com.kevin.model.User;
import com.kevin.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
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
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by sunboy on 2016/4/19.
 */
@Controller
public class LoginController {
    @Autowired
    private UserServiceImpl userService;

    private final static long TOKENVALIDDATE = 7*24*60*60*1000;

    /**
     * 用户登录
     * @return
     */
    @RequestMapping(value = "/login.json",method = RequestMethod.GET)
    @ResponseBody
    public ResultCode login(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ){

        int id = userService.getUserIdByName(username, MD5Util.stringToMD5(password));
        System.out.println("id =  " + id);

        if (id == -1){
            return null;
        }

        User user = userService.getUserById(id);
        String token = generateTokenByUsername(username);

        System.out.println("user = " + user);
        System.out.println("id = " + user.getId());
        System.out.println("nickname = " + user.getNickname());

        user.setToken(token);
        user.setTokenTime(new Date());

        userService.updateUser(user);

        ResultCode result = new ResultCode();
        result.setData(token);

        return result;
    }

    /**
     * 用户注册
     * @return
     */
    @RequestMapping(value = "/register.json",method = RequestMethod.GET)
    @ResponseBody
    public ResultCode register(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ){
        User user = new User();
        user.setUsername(username);
        user.setPassword(MD5Util.stringToMD5(String.valueOf(password)));
//        System.out.println("user.getPassword() = " + user.getPassword());

        System.out.println("recv username =  " + username);

        int count = userService.checkUserByName(username, password);
        System.out.println("count = " + count);

        ResultCode result = new ResultCode();
        if (count == 0){
            String token = generateTokenByUsername(username);
            user.setToken(token);
            user.setTokenTime(new Date());
            user.setAliasname(generateAliasname(username, password));

            System.out.println("username = " + user.getUsername());

            userService.insertUser(user);
            result.setData(token);
            return result;
        }

        result.setErrCode(100);
        result.setErrMsg("user existed");

        return result;
    }

    /**
     * 检查token是否有效
     * @param token
     * @return
     */
    @RequestMapping(value = "/checktoken.json", method = RequestMethod.GET)
    @ResponseBody
    public ResultCode checkToken(@Param("token")String token){
        ResultCode result = new ResultCode();

        Date date = userService.getTokenTimeByToken(token);
        System.out.println("date = " + date);

        long difftime = new Date().getTime() - date.getTime();
        System.out.println("difftime = " + difftime);

        if(difftime < TOKENVALIDDATE){
            result.setErrMsg("in the valid");
            result.setData(true);
        }else{
            result.setErrMsg("out of the valid");
            result.setData(false);
        }
        return result;
    }

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    @RequestMapping(value = "/userinfo.json", method = RequestMethod.GET)
    @ResponseBody
    public ResultCode getUserInfo(@Param("token")String token){
        ResultCode result = new ResultCode();

        User user = userService.getUserByToken(token);

        result.setData(user);

        return result;
    }

    /**
     * 获取用户别名
     * @param userid
     * @return
     */
    @RequestMapping(value = "/getaliasname.json",method = RequestMethod.GET)
    @ResponseBody
    public ResultCode getAliasname(@Param("userid")String userid){
        ResultCode result = new ResultCode();

        String aliasname = userService.getAliasnameById(Integer.parseInt(userid));

        result.setData(aliasname);
        return result;
    }

    /**
     * 更新用户信息
     * @param token
     * @param file
     * @param nickname
     * @param sex
     * @param signature
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateuser.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultCode updateUser(
            @Param("token")String token,
            @RequestParam(value="file",required=false) MultipartFile file,
            @RequestParam(value = "nickname", required = false)String nickname,
            @RequestParam(value = "sex", required = false)String sex,
            @RequestParam(value = "signature", required = false)String signature,
            HttpServletRequest request
    ){
        ResultCode result = new ResultCode();

        User user = userService.getUserByToken(token);

        if (file != null){
            String path = storePic(request, file);
            user.setPicPath(path);
        }

        if(nickname != null){
            user.setNickname(nickname);
        }

        if (sex != null){
            user.setSex(Integer.valueOf(sex));
        }

        if (signature != null){
            user.setSignature(signature);
        }
        userService.updateUser(user);
        return result;
    }




    public String generateTokenByUsername(String username) {
        int random = new Random(System.currentTimeMillis()).nextInt();
        String joint = String.valueOf(System.currentTimeMillis()) + random + username;
        String token = MD5Util.stringToMD5(joint);
        System.out.println("token = " + token);
        return token;
    }


    public String generateAliasname(String username,String password) {
        int random = new Random(System.currentTimeMillis()).nextInt();
        String joint = String.valueOf(System.currentTimeMillis()) + random + username + password;
        String token = MD5Util.stringToMD5(joint);
        System.out.println("token = " + token);
        return token;
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
