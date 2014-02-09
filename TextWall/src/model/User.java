package model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private List<Msg> messages = new ArrayList<Msg>();
	private String username;
	private String phonenumber;
	public List<Msg> getMessages() {
		return messages;
	}

	public void setMessages(List<Msg> messages) {
		this.messages = messages;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	

}
