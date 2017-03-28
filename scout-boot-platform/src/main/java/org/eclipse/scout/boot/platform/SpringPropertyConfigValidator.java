package org.eclipse.scout.boot.platform;

import org.eclipse.scout.rt.platform.config.IConfigurationValidator;

public class SpringPropertyConfigValidator implements IConfigurationValidator {

	@Override
	public boolean isValid(String key, String value) {
		return true;
	}
}
