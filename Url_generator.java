/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawler;
import java.util.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author gaurav
 */
public class Url_generator {
    public void Begin() {
             // TODO code application logic here
             String url=this.geturl();
             Filterdomain domain=new Filterdomain(Searcher.hash(url),url);
             Domain dom=new Domain (domain.getDhash(),domain.getDurl(),domain);
             
                     
            HashSet<String> tags=new HashSet<String>();
           try
           {
              Document d = Jsoup.connect(dom.getDurl()).get();
         
                 
                     Page_html webpage=new Page_html(d.html(),dom,new Date());
                     
                
               
              
              Frontpage page=new Frontpage("",dom,new Date());
               Elements reference = d.select("a");
            for (Element iter:reference)
            {   String temp=iter.attr("href");
                temp=Handler_html.Url(temp,domain);
                tags.add(temp);
        //        System.out.println(temp);
             }
        } catch (IOException ex) {
            Logger.getLogger(Url_generator.class.getName()).log(Level.SEVERE, null, ex);
        }
           catch (Exception ex) {
                     Logger.getLogger(Url_generator.class.getName()).log(Level.SEVERE, null, ex);
                 }
                  
          
        
         
        //System.out.println("--------------------------------------------");
         
        for (String  itr:tags  ){
             System.out.println(itr);
         }
    
    
    
    }
    
    private String geturl()
    {
        Scanner read=new Scanner(System.in);
       String inputurl=read.nextLine();
             //.String  inputurl="http://www.jsoup.org";
             if (inputurl.startsWith("www"))
                 inputurl="http://"+inputurl;
              return inputurl;
    }
    
}
