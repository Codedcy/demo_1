package com.example.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;

@Controller  
public class UserController {  
  
	@Autowired
	private UserService userService;
    @Autowired  
    private UserMapper userMapper;  
      
    @Value("${cbs.imagesPath}")
    private String theSetDir; //全局配置文件中设置的图片的路径
    
    
    @RequestMapping("/getUser")  
    @ResponseBody
    public List<User> getUser(Integer userId) {  
        if(userId == null) {  
            userId = 1;  
        }  
        return userMapper.getById(userId);  
    }  
      
    @RequestMapping("/getAll")  
    @ResponseBody
    public List<User> getAll(){
    	return userMapper.getAll();
    }
    
    @RequestMapping("/addUser") 
    @ResponseBody
    public User addUser(User user) {  
        userMapper.add(user);  
        return user;  
    }  
    
    @RequestMapping("/personInfo")
    public String personInfo() {
    	return "personInfo";
    }
   	
    
    @RequestMapping("/updateUser") 
    public String updateUser(User user , HttpServletRequest request , MultipartFile headImg, Model model) throws Exception {  
    	
    	if(!headImg.getOriginalFilename().equals("")) {
    		String parentDirPath = theSetDir.substring(theSetDir.indexOf(':')+1, theSetDir.length()); //通过设置的那个字符串获得存放图片的目录路径
            String realFileName = headImg.getOriginalFilename();
            String fileSuf = realFileName.substring(realFileName.lastIndexOf(".")+1);
            String fileName = "head"+user.getUserId()+"."+fileSuf;
            File parentDir = new File(parentDirPath);
            if(!parentDir.exists()) //如果那个目录不存在先创建目录
            {
                parentDir.mkdir();
            }
            File hi = new File(parentDirPath + fileName);
            headImg.transferTo(hi); //全局配置文件中配置的目录加上文件名
            user.setHeadUrl(fileName);
            userService.updateUser(user);
    	}else {
    		userService.updateUserWithoutHead(user);
    		user = userService.getByUserId(user.getUserId());
    	}
		
    	HttpSession session = request.getSession();
    	session.setAttribute("user", userService.getByUserId(user.getUserId()));
        return "personInfo";
    	
    	
    }	
    
    @RequestMapping(value = "/get",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public BufferedImage getImage() throws IOException {
        return ImageIO.read(new FileInputStream(new File("D:/test.jpg")));
    }
    
    @RequestMapping("/updateUserPassWord")
    @ResponseBody
    public Map<String,Integer> updateUserPassWord(User user) {
    	Map<String,Integer> map = new HashMap<String,Integer>();
    	if(userService.updateUserPassWord(user) == 1) {
    		map.put("flag", 1);
    	}else {
    		map.put("flag", 0);
    	}
    	return map;
    	
    }
    
      
}  