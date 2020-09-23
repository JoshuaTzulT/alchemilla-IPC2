
package proyecto.alchemilla.conexion;

import java.io.UnsupportedEncodingException;
import java.util.Base64;


public class Encriptar {
    
    public static String codificar(String value) throws UnsupportedEncodingException{
       Base64.Encoder e = Base64.getEncoder();
       return e.encodeToString(value.getBytes("utf-8"));
    }
    
    public static String decodificar(String encrypted) throws UnsupportedEncodingException{
        byte[] b = Base64.getDecoder().decode(encrypted);
        return new String(b, "utf-8");
    }
    
    public static void main(String [] args) throws UnsupportedEncodingException{
        System.out.println(codificar("123"));
        System.out.println(decodificar("MTIz"));
    }
    
}
