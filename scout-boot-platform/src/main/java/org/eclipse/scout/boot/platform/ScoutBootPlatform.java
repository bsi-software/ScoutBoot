package org.eclipse.scout.boot.platform;

import org.eclipse.scout.boot.platform.internal.ScoutBootBeanFilter;
import org.eclipse.scout.boot.platform.internal.ScoutBootBeanManager;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.Replace;
import org.eclipse.scout.rt.platform.config.ConfigUtility;
import org.eclipse.scout.rt.platform.interceptor.IBeanDecorator;
import org.eclipse.scout.rt.platform.internal.BeanManagerImplementor;
import org.eclipse.scout.rt.platform.internal.PlatformImplementor;
import org.eclipse.scout.rt.platform.inventory.ClassInventory;
import org.eclipse.scout.rt.server.commons.WebappEventListener;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Scout platform which uses Spring bean manager to manage and lookup beans.
 * <p>
 * This allows Scout beans to be looked up via {@link BEANS#get(Class)} or
 * {@link ConfigurableApplicationContext#getBean(Class)}. Also, when lookup
 * beans via Scout bean manager, the semantic of {@link Replace}, {@link Order}
 * and {@link IBeanDecorator} is still guaranteed.
 * <p>
 * This class is registered in
 * 'META-INF/services/org.eclipse.scout.rt.platform'.
 */
public class ScoutBootPlatform extends PlatformImplementor implements ApplicationListener<ApplicationReadyEvent> {
	// TODO Reactor that Scout gets started when Spring is Ready
	// TODO Check Platform stop

	private ConfigurableApplicationContext springApplicationContext;

	/**
	 * This method does nothing. Use
	 * {@link #start(ConfigurableApplicationContext)} instead.
	 */
	@Override
	public void start() {
		notifyPlatformStarting();
		return;
	}

	/**
	 * Starts the Scout platform.
	 */
	public void start(final ConfigurableApplicationContext context) {
		this.springApplicationContext = context;
		this.springApplicationContext.addApplicationListener(this);
		System.setProperty(ConfigUtility.CONFIG_FILE_NAME, "application.properties");

		super.start();
	}

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		super.changeState(State.PlatformStarted, true);
	}

	@Override
	protected void changeState(final State newState, final boolean throwOnIllegalStateChange) {
		if (State.PlatformStarted.equals(newState)) {
			return; // Scout platform transitions into this state upon Spring platform is ready. See 'onApplicationEvent(ApplicationReadyEvent)'
		}
		super.changeState(newState, throwOnIllegalStateChange);
	}

	@Override
	protected BeanManagerImplementor createBeanManager() {
		final BeanDefinitionRegistry springBeanRegistry = (BeanDefinitionRegistry) springApplicationContext.getBeanFactory();
		final ScoutBootBeanManager beanManager = new ScoutBootBeanManager(springApplicationContext, springBeanRegistry);

		for (final Class<?> bean : new ScoutBootBeanFilter().withNoArgConstructorRequired(false)
				.withIgnoredBeanClass(WebappEventListener.ServletContextRegistration.class.getName())
				.collect(ClassInventory.get())) {
			beanManager.registerClass(bean);
		}

		return beanManager;
	}
}
