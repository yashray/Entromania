package Co;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.cityDao;
import Dao.employeeDao;
import Dao.stadiumDao;
import Dao.stateDao;
import Vo.cityVo;
import Vo.employeeVo;
import Vo.stadiumVo;
import Vo.stateVo;

/**
 * Servlet implementation class employeeCo
 */
@WebServlet("/employeeCo")
public class employeeCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeCo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("viewemployee"))
		{
			viewemployee(request,response);
		}
		if(flag.equals("deleteemployee"))
		{
			deleteemployee(request,response);
		}
		if(flag.equals("editemployee"))
		{
			editemployee(request,response);
		}
		if(flag.equals("updateemployee"))
		{
			updateemplyee(request,response);
		}
		if(flag.equals("loadssc"))
		{
			loadssc(request,response);
		}
		if(flag.equals("loadCity"))
		{
			System.out.println("inside LoadState");
			loadCity(request, response);
		}
		if(flag.equals("loadStadium"))
		{
			System.out.println("inside LoadStadium");
			loadStadium(request, response);
		}
		
	}
			private void loadssc(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
				stateVo statevo = new stateVo();
				cityVo cityvo = new cityVo();
				stadiumVo stadiumvo = new stadiumVo();
				employeeDao employeedao = new employeeDao();
				List ls= employeedao.loadstate(statevo);
				List lc = employeedao.loadcity(cityvo);
				List lst = employeedao.loadstadium(stadiumvo);
				HttpSession session= request.getSession();
				session.setAttribute("loadstate", ls);
				HttpSession session2= request.getSession();
				session2.setAttribute("loadcity", lc);
				HttpSession session3 = request.getSession();
				session3.setAttribute("loadstadium", lst);
				response.sendRedirect("Admin/add-employee.jsp");
		
	}

			private void updateemplyee(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
				int e_id = Integer.parseInt(request.getParameter("id"));
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String dob = request.getParameter("dob");
				String gender = request.getParameter("gender");
				String emailid = request.getParameter("emailid");
				int mobileno = Integer.parseInt(request.getParameter("mobileno"));
				String address = request.getParameter("address");
				String uname = request.getParameter("uname");
				String etype = request.getParameter("etype");
				int cityid = Integer.parseInt(request.getParameter("cityId"));
				int stateid = Integer.parseInt(request.getParameter("stateId"));
				int stadiumid = Integer.parseInt(request.getParameter("stadiumId"));
				cityVo cityvo = new cityVo();
				cityvo.setC_id(cityid);
				stateVo statevo = new stateVo();
				statevo.setId(stateid);
				stadiumVo stadiumvo = new stadiumVo();
				stadiumvo.setS_id(stadiumid);
				employeeVo employeevo = new employeeVo();
				employeevo.setE_id(e_id);
				employeevo.setFname(fname);
				employeevo.setLname(lname);
				employeevo.setDob(dob);
				employeevo.setGender(gender);
				employeevo.setEmailid(emailid);
				employeevo.setMobileno(mobileno);
				employeevo.setAddress(address);
				employeevo.setUname(uname);
				employeevo.setEtype(etype);
				employeevo.setCityvo(cityvo);
				employeevo.setStadiumvo(stadiumvo);
				employeevo.setStatevo(statevo);
				employeeDao employeedao = new employeeDao();
				employeedao.update(employeevo);
				response.sendRedirect("employeeCo?flag=viewemployee");
				
		
	}

			private void editemployee(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

				int e_id = Integer.parseInt(request.getParameter("id"));
				employeeVo employeevo = new employeeVo();
				employeevo.setE_id(e_id);
				employeeDao employeedao = new employeeDao();
				List ls = employeedao.edit(employeevo);
				stateDao statedao = new stateDao();
				List ls1 = statedao.search(null);
				cityDao citydao = new cityDao();
				List ls2 = citydao.search(null);
				stadiumDao stadiumdao = new stadiumDao();
				List ls3 = stadiumdao.search(null);
				HttpSession session = request.getSession();
				session.setAttribute("editemployee", ls);
				session.setAttribute("loadstate", ls1);
				session.setAttribute("loadcity", ls2);
				session.setAttribute("loadstadium", ls3);
				response.sendRedirect("Admin/edit_employee.jsp");
	}

			private void deleteemployee(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

				 int e_id = Integer.parseInt(request.getParameter("id"));
				 employeeVo employeevo = new employeeVo();
				 employeevo.setE_id(e_id);
				 employeeDao employeedao = new employeeDao();
				 employeedao.delete(employeevo);
				 response.sendRedirect("employeeCo?flag=viewemployee");
		
	}

			private void viewemployee(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

				employeeVo employeevo = new employeeVo();
				employeeDao employeedao = new employeeDao();
				List ls = employeedao.search(employeevo);
				HttpSession session = request.getSession();
				session.setAttribute("viewemployee", ls);
				response.sendRedirect("Admin/view_employee.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				String flag=request.getParameter("flag");
				if(flag.equals("insertemployee"))
				{
					insertstate(request,response);
				}
			}

			private void insertstate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String dob = request.getParameter("dob");
				String gender = request.getParameter("gender");
				String emailid = request.getParameter("emailid");
				int mobileno = Integer.parseInt(request.getParameter("mobileno"));
				String address = request.getParameter("address");
				String uname = request.getParameter("uname");
				String etype = request.getParameter("etype");
				int loadcity = Integer.parseInt(request.getParameter("cityId"));
				System.out.println("city : "+loadcity);
				cityVo cityvo = new cityVo();
				cityvo.setC_id(loadcity);
				int loadstate = Integer.parseInt(request.getParameter("stateId"));
				System.out.println("state : "+loadstate);
				stateVo statevo = new stateVo();
				statevo.setId(loadstate);
				int stadiumid = Integer.parseInt(request.getParameter("stadiumId"));
				stadiumVo stadiumvo = new stadiumVo();
				stadiumvo.setS_id(stadiumid);
				System.out.println("stadium : "+stadiumid);
				employeeVo employeevo = new employeeVo();
				employeevo.setFname(fname);
				employeevo.setLname(lname);
				employeevo.setDob(dob);
				employeevo.setGender(gender);
				employeevo.setEmailid(emailid);
				employeevo.setMobileno(mobileno);
				employeevo.setAddress(address);
				employeevo.setUname(uname);
				employeevo.setEtype(etype);
				employeevo.setCityvo(cityvo);
				employeevo.setStatevo(statevo);
				employeevo.setStadiumvo(stadiumvo);
				employeeDao employeedao = new employeeDao();
				employeedao.insert(employeevo);
				response.sendRedirect("Admin/add-employee.jsp");
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

			protected void loadStadium(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				int cityId= Integer.parseInt(request.getParameter("cityId"));
				System.out.println("cID :"+cityId);
				cityVo cityvo=new cityVo();
				cityvo.setC_id(cityId);
				employeeDao employeedao=new employeeDao();
				List list = employeedao.loadStadium(cityvo);
				HttpSession s=request.getSession();
				s.setAttribute("viewstadium",list);
				response.sendRedirect("Admin/loadStadium.jsp");
				}	

	}
