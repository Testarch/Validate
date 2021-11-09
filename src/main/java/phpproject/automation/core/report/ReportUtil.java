package phpproject.automation.core.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

import phpproject.automation.core.util.CommonUtil;
import phpproject.automation.core.util.VariableController;


public class ReportUtil 

{
    
	 //static Logger log = Logger.getLogger(ReportUtil.class);
	 
	public static ArrayList< String > tcdescription = new ArrayList< String>();
	public static ArrayList< String > tcasestep = new ArrayList< String>();
	public static ArrayList< String > description = new ArrayList< String>();
	public static ArrayList< String > status = new ArrayList< String>();
	public static ArrayList< String > Screenshot = new ArrayList< String>();
	public static Date EndTime;
	public static long seconds;
	

	
	// Graph
	public static ArrayList< String > tcases = new ArrayList< String>();
	public static ArrayList< String > tcasesdescription = new ArrayList< String>();
	public static ArrayList< String > tcasesstatus = new ArrayList< String>();
	public static ArrayList< String > tcasesscenario = new ArrayList< String>();
	public static ArrayList< String > browser = new ArrayList< String>();
	public static ArrayList< Date > tcasesstarttime = new ArrayList< Date>();
	public static ArrayList< Date > tcasesendtime = new ArrayList< Date>();
	public static int passed = 0;
	public static int failed = 0;
	
	public static void createDirectory()
	
	{
		try
		
		{
			// Create File Directory
	    	File files = new File( Report.getPath()+VariableController.getTestCaseName()+"\\img");
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
	
	public static void copyFiles()
	
	{
		try
		
		{
			// Copy image file - imag1
			File sources = new File(System.getProperty("user.dir")+"\\src\\report\\img\\bg.jpg");
	        File dests = new File(Report.getPath()+VariableController.getTestCaseName()+"\\img\\bg.jpg");
	        copyFileUsingFileStreams(sources, dests);
	        
	        // Copy image file - imag2
	        File sourcess = new File(System.getProperty("user.dir")+"\\src\\report\\img\\image_not_available.png");
	        File destss = new File(Report.getPath()+VariableController.getTestCaseName()+"\\img\\image_not_available.png");
	        copyFileUsingFileStreams(sourcess, destss);
	        
	        // Copy image file - imag3
	        File sourcesss = new File(System.getProperty("user.dir")+"\\src\\report\\img\\plogo.jpg");
	        File destsss = new File(Report.getPath()+VariableController.getTestCaseName()+"\\img\\plogo.jpg");
	        copyFileUsingFileStreams(sourcesss, destsss);
	        
	        // Copy js File 
	        File source = new File(System.getProperty("user.dir")+"\\src\\demoproject\\automation\\core\\report\\jsapi.js");
	        File dest = new File(Report.getPath()+VariableController.getTestCaseName()+"\\jsapi.js");
	        copyFileUsingFileStreams(source, dest);
	        System.out.println(Report.getPath()+VariableController.getTestCaseName());
	        
			}
		
		catch(Exception e)
		
		{
				
		}
		
	}
	
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
        } finally {
            input.close();
            output.close();
        		} 
        
    	}
	
	public static void generateHTMLReport(String Status)
	
	{
		try
		
		{
				EndTime =  new java.util.Date();
				long seconds = (EndTime.getTime()-VariableController.StartTime.getTime())/1000;
				
				//********************// For Graph 
				ReportUtil.tcasesstatus.add(Status);
				if(Status.equalsIgnoreCase("Pass".toLowerCase()))
				
				{
					passed++;
				}
				
				else if(Status.equalsIgnoreCase("Fail".toLowerCase()))
				
				{
					failed++;
				}
				ReportUtil.browser.add(CommonUtil.getBrowser());
				ReportUtil.tcasesendtime.add(EndTime);
				//********************// For Graph 
				
		        ListToHtmlTransformer renderer = new ListToHtmlTransformer();
 		        String renderedHtml = renderer.renderReport(VariableController.getTestCaseName(),VariableController.getTestDescription(), VariableController.StartTime,EndTime ,Status, CommonUtil.getBrowser(), tcasestep,status,description,Screenshot,seconds );
		        
		        OutputStream htmlfile= new FileOutputStream(new File(Report.getPath()+VariableController.getTestCaseName()+"\\"+VariableController.getTestCaseName()+".html"));
		        PrintStream printhtml = new PrintStream(htmlfile);
		        printhtml.println(renderedHtml);
		        
		       tcasestep.clear();
		       //tcdescription.clear();
		       status.clear();
		       description.clear();
		       Screenshot.clear();
		       printhtml.close();
		       htmlfile.close();
			
		}
		
		catch(Exception e)
		
		{
			e.printStackTrace();
		}
		
	}

    }

