package Co;
import java.net.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class smsController
 */
@WebServlet("/smsController")
public class smsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public smsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
    		String mobileno=request.getParameter("mobile");
    		String name = request.getParameter("name");
    		String date = request.getParameter("date");
    		String time = request.getParameter("time");
    		String stadium = request.getParameter("stadium");
    		String bookingid = request.getParameter("bookingid");
    		String match = request.getParameter("match");
    		
    		System.out.println("mobile::"+mobileno);
    		System.out.println("name::"+name);
    		System.out.println("date::"+date);
    		System.out.println("time::"+time);
    		System.out.println("stadium::"+stadium);
    		System.out.println("bookingid::"+bookingid);
    		System.out.println("match::"+match);
    		
    		sendsms(mobileno,name,date,time,stadium,match,bookingid);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			}
	private void sendsms(String mobileno, String name, String match, String stadium, String date, String time, String bookingid){
		try {
            // Construct data
            String data = "";
            
            data += "username=" + URLEncoder.encode("Bhavindonga96", "ISO-8859-1");
            data += "&password=" + URLEncoder.encode("9426213454", "ISO-8859-1");
			data += "&message="+ stringToHex("BookID:"+bookingid+"\nDate:"+match+"\nMatch:"+time);
            data += "&dca=16bit";
            data += "&want_report=1";
            data += "&msisdn="+mobileno;
            
            System.out.println("bookingid::"+bookingid);
            System.out.println("name::"+name);
            System.out.println("match::"+match);
            System.out.println("datetime::"+date+"&"+time);
            // Send data
            // Please see the FAQ regarding HTTPS (port 443) and HTTP (port 80/5567)
            URL url = new URL("https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                // Print the response output...
                System.out.println(line);
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	static public String stringToHex(String s) {
        char[] chars = s.toCharArray();
        String next;
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            next = Integer.toHexString((int)chars[i]);
            // Unfortunately, toHexString doesn't pad with zeroes, so we have to.
            for (int j = 0; j < (4-next.length()); j++)  {
                output.append("0");
            }
            output.append(next);
        }
        return output.toString();
    }
}
