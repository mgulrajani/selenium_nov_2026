package com.itm.dataproviders;

import org.testng.annotations.DataProvider;

import com.itm.utils.ExcelUtil;

public class LoginDataProvider {
    @DataProvider(name="loginData")
    public Object[][] getData()
            throws Exception {
        return ExcelUtil.getLoginData();
    }
}
