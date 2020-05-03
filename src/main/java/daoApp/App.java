package daoApp;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Class.forName("org.mariadb.jdbc.Driver");
        System.out.println("Driver loaded");
    }
}
