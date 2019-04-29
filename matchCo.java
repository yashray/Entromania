package Co;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.matchDao;
import Dao.stadiumDao;
import Vo.matchVo;
import Vo.stadiumVo;

/**
 * Servlet implementation class matchCo
 */
@WebServlet("/matchCo")
public class matchCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public matchCo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		if(flag.equals("viewmatch"))
		{
			viewmatch(request,response);
		}
		if(flag.equals("deletematch"))
		{
			deletematch(request,response);
		}
		if(flag.equals("editmatch"))
		{
			editmatch(request,response);
		}
		if(flag.equals("loadstadium"))
		{
			loadstadium(request,response);
		}
		if(flag.equals("loadmatch"))
		{
			loadmatch(request,response);
		}
		
	}

	private void loadmatch(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		matchVo matchvo = new matchVo();
		matchDao matchdao = new matchDao();
		List lm = matchdao.loadmatch(matchvo);
		HttpSession session = request.getSession();
		session.setAttribute("loadmatch", lm);
		response.sendRedirect("User/viewMatch.jsp");
		
	}

	private void loadstadium(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		stadiumVo stadiumvo = new stadiumVo();
		matchDao matchdao = new matchDao();
		List lss = matchdao.loadstadium(stadiumvo);
		HttpSession session = request.getSession();
		session.setAttribute("loadstadium", lss);
		response.sendRedirect("Admin/add-match.jsp");
	}

	private void editmatch(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int m_id = Integer.parseInt(request.getParameter("id"));
		matchVo matchvo = new matchVo();
		matchvo.setM_id(m_id);
		matchDao matchdao = new matchDao();
		List ls = matchdao.edit(matchvo);
		stadiumDao stadiumdao = new stadiumDao();
		List ls3 = stadiumdao.search(null);
		HttpSession session = request.getSession();
		session.setAttribute("editmatch", ls);
		session.setAttribute("loadstadium", ls3);
		response.sendRedirect("Admin/edit_match.jsp");
	}

	private void deletematch(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int m_id = Integer.parseInt(request.getParameter("id"));
		matchVo matchvo = new matchVo();
		matchvo.setM_id(m_id);
		matchDao matchdao = new matchDao();
		matchdao.delete(matchvo);
		response.sendRedirect("matchCo?flag=viewmatch");
		
	}

	private void viewmatch(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		matchVo matchvo = new matchVo();
		matchDao matchdao = new matchDao();
		List ls = matchdao.search(matchvo);
		HttpSession session = request.getSession();
		session.setAttribute("viewmatch", ls);
		response.sendRedirect("Admin/view_match.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String flag = request.getParameter("flag");
		if(flag.equals("insertmatch"))
		{
			insertmatch(request,response);
		}
		if(flag.equals("updatematch"))
		{
			updatematch(request,response);
		}
	}

	private void updatematch(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int m_id = Integer.parseInt(request.getParameter("m_id"));
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String m_des = request.getParameter("m_des");
		int stadiumid = Integer.parseInt(request.getParameter("loadstadium"));
		stadiumVo stadiumvo= new stadiumVo();
		stadiumvo.setS_id(stadiumid);
		matchVo matchvo = new matchVo();
		matchvo.setM_id(m_id);
		matchvo.setTitle(title);
		matchvo.setDate(date);
		matchvo.setTime(time);
		matchvo.setM_des(m_des);
		matchvo.setStadiumvo(stadiumvo);
		matchDao matchdao = new matchDao();
		matchdao.update(matchvo);
		response.sendRedirect("matchCo?flag=viewmatch");
	}

	private void insertmatch(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String team1 = request.getParameter("team1");
		String team2 = request.getParameter("team2");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String m_des = request.getParameter("m_des");
		int stadiumid = Integer.parseInt(request.getParameter("stadiumid"));
		stadiumVo stadiumvo = new stadiumVo();
		stadiumvo.setS_id(stadiumid);
		matchVo matchvo = new matchVo();
		matchvo.setTitle(title);
		matchvo.setTeam1(team1);
		matchvo.setTeam2(team2);
		matchvo.setDate(date);
		matchvo.setTime(time);
		matchvo.setM_des(m_des);
		matchvo.setStadiumvo(stadiumvo);
		matchDao matchdao = new matchDao();
		matchdao.insert(matchvo);
		response.sendRedirect("Admin/add-match.jsp");
	}

}
