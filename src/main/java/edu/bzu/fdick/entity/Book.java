package edu.bzu.fdick.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bookinfo")
public class Book {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.INPUT)
    private String ISBN;
    private String bookName;
    private String author;
    private String imageFile;
    private String press;
    private int categoryID;
    private String description;
    private Double price;


}
