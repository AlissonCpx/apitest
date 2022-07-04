package com.api.test.sdconecta.apitest.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Util {

    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "reg.properties");
        props.load(file);
        return props;
    }

}
