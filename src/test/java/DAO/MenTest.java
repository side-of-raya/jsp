// package DAO;

// import static org.junit.Assert.*;

// import org.junit.Before;
// import org.junit.Test;


// public class MenTest 
// {
//     @Before
//     public void clearDatabase() throws Exception
//     {
//         Client client = new Client();
//         client.execute("DELETE FROM men;");
//         client.execute("DELETE FROM pets;");
//         client.execute("ALTER TABLE men AUTO_INCREMENT = 1;");
//         client.execute("ALTER TABLE pets AUTO_INCREMENT = 1;");
//     }
//     @Test
//     public void testCreateMan() throws Exception
//     {
//         assertEquals(1, (int)MenDAO.createMan("James", 18));
//         assertEquals(2, (int)MenDAO.createMan("Alyssa", 17));
//     }
//     @Test
//     public void testSelectMans() throws Exception
//     {
//         Client client = new Client();        
//         client.execute("INSERT INTO men (name, age) VALUES ('TEST', 666)");
//         client.execute("INSERT INTO men (name, age) VALUES ('TEST', 999)");
//         client.execute("INSERT INTO men (name, age) VALUES ('TEST', 999)");
//         assertEquals(3, MenDAO.getAll().size());
//     }
//     @Test
//     public void testUpdateMan() throws Exception
//     {
//         Client client = new Client();
//         client.execute("INSERT INTO men (name, age)"
//         + "VALUES ('TEST', 666)," +
//         "('lol', 2)," +
//         "('kek', 2000)");
//         UpdateArgs[] args = new UpdateArgs[1];
//         UpdateArgs arg = new UpdateArgs();
//         arg.field = "name";
//         arg.value = "anotherTEST";
//         args[0] = arg;
//         assertEquals(1, (int)MenDAO.updateMan(1, args));
//     }
//     @Test
//     public void testDeleteMan() throws Exception
//     {
//         Client client = new Client();
//         client.getAffected("INSERT INTO men (name, age) VALUES ('TEST', 666)");
//         client.getAffected("INSERT INTO men (name, age) VALUES ('TEST', 999)");
//         client.getAffected("INSERT INTO men (name, age) VALUES ('TEST', 999)");
//         assertEquals(1, (int)MenDAO.deleteMan(2));
//     }
//     @Test
//     public void testSelectMansPets() throws Exception {
//         Client client = new Client();
//         client.getAffected("INSERT INTO men (name, age) VALUES ('TEST', 666)");
//         client.getAffected("INSERT INTO men (name, age) VALUES ('TEST', 999)");
//         client.execute("INSERT INTO pets (name, age, master_id) VALUES ('pet1', 111, 1)");
//         client.execute("INSERT INTO pets (name, age, master_id) VALUES ('pet2', 222, 2)");
//         client.execute("INSERT INTO pets (name, age) VALUES ('pet3', 300)");
//         client.execute("INSERT INTO pets (name, age, master_id) VALUES ('pet4', 3060, 2)");
//         assertEquals(2, (int)MenDAO.getAllPets(2).size());
//     }
// }
