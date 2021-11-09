package phpproject.automation.core.report;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HighLevelListToHtmlTransformer 

{

	// static Logger log = Logger.getLogger(HighLevelListToHtmlTransformer.class);
	SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
	 

	 int ppass = 0,pfail = 0,fpass = 0,ffail = 0;
	 long second;
	 String startDate,endDate;
	 Date sstartDate,eendDate;


	 public String renderReport(int pass,int fail,java.util.Collection< String > tcases, java.util.Collection< String> tcdescription, java.util.Collection< String > tcasesstatus,java.util.Collection< String > tcasesscenario,java.util.Collection< String > browser, java.util.Collection< Date> tcasesstarttime, java.util.Collection< Date> tcasesendtime) throws ParseException{   	
		    	 StringBuilder html = new StringBuilder();
		         html.append("<html>\n" );
		         html.append("<head>\n" );
		         html.append("<title>FFPM Automation Test Report</title>\n" );
		         html.append("<style>\n" );
		         html.append("body {margin 0px 0px 0px 0px;	background-image: url('img/bg.jpg')}\n" );
		         html.append("html {height: 100%;width: 100%;}\n" );
		         html.append("#wrapper {height: 100%; width: 95%; overflow-y: auto}\n" );
		         html.append(".maintable {width: 100%; height: 100%;}\n" );
		         html.append(".header {font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;font-size: 18px; font-weight: normal; font-style: italic; font-variant: normal; color: #000080; vertical-align: middle; text-align: center;word-spacing: normal; letter-spacing: normal; width: 100%; height: 10%}\n" );
		         html.append(".content {vertical-align: top; width: 100%; height: 100%; text-align: center}\n" );
		         html.append(".HeadingTable {border: 1pxsolid #bdbdbd; padding: 6px; vertical-align: top; text-align: center; border-radius: 10px; width: 95%; background-color: aliceblue}\n" );
		         html.append(".contentTable {border: 1px solid #bdbdbd; padding: 6px; vertical-align: top; text-align: center; border-radius: 10px; width: 95%; background-color: aliceblue}\n" );
		         html.append(".tableheading {font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;font-size: 15px; font-weight: normal; font-style: italic; font-variant: normal; color: #000080; text-align: center; background-color: #5098C8;border: 1px solid #bdbdbd; height: 30px}\n" );
		         html.append(".tablecontent {font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;font-size: 13px; font-weight: normal; font-style: italic; font-variant: normal; color: #000080; text-align: center; border: 1px solid #bdbdbd; height: 25px;}\n" );
		         html.append(".tablecontentpass {font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;font-size: 13px; font-weight: normal; font-style: italic; font-variant: normal; color: #000080; text-align: center; border: 1px solid #bdbdbd; background-color: #A9F5A9}\n" );
		         html.append(".tablecontentfail {font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;font-size: 13px; font-weight: normal; font-style: italic; font-variant: normal; color: #000080; text-align: center; border: 1px solid #bdbdbd; background-color: #F78181}\n" );
		         html.append(".footer {font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;font-size: 11px; font-weight: normal; font-style: italic; font-variant: normal; color: #000080; vertical-align: middle; text-align: center;word-spacing: normal; letter-spacing: normal; width: 100%; height: 5%}}\n" );
		         
		         
		         for (int i = 0; i < tcases.size(); i++) 
		         
		         {
		        	 int z = tcases.size();
		        	 if(tcasesstatus.toArray()[i].equals("Pass") && tcasesscenario.toArray()[i].equals("Positive"))
		        	 
		        	 {
		        		 ppass ++;
		        	 }
		        	 
		        	 else if(tcasesstatus.toArray()[i].equals("Fail") && tcasesscenario.toArray()[i].equals("Positive"))
		        	 
		        	 {
		        		 pfail ++;
		        	 }
		        	 
		        	 else if(tcasesstatus.toArray()[i].equals("Fail") && tcasesscenario.toArray()[i].equals("Negative"))
		        	 
		        	 {
		        		 
		        		 //fpass++; 
		        		 pfail ++;
		        	 }
		        	 
		        	 else if(tcasesstatus.toArray()[i].equals("Pass") && tcasesscenario.toArray()[i].equals("Negative"))
		        	 
		        	 {
		        		 //ffail++;
		        		 ppass ++;
		        	 }
		        	 
		        	 startDate = tcasesstarttime.toArray()[0].toString();
		        	 sstartDate = formatter.parse(startDate);
		        	 endDate = tcasesendtime.toArray()[z-1].toString();
		        	 eendDate = formatter.parse(endDate);
		        	 second = (eendDate.getTime()-sstartDate.getTime())/1000;
		        	
		         }
		        
		        
		         html.append("</style>\n" );
		         html.append("<script type='text/javascript' src='jsapi.js'></script>\n" );
		         html.append("<script type='text/javascript'>\n" );
		         html.append("google.load('visualization', '1', {packages:['corechart']});\n" );
		         html.append("google.setOnLoadCallback(positive);\n" );
		         html.append("google.load('visualization', '1', {packages:['corechart']});\n" );
		         html.append("google.setOnLoadCallback(negative);\n" );
		         html.append("function positive() {\n" );
		         html.append("var data = google.visualization.arrayToDataTable([\n" );
		         html.append("['Status', 'Number'],\n" );
		         html.append("['Pass - "+ppass+"',"+ppass+"],\n" );
		         html.append("['Fail - "+pfail+"',"+pfail+"]\n" );
		         html.append("]);\n" );
		         html.append("var options = {title: 'Result Summary',is3D: true,};\n" );
		         //html.append("var options = {title: 'Positive Scenario Summary',is3D: true,};\n" );
		         html.append("var chart = new google.visualization.PieChart(document.getElementById('piechart_3dp'));\n" );
		         html.append("chart.draw(data, options);\n" );
		         html.append("}\n" );
		         html.append("function negative() {\n" );
		         html.append("var data = google.visualization.arrayToDataTable([\n" );
		         html.append("['Status', 'Number'],\n" );
		         html.append("['Pass - "+fpass+"',"+fpass+"],\n" );
		         html.append("['Fail - "+ffail+"',"+ffail+"]\n" );
		         html.append("]);\n" );
		         html.append("var options = {title: 'Negative Scenario Summary',is3D: true,};\n" );
		         html.append("var chart = new google.visualization.PieChart(document.getElementById('piechart_3dn'));\n" );
		         html.append("chart.draw(data, options);\n" );		
		         
		        /*      
		         
		         html.append("google.load('visualization', '1', {packages:['corechart']});\n" );
		         html.append("google.setOnLoadCallback(drawChart);\n" );
		         html.append("function drawChart() {\n" );
		         html.append("var data = google.visualization.arrayToDataTable([['Status', 'Number'],['Pass - "+pass+"',"+pass+"],['Fail - "+fail+"',"+fail+"]]);\n" );
		         html.append("var options = {title: 'Summary Status', slices: {0: { color: 'green' },1: { color: 'red' }}};\n" );
		         html.append("var chart = new google.visualization.PieChart(document.getElementById('piechart'));\n" );
		         html.append("chart.draw(data, options);\n" );
		       
		       */
		         
		         html.append("}\n" );
		         html.append("</script>\n" );
		         html.append("</head>\n" );
		         html.append("<body>\n" );
		         html.append("<table align='center' id='tableHeading' >\n" );
		         html.append("<tr>\n" );
		         html.append("<td>\n" );
		         html.append("<div id='piechart_3dp' style='width: 400px; height: 200px; 	border: 3px solid; 	border-radius: 25px; border: 0px solid #a1a1a1;  padding: 10px 40px; ' align='center'></div>\n" );
		         html.append("</td>\n" );
		        //html.append("<td>\n" );
		        //html.append("<div id='piechart_3dn' style='width: 400px; height: 200px; 	border: 3px solid; 	border-radius: 25px; border: 0px solid #a1a1a1;  padding: 10px 40px; ' align='center'></div>\n" );
		        //html.append("</td>\n" );
		         html.append("</tr>\n" );
		         html.append("</table>\n" );
		         html.append("<table class='maintable'\n" );
		         html.append("<tr>\n" );
		         html.append("<td class='header'>\n" );
		         html.append("<div style='float: right; margin-right: 35px'><img src='img/plogo.jpg' /></div>\n" );
		         //html.append("<div style='float: right; margin-right: 40px'><img src='img/plogo.jpg' /></div>\n" );
		         html.append("<br />\n" );
		         html.append("FFPM - Automation Test Report\n" );
		         html.append("</td>\n" );
		         html.append("</tr>\n" );
		         html.append("<tr>\n" );
		         html.append("<td class='content'>\n" );
		         html.append("<table align='center' id='tableHeading' class='contentTable'>\n" );
		         html.append("<tr>\n" );
		         html.append("<td class='tableheading' width='5%'>Sl No.</td>\n" );
		         html.append("<td class='tableheading' width='10%'>Test Case No.</td>\n" );
		         html.append("<td class='tableheading' width='30%'>Test Case Description</td>\n" );
		         html.append("<td class='tableheading' width='10%'>Status</td>\n" );
		         html.append("<td class='tableheading' width='15%'>Scenario</td>\n" );
		         html.append("<td class='tableheading' width='20%'>Browser</td>\n" );
		         html.append("<td class='tableheading' width='10%'>Execution Time (Sec)</td>\n" );
		         html.append("</tr>\n" );
		         // Loop the list of reports passed as argument.
		      
		         for (int i = 0; i < tcases.size(); i++) 
		         {
		        	 int j = i+1;
		         html.append("<tr>\n" );
		         html.append("<td class='tablecontent' width='5%'>"+j+"</td>\n" );
		         html.append("<td class='tablecontent' width='10%'><a target =\"_blank\" name =\"testcase\" href=\"./"+tcases.toArray()[i]+"/"+tcases.toArray()[i]+".html\">"+tcases.toArray()[i]+"&nbsp;</a></td>\n" ); 
		         html.append("<td class='tablecontent' width='30%'>"+tcdescription.toArray()[i]+"</td>\n" );
		         
		        
		         
		       if(tcasesstatus.toArray()[i].equals("Pass"))
		       
		       {
		     	    html.append( "<td class= 'tablecontentpass' align='center' width='12%'>"+tcasesstatus.toArray()[i]+"</td>\n" );
		     	    
		       }
		       
		       else if (tcasesstatus.toArray()[i].equals("Fail"))
		       
		       {
		     	    html.append( "<td class= 'tablecontentfail' align='center' width='12%'>"+tcasesstatus.toArray()[i]+"</td>\n" ); 
		       }
		      
		 
		         
		         if(tcasesscenario.toArray()[i].equals("Positive"))
		        
		         
		         {
		        	 //html.append("<td class='tablecontentpass' align='center' width='15%'>"+tcasesscenario.toArray()[i]+"&nbsp;</td>\n" );
		        	 
		        	 html.append("<td class='tablecontent' align='center' width='15%'>"+tcasesscenario.toArray()[i]+"&nbsp;</td>\n" );
	
			     }
		         
		         else if(tcasesscenario.toArray()[i].equals("Negative"))
				        
			         
		         {
		        	 //html.append("<td class='tablecontentpass' align='center' width='15%'>"+tcasesscenario.toArray()[i]+"&nbsp;</td>\n" );
		        	 
		        	 html.append("<td class='tablecontent' align='center' width='15%'>"+tcasesscenario.toArray()[i]+"&nbsp;</td>\n" );
	
			     }
		         
		         else 
		         
		          {
			    	  //html.append("<td class='tablecontentfail' align='center'  width='15%'>"+tcasesscenario.toArray()[i]+"&nbsp;</td>\n" );
		        	 html.append("<td class='tablecontent' align='center' width='15%'>"+tcasesscenario.toArray()[i]+"&nbsp;</td>\n" );
			    	

			      }
		         

		          html.append("<td class='tablecontent' width='20%'>"+browser.toArray()[i]+"&nbsp;</td>\n" );
		         
		         
		         
		         //long seconds = (tcasesendtime.toArray()[k-1]browser.toString()-tcasesstarttime.toArray()[i]).toString()/1000;
		         
		
		         
		         if(i==0)
		         {
		         html.append("<td class='tablecontent' width='10%' rowspan='"+tcases.size()+"'>"+second+"&nbsp;</td>\n");
		         }
		         html.append("</tr>\n" );
		         }
		         html.append("</table>\n" );
		         html.append("</td>\n" );
		         html.append(" </tr>\n" );
		         html.append("</table></body>\n" );
		         html.append("</html>\n" );

		         return html.toString();
		    
	 }
    

}