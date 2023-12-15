package com.lpu.ecommerce.utils;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author KANWALJEET on 29-11-2023
 * @project ecommerce
 **/
public final class StringUtils {

    private StringUtils() throws IllegalAccessException {
        throw new IllegalAccessException("you can not create an object of utility class");
    }

    public static String format(String message,Object ...args){
        final String[] msg = {message};
        Arrays.stream(args).forEach(arg -> msg[0] = msg[0].replaceFirst("\\{\\}",arg.toString()));
        return msg[0];
    }

}
