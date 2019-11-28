package com.dsql.service.impl;

import com.alibaba.fastjson.JSON;
import com.dsql.core.EntityUtil;
import com.dsql.service.commService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class commServiceImpl implements commService {

    @Autowired
    DataSource dataSource;

    @Override
    public Object select(String param) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = dataSource.getConnection();
            statement = conn.prepareStatement(param);
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int colum = rsmd.getColumnCount();
            Map<String, Object> map = new HashMap<>(2);
            List<Object> list = new ArrayList<>();
            Object value = null;
            while (resultSet.next()) {
                for (int i = 1; i <= colum; i++) {
                    //获取列名
                    String columName = rsmd.getColumnName(i);
                    //获取每一列的数据类型
                    int type = rsmd.getColumnType(i);
                    //判断

                    if (Types.INTEGER == type||Types.FLOAT==type) {
                        // typeStr = "Integer";
                        value = resultSet.getDouble(i);
                    } else if (Types.VARCHAR == type||Types.CHAR==type||Types.BLOB==type||Types.NCHAR==type||Types.NVARCHAR==type) {
                        //  typeStr = "String";
                        value = resultSet.getString(i);
                    }else if(Types.TIMESTAMP==type){
                        value = resultSet.getTimestamp(i);
                     }
                    else if(Types.DATE==type ){
                        value = resultSet.getDate(i);
                    }
                    map.put(columName, value);
                }
                list.add(EntityUtil.creatBean(map));
                map.clear();
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn.isClosed()) {
                conn.close();
            }
            if (statement.isClosed()) {
                statement.close();
            }
         }
        return null;
    }
}
