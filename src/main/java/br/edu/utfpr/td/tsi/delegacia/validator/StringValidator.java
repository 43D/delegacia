package br.edu.utfpr.td.tsi.delegacia.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class StringValidator {
    public static String validateStringWithoutSpace(String str, String name) {
        if (str == null)
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, name + " Invalida!!!");

        str = str.replaceAll("[^a-zA-Z0-9áàâãéèêíïóôõöúçñ]", "");
        str = str.trim();
        str = str.toUpperCase();
        if (str.isEmpty())
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, name + " Invalida!!!");

        return str;
    }

    public static String validateStringWithSpace(String str, String name) {
        if (str == null)
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, name + " Invalida!!!");

        str = str.replaceAll("[^a-zA-Z0-9áàâãéèêíïóôõöúçñ ]", "");
        str = str.trim();
        str = str.toUpperCase();
        if (str.isEmpty())
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, name + " Invalida!!!");

        return str;
    }

    public static String validateStringWithUnderline(String str, String name) {
        if (str == null)
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, name + " Invalida!!!");

        str = str.replaceAll(" ", "_");
        str = str.replaceAll("[^a-zA-Z0-9_]", "");
        str = str.trim();
        str = str.toUpperCase();
        if (str.isEmpty())
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, name + " Invalida!!!");

        return str;
    }

    public static boolean validateRegex(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static String validateString(String str, String name) {
        if (str == null)
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, name + " Invalida!!!");

        str = str.trim();
        str = str.toUpperCase();
        if (str.isEmpty())
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, name + " Invalida!!!");

        return str;
    }

}
