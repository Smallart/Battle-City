package small.com.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyMagrUtil {
    static Properties props=new Properties();
    static {
        try {
            props.load(PropertyMagrUtil.class.getClassLoader().getResourceAsStream("configfile.config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object get(String key){
        if (props==null) return null;
        return props.get(key);
    }
}
