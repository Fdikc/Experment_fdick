package edu.bzu.fdick.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "userinfo")
public class User {
    @TableId(type = IdType.AUTO)
    private int id;
    private String userName;
    private String userPass;
    private String sex;
    private int age;
    private String hobby;
}
