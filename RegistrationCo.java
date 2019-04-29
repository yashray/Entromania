package Co;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.LoginDao;
import Dao.RegistrationDao;
import Vo.LoginVo;
import Vo.RegistrationVo;

/**
 * Servlet implementation class RegistrationCo
 */
@WebServlet("/RegistrationCo")
public class RegistrationCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationCo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("register"))
		{
			registeruser(request,response);
		}
	}

	private void registeruser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String dateofbirth = request.getParameter("dateofbirth");
		String gender = request.getParameter("gender");
		long mobileno = Integer.parseInt(request.getParameter("mobileno"));
		
		RegistrationVo registrationvo = new RegistrationVo();
		registrationvo.setName(name);
		registrationvo.setDateofbirth(dateofbirth);
		registrationvo.setGender(gender);
		registrationvo.setMobile(mobileno);
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginVo loginvo = new LoginVo();
		loginvo.setEmail(email);
		loginvo.setPassword(password);
		loginvo.setType("USER");
		
		LoginDao logindao = new LoginDao();
		logindao.insert(loginvo);
		registrationvo.setLoginvo(loginvo);
		
		RegistrationDao registrationdao = new RegistrationDao();
		registrationdao.insert(registrationvo);
		
		response.sendRedirect("Admin/login.jsp");
		
	}

}
