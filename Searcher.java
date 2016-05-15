
package webcrawler;

import java.security.MessageDigest;

public class Searcher {
    
    public static String hash(String input)
    {
        try
        {
            MessageDigest m=MessageDigest.getInstance("SHA-256");
            String word=input.toLowerCase();
            m.update(word.getBytes("ASCII"));
            byte [] hasher=m.digest();
            
            StringBuilder  build=new StringBuilder();
            for( byte b: hasher)
            {
                build.append(String.format("%02x",b));
                
            }
            
            return build.toString().toUpperCase();
            
        }
            catch(Exception e)
            {
                    return e.toString();
            }
    
    
    }
}
