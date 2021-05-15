package com.trescomas.utils;

import com.trescomas.service.role.impl.RoleDataServiceImpl;
import com.trescomas.service.user.impl.UserDataServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StringUtilsTest {

    @Test
    void getEntityName() {
        var userDataServiceMock = new UserDataServiceImpl(null);
        var roleServiceMock = new RoleDataServiceImpl(null);


        assertEquals("Role", StringUtils.getEntityName(roleServiceMock));
        assertEquals("User", StringUtils.getEntityName(userDataServiceMock));

        assertNotEquals("Role", StringUtils.getEntityName(userDataServiceMock));
        assertNotEquals("User", StringUtils.getEntityName(roleServiceMock));
    }
}