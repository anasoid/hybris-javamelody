
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

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import com.github.anasoid.hybris.javamelody.constants.JavamelodyConstants;
import de.hybris.platform.core.Registry;

public class HybrisMonitoringFilter extends net.bull.javamelody.MonitoringFilter {

  private Boolean monitoringEnabled;


  public HybrisMonitoringFilter() {
    super();

  }


  @Override
  public void init(FilterConfig config) throws ServletException {
    if (isMonitoringEnabled()) {
      super.init(config);
    }
  }

  @Override
  public void destroy() {
    if (isMonitoringEnabled()) {
      super.destroy();
    }
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    if (isMonitoringEnabled()) {
      super.doFilter(request, response, chain);
    } else {
      chain.doFilter(request, response);
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
