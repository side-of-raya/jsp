package DAO;

import java.sql.*;
import java.util.List;
public class Client {
    public Client() throws java.lang.ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
    public PreparedStatement getPreparedStatement(String sql, List<Object> values, Connection con) throws Exception {
        PreparedStatement statement = con.prepareStatement(sql);
        int valueCount = 0;
        for( Object value: values ) {
            valueCount++;
            if( value instanceof Integer) {
                statement.setInt(valueCount, (int)value);
            } else if( value instanceof String) {
                statement.setString(valueCount, (String)value);
            }
        }
        return statement;
    }
}