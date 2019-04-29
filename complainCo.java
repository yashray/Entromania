package Co;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import otp.mail;
import Dao.LoginDao;
import Dao.complainDao;
import Vo.LoginVo;
import Vo.complainVo;

/**
 * Servlet implementation class complainCo
 */
@WebServlet("/complainCo")
public class complainCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public complainCo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag=request.getParameter("flag");
		if(flag.equals("viewComplain"))
		{
			viewComplain(request,response);
		}
		if(flag.equals("reply"))
		{
			reply(request,response);
		}
	}

	private void reply(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		complainVo complainVo = new complainVo();
		complainVo.setComplainId(id);
		complainDao complainDao = new complainDao();
		List ls = complainDao.edit(complainVo);
		HttpSession session = request.getSession();
		session.setAttribute("replyList", ls);
		
		response.sendRedirect("Admin/replyComplain.jsp");
	}

	private void viewComplain(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		complainVo complainVo = new complainVo();
		
		complainDao complainDao = new Dao.complainDao();
		List ls = complainDao.viewComplain(complainVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("viewComplain", ls);
		
		response.sendRedirect("Admin/viewComplain.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag=request.getParameter("flag");
		if(flag.equals("insertComplain"))
		{
			insertComplain(request,response);
		}
		if(flag.equals("replytouser"))
		{
			replytouser(request,response);
		}
	}

	private void replytouser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		
		String complainTitle = request.getParameter("title");
		String complainDescription = request.getParameter("complainDescription");
		String complainReply = request.getParameter("complainReply");
		
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat f1 = new SimpleDateFormat("HH:mm:ss");
		Date d = new Date();
		String date = f.format(d);
		String time = f1.format(d);
		
		int id = (Integer)request.getSession().getAttribute("userId");
		LoginVo loginVoFrom = new LoginVo();
		loginVoFrom.setLoginId(id);
		
		int to = Integer.parseInt(request.getParameter("replyTo"));
		LoginVo loginVoTo = new LoginVo();
		loginVoTo.setLoginId(to);

		complainVo complainVo = new complainVo();
		
		complainVo.setComplainTitle(complainTitle);
		complainVo.setComplainDescription(complainDescription);
		complainVo.setComplainReply(complainReply);
		complainVo.setComplainTime(time);
		complainVo.setComplainDate(date);
		complainVo.setLoginVoTo(loginVoTo);
		complainVo.setLoginVoFrom(loginVoFrom);
		
		complainDao complainDao = new complainDao();
		complainDao.insert(complainVo);
		
		/*mail mail = new mail();
		mail.sendReply();*/
		
		viewComplain(request, response);
	}

	private void insertComplain(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String complainTitle = request.getParameter("title");
		String complainDescription = request.getParameter("message");
		
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
		
		complainVo complainVo = new complainVo();
		complainVo.setComplainTitle(complainTitle);
		complainVo.setComplainDescription(complainDescription);
		complainVo.setComplainDate(date);
		complainVo.setComplainTime(time);
		complainVo.setLoginVoTo(loginVoTo);
		complainVo.setLoginVoFrom(loginVoFrom);
		
		complainDao complainDao = new complainDao();
		complainDao.insert(complainVo);
		
		response.sendRedirect("User/complain.jsp");
		
	}

}
