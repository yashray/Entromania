package Co;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CategoryDao;
import Vo.CategoryVo;

/**
 * Servlet implementation class CategoryCo
 * @param <E>
 */
@WebServlet("/CategoryCo")
public class CategoryCo<E> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryCo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		if(flag.equals("viewCategory"))
		{
			viewCategory(request,response);
		}
		if(flag.equals("deleteCategory"))
		{
			deleteCategory(request,response);
		}
		if(flag.equals("editCategory"))
		{
			editCategory(request,response);
		}
	}

	private void editCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		int categoryId = Integer.parseInt(request.getParameter("id"));
		
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setCategoryId(categoryId);
		
		CategoryDao categoryDao = new CategoryDao();
		List ls = categoryDao.editCategory(categoryVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("editCategory", ls);
		System.out.println("length-----"+ls.size());
		response.sendRedirect("Admin/editCategory.jsp");
	}

	private void deleteCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int categoryId = Integer.parseInt(request.getParameter("id"));
		
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setCategoryId(categoryId);
		
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.deleteCategory(categoryVo);
		
		viewCategory(request, response);
		
	}

	private void viewCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		CategoryVo categoryVo = new CategoryVo();
		CategoryDao categoryDao = new CategoryDao();
		
		List ls= categoryDao.viewCategory(categoryVo);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("viewCategory", ls);
	
		response.sendRedirect("Admin/viewCategory.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		if(flag.equals("addCategory"))
		{
			addCategory(request,response);
		}
		if(flag.equals("updateCategory"))
		{
			updateCategory(request,response);
		}
	}

	private void updateCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("categoryName");
		String categoryDescription = request.getParameter("categoryDescription");
		
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setCategoryId(categoryId);
		categoryVo.setCategoryName(categoryName);
		categoryVo.setCategoryDescription(categoryDescription);
		
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.updateCategory(categoryVo);
		
		viewCategory(request, response);
		
	}

	private void addCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String categoryName = request.getParameter("categoryName");
		String categoryDescription = request.getParameter("categoryDescription");
		
		CategoryVo CategoryVo = new CategoryVo();
		CategoryVo.setCategoryName(categoryName);
		CategoryVo.setCategoryDescription(categoryDescription);
		
		CategoryDao CategoryDao = new CategoryDao();
		CategoryDao.insertCategory(CategoryVo);
		
		response.sendRedirect("Admin/addCategory.jsp");
		
	}

}
