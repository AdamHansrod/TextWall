package actions;

import java.util.ArrayList;
import java.util.List;

import model.Msg;
import model.User;

import com.opensymphony.xwork2.ActionSupport;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.instance.Message;
import com.twilio.sdk.resource.list.MessageList;

public class GetMessagesAction extends ActionSupport {
	// Find your Account Sid and Token at twilio.com/user/account
	private static final String ACCOUNT_SID = "";//sub account
	private static final String AUTH_TOKEN = "";
	private static final String TWILIO_PHONE_NUMBER = "+";
	private static final String USERNAME_SEPERATOR = ":";
	private List<Msg> msgs = new ArrayList<Msg>();
	private List<User> users = new ArrayList<User>();
	public String execute() {
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		MessageList messages = client.getAccount().getMessages();
		//get the list of messages not from the twilio phone number
		for(Message msg: messages){
			Msg m = new Msg();
			m.setContent(msg.getBody());
			m.setFrom(msg.getFrom());
			m.setPhonenumber(msg.getFrom());
			if (!m.getFrom().equals(TWILIO_PHONE_NUMBER)){
				msgs.add(m);
			}
		}
		createUsers();
		//msgs =  assignUsernames(msgs);
		assignMessagesToUsername(msgs);
		mergeAnyUsers();
		return SUCCESS;
	}
	private void mergeAnyUsers(){
		
	}
	private void createUsers(){
		for (Msg msg:msgs){
			String content = msg.getContent();
			if (content.contains(USERNAME_SEPERATOR)){//They've set a username at some point
				//go through list, looking at each from value, if matching then set the from field to username
				String phonenumber = msg.getPhonenumber();
				String username = content.substring(0,content.indexOf(USERNAME_SEPERATOR));
				//add a user to the list
				addUser(username,phonenumber);
				assignUsernameForAllMessages(msgs, phonenumber,username);
				//remove the username from the original message
				msg.setContent(content.substring(content.indexOf(":") + 1));
			}else{
//				addUser(msg.getFrom(),);
			}
		}
	}

	private void assignMessagesToUsername(List<Msg> msgs){
		for (Msg msg:msgs){
				for (User user:users){
					if (user.getUsername().equals(msg.getUsername())){
						List<Msg> usersMsgs = user.getMessages();
						usersMsgs.add(msg);
						user.setMessages(usersMsgs);
					}
				}
		}		
	}

	private void addUser(String username,String phonenumber){
		if(!containsUser(users,username)){
			User u = new User();
			u.setUsername(username);
			u.setPhonenumber(phonenumber);
			users.add(u);
//			System.out.println(username);
		}
	}
	private boolean containsUser(List<User> users, String username){
		for (User u:users){
			if(u.getUsername().equals(username)){
				return true;
			}
		}
		return false;
	}
	private List<Msg> assignUsernames(List<Msg> msgs){
		for (Msg msg:msgs){
			String content = msg.getContent();
			if (content.contains(USERNAME_SEPERATOR)){//They've set a username at some point
				//go through list, looking at each from value, if matching then set the from field to username
				String phonenumber = msg.getPhonenumber();
				String username = content.substring(0,content.indexOf(USERNAME_SEPERATOR));
				//add a user to the list
				addUser(username,phonenumber);
				assignUsernameForAllMessages(msgs, phonenumber,username);
				//remove the username from the original message
				content = content.substring(content.indexOf(":") + 1);
				msg.setContent(content);
				msg.setFrom(username);
			}else{
				addUser(msg.getFrom(),msg.getFrom());
				msg.setFrom(msg.getFrom());
			}
		}			
		return msgs;
	}
	private List<Msg> assignUsernameForAllMessages(List<Msg> msgs, String phonenumber, String username){
		for (Msg msg:msgs){
			if (msg.getPhonenumber().equals(phonenumber)){
				msg.setFrom(username);
				msg.setUsername(username);
			}
		}
		return msgs;
	}
	public List<Msg> getMsgs() {
		return msgs;
	}
	public void setMsgs(List<Msg> msgs) {
		this.msgs = msgs;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
