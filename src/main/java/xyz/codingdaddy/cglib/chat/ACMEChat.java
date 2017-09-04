package xyz.codingdaddy.cglib.chat;

import java.util.ArrayList;
import java.util.List;

import xyz.codingdaddy.cglib.chat.annotations.Secured;

/**
 * Represents the chat service.
 * 
 * @author serhiy
 */
public class ACMEChat {
	private List<ACMEMessage> messages = new ArrayList<ACMEMessage>();

	/**
	 * @param message to be written to the chat (required authentication).
	 */
	@Secured
	public void addMessage(ACMEMessage message) {
		messages.add(message);
	}

	/**
	 * @return the list of written messages (does not need authentication).
	 */
	public List<ACMEMessage> getMessages() {
		return new ArrayList<ACMEMessage>(messages);
	}

	/**
	 * @return the timestamp of the last message (does not need authentication).
	 */
	public long getLastMessageTimestamp() {
		return messages.get(messages.size() - 1).getTimestamp();
	}

}
