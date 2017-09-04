package xyz.codingdaddy.cglib.chat;

/**
 * Represents the message which can be written/read from the chat.
 * 
 * @author serhiy
 */
public class ACMEMessage {
	private long timestamp;
	private String username;
	private String message;

	public ACMEMessage(long timestamp, String message) {
		this.timestamp = timestamp;
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
