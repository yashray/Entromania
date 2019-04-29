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
import Dao.stateDao;
import Vo.cityVo;
import Vo.stateVo;

/**
 * Servlet implementation class cityCo
 */
@WebServlet("/cityCo")
public class cityCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cityCo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("viewcity"))
		{
			viewcity(request,response);
		}
		if(flag.equals("deletecity"))
		{
			deletecity(request,response);
		}
		if(flag.equals("editcity"))
		{
			editcity(request,response);
		}
		if(flag.equals("updatecity"))
		{
			updatecity(request,response);
		}
		if(flag.equals("loadstate"))
		{
			loadstate(request,response);
		}
	
	}

		
	

	private void loadstate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		stateVo statevo = new stateVo();
 		cityDao citydao = new cityDao();
 		List ls = citydao.searchstate(statevo);
 		HttpSession session = request.getSession();
		session.setAttribute("search_state", ls);
		response.sendRedirect("Admin/add-city.jsp");
		
	}

	private void updatecity(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int c_id = Integer.parseInt(request.getParameter("id"));
		String city = request.getParameter("city");
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		int stateid = Integer.parseInt(request.getParameter("loadstate"));
		stateVo statevo = new stateVo();
		statevo.setId(stateid);
		cityVo cityvo = new cityVo();
		cityvo.setC_id(c_id);
		cityvo.setCity(city);
		cityvo.setPincode(pincode);
		cityvo.setStatevo(statevo);
		cityDao citydao = new cityDao();
		citydao.update(cityvo);
		response.sendRedirect("cityCo?flag=viewcity");
		
	}

	private void editcity(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int c_id = Integer.parseInt(request.getParameter("id"));
		cityVo cityvo = new cityVo();
		cityvo.setC_id(c_id);
		cityDao citydao = new cityDao();
		citydao.edit(cityvo);
		stateDao statedao = new stateDao();
		List ls1 = statedao.search(null); 
		List ls = citydao.edit(cityvo);
		HttpSession session = request.getSession();
		session.setAttribute("view_city", ls);
		session.setAttribute("loadstate", ls1);
		response.sendRedirect("Admin/edit_city.jsp");
		
	}

	private void deletecity(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		 int c_id = Integer.parseInt(request.getParameter("id"));
		 cityVo cityvo = new cityVo();
		 cityvo.setC_id(c_id);
		 cityDao citydao = new cityDao();
		 citydao.delete(cityvo);
		 response.sendRedirect("cityCo?flag=viewcity");
		
	}

	private void viewcity(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		cityVo cityvo = new cityVo();
		cityDao citydao = new cityDao();
		List ls = citydao.search(cityvo);
		HttpSession session = request.getSession();
		session.setAttribute("view_city", ls);
		response.sendRedirect("Admin/view-city.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag=request.getParameter("flag");
		if(flag.equals("insertcity"))
		{
			insertstate(request,response);
		}
	}				
		 	private void insertstate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		 		String city = request.getParameter("city");
		 		System.out.println("city : "+city);
		 		int id = Integer.parseInt(request.getParameter("s_id"));
		 		System.out.println("id : "+id);
		 		int pincode = Integer.parseInt(request.getParameter("pincode"));
		
		 		stateVo statevo = new stateVo();
		 		statevo.setId(id);
		 		
		 		cityVo c = new cityVo();
		 		c.setCity(city);
		 		c.setPincode(pincode);
		 		c.setStatevo(statevo);
		 		
		 		cityDao cd = new cityDao();
		 		cd.insert(c);
		 		response.sendRedirect("Admin/add-city.jsp");
		 	}
		 	
	}
