package Co;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.bookticketDao;
import Vo.bookticketVo;

@WebServlet("/bookticketCo")
public class bookticketCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookticketCo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("viewbookedticket")){
			viewbookedticket(request,response);
		}
	}
	

	private void viewbookedticket(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		bookticketVo bookticketvo = new bookticketVo();
		bookticketDao bookticketdao = new bookticketDao();
		List ls = bookticketdao.search(bookticketvo);
		HttpSession session = request.getSession();
		session.setAttribute("viewbookedticket", ls);
		response.sendRedirect("Admin/viewbookedTicket.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String flag = request.getParameter("flag");
		
		if(flag.equals("bookmatchticket")){
			bookmatchticket(request,response);
		}
	}

	private void bookmatchticket(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");	
		
		bookticketVo bookticketvo = new bookticketVo();
		bookticketvo.setName(name);
		bookticketvo.setPhone(phone);
		bookticketvo.setEmail(email);
		bookticketvo.setAddress(address);
		
		bookticketDao bookticketdao = new bookticketDao();
		bookticketdao.insert(bookticketvo);
		System.out.println("name"+name);
		response.sendRedirect("User/bookmatchNow.jsp");
		
	}

}
