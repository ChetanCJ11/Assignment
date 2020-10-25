package Array_read;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class readArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		    String toWrite = "";
		    int x = 0;
			
			  try { 
				  File file = new File("D:\\Eclipse_Workplace\\Read_array\\Sample.txt");
			
			  BufferedReader br = new BufferedReader(new FileReader(file));
			  for (int i = 0; i < 10; i++) {
			  
			  String st;
			  if ((st = br.readLine()) != null) {
				  String str =  st. replace('|', ' ');
			  System.out.println(str); } 
			  } 
			  } 

			  catch (IOException e) {
			  e.printStackTrace(); }
			 

		    try
		    {
		        File file1 = new File("D:\\Eclipse_Workplace\\Read_array\\Sample.txt");
		        FileReader filereader = new FileReader(file1);
		        BufferedReader reader = new BufferedReader(filereader);
		        String y;
		        while ((y = reader.readLine()) != null)
		        {
		        	  String str =  y. replace('|', ' ');
		      	  
		            //trim - delete leading spaces from y
		            String[] array = str.trim().split(" ");
		    
		            for (int i = 0; i < array.length; i++)
		            {
		                int number = Integer.parseInt(array[i]);
		                
		                System.out.println(number);
		          	 
		                toWrite += (number * 10 + " ");

		            }
		            System.out.println('\n');
		            System.out.println(toWrite);
		          
		        }


		        File output = new File("D:\\Eclipse_Workplace\\Read_array\\result.txt");
		        if (!output.exists()) 
		        output.createNewFile();
		        FileWriter writer = new FileWriter(output.getAbsoluteFile());
		        BufferedWriter bWriter = new BufferedWriter(writer);
		        
		        bWriter.write(toWrite);
		        bWriter.close();
		    } catch (Exception e)
		    {
		        e.printStackTrace();
		    }
		}

	}


