package com.netcracker.unc.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ParseUtilTest {

    @Test
    public void parseStringArrayTest() {
        String stringArray = "1, 2, 3,4";
        ArrayList resList = ParseUtil.parseStringArray(stringArray);
        Assert.assertEquals(4, resList.size());
        Assert.assertEquals(1, resList.get(0));
        Assert.assertEquals(2, resList.get(1));
        Assert.assertEquals(3, resList.get(2));
        Assert.assertEquals(4, resList.get(3));
    }

    @Test
    public void convertArrayToStringTest() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};
        String stringArray = ParseUtil.convertArrayToString(arrayList);
        Assert.assertEquals("1, 2, 3", stringArray);
    }
}
