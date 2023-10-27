package br.edu.utfpr.td.tsi.delegacia.boletim.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {
    public static String validateString(String str, String name) {
        if (str == null)
            throw new IllegalStateException(name + " Invalido!!!");

        str = str.replaceAll("[^a-zA-Z0-9]", "");
        str = str.trim();
        str = str.toUpperCase();
        if (str.isEmpty())
            throw new IllegalStateException(name + " Invalido!!!");

        return str;
    }

    public static boolean validateRegex(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}
