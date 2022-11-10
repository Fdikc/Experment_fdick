package edu.bzu.fdick.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName orderinfo
 */
@TableName(value ="orderinfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 
     */
    private Integer userid;

    /**
     * 
     */
    private Double money;

    /**
     * 
     */
    private String receiveraddress;

    /**
     * 
     */
    private String receivername;

    /**
     * 
     */
    private String receiverphone;

    /**
     * 
     */
    private Date ordertime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

//
//    @Override
//    public String toString() {
//        return "Order{" +
//                "id='" + id + '\'' +
//                ", userid=" + userid +
//                ", money=" + money +
//                ", receiveraddress='" + receiveraddress + '\'' +
//                ", receivername='" + receivername + '\'' +
//                ", receiverphone='" + receiverphone + '\'' +
//                ", ordertime=" + ordertime +
//                '}';
//    }
}