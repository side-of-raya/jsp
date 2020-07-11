// package DAO;

// import static org.junit.Assert.assertEquals;

// import org.junit.*;
// import model.Pet;

// public class PetsTest {
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
//     public void testCreatePet() throws Exception
//     {
//         assertEquals(1, (int)PetsDAO.createPet("Mike", 18));
//         assertEquals(2, (int)PetsDAO.createPet("Beauty", 17));
//     }
//     @Test
//     public void testGetPet() throws Exception
//     {
//         Client client = new Client();
//         client.getAffected("INSERT INTO men (name, age) VALUES ('TEST', 666)");
//         client.getAffected("INSERT INTO men (name, age) VALUES ('TEST', 999)");
//         client.execute("INSERT INTO pets (name, age, master_id) VALUES ('Allen', 32, 1)");
//         client.execute("INSERT INTO pets (name, age, master_id) VALUES ('pet2', 222, 2)");
//         client.execute("INSERT INTO pets (name, age) VALUES ('pet3', 300)");
//         client.execute("INSERT INTO pets (name, age, master_id) VALUES ('pet4', 3060, 2)");
//         Pet expectedPet = new Pet("Allen", 32, 1);
//         Pet receivedPet = PetsDAO.get(1);
//         assertEquals(true, expectedPet.equals(receivedPet));
//     }
//     @Test
//     public void testSelectPets() throws Exception
//     {
//         Client client = new Client();        
//         client.execute("INSERT INTO pets (name, age) VALUES ('pet1', 111)");
//         client.execute("INSERT INTO pets (name, age) VALUES ('pet2', 222)");
//         client.execute("INSERT INTO pets (name, age) VALUES ('pet3', 300)");
//         client.execute("INSERT INTO pets (name, age) VALUES ('pet4', 3060)");
//         assertEquals(4, PetsDAO.getAll().size());
//     }
//     @Test
//     public void testUpdatePet() throws Exception
//     {
//         Client client = new Client();
//         client.execute("INSERT INTO pets (name, age)"
//         + "VALUES ('TEST', 666)," +
//         "('lol', 2)," +
//         "('kek', 2000)");
//         UpdateArgs[] args = new UpdateArgs[1];
//         UpdateArgs arg = new UpdateArgs();
//         arg.field = "name";
//         arg.value = "anotherTEST";
//         args[0] = arg;
//         assertEquals(1, (int)PetsDAO.updatePet(1, args));
//     }
//     @Test
//     public void testDeletePet() throws Exception
//     {
//         Client client = new Client();
//         client.getAffected("INSERT INTO pets (name, age) VALUES ('TEST', 666)");
//         client.getAffected("INSERT INTO pets (name, age) VALUES ('TEST', 999)");
//         client.getAffected("INSERT INTO pets (name, age) VALUES ('TEST', 999)");
//         assertEquals(1, (int)PetsDAO.deletePet(2));
//     }
// }