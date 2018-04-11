package com.netcracker.unc.util;

import java.util.ArrayList;
import java.util.Arrays;

public class ParseUtil {
    public static ArrayList<Integer> parseStringArray(String array) {
        if (array == null) return null;
        ArrayList<Integer> result = new ArrayList<>();
        String[] strings = array.split(",");
        Arrays.stream(strings).forEach(stringValue -> {
            try {
                result.add(Integer.parseInt(stringValue.trim()));
            } catch (NumberFormatException e) {
                //TODO: add logger
            }
        });
        return result;
    }

    public static String convertArrayToString(ArrayList<Integer> arrayList) {
        return arrayList == null ? null : arrayList.toString().replaceAll("\\[", "").replaceAll("]", "").trim();
    }
}
