package Co;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.stateDao;
import Vo.stateVo;

/**
 * Servlet implementation class insertState
 */
@WebServlet("/insertState")
public class insertState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertState() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("searchState"))
		{
			searchState(request,response);
		}
		if(flag.equals("deleteState"))
		{
			deleteState(request,response);
		}
		if(flag.equals("editState"))
		{
			editState(request,response);
		}
		if(flag.equals("updateState"))
		{
			updateState(request,response);
		}
	}
	
	private void updateState(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String z = request.getParameter("state");
		int i = Integer.parseInt(request.getParameter("id"));
		stateVo v3 = new stateVo();
		v3.setState(z);
		v3.setId(i);
		stateDao d3 = new stateDao();
		d3.update(v3);
		response.sendRedirect("insertState?flag=searchState");
		
	}

	private void editState(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int a2 = Integer.parseInt(request.getParameter("id"));
		 stateVo v2 = new stateVo();
		 v2.setId(a2);
		 stateDao d2 = new stateDao();
		 d2.edit(v2);
		 List ls = d2.edit(v2);
		 HttpSession session = request.getSession();
		 session.setAttribute("search_state",ls);
		 response.sendRedirect("Admin/edit-state.jsp");
		
	}

	private void deleteState(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		 int a1 = Integer.parseInt(request.getParameter("id"));
		 stateVo v1 = new stateVo();
		 v1.setId(a1);
		 stateDao d1 = new stateDao();
		 d1.delete(v1);
		 searchState(request,response);
	}

	private void searchState(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String a = request.getParameter("state");
		stateVo v = new stateVo();
		v.setState(a);
		stateDao d = new stateDao();
		List ls = d.search(v);
		HttpSession session = request.getSession();
		session.setAttribute("search_state", ls);
		response.sendRedirect("Admin/search-state.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag=request.getParameter("flag");
		if(flag.equals("insertstate"))
		{
			insertstate(request,response);
		}
		
	}

	

	private void insertstate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String s = request.getParameter("state");
		stateVo v = new stateVo();
		v.setState(s);
		stateDao d = new stateDao();
		d.insert(v);
		response.sendRedirect("Admin/add-state.jsp");
	}

}
