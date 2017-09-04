package xyz.codingdaddy.cglib.chat.security;

import java.lang.reflect.Method;

import xyz.codingdaddy.cglib.chat.ACMEChat;
import xyz.codingdaddy.cglib.chat.ACMEMessage;
import xyz.codingdaddy.cglib.chat.annotations.Secured;
import xyz.codingdaddy.cglib.chat.session.DummySession;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Performs security checks on the enhanced {@link ACMEChat} instance.
 * 
 * @author serhiy
 */
public class SecurityManager implements MethodInterceptor {

	public Object intercept(Object object, Method method, Object[] methodArgs,
			MethodProxy methodProxy) throws Throwable {

		// Check whether the method is secured (requires authentication).
		if (method.isAnnotationPresent(Secured.class)) {
			// Deny the invocation if no user is authenticated.
			if (!DummySession.isAuthenticated()) {
				System.out.println("User must be authenticated to invoke "
						+ method.getName() + "() method.");
				return null;
			}
		}

		// Check whether the method requires any enhacement
		if (method.getName().equalsIgnoreCase(
				ACMEChat.class.getDeclaredMethod("addMessage",
						ACMEMessage.class).getName())
				&& DummySession.getCredentials() != null) {
			((ACMEMessage) methodArgs[0]).setUsername(DummySession
					.getCredentials().getUsername());
		}

		// Invoke the original method implementation
		return methodProxy.invokeSuper(object, methodArgs);
	}

}
