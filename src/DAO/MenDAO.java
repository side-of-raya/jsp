package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class MenDAO {
    private static final String url = "jdbc:mysql://localhost:3306/test_local?useSSL=false&useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static List<Man> getAll() throws Exception {
        List<Man> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, "god", "fser")) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM men");
            while (rs.next()) {
                Man man = new Man();
                man.setId(rs.getInt("id"));
                man.setName(rs.getString("name"));
                man.setAge(rs.getInt("age"));
                result.add(man);
            }
            return result;
        }
    }
    public static int updateMan (int id, Man man) throws Exception
    {
        try (Connection con = DriverManager.getConnection(url, "god", "fser")) {
            Client client = new Client();
            String query = "UPDATE men SET ";
            List<Object> values = new ArrayList<>();
            if (man.getName() != null) {
                query += "name = ?,";
                values.add(man.getName());
            }
            if (man.getAge() != 0) {
                query += "age = ?,";
                values.add(man.getAge());
            }
            query = query.substring(0, query.length() - 1);
            query += " WHERE id = ?;";
            values.add(id);
            PreparedStatement pstmt = client.getPreparedStatement(query, values, con);
            return pstmt.executeUpdate();
        }
    }
    public static int createMan (String name, int age) throws Exception
    {
        try (Connection con = DriverManager.getConnection(url, "god", "fser")) {
            Client client = new Client();
            List<Object> values = new ArrayList<>();
            values.add(name);
            values.add(age);
            PreparedStatement insertPstmt = client.getPreparedStatement("INSERT INTO men (name, age) VALUES (?, ?)", values, con);
            insertPstmt.execute();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id FROM men ORDER BY created DESC;");
            int result = -1;
            while (rs.next()) {
                result = rs.getInt("id");
            }
            return result;
        }
    }
    public static int deleteMan (Integer id) throws Exception
    {
        try (Connection con = DriverManager.getConnection(url, "god", "fser")) {
            Client client = new Client();
            List<Object> values = new ArrayList<>();
            values.add(id);
            PreparedStatement pstmt = client.getPreparedStatement("DELETE FROM men WHERE id = ?", values, con);
            return pstmt.executeUpdate();
        }
    }
}