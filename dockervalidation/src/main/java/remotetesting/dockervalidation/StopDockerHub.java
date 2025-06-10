package remotetesting.dockervalidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;


public class StopDockerHub {

	
	//@Test
	public void stopFile() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
       Runtime runtime = Runtime.getRuntime();
       runtime.exec("cmd /c docker-down.bat");
       
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
    	   
    	   if(firstLine.contains("elenium-hub exited")) {
    		   System.out.println("found my text of shutdown");
    		   System.out.flush();
    		   flag=true;
    		   break;
    	   }
    	   firstLine = br.readLine();
       }
       br.close();
       }
              
       Assert.assertTrue(flag);       
       Thread.sleep(3000);
       //delete the output file.
       File f = new File("output.txt");
       if(f.delete()) {
    	   System.out.println("file deleted successfully");
    	   System.out.flush();
       }
       
	}

}
