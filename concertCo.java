package Co;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.concertDao;
import Dao.stadiumDao;
import Vo.concertVo;
import Vo.stadiumVo;

/**
 * Servlet implementation class concertCo
 */
@WebServlet("/concertCo")
public class concertCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public concertCo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String flag = request.getParameter("flag");
			if(flag.equals("viewconcert"))
			{
				viewconcert(request,response);
			}
			if(flag.equals("deleteconcert"))
			{
				deleteconcert(request,response);
			}
			if(flag.equals("editconcert"))
			{
				editconcert(request,response);
			}
			if(flag.equals("updateconcert"))
			{
				updateconcert(request,response);
			}
			if(flag.equals("loadstadium"))
			{
				loadstadium(request,response);
			}
			if(flag.equals("loadconcert"))
			{
				loadconcert(request,response);
			}
	}

	private void loadconcert(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		concertVo concertvo = new concertVo();
		concertDao concertdao = new concertDao();
		List ls = concertdao.loadconcert(concertvo);
		HttpSession session = request.getSession();
		session.setAttribute("loadconcert", ls);
		response.sendRedirect("User/viewConcert.jsp");
		
	}

	private void loadstadium(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		stadiumVo stadiumvo = new stadiumVo();
		concertDao concertdao = new concertDao();
		List ls = concertdao.loadstadium(stadiumvo);
		HttpSession session = request.getSession();
		session.setAttribute("loadstadium", ls);
		response.sendRedirect("Admin/add-concert.jsp");
		
	}

	private void updateconcert(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String c_des = request.getParameter("c_des");
		int cn_id = Integer.parseInt(request.getParameter("cn_id"));
		int stadiumid = Integer.parseInt(request.getParameter("loadstadium"));
		stadiumVo stadiumvo= new stadiumVo();
		stadiumvo.setS_id(stadiumid);
		concertVo concertvo = new concertVo();
		concertvo.setCn_id(cn_id);
		concertvo.setTitle(title);
		concertvo.setDate(date);
		concertvo.setTime(time);
		concertvo.setStadiumvo(stadiumvo);
		concertvo.setC_des(c_des);
		concertDao concertdao = new concertDao();
		concertdao.update(concertvo);
		response.sendRedirect("concertCo?flag=viewconcert");
		
	}

	private void editconcert(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int cn_id = Integer.parseInt(request.getParameter("id"));
		concertVo concertvo = new concertVo();
		concertvo.setCn_id(cn_id);
		stadiumDao stadiumdao = new stadiumDao();
		List ls3 = stadiumdao.search(null);
		concertDao concertdao = new concertDao();
		List ls = concertdao.edit(concertvo);
		HttpSession session = request.getSession();
		session.setAttribute("editconcert", ls);
		session.setAttribute("loadstadium", ls3);
		response.sendRedirect("Admin/edit_concert.jsp");
		
	}

	private void deleteconcert(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int cn_id = Integer.parseInt(request.getParameter("id"));
		concertVo concertvo = new concertVo();
		concertvo.setCn_id(cn_id);
		concertDao concertdao = new concertDao();
		concertdao.delete(concertvo);
		response.sendRedirect("concertCo?flag=viewconcert");
		
	}

	private void viewconcert(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		concertVo concertvo = new concertVo();
		concertDao concertdao = new concertDao();
		List ls = concertdao.search(concertvo);
		HttpSession session = request.getSession();
		session.setAttribute("viewconcert", ls);
		response.sendRedirect("Admin/view_concert.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String flag=request.getParameter("flag");
		if(flag.equals("insertconcert"))
		{
			insertconcert(request,response);
		}
	}

	private void insertconcert(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String singer = request.getParameter("singer");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String c_des = request.getParameter("c_des");
		int stadiumid = Integer.parseInt(request.getParameter("stadiumid"));
		stadiumVo stadiumvo = new stadiumVo();
		stadiumvo.setS_id(stadiumid);
		concertVo concertvo = new concertVo();
		concertvo.setTitle(title);
		concertvo.setDate(date);
		concertvo.setSinger(singer);
		concertvo.setTime(time);
		concertvo.setC_des(c_des);
		concertvo.setStadiumvo(stadiumvo);
		concertDao concertdao = new concertDao();
		concertdao.insert(concertvo);
		response.sendRedirect("Admin/add-concert.jsp");
		
	}

}
