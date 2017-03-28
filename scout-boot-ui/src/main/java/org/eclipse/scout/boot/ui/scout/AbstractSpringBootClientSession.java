package org.eclipse.scout.boot.ui.scout;

import org.eclipse.scout.rt.client.AbstractClientSession;
import org.eclipse.scout.rt.client.IClientSession;
import org.eclipse.scout.rt.client.session.ClientSessionProvider;
import org.eclipse.scout.rt.platform.BEANS;

public abstract class AbstractSpringBootClientSession extends AbstractClientSession {

	public AbstractSpringBootClientSession() {
		super(true);
	}

	/**
	 * @return The {@link IClientSession} which is associated with the current
	 *         thread, or <code>null</code> if not found.
	 */
	public static AbstractSpringBootClientSession get() {
		return ClientSessionProvider.currentSession(AbstractSpringBootClientSession.class);
	}

	@Override
	protected void execLoadSession() {
		setDesktop(BEANS.get(AbstractScoutBootDesktop.class));
	}

	@Override
	public String getUserId() {
		return "root";
	}
}
