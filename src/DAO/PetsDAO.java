package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Pet;

public class PetsDAO {
    private static String url = "jdbc:mysql://localhost:3306/test_local?useSSL=false&useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static List<Pet> getAll() throws Exception {
        try (Connection con = DriverManager.getConnection(url, "god", "fser")) {
            Statement stmt = con.createStatement();
            List<Pet> result = new ArrayList<>();
            ResultSet rs = stmt.executeQuery("SELECT pets.*, men.name as mname FROM pets JOIN men on master_id = men.id");
            while (rs.next()) {
                Pet pet = new Pet();
                pet.setMasterName(rs.getString("mname"));
                pet.setMaster(rs.getInt("master_id"));
                pet.setId(rs.getInt("id"));
                pet.setName(rs.getString("name"));
                pet.setAge(rs.getInt("age"));
                result.add(pet);
            }
            return result;
        }
    }
    public static Pet get(int id) throws Exception {
        try (Connection con = DriverManager.getConnection(url, "god", "fser")) {
            Client client = new Client();
            Pet pet = new Pet();
            List<Object> values = new ArrayList<>();
            values.add(id);
            PreparedStatement pstmt = client.getPreparedStatement("SELECT * FROM pets WHERE id = ?;", values, con);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                pet.setName(rs.getString("name"));
                pet.setAge(rs.getInt("age"));
                pet.setMaster(rs.getInt("master_id"));
            }
            return pet;
        }
    }
    public static int updatePet (int id, UpdateArgs[] args) throws Exception
    {
        if (args.length == 0) return -1;
        try (Connection con = DriverManager.getConnection(url, "god", "fser")) {
            Client client = new Client();
            String query = "UPDATE pets SET ";
            List<Object> values = new ArrayList<>();
            for (UpdateArgs arg: args) {
                query += arg.field + " = ?,";
                values.add(arg.value);
            }
            query = query.substring(0, query.length() - 1);
            query += " WHERE id = ?;";
            values.add(id);
            PreparedStatement pstmt = client.getPreparedStatement(query, values, con);
            int result = pstmt.executeUpdate();
            return result;
        }
    }
    public static int createPet (String name, int age) throws Exception
    {
        try (Connection con = DriverManager.getConnection(url, "god", "fser")) {
            Client client = new Client();
            List<Object> values = new ArrayList<>();
            values.add(name);
            values.add(age);
            PreparedStatement pstmt = client.getPreparedStatement("INSERT INTO pets (name, age) VALUES (?, ?)", values, con);
            pstmt.execute();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id FROM pets ORDER BY created DESC;");
            int result = -1;
            while (rs.next()) {
                result = rs.getInt("id");
            }
            return result;
        }
    }
    public static int deletePet (Integer id) throws Exception
    {
        try (Connection con = DriverManager.getConnection(url, "god", "fser")) {
            Client client = new Client();
            List<Object> values = new ArrayList<>();
            values.add(id);
            PreparedStatement pstmt = client.getPreparedStatement("DELETE FROM pets WHERE id = ?", values, con);
            int result = pstmt.executeUpdate();
            return result;
        }
    }
}
