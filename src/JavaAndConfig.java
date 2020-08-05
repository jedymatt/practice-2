
import java.util.*;
import java.io.*;

public class JavaAndConfig {
    
    public static void main(String[] args) {
        File configFile = new File("C:\\Users\\Jedy Matt\\Desktop\\config.properties");
        try {
            FileReader reader = new FileReader(configFile);
            Properties prop = new Properties();
            prop.load(reader);
            
            String host = prop.getProperty("host");
            String pass = prop.getProperty("pass");
            System.out.println("Host name is " + host);
            System.out.println("Password is " + pass);
            reader.close();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }
    }
}
