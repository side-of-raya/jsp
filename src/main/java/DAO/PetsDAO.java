package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Pet;

public class PetsDAO {
    public static List<Pet> getAll() throws Exception {
      Client client = new Client();
      Pet pet = new Pet();
      List<Pet> result = new ArrayList<>();
      ResultSet rs = client.getRows("SELECT * FROM pets");
      while (rs.next()) {
        pet.setName(rs.getString("name"));
        pet.setAge(rs.getInt("age"));
        result.add(pet);
      }
      return result;
    }
    public static Pet get(int id) throws Exception {
      Client client = new Client();
      Pet pet = new Pet();
      List<Object> values = new ArrayList<>();
      values.add(id);
      ResultSet rs = client.getRows("SELECT * FROM pets WHERE id = ?;", values);
      while (rs.next()) {
        pet.setName(rs.getString("name"));
        pet.setAge(rs.getInt("age"));
        pet.setMaster(rs.getInt("master_id"));
      }
      return pet;
    }
    public static int updatePet (int id, UpdateArgs[] args) throws Exception
    {
      if (args.length == 0) return -1;
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
      int result = client.getAffected(query, values);
      return result;
    }
    public static int createPet (String name, int age) throws Exception
    {
      Client client = new Client();
      List<Object> values = new ArrayList<Object>();
      values.add(name);
      values.add(age);
      client.execute("INSERT INTO pets (name, age) VALUES (?, ?)", values);
      ResultSet rs = client.getRows("SELECT id FROM pets ORDER BY created DESC;");
      int result = -1;
      while (rs.next()) {
        result = rs.getInt("id");
      }
      return result;
    }
    public static int deletePet (Integer id) throws Exception
    {
      Client client = new Client();
      List<Object> values = new ArrayList<Object>();
      values.add(id);
      int result = client.getAffected("DELETE FROM pets WHERE id = ?", values);
      return result;
    }
}
