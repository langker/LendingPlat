package me.langker.LendingPlat.Util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.primefaces.model.UploadedFile;

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
	public String submit(InputStream input, String savePath) {
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String rootPath = session.getServletContext().getRealPath(savePath); //得到服务器相对路径   
		
		
			String filename = String.valueOf(System.currentTimeMillis())+".jpg";
	        try {
				Files.copy(input, new File(rootPath, filename).toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return filename;
	   
    }
	public int getUserId() {
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		return (int)session.getAttribute("userid");
	}
}
