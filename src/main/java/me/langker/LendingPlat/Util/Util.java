package me.langker.LendingPlat.Util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@SessionScoped
public class Util { 
	private static Util instance;
	private Util() {};
	public static Util getInstance() {
		if (instance == null) {
			instance = new Util();
		}
		return instance;
	}
	public String submit(Part file) throws IOException{
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String rootPath = session.getServletContext().getRealPath("/upload/"); //得到服务器相对路径   
		try (InputStream input = file.getInputStream()) {
			String filename = String.valueOf(System.currentTimeMillis())+".jpg";
	        Files.copy(input, new File(rootPath, filename).toPath());
	        return filename;
	    }
	    catch (IOException e) {
	    	return null;
	    }
    }
	public int getUserId() {
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		return (int)session.getAttribute("userid");
	}
}
