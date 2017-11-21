package me.langker.LendingPlat.Controller;
import javax.faces.bean.ManagedBean;   
import javax.faces.bean.SessionScoped;   

@ManagedBean(name="hello")   
@SessionScoped   
public class UserController {   
	private String name; 
	public String getName(){   
        if(this.name == null){   
           return "World";   
        }   
        return name;   
    }   
    public void setName(String name){   
        this.name = name;   
    }   
}   