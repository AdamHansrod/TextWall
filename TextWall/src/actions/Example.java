package actions;

//Install the Java helper library from twilio.com/docs/java/install
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.AccountFactory;
import com.twilio.sdk.resource.instance.Account;

public class Example { 
//1dbb01a18674959c97f28d532cc1b077
// Find your Account Sid and Token at twilio.com/user/account
public static final String ACCOUNT_SID = "ACfc938b4c9f1813e2a98321fccbb86976";
public static final String AUTH_TOKEN = "1dbb01a18674959c97f28d532cc1b077";

public static void main(String[] args) throws TwilioRestException {
 TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

 // Build a filter for the AccountList
 List<NameValuePair> params = new ArrayList<NameValuePair>();
 params.add(new BasicNameValuePair("FriendlyName", "Submarine"));
  
  
 AccountFactory accountFactory = client.getAccountFactory();
 Account account = accountFactory.create(params);
 System.out.println(account.getSid());
}
}