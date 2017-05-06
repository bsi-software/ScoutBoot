#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.ui;

import ${package}.${artifactId}.model.User;
import ${package}.${artifactId}.model.service.UserService;

import javax.inject.Inject;

import org.eclipse.scout.boot.ui.scout.AbstractScoutBootClientSession;
import org.eclipse.scout.rt.client.IClientSession;
import org.eclipse.scout.rt.client.session.ClientSessionProvider;
import org.eclipse.scout.rt.platform.BEANS;

/**
 * Session class for the Eclipse Scout user interface.
 */
public class ClientSession extends AbstractScoutBootClientSession {

  private String userId = "";

  @Inject
  protected UserService userService;

  /**
   * @return The {@link IClientSession} which is associated with the current thread, or <code>null</code> if not found.
   */
  public static ClientSession get() {
    return ClientSessionProvider.currentSession(ClientSession.class);
  }

  @Override
  protected void execLoadSession() {
    initCurrentUser();
    setDesktop(BEANS.get(Desktop.class)); // lookup via BeanManager to support auto-wiring.
  }

  private void initCurrentUser() {
    if (getSubject() != null && !getSubject().getPrincipals().isEmpty()) {
      userId = getSubject().getPrincipals().iterator().next().getName();

      User user = userService.get(userId);
      if (user.getLocale() != null) {
        setLocale(user.getLocale());
      }
    }
  }

  @Override
  public String getUserId() {
    return userId;
  }
}
