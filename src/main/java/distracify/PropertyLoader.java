package distracify;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Class that extracts properties from the prop file.
 */
public class PropertyLoader {


    public static String loadProperty(String prop) {
        String r = "undefined";
        try {
            Properties pro = new Properties();
            FileInputStream in = new FileInputStream("application.properties");
            pro.load(in);
            in.close();
            r = pro.getProperty(prop);
        } catch (Exception e) {
        }
        return r;
    }

    public static void setProperty(String prop, String val){
        try {
            Properties pro = new Properties();
            FileInputStream in = new FileInputStream("application.properties");
            pro.load(in);
            in.close();
            pro.setProperty(prop, val);
            FileOutputStream out = new FileOutputStream("application.properties");
            pro.store(out, null);
            out.close();
        } catch (Exception e) {
        }
    }


   public static void wait(int sec)
   {
       try {
           Thread.sleep(sec);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}