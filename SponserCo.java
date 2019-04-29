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

import Dao.SponserDao;
import Dao.attachmentDao;
import Vo.SponserVo;
import Vo.attachmentVo;

/**
 * Servlet implementation class SponserCo
 */
@WebServlet("/SponserCo")
@MultipartConfig
public class SponserCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SponserCo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String flag = request.getParameter("flag");
		
		if(flag.equals("viewSponser")){
			viewSponser(request,response);
		}
		if(flag.equals("editSponser")){
			editSponser(request,response);
		}
		if(flag.equals("deleteSponser")){
			deleteSponser(request,response);
		}
		if(flag.equals("loadSponser")){
			loadSponser(request,response);
		}
		
	}

	private void loadSponser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		SponserVo sponserVo = new SponserVo();
		
		SponserDao sponserDao = new SponserDao();
		List ls = sponserDao.loadSponser(sponserVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("loadSponser", ls);
		
		response.sendRedirect("User/about.jsp");
		
	}

	private void deleteSponser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int sponserId = Integer.parseInt(request.getParameter("id"));
		
		SponserVo sponserVo = new SponserVo();
		sponserVo.setSponserId(sponserId);
		
		SponserDao sponserDao = new SponserDao();
		sponserDao.deleteSponser(sponserVo);
		
		viewSponser(request, response);
		
	}

	private void editSponser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int sponserId = Integer.parseInt(request.getParameter("id"));
		
		SponserVo sponserVo = new SponserVo();
		sponserVo.setSponserId(sponserId);
		
		SponserDao sponserDao = new SponserDao();
		List ls = sponserDao.editSponser(sponserVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("editSponser", ls);
		
		response.sendRedirect("Admin/edit_sponsership.jsp");
		
	}

	private void viewSponser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		SponserVo sponserVo = new SponserVo();
		
		SponserDao sponserDao = new SponserDao();
		
		List ls = sponserDao.viewSponser(sponserVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("viewSponser", ls);
		
		response.sendRedirect("Admin/view_sponsership.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("addSponser")){
			addSponser(request,response);
		}
		if(flag.equals("updateSponser")){
			updateSponser(request,response);
		}
	}

	private void updateSponser(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		int sponserId = Integer.parseInt(request.getParameter("sponserId"));
		String sponserName = request.getParameter("sponserName");
		
		Part filePart = request.getPart("abc"); // Retrieves <input type="file" name="file">
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
	    
		
		
		SponserVo sponserVo = new SponserVo();
		sponserVo.setSponserId(sponserId);
		sponserVo.setSponserName(sponserName);
		sponserVo.setAttachmentVo(attachmentVo);
		
		SponserDao sponserDao = new SponserDao();
		sponserDao.updateSponser(sponserVo);
		
		viewSponser(request, response);
		
	}

	private void addSponser(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String sponserName = request.getParameter("sponserName");
		
		Part filePart = request.getPart("abc"); // Retrieves <input type="file" name="file">
	    String fileName = filePart.getSubmittedFileName();
	    InputStream fileContent = filePart.getInputStream();
	    // ... (do your job here)
	    
	    
	    System.out.println("filePart :: "+filePart);
		System.out.println("file Name :: "+fileName);
	    
		System.out.println("File Content :: "+fileContent);
		
		byte[] buffer = new byte[fileContent.available()];
		fileContent.read(buffer);
	 
		String filePath = getServletContext().getRealPath(request.getServletPath());
		
		int path = filePath.lastIndexOf('\\');
		String path1= filePath.substring(0, path) +"\\doc\\";
		
	    //File targetFile = new File(path1+fileName);
	    //OutputStream outStream = new FileOutputStream(targetFile);
	    //outStream.write(buffer);
		String encryptedFileName = encryptFileName(fileName);
	    //uncoment this if you want to encrypt name of file n coment above 3 line
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
	    
		
	    SponserVo sponserVo = new SponserVo();
		sponserVo.setSponserName(sponserName);
		sponserVo.setAttachmentVo(attachmentVo);
		
		SponserDao sponserDao = new SponserDao();
		sponserDao.addSponser(sponserVo);
		
		response.sendRedirect("Admin/add-sponsership.jsp");
	}
	
	//uncoment this to encrypt name of file
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