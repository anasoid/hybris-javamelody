/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with SAP.
 */
package com.github.anasoid.hybris.javamelody.constants;

/**
 * Global class for all Javamelody constants. You can add global constants for your extension into
 * this class.
 */
public final class JavamelodyConstants extends GeneratedJavamelodyConstants {
  public static final String EXTENSIONNAME = "javamelody";

  private JavamelodyConstants() {
    // empty to avoid instantiating this constant class
  }

  // implement here constants used by this extension

  public static final String PLATFORM_LOGO_CODE = "javamelodyPlatformLogo";

  public static final String MONITORING_ENABLED_KEY = "monitoring.javamelody.enabled";
}
