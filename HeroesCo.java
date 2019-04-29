package Co;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import Dao.HeroesDao;
import Dao.attachmentDao;
import Vo.HeroesVo;
import Vo.attachmentVo;

/**
 * Servlet implementation class HeroesCo
 */
@WebServlet("/HeroesCo")
@MultipartConfig
public class HeroesCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeroesCo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("editHero")){
			editHero(request,response);
		}
		if(flag.equals("deleteHero")){
			deleteHero(request,response);
		}
		if(flag.equals("viewHero")){
			viewHero(request,response);
		}
	}

	private void viewHero(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		HeroesVo heroesVo = new HeroesVo();
		
		HeroesDao heroesDao = new HeroesDao();
		List ls = heroesDao.viewHero(heroesVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("viewHero", ls);
		
		response.sendRedirect("Admin/viewHero.jsp");
		
	}

	private void deleteHero(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int heroId = Integer.parseInt(request.getParameter("id"));
		
		HeroesVo heroesVo = new HeroesVo();
		heroesVo.setHeroId(heroId);
		
		HeroesDao heroesDao = new HeroesDao();
		heroesDao.deleteHero(heroesVo);
		
		viewHero(request, response);
		
	}

	private void editHero(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int heroId = Integer.parseInt(request.getParameter("id"));
		
		HeroesVo heroesVo = new HeroesVo();
		heroesVo.setHeroId(heroId);
		
		HeroesDao heroesDao = new HeroesDao();
		List ls=heroesDao.editHero(heroesVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("editHero", ls);
		
		response.sendRedirect("Admin/editHero.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String flag = request.getParameter("flag");
		
		if(flag.equals("addHero")){
			addHero(request,response);
		}
		if(flag.equals("updateHero")){
			updateHero(request,response);
		}
	}

	private void updateHero(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		int heroId = Integer.parseInt(request.getParameter("heroId"));
		String heroName = request.getParameter("heroName");
		String heroPosition = request.getParameter("heroPosition");
		int heroAge = Integer.parseInt(request.getParameter("heroAge"));
		String heroDob = request.getParameter("heroDob");
		
		Part filePart = request.getPart("heroImage"); 
	    String fileName = filePart.getSubmittedFileName();
	    InputStream fileContent = filePart.getInputStream();
	    
	    System.out.println("filePart :: "+filePart);
		System.out.println("file Name :: "+fileName);
	    
		System.out.println("File Content :: "+fileContent);
		
		byte[] buffer = new byte[fileContent.available()];
		fileContent.read(buffer);
	 
		String filePath = getServletContext().getRealPath(request.getServletPath());
		
		int path = filePath.lastIndexOf('\\');
		String path1= filePath.substring(0, path) +"\\doc\\";
		
		String encryptedFileName = encryptFileName(fileName);
		
		File targetEncryptFile = new File(path1+encryptedFileName);
	    OutputStream outStream = new FileOutputStream(targetEncryptFile);
	    outStream.write(buffer);
	    
	    System.out.println("File Output Path :: "+path1+fileName);
	    
	    outStream.close();
	    
	    attachmentVo attachmentVo = new attachmentVo();
	    attachmentVo.setFileName(fileName);
	    attachmentVo.setEncryptedFileName(encryptedFileName);
	    
	    attachmentDao attachmentDao = new attachmentDao();
	    attachmentDao.insert(attachmentVo);
	    
	    HeroesVo heroesVo = new HeroesVo();
	    heroesVo.setHeroId(heroId);
	    heroesVo.setHeroName(heroName);
	    heroesVo.setHeroDob(heroDob);
	    heroesVo.setHeroAge(heroAge);
	    heroesVo.setHeroPosition(heroPosition);
	    heroesVo.setAttachmentVo(attachmentVo);
	    
	    HeroesDao heroesDao = new HeroesDao();
	    heroesDao.updateHero(heroesVo);
		
	    viewHero(request, response);
	}

	private void addHero(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String heroName = request.getParameter("heroName");
		String heroDob = request.getParameter("heroDob");
		String heroPosition = request.getParameter("heroPosition");
		int heroAge = Integer.parseInt(request.getParameter("heroAge"));
		
		System.out.println("Name:"+heroName+"-DOB:"+heroDob+"-Position:"+heroPosition+"-Age:"+heroAge);
		
		Part filePart = request.getPart("heroImage"); 
	    String fileName = filePart.getSubmittedFileName();
	    InputStream fileContent = filePart.getInputStream();
	    
	    System.out.println("filePart :: "+filePart);
		System.out.println("file Name :: "+fileName);
	    
		System.out.println("File Content :: "+fileContent);
		
		byte[] buffer = new byte[fileContent.available()];
		fileContent.read(buffer);
	 
		String filePath = getServletContext().getRealPath(request.getServletPath());
		
		int path = filePath.lastIndexOf('\\');
		String path1= filePath.substring(0, path) +"\\doc\\";
		
		String encryptedFileName = encryptFileName(fileName);
		
		File targetEncryptFile = new File(path1+encryptedFileName);
	    OutputStream outStream = new FileOutputStream(targetEncryptFile);
	    outStream.write(buffer);
	    
	    System.out.println("File Output Path :: "+path1+fileName);
	    
	    outStream.close();
	    
	    attachmentVo attachmentVo = new attachmentVo();
	    attachmentVo.setFileName(fileName);
	    attachmentVo.setEncryptedFileName(encryptedFileName);
	    
	    attachmentDao attachmentDao = new attachmentDao();
	    attachmentDao.insert(attachmentVo);
	    
	    HeroesVo heroesVo = new HeroesVo();
	    heroesVo.setHeroName(heroName);
	    heroesVo.setHeroDob(heroDob);
	    heroesVo.setHeroAge(heroAge);
	    heroesVo.setHeroPosition(heroPosition);
	    heroesVo.setAttachmentVo(attachmentVo);
	    
	    HeroesDao heroesDao = new HeroesDao();
	    heroesDao.addHero(heroesVo);
	    
	    response.sendRedirect("Admin/addHero.jsp");
	}
	
	private String encryptFileName(String fileName){
		 
		   Random r = new Random();
		   String file[] = fileName.split("\\.");
		  
		   byte[] unencodedFile = file[0].getBytes();
		   MessageDigest md = null;
		   try {
		   md = MessageDigest.getInstance("MD5");
		   } catch (Exception e) {}
		   md.reset();
		   md.update(unencodedFile);
		   byte[] encodedFile = md.digest();
		   StringBuffer buf = new StringBuffer();
		   for (int i = 0; i < encodedFile.length; i++) {
		   if (((int) encodedFile[i] & 0xff) < 0x10) {
		   buf.append("0");
		   }
		   buf.append(Long.toString((int) encodedFile[i] & 0xff, 16));
		   }
		  
		   String encryptedFileName=(buf.toString()).concat(String.valueOf(r.nextInt())); 
   
		   return encryptedFileName+"."+file[1];
	   }
}
