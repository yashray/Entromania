package Co;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.sportDao;
import Vo.sportVo;

/**
 * Servlet implementation class sportCo
 */
@WebServlet("/sportCo")
public class sportCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sportCo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("viewsport")){
			viewsport(request,response);
		}
		if(flag.equals("deletesport")){
			deletesport(request,response);
		}
		if(flag.equals("editsport")){
			editsport(request,response);
		}
	}

	private void editsport(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int sportId = Integer.parseInt(request.getParameter("id"));
		
		sportVo sportVo = new sportVo();
		sportVo.setSportId(sportId);
		
		sportDao sportDao = new sportDao();
		List ls = sportDao.editsport(sportVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("editsport", ls);
		
		response.sendRedirect("Admin/editSport.jsp");
		
	}

	private void deletesport(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int sportId = Integer.parseInt(request.getParameter("id"));
		
		sportVo sportVo = new sportVo();
		sportVo.setSportId(sportId);
		
		sportDao sportDao = new sportDao();
		sportDao.deletesport(sportVo);
		
		viewsport(request, response);
		
	}

	private void viewsport(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		sportVo sportVo = new sportVo();
		
		sportDao sportDao = new sportDao();
		List ls = sportDao.viewsport(sportVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("viewsport", ls);
			
		response.sendRedirect("Admin/viewSport.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("addsport")){
			addsport(request,response);
		}
		if(flag.equals("updatesport")){
			updatesport(request,response);
		}
	}

	private void updatesport(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int sportId = Integer.parseInt(request.getParameter("sportId"));
		String sportName = request.getParameter("sportName");
		String sportDescription = request.getParameter("sportDescription");
		
		sportVo sportVo = new sportVo();
		sportVo.setSportId(sportId);
		sportVo.setSportName(sportName);
		sportVo.setSportDescription(sportDescription);
		
		sportDao sportDao = new sportDao();
		sportDao.updatesport(sportVo);
		
		viewsport(request, response);	
	}

	private void addsport(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String sportName = request.getParameter("sportName");
		String sportDescription = request.getParameter("sportDescription");
		
		sportVo sportVo = new sportVo();
		sportVo.setSportName(sportName);
		sportVo.setSportDescription(sportDescription);
		
		sportDao sportDao = new sportDao();
		sportDao.addsport(sportVo);
		
		response.sendRedirect("Admin/addSport.jsp");
	}	

}
