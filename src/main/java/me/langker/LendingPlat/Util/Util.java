package me.langker.LendingPlat.Util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
		return (Integer)session.getAttribute("userid");
	}
	public static String getMD5(String str) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(str.getBytes());
	        return new BigInteger(1, md.digest()).toString(16);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
}
