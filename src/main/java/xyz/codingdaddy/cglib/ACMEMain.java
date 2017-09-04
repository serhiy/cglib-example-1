package xyz.codingdaddy.cglib;

import java.util.Iterator;

import xyz.codingdaddy.cglib.chat.ACMEChat;
import xyz.codingdaddy.cglib.chat.ACMEMessage;
import xyz.codingdaddy.cglib.chat.security.SecurityManager;
import xyz.codingdaddy.cglib.chat.session.DummySession;
import net.sf.cglib.proxy.Enhancer;

/**
 * An example of the GCLib method interception.
 * 
 * @author serhiy
 */
public class ACMEMain {

	public static void main(String[] args) {
		
		DummySession.set("test", "test");

		ACMEChat chat = (ACMEChat) Enhancer.create(ACMEChat.class, new SecurityManager());
		
		System.out.println(" --- Adding message --- ");
		chat.addMessage(new ACMEMessage(System.currentTimeMillis(), "Hello message 1."));
		
		System.out.println(" --- Listing messages --- ");
		Iterator<ACMEMessage> iterator = chat.getMessages().iterator();
		while(iterator.hasNext()) {
			ACMEMessage message = iterator.next();
			System.out.println(message.getTimestamp() + " : <" + message.getUsername() + "> : " + message.getMessage());
		}
		
		System.out.println(" --- Last message timestamp --- ");
		System.out.println(chat.getLastMessageTimestamp());
		
		DummySession.invalidate();
		
		System.out.println(" --- Adding message (not authenticated) --- ");
		chat.addMessage(new ACMEMessage(System.currentTimeMillis(), "Hello message 2."));
		
		System.out.println(" --- Listing messages (not authenticated) --- ");
		iterator = chat.getMessages().iterator();
		while(iterator.hasNext()) {
			ACMEMessage message = iterator.next();
			System.out.println(message.getTimestamp() + " : <" + message.getUsername() + "> : " + message.getMessage());
		}
		
		System.out.println(" --- Last message timestamp (not authenticated) --- ");
		System.out.println(chat.getLastMessageTimestamp());
	}
}
