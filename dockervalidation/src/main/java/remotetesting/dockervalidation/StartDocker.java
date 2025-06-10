package remotetesting.dockervalidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;


public class StartDocker {	

	//@Test
	public void startFile() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
       Runtime runtime = Runtime.getRuntime();
       runtime.exec("cmd /c dockerUp.bat");
       
       Calendar cal = Calendar.getInstance();
       cal.add(Calendar.SECOND, 55);
       long stopnow = cal.getTimeInMillis();
       
       Thread.sleep(3000);
       String file = "output.txt";
       boolean flag= false;
       BufferedReader br;      
       
       while(System.currentTimeMillis() < stopnow) {
    	   
    	   if(flag) {
    		   break;
    	   }
    	   br = new BufferedReader(new FileReader(file));
           String firstLine = br.readLine();
       
       while(firstLine!=null && !flag) {
    	   
    	   if(firstLine.contains("Node has been added")) {
    		   System.out.println("found my text");
    		   System.out.flush();
    		   flag=true;
    		   break;
    	   }
    	   firstLine = br.readLine();
       }
       br.close();
       }
              
       Assert.assertTrue(flag);
       runtime.exec("cmd /c scale-up-chrome.bat");
       Thread.sleep(15000);
	}

}
