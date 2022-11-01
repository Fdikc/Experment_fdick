package edu.bzu.fdick.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DuridDataSourceFactoryUtil extends UnpooledDataSourceFactory {

    public DuridDataSourceFactoryUtil(){
        this.dataSource = new DruidDataSource();
    }

    @Override
    public DataSource getDataSource() {
        try {
            ((DruidDataSource)this.dataSource).init(); //初始化Druid数据源
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
        return this.dataSource;
    }
}
