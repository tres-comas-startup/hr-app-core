package com.trescomas.domain.dto.util;

import java.util.Map;

public record AppInfo(String name, String version, Map<String, String> routesMap) {
}
