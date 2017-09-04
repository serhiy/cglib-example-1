package xyz.codingdaddy.cglib.chat.session;

import xyz.codingdaddy.cglib.chat.security.Credentials;

/**
 * Manages the user session.
 * 
 * @author serhiy
 */
public class DummySession {

	private static Credentials credentials;

	private DummySession() {}
	
	/**
	 * Initiates the user session.
	 * 
	 * @param username
	 * @param password
	 */
	public static void set(String username, String password) {
		credentials = new Credentials(username, password);
	}
	
	/**
	 * @return the credentials of currently authenticated user.
	 */
	public static Credentials getCredentials() {
		return credentials;
	}

	/**
	 * @return true is user is authenticated, false otherwise.
	 */
	public static boolean isAuthenticated() {
		return credentials != null;
	}

	/**
	 * Invalidates the session.
	 */
	public static void invalidate() {
		credentials = null;
	}
}
