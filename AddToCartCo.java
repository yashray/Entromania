package Co;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ProductDao;
import Vo.AddToCartVo;
import Vo.ProductVo;

/**
 * Servlet implementation class AddToCartCo
 */
@WebServlet("/AddToCartCo")
public class AddToCartCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartCo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("addItem")){
			addIteam(request,response);
		}
	}

	private void addIteam(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		ProductVo productVo = new ProductVo();
		productVo.setProductId(productId);
		System.out.println("productID::"+productId);
		
		ProductDao productDao = new ProductDao();
		List<ProductVo> ls= productDao.addtoCart(productVo);
		System.out.println("addtocartSIZE::"+ls.size());
		
		HttpSession session = request.getSession();
		List<AddToCartVo> ls1=(List<AddToCartVo>) session.getAttribute("addToCart");
		
/*		System.out.println("ls1SIZE::"+ls1.size());*/
		System.out.println("::ADDTOCART::");
		
		if(ls1==null){
			List<AddToCartVo> ls2=new ArrayList<AddToCartVo>();
			ProductVo productVo2 = (ProductVo)ls.get(0);
			
			AddToCartVo addToCartVo = new AddToCartVo();
			addToCartVo.setProductId(productVo2);
			
			ls2.add(addToCartVo);
			session.setAttribute("addToCart", ls2);
			System.out.println("::NEW::");
		}
		else{
			ProductVo productVo2 = (ProductVo)ls.get(0);
			
			AddToCartVo addToCartVo = new AddToCartVo();
			addToCartVo.setProductId(productVo2);
			
			System.out.println("::USED::");
			
			ls1.add(addToCartVo);
			session.setAttribute("addToCart", ls1);
		}
		List ls3 = (List)session.getAttribute("addToCart");
		
		System.out.println("Add TO Cart size (After)::"+ls3.size());
		
		response.sendRedirect("User/shopcart.jsp");
	}

	/*private void addIteam(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int productId = Integer.parseInt(request.getParameter("id"));
		
		ProductVo productVo = new ProductVo();
		productVo.setProductId(productId);
		
		ProductDao productDao = new ProductDao();
		List ls = productDao.addtoCart(productVo);
		
		System.out.println("List:"+ls.size());
		
		ProductVo productVo2 = new ProductVo();
		productVo2 = (ProductVo) ls.get(0);
		
		HttpSession session = request.getSession();
		
		List<AddToCartVo> ls1 = (List<AddToCartVo>)session.getAttribute("AddTOCart");
		
		if(ls1!=null){
			List<AddToCartVo> ls2 = new ArrayList<AddToCartVo>();
			
			ProductVo productVo2 = (ProductVo)ls.get(0);
			
			AddToCartVo addToCartVo = new AddToCartVo();
			addToCartVo.setProductVo(productVo2);
			addToCartVo.setItemName(productVo2.getProductName());
			addToCartVo.setPrice(productVo2.getProductPrice());
			addToCartVo.setProductVo(productVo2);
			
			ls2.add(addToCartVo);
			session.setAttribute("AddToCart", ls2);
		}
		else{
			ProductVo productVo2 = (ProductVo)ls.get(0);
			
			AddToCartVo addToCartVo = new AddToCartVo();
			addToCartVo.setProductVo(productVo2);
			
			addToCartVo.setItemName(productVo2.getProductName());
			addToCartVo.setPrice(productVo2.getProductPrice());
			addToCartVo.setProductVo(productVo2);
			
			
			ls1.add(addToCartVo);
			session.setAttribute("AddToCart", ls1);
		}
		
		response.sendRedirect("User/shopcart.jsp");
	}
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
