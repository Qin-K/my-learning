package qinkai.web.action;


import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {
	public String execute() {
		System.out.println("hello word");
		return SUCCESS;
	}
}
