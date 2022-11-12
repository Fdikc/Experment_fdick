package edu.bzu.fdick.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "orderitem")
public class OrderAndISBN {

    private String orderID;
    private String bookISBN;
    private int buynum;

}
