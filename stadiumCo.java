package Co;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.cityDao;
import Dao.stadiumDao;
import Dao.stateDao;
import Vo.cityVo;
import Vo.stadiumVo;
import Vo.stateVo;

/**
 * Servlet implementation class stadiumCo
 */
@WebServlet("/stadiumCo")
public class stadiumCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stadiumCo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String flag=request.getParameter("flag");
		if(flag.equals("viewstadium"))
		{
			viewstadium(request,response);
		}
		if(flag.equals("deletestadium"))
		{
			deletestadium(request,response);
		}
		if(flag.equals("editstadium"))
		{
			editstadium(request,response);
		}
		if(flag.equals("updatestadium"))
		{
			updatestadium(request,response);
		}
		if(flag.equals("loadstatecity"))
		{
			loadstatecity(request,response);
		}
		if(flag.equals("loadCity"))
		{
			System.out.println("inside LoadState");
			loadCity(request, response);
		}
		
	}

	

	private void loadstatecity(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		stateVo statevo = new stateVo();
		cityVo cityvo = new cityVo();
		stadiumDao stadiumdao = new stadiumDao();
		List ls= stadiumdao.loadstate(statevo);
		List lc = stadiumdao.loadcity(cityvo);
		HttpSession session= request.getSession();
		session.setAttribute("loadstate", ls);
	/*	HttpSession session2= request.getSession();
		session2.setAttribute("loadcity", lc);
	*/	response.sendRedirect("Admin/add-stadium.jsp");
		
	}
	protected void loadCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int stateId= Integer.parseInt(request.getParameter("stateId"));
		
		System.out.println("sID :"+stateId);
		
		stateVo statevo=new stateVo();
		statevo.setId(stateId);
		
		stadiumDao stadiumdao=new stadiumDao();
		List list = stadiumdao.loadCity(statevo);

		
		
		HttpSession s=request.getSession();
		s.setAttribute("view_city",list);
		response.sendRedirect("Admin/loadCity.jsp");
		}	

	private void updatestadium(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		String stadium = request.getParameter("stadium");
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		int p_capacity = Integer.parseInt(request.getParameter("p_capacity"));
		int stateid = Integer.parseInt(request.getParameter("loadstate"));
		int cityid = Integer.parseInt(request.getParameter("loadcity"));
		stateVo statevo = new stateVo();
		statevo.setId(stateid);
		cityVo cityvo = new cityVo();
		cityvo.setC_id(cityid);
		stadiumVo stadiumvo = new stadiumVo();
		stadiumvo.setS_id(s_id);
		stadiumvo.setCapacity(capacity);
		stadiumvo.setP_capacity(p_capacity);
		stadiumvo.setStadium(stadium);
		stadiumvo.setCityvo(cityvo);
		stadiumvo.setStatevo(statevo);
		stadiumDao stadiumdao = new stadiumDao();
		stadiumdao.update(stadiumvo);
		response.sendRedirect("stadiumCo?flag=viewstadium");
		
	}

	private void editstadium(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int s_id = Integer.parseInt(request.getParameter("id"));
		stadiumVo stadiumvo = new stadiumVo();
		stadiumvo.setS_id(s_id);
		stadiumDao stadiumdao = new stadiumDao();
		List ls=stadiumdao.edit(stadiumvo);
		stateDao statedao = new stateDao();
		List ls1 = statedao.search(null);
		cityDao citydao = new cityDao();
		List ls2 = citydao.search(null);
		HttpSession session = request.getSession();
		session.setAttribute("editstadium", ls);
		session.setAttribute("loadstate", ls1);
		session.setAttribute("loadcity", ls2);
		response.sendRedirect("Admin/edit_stadium.jsp");
		
	}

	private void deletestadium(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int s_id = Integer.parseInt(request.getParameter("id"));
		stadiumVo stadiumvo = new stadiumVo();
		stadiumvo.setS_id(s_id);
		stadiumDao stadiumdao = new stadiumDao();
		stadiumdao.delete(stadiumvo);
		response.sendRedirect("stadiumCo?flag=viewstadium");
	}

	private void viewstadium(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		stadiumVo stadiumvo = new stadiumVo();
		stadiumDao stadiumdao = new stadiumDao();
		List ls = stadiumdao.search(stadiumvo);
		HttpSession session = request.getSession();
		session.setAttribute("viewstadium", ls);
		response.sendRedirect("Admin/view_stadium.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag=request.getParameter("flag");
		if(flag.equals("insertstadium"))
		{
			insertstate(request,response);
		}
	}

	private void insertstate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String stadium = request.getParameter("stadium");
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		int p_capacity = Integer.parseInt(request.getParameter("p_capacity"));
		int loadcity = Integer.parseInt(request.getParameter("cityId"));
		cityVo cityvo = new cityVo();
		cityvo.setC_id(loadcity);
		int loadstate = Integer.parseInt(request.getParameter("stateId"));
		stateVo statevo = new stateVo();
		statevo.setId(loadstate);
		stadiumVo stadiumvo = new stadiumVo();
		stadiumvo.setStadium(stadium);
		stadiumvo.setCapacity(capacity);
		stadiumvo.setP_capacity(p_capacity);
		stadiumvo.setStatevo(statevo);
		stadiumvo.setCityvo(cityvo);
		stadiumDao stadiumdao = new stadiumDao();
		stadiumdao.insert(stadiumvo);
		response.sendRedirect("Admin/add-stadium.jsp");
		}

}
