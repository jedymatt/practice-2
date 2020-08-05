
import java.util.*;
import java.io.*;

public class CreateConfig {

    public static void main(String[] args) {
        try {
            FileOutputStream output = new FileOutputStream("config.properties");

            Properties prop = new Properties();
            prop.setProperty("db.url", "localhost");
            prop.setProperty("db.user", "admin");
            prop.setProperty("db.password", "password");

            prop.store(output, "settings");

        } catch (IOException ex) {
            System.out.println("Ano na?");
        }
    }
}
