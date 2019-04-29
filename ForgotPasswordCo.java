package Co;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import otp.OTPJava;
import otp.mail;
import Dao.LoginDao;
import Vo.LoginVo;

/**
 * Servlet implementation class ForgotPasswordCo
 */
@WebServlet("/ForgotPasswordCo")
public class ForgotPasswordCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordCo() {
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
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("forgotPassword")){
			forgotPassword(request,response);
		}
		if(flag.equals("updatePassword")){
			updatePassword(request,response);
		}
	}
	
	OTPJava otpJava = new OTPJava();
	int otp = otpJava.generateOTP(5);

	private void updatePassword(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		HttpSession session=request.getSession();
		
		int otpnew = Integer.parseInt(request.getParameter("otpnew"));
		String password = request.getParameter("password");
		
				
		System.out.println("emailid----found--"+session.getAttribute("Email"));
		
		String email = (String)session.getAttribute("Email");
		System.out.println(email);
		if(otp == otpnew)
		{
			LoginVo loginVo = new LoginVo();
			/*loginVo.setLoginId(loginId);*/
			loginVo.setPassword(password);
			loginVo.setEmail(email);
			
			LoginDao loginDao = new LoginDao();
			loginDao.updatePassword(loginVo);
			
			response.sendRedirect("Admin/login.jsp");
				
		}
		else
		{
			response.sendRedirect("confirmPassword.jsp");
		}
	}

	
	
	private void forgotPassword(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String email = request.getParameter("email");
		
		HttpSession session = request.getSession();
		session.setAttribute("Email", email);
		
		LoginVo loginVo = new LoginVo();
		loginVo.setEmail(email);
		
		LoginDao loginDao = new LoginDao();
		
		
		System.out.println("emailid--"+email);
		
		List ls = loginDao.forgotpassword(loginVo);
		
		if(ls.size()>= 1){
		
		mail mail = new mail();
		mail.sendMail(email,otp);
		System.out.println("otp---"+otp);
		
		response.sendRedirect("Admin/confirmPassword.jsp");
		}
		
		else{
				response.sendRedirect("Admin/forgotpassword.jsp");
		}
		}
	}

