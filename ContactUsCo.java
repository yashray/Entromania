package Co;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ContactUsDao;
import Dao.LoginDao;
import Vo.ContactUsVo;
import Vo.LoginVo;

/**
 * Servlet implementation class ContactUsCo
 */
@WebServlet("/ContactUsCo")
public class ContactUsCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUsCo() {
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
		
		if(flag.equals("contactUs")){
			contactUs(request,response);
		}
	}

	private void contactUs(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String comment = request.getParameter("comment");
		
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat f1 = new SimpleDateFormat("HH:mm:ss");
		Date d = new Date();
		String date = f.format(d);
		String time = f1.format(d);
		
		int id = (Integer)request.getSession().getAttribute("userId");
		LoginVo loginVoFrom = new LoginVo();
		loginVoFrom.setLoginId(id);
		
		LoginDao loginDao = new LoginDao();
		List ls = loginDao.searchAdmin();
		LoginVo loginVoTo = (LoginVo)ls.get(0);
		
		ContactUsVo contactUsVo = new ContactUsVo();
		contactUsVo.setName(name);
		contactUsVo.setPhone(phone);
		contactUsVo.setSubject(subject);
		contactUsVo.setEmail(email);
		contactUsVo.setComment(comment);
		contactUsVo.setDate(date);
		contactUsVo.setTime(time);
		contactUsVo.setLoginVoFrom(loginVoFrom);
		contactUsVo.setLoginVoTo(loginVoTo);
		
		ContactUsDao contactUsDao = new ContactUsDao();
		contactUsDao.insert(contactUsVo);
		
		response.sendRedirect("User/contact.jsp");
		
	}

}
