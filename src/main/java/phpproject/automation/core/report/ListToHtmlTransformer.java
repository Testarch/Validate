package phpproject.automation.core.report;

import java.util.Date;

public class ListToHtmlTransformer 

{

  
	 //static Logger log = Logger.getLogger(ListToHtmlTransformer.class);
	 

	public String renderReport(String tesCaseNo, String TCDescription, Date Starttime ,Date Endtime,String Status,String browser , java.util.Collection< String >  tcasestep , java.util.Collection< String >  status , java.util.Collection< String >  description , java.util.Collection< String >  Screenshot , long time){
    	
    	 StringBuilder html = new StringBuilder();
         html.append( "<html>\n" );
         html.append( "<head>\n" );
         html.append( "<title>FFPM Automation Test Report</title>\n" );
         html.append( "<style>" );
         html.append( "body {margin 0px 0px 0px 0px;	background-image: url('./img/bg.jpg')}\n" );
         html.append( "html, body {height: 100%; overflow: auto; overflow: scroll}\n" );
         html.append( "#wrapper {height: 100%; width: 95%; overflow-y: auto; overflow-y: scroll}\n" );
         html.append( ".maintable {width: 100%; height: 100%; position: fixed; text-align: center}\n" );
         html.append( ".header {font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;font-size: 18px; font-weight: normal; font-style: italic; font-variant: normal; color: #000080; vertical-align: middle; text-align: center;word-spacing: normal; letter-spacing: normal; width: 100%; height: 10%}\n" );
         html.append( ".content {vertical-align: top; width: 100%; height: 100%;}\n" );
         

         html.append( ".HeadingTable {border: 1pxsolid #bdbdbd; padding: 6px; vertical-align: top; text-align: center; border-radius: 10px; width: 95%; background-color: aliceblue}\n" );
         html.append( ".contentTable {border: 1pxsolid #bdbdbd; padding: 6px; vertical-align: top; text-align: center; border-radius: 10px; width: 100%; background-color: aliceblue}}\n" );
         html.append( ".tableheading {font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;font-size: 15px; font-weight: normal; font-style: italic; font-variant: normal; color: #000080; text-align: center; background-color: #5098C8;border: 1px solid #bdbdbd; height: 30px}\n" );
         html.append( ".tablecontent {font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;font-size: 13px; font-weight: normal; font-style: italic; font-variant: normal; color: #000080; text-align: center; border: 1px solid #bdbdbd; height: 25px;}\n" );
         html.append( ".tablecontentpass {font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;font-size: 13px; font-weight: normal; font-style: italic; font-variant: normal; color: #000080; text-align: center; border: 1px solid #bdbdbd; background-color: #A9F5A9}\n" );
         html.append( ".tablecontentfail {font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;font-size: 13px; font-weight: normal; font-style: italic; font-variant: normal; color: #000080; text-align: center; border: 1px solid #bdbdbd; background-color: #F78181}\n" );
         html.append( ".footer {font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;font-size: 11px; font-weight: normal; font-style: italic; font-variant: normal; color: #000080; vertical-align: middle; text-align: center;word-spacing: normal; letter-spacing: normal; width: 100%; height: 5%}}}\n" );
         html.append( "</style>\n" );
         html.append( "</head>\n" );
         html.append( "<body>\n" );
         html.append( "<table class='maintable'>\n" );
         html.append( "<tr>\n" );
         html.append( "<td class='header'>\n" );
         html.append( "<div style='float: right; margin-right: 33px'><img src='./img/plogo.jpg' /></div>\n" );
         //html.append( "<div style='float: right; margin-right: 45px'><img src='./img/plogo.jpg' /></div>\n" );
         html.append( "<br />\n" );
         html.append( "FFPM - Automation Test Report\n" );
         html.append( "</td>\n" );
         html.append( "</tr>\n" );
         html.append( "<tr>\n" );
         html.append( "<td>\n" );
         html.append( "<table align='center' id='tableHeading' class='HeadingTable'>\n" );
         html.append( "<tr>\n" );
         html.append( "<td class='tablecontent' style='text-align: left' width='50%'><b>Test Case No:</b> "+tesCaseNo+"</td>\n" );
         html.append( "<td class='tablecontent' style='text-align: left' width='50%'><b>Test Case Description:</b> "+TCDescription+"</td>\n" );
         //html.append( "<td class='tablecontent' style='text-align: left' width='40%'><b>Test Case Status :</b>"+Status+"</td>\n" );
         html.append( "</tr>\n" );
         html.append( "<tr>\n" );
         html.append( "<td class='tablecontent' style='text-align: left' width='50%'><b>Execution Start Time:</b> "+Starttime.toString()+"</td>\n" );
         html.append( "<td class='tablecontent' style='text-align: left' width='50%'><b>Execution End Time:</b> "+Endtime.toString()+"</td>\n" );
         html.append( "</tr>\n" );
         html.append( "</table>\n" );
         html.append( "</td>\n" );
         html.append( "</tr>\n" );
         html.append( "<tr>\n" );
         html.append( "<td align='center' class='content'>\n" );
         html.append( "<div id='wrapper' align='center'>\n" );
         html.append( "<table align='center' id= "+browser+" class='contentTable'>\n" );
         html.append( "<tr>\n" );
         html.append( "<td colspan='7' class='tableheading'>"+browser+"</td>\n" );
         html.append( "</tr>\n" );
         html.append( "<tr>\n" );
         
         html.append( "<td class='tableheading' width='8%'>SL No.</td>\n" );
         html.append( "<td class='tableheading' width='34%'>Test Case Step</td>\n" );
         html.append( "<td class='tableheading' width='11%'>Status</td>\n" );
         html.append( "<td class='tableheading' width='23%'>Actual result</td>\n" );
         html.append( "<td class='tableheading' width='15%'>Screenshot</td>\n" );
         html.append( "<td class='tableheading' width='9%'>Time(In Sec)</td>\n" );

         html.append( "</tr>\n" );
         // Loop the list of reports passed as argument.
         for (int i = 0; i < tcasestep.size(); i++) 
         
         {
        	 int j = i+1;
        	 html.append( "<tr>\n" );
             html.append( "<td class= 'tablecontent' align='center' width='8%'>"+j+"</td>\n" );
             html.append( "<td class= 'tablecontent' width='34%' style='text-align: left'>"+tcasestep.toArray()[i]+"&nbsp;</td>\n" );
             if(status.toArray()[i].equals("Pass")){
            	    html.append( "<td class= 'tablecontentpass' align='center' width='11%'>"+status.toArray()[i]+"</td>\n" );
             }
             
             else if (status.toArray()[i].equals("Fail"))
             
             {
            	    html.append( "<td class= 'tablecontentfail' align='center' width='11%'>"+status.toArray()[i]+"</td>\n" ); 
             }
             html.append( "<td class= 'tablecontent' width='23%'>"+description.toArray()[i]+"&nbsp;</td>\n" );
             html.append( "<td class= 'tablecontent' align='center' width='15%'><a target=blank() href='"+Screenshot.toArray()[i]+"' >Screenshot</a></td>\n" );
             if(i==0)
             
             {
               html.append( "<td class= 'tablecontent' align='center' width='9%' rowspan='"+tcasestep.size()+"'>"+time+"</td>\n" );
             }
             
             html.append( "</tr>\n" );
         }    	
         html.append( "</table>\n" );
         html.append( "</div>\n" );
         html.append( "</td>\n" );
         html.append( "</tr>\n" );
         html.append( "<tr>\n" );
         html.append( "</tr>\n" );
         html.append( "</table>\n" );
         html.append( "</body>\n" );
         html.append( "</html>\n" );
         return html.toString();
         
      

    }
    
    

}