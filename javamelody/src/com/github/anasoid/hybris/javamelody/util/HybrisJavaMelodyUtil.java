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

package com.github.anasoid.hybris.javamelody.util;

import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang3.StringUtils;
import com.github.anasoid.hybris.javamelody.constants.JavamelodyConstants;
import de.hybris.platform.core.Registry;

/**
 * 
 * @author Anas OUFDOU
 */
public final class HybrisJavaMelodyUtil {

  private static Boolean monitoringEnabled;
  private static boolean init = false;

  public static Boolean isMonitoringEnabled() {

    if (monitoringEnabled == null) {
      monitoringEnabled = Registry.getMasterTenant().getConfig()
          .getBoolean(JavamelodyConstants.MONITORING_ENABLED_KEY, true);
    }
    return monitoringEnabled;
  }


  public static void init() {
    if (!init) {
      Map<String, String> params = Registry.getMasterTenant().getConfig()
          .getParametersMatching("monitoring.javamelody\\..*");
      for (Entry<String, String> entry : params.entrySet()) {
        if (StringUtils.isNotBlank(entry.getValue())) {
          String key = entry.getKey().substring("monitoring.".length());
          if (StringUtils.isBlank(System.getProperty(key))) {
            System.setProperty(key, entry.getValue());
          }
        }

      }
      if (!isMonitoringEnabled()) {
        System.setProperty("monitoring.no-database", "true");
        System.setProperty("monitoring.disabled", "true");
      }
      init = true;
    }
  }
}
