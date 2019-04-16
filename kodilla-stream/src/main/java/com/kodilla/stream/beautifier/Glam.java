package com.kodilla.stream.beautifier;

import jdk.nashorn.internal.objects.NativeString;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class Glam {
    public static String glamText (String text){
        return "@@ " + toUpperCase(NativeString.substr(text, 0, 1)) + toLowerCase(NativeString.substr(text, 1, NativeString.length(text)))+" @@";
    }
}
