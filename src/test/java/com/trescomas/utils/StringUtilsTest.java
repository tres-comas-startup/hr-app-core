package com.trescomas.utils;

import com.trescomas.service.dataService.impl.RoleDataServiceImpl;
import com.trescomas.service.dataService.impl.UserDataServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StringUtilsTest {

    @Test
    void getEntityName() {
        var roleServiceMock = new RoleDataServiceImpl(null);
        var userDataServiceMock = new UserDataServiceImpl(null, roleServiceMock, null);

        assertEquals("Role", StringUtils.getEntityName(roleServiceMock));
        assertEquals("User", StringUtils.getEntityName(userDataServiceMock));

        assertNotEquals("Role", StringUtils.getEntityName(userDataServiceMock));
        assertNotEquals("User", StringUtils.getEntityName(roleServiceMock));
    }
}