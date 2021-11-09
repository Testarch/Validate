package phpproject.automation.core.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class HighLevelReportUtil 

{
    
	 //static Logger log = Logger.getLogger(HighLevelReportUtil.class);

// To create directories	
	
	public static void createDirectorys()
	
	{
		try
		
		{
			// Create File Directory
	    	File files = new File( Report.getPath()+"\\img");
			if (files.mkdirs()) 
			
			{
				//System.out.println("Multiple directories are created!");
			}
			
			else 
			
			{
				System.out.println("Failed to create multiple directories!");
			}
			}
		
		catch(Exception e)
		
		{
			
		}
	
	  }
	
	public static void highlevelcopyFiles()
	
	{
		try
		
		{
			// Copy image file - imag1
			File sources = new File(System.getProperty("user.dir")+"\\src\\report\\img\\bg.jpg");
	        File dests = new File(Report.getPath()+"\\img\\bg.jpg");
	        copyFileUsingFileStreams(sources, dests);
	        
	        // Copy image file - imag2
	        File sourcess = new File(System.getProperty("user.dir")+"\\src\\report\\img\\image_not_available.png");
	        File destss = new File(Report.getPath()+"\\img\\image_not_available.png");
	        copyFileUsingFileStreams(sourcess, destss);
	        
	        // Copy image file - imag3
	        File sourcesss = new File(System.getProperty("user.dir")+"\\src\\report\\img\\plogo.jpg");
	        File destsss = new File(Report.getPath()+"\\img\\plogo.jpg");
	        copyFileUsingFileStreams(sourcesss, destsss);
	        
	        // Copy js File 
	        
	        File source = new File(System.getProperty("user.dir")+"\\src\\main\\java\\demoproject\\automation\\core\\report\\jsapi.js");
	        //File source = new File(System.getProperty("user.dir")+"\\src\\demoproject\\automation\\core\\report\\jsapi.js");
	        File dest = new File(Report.getPath()+"\\jsapi.js");
	        copyFileUsingFileStreams(source, dest);
	        
			}
		
		catch(Exception e)
		
		{
				
	    }
		
	}
	
	
	// Copy files
    private static void copyFileUsingFileStreams(File source, File dest)throws IOException 
    
    {

        InputStream input = null;
        OutputStream output = null;

        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) 
            
            {
                output.write(buf, 0, bytesRead);
            }
        } 
        
        finally 
        
        {
            input.close();
            output.close();
        } 
        
    	}
	
	public static void highlevelgenerateHTMLReport()
	
	{
		try
		
		{
				
				HighLevelListToHtmlTransformer renderer = new HighLevelListToHtmlTransformer();
		        String renderedHtml = renderer.renderReport(ReportUtil.passed, ReportUtil.failed, ReportUtil.tcases, ReportUtil.tcdescription, ReportUtil.tcasesstatus,ReportUtil.tcasesscenario, ReportUtil.browser, ReportUtil.tcasesstarttime, ReportUtil.tcasesendtime);
		        OutputStream htmlfile= new FileOutputStream(new File(Report.getPath()+"\\"+"HighLevelReport"+".html"));
		        PrintStream printhtml = new PrintStream(htmlfile);
		        printhtml.println(renderedHtml);
		        
		        
		        ReportUtil.tcases.clear();
		        ReportUtil.tcdescription.clear();
		        ReportUtil.tcasesstatus.clear();
		        ReportUtil.browser.clear();
		        ReportUtil.tcasesstarttime.clear();
		        ReportUtil.tcasesendtime.clear();
		        printhtml.close();
		        htmlfile.close();
			
		}
		
		catch(Exception e)
		
		{
			e.printStackTrace();
		}
		
	}

    }
