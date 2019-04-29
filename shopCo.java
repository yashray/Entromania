package Co;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ProductDao;
import Dao.shopDao;
import Vo.ProductVo;

/**
 * Servlet implementation class shopCo
 */
@WebServlet("/shopCo")
public class shopCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shopCo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String flag = request.getParameter("flag");
		
		if(flag.equals("loadProduct")){
			loadProduct(request,response);
		}
	}

	private void loadProduct(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		ProductVo productVo = new ProductVo();
		
		shopDao shopDao = new shopDao();
		List ls = shopDao.loadProduct(productVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("loadProduct", ls);
		
		response.sendRedirect("User/shop.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
