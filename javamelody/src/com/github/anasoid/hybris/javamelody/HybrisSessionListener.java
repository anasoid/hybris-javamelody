/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.github.anasoid.hybris.javamelody;

import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpSessionEvent;
import com.github.anasoid.hybris.javamelody.constants.JavamelodyConstants;
import de.hybris.platform.core.Registry;
import net.bull.javamelody.SessionListener;

/**
 * @author Anas OUFDOU
 */
public class HybrisSessionListener extends SessionListener {

  private Boolean monitoringEnabled;

  /**
   *
   */
  public HybrisSessionListener() {

    super();

  }

  /**
   * @param instanceEnabled
   */
  public HybrisSessionListener(boolean instanceEnabled) {
    super(instanceEnabled);

  }

  /*
   * (non-Javadoc)
   *
   * @see net.bull.javamelody.SessionListener#contextInitialized(javax.servlet.ServletContextEvent)
   */
  @Override
  public void contextInitialized(ServletContextEvent event) {
    if (isMonitoringEnabled()) {
      super.contextInitialized(event);
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see net.bull.javamelody.SessionListener#contextDestroyed(javax.servlet.ServletContextEvent)
   */
  @Override
  public void contextDestroyed(ServletContextEvent event) {
    if (isMonitoringEnabled()) {
      super.contextDestroyed(event);
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see net.bull.javamelody.SessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
   */
  @Override
  public void sessionCreated(HttpSessionEvent event) {
    if (isMonitoringEnabled()) {
      super.sessionCreated(event);
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see net.bull.javamelody.SessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
   */
  @Override
  public void sessionDestroyed(HttpSessionEvent event) {
    if (isMonitoringEnabled()) {
      super.sessionDestroyed(event);
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * net.bull.javamelody.SessionListener#sessionDidActivate(javax.servlet.http.HttpSessionEvent)
   */
  @Override
  public void sessionDidActivate(HttpSessionEvent event) {
    if (isMonitoringEnabled()) {
      super.sessionDidActivate(event);
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * net.bull.javamelody.SessionListener#sessionWillPassivate(javax.servlet.http.HttpSessionEvent)
   */
  @Override
  public void sessionWillPassivate(HttpSessionEvent event) {
    if (isMonitoringEnabled()) {
      super.sessionWillPassivate(event);
    }
  }


  private Boolean isMonitoringEnabled() {

    if (monitoringEnabled == null) {

      monitoringEnabled = Registry.getMasterTenant().getConfig()
          .getBoolean(JavamelodyConstants.MONITORING_ENABLED_KEY, true);
    }
    return monitoringEnabled;

  }

}
