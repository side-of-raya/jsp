package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class MenDAO {
  public static Man get(int id) throws Exception {
    Client client = new Client();
    Man man = new Man();
    List<Object> values = new ArrayList<>();
    values.add(id);
    ResultSet rs = client.getRows("SELECT * FROM men WHERE id = ?", values);
    while (rs.next()) {
      man.setName(rs.getString("name"));
      man.setAge(rs.getInt("age"));
    }
    return man;    
  }
  public static List<Man> getAll() throws Exception {
    Client client = new Client();
    Man man = new Man();
    List<Man> result = new ArrayList<>();
    ResultSet rs = client.getRows("SELECT * FROM men");
    while (rs.next()) {
      man.setName(rs.getString("name"));
      man.setAge(rs.getInt("age"));
      result.add(man);
    }
    return result;
  }
  public static List<Pet> getAllPets(int id) throws Exception {
    Client client = new Client();
    Pet pet = new Pet();
    List<Pet> result = new ArrayList<>();
    List<Object> values = new ArrayList<>();
    values.add(id);
    ResultSet rs = client.getRows("SELECT * FROM pets WHERE master_id = ?", values);
    while (rs.next()) {
      pet.setName(rs.getString("name"));
      pet.setAge(rs.getInt("age"));
      result.add(pet);
    }
    return result;    
  }
  public static int updateMan (int id, UpdateArgs[] args) throws Exception
  {
    if (args.length == 0) return -1;
    Client client = new Client();
    String query = "UPDATE men SET ";
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
  public static int createMan (String name, int age) throws Exception
  {
    Client client = new Client();
    List<Object> values = new ArrayList<Object>();
    values.add(name);
    values.add(age);
    client.execute("INSERT INTO men (name, age) VALUES (?, ?)", values);
    ResultSet rs = client.getRows("SELECT id FROM men ORDER BY created DESC;");
    int result = -1;
    while (rs.next()) {
      result = rs.getInt("id");
    }
    return result;
  }
  public static int deleteMan (Integer id) throws Exception
  {
    Client client = new Client();
    List<Object> values = new ArrayList<Object>();
    values.add(id);
    int result = client.getAffected("DELETE FROM men WHERE id = ?", values);
    return result;
  }
}