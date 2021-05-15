package com.trescomas.utils;

import com.trescomas.service.DataService;

public class StringUtils extends org.springframework.util.StringUtils {

    public static final String DATA_SERVICE_POSTFIX = "DataService";

    /**
     * @return String - name of entity based on class name of the corresponding DataService
     */
    public static String getEntityName(DataService<?, ?> dataService) {
        var dataServiceName = dataService.getClass().getSimpleName();
        return dataServiceName.substring(0, dataServiceName.indexOf(DATA_SERVICE_POSTFIX));
    }

}
