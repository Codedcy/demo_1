package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.example.bean.User;
/*mapper接口*/

//1 @Mapper将UserDao声明为一个Mapper接口
//2 @Results是结果映射列表，@Result中property是User类的属性名，colomn是数据库表的字段名
//3 @Select, @Insert 分别代表了执行的真实SQL

@Component
@Mapper  
public interface UserMapper {  
  
    @Select("select * from users where userId = #{userId}")  
    public List<User> getById(Integer userId);  
      
    @Select("select userId from users where userId <> #{userId}")  
    public List<Integer> getAllIdWithoutOne(int userId);  
    
    @Select("select * from users where email = #{email}")  
    public List<User> getByEmail(String email);  
    
    @Select("select * from users")  
    public List<User> getAll();  
    
    @Options(useGeneratedKeys=true,keyProperty="userId")  
    @Insert("insert into users(userName,email,passWord) values(#{userName},#{email},#{passWord})")  
    public Integer add(User user);   
     
    @Update("update users set userName=#{userName} , sex=#{sex} , introduction=#{introduction} , birthDate=#{birthDate} , headUrl=#{headUrl} where userId=#{userId}")  
    public Integer updateUser(User user);  
    
    @Update("update users set userName=#{userName} , sex=#{sex} , introduction=#{introduction} , birthDate=#{birthDate} where userId=#{userId}")  
    public Integer updateUserWithoutHead(User user);
    
    @Update("update users set passWord=#{passWord} where userId=#{userId}")  
    public Integer updateUserPassWord(User user); 
}  

