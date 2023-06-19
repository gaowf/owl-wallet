package com.turing.wallet.utils;

public class NameUtils {
    public static String getHideName(String name) {

        try {
            if (name == null) {
                return "";
            }
            char names[] = name.toCharArray();
            if (names == null || names.length == 0) {
                return "";
            }

            String newName = String.valueOf(names[0]);

            for (int i = 0; i < names.length; i++) {
                if (i != 0) {
                    newName += "*";
                }
            }
            return newName;
        } catch (Exception e) {
            return "";
        }
    }
}
