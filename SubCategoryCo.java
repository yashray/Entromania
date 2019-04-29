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
import Dao.SubCategoryDao;
import Dao.cityDao;
import Dao.stateDao;
import Vo.CategoryVo;
import Vo.SubCategoryVo;
import Vo.cityVo;

/**
 * Servlet implementation class SubCategoryCo
 */
@WebServlet("/SubCategoryCo")
public class SubCategoryCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubCategoryCo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		if(flag.equals("viewSubCategory"))
		{
			viewSubCategory(request,response);
		}
		if(flag.equals("deleteSubCategory"))
		{
			deleteSubCategory(request,response);
		}
		if(flag.equals("editSubCategory"))
		{
			editSubCategory(request,response);
		}
		if(flag.equals("loadCategory"))
		{
			loadCategory(request,response);
		}
	}

	private void loadCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		CategoryVo categoryVo = new CategoryVo();
		
		SubCategoryDao subcategoryDao = new SubCategoryDao();
		List ls = subcategoryDao.loadCategory(categoryVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("loadCategory", ls);
		
		response.sendRedirect("Admin/addSubCategory.jsp");
		
	}

	private void editSubCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int subcategoryId = Integer.parseInt(request.getParameter("id"));
		
		SubCategoryVo subCategoryVo = new SubCategoryVo();
		subCategoryVo.setSubcategoryId(subcategoryId);
		
		CategoryDao categoryDao = new CategoryDao();
		List ls1 = categoryDao.viewCategory(null);
		
		SubCategoryDao subCategoryDao = new SubCategoryDao();
		List ls = subCategoryDao.editSubCategory(subCategoryVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("editSubCategory", ls);
		session.setAttribute("loadCategory", ls1);
		
		response.sendRedirect("Admin/editSubCategory.jsp");
		
	}

	private void deleteSubCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int subcategoryId = Integer.parseInt(request.getParameter("id"));
		
		SubCategoryVo subCategoryVo = new SubCategoryVo();
		subCategoryVo.setSubcategoryId(subcategoryId);
		
		SubCategoryDao subCategoryDao = new SubCategoryDao();
		subCategoryDao.deleteSubCategory(subCategoryVo);
		
		viewSubCategory(request, response);
		
	}

	private void viewSubCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		SubCategoryVo subCategoryVo = new SubCategoryVo();
		
		SubCategoryDao subCategoryDao = new SubCategoryDao();
		List ls = subCategoryDao.viewSubcategory(subCategoryVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("viewSubcategory", ls);
		
		response.sendRedirect("Admin/viewSubCategory.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("addSubCategory"))
		{
			addSubCategory(request,response);
		}
		if(flag.equals("updateSubCategory"))
		{
			updateSubCategory(request,response);
		}
	}

	private void updateSubCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		int subcategoryId = Integer.parseInt(request.getParameter("subcategoryId"));
		String subcategoryName = request.getParameter("subcategoryName");
		String subcategoryDescription = request.getParameter("subcategoryDescription");
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setCategoryId(categoryId);
		
		SubCategoryVo subCategoryVo = new SubCategoryVo();
		subCategoryVo.setSubcategoryId(subcategoryId);
		subCategoryVo.setSubcategoryName(subcategoryName);
		subCategoryVo.setSubcategoryDescription(subcategoryDescription);
		subCategoryVo.setCategoryVo(categoryVo);
		
		SubCategoryDao subCategoryDao = new SubCategoryDao();
		subCategoryDao.updateSubCategory(subCategoryVo);
		
		viewSubCategory(request, response);
	}

	private void addSubCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String subcategoryName = request.getParameter("subcategoryName");
		String subcategoryDescription = request.getParameter("subcategoryDescription");
		
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setCategoryId(categoryId);
		
		SubCategoryVo subcategoryVo = new SubCategoryVo();
		subcategoryVo.setSubcategoryName(subcategoryName);
		subcategoryVo.setSubcategoryDescription(subcategoryDescription);
		subcategoryVo.setCategoryVo(categoryVo);
		
		SubCategoryDao subcategoryDao = new SubCategoryDao();
		subcategoryDao.addSubcategory(subcategoryVo);
		
		response.sendRedirect("Admin/addSubCategory.jsp");
		
	}

}
