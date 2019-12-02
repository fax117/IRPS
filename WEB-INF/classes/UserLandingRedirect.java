import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLandingRedirect{

	String irpsVal = "-1";
	
	public UserLandingRedirect(){

	}

	public String loadLanding(){
		/*try{
            Document document = Jsoup.connect("http://www.aire.cdmx.gob.mx/conoce-tu-numero-iner/").get();
            Element content = document.getElementById("graficaIRPS");
            String divContents = content.outerHtml();

            System.out.println("Div contents are: " + divContents);

            Pattern pattern = Pattern.compile("(?<=var valorIRPS = ').*");
            Matcher matcher = pattern.matcher(divContents);

            /*System.out.println("Yay match found: " + matcher.group().toString());
            
            boolean found = false;
            while (matcher.find()){
                System.out.println("I found the text: " + matcher.group().toString() + " with length " + matcher.group().toString().length());
                found = true;
            }
            if (!found){
                System.out.println("I didn't find the text");
            }
        }
            catch(Exception e){
            //Rip
            System.out.println("We crashin bois: " + e);
        }*/
        try{
            Document document = Jsoup.connect("http://www.aire.cdmx.gob.mx/conoce-tu-numero-iner/").get();
            Element content = document.getElementById("graficaIRPS");
            String linkText = content.outerHtml();

            Pattern pattern = Pattern.compile("(?<=var valorIRPS = ').*");
            Matcher matcher = pattern.matcher(linkText);
            
            while (matcher.find()){
                String temp = matcher.group().toString();
                if(temp.length() == 3){
                    irpsVal = temp.substring(0,1);
                }
                else{
                    irpsVal = temp.substring(0,2);
                }
            }
        }
            catch(Exception e){
            //Rip
            System.out.println("Error report: " + e);
        }
        finally{
            return irpsVal;
        }
	}

}