import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CMP_Archivos {

	public static void main(String lqs[])
	{
		compare();
	
	}
	
	
	public static void compare()
	{
		String linea,linea2;
		int contador=0;
		
		JFileChooser chooser = new JFileChooser();
		JFileChooser chooser2= new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
	    
	    chooser.setFileFilter(filter);
	    
	    int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) 
	    {
	    	
		    chooser2.setFileFilter(filter);
		    returnVal = chooser2.showOpenDialog(null);
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) 
		    {
		    	try
		    	{
		    		File archivo = new File(chooser.getCurrentDirectory().getPath() + System.getProperty("file.separator") + chooser.getSelectedFile().getName());
		    		File archivo2 = new File(chooser2.getCurrentDirectory().getPath() + System.getProperty("file.separator") + chooser2.getSelectedFile().getName());
		    		
		    		FileReader lector = new FileReader(archivo);
		    		FileReader lector2 = new FileReader(archivo2);
		    		
		    		BufferedReader Lectura = new BufferedReader(lector);
		    		BufferedReader Lectura2 = new BufferedReader(lector2);
		    		
		    		
		    		do
		    		{
		    			linea=Lectura.readLine();		    		    
			    		linea2=Lectura2.readLine();
			    		
			    		if(linea != null && linea2 != null)
			    		{
			    			
			    			if(!linea.equals(linea2))
			    			{
			    				System.out.println("Fallo en esta linea:" + linea +" != " + linea2);
			    				System.out.println("Linea: " + contador);
			    				System.out.println("");
			    				
			    			}
			    		}
			    		
			    		
    		
			    		contador++;
		    		}while(linea!=null);
		    		
		    		Lectura.close();
		    		Lectura2.close();
		    		

		    
		    	}catch(Exception e)
		    	{
		    		System.out.print(e.getMessage());
		    	}
		    }
		   
	    }
	   
	    
	    
	    
	
	}
}
