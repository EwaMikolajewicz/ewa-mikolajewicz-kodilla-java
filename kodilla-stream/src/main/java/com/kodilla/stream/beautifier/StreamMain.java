package com.kodilla.stream.beautifier;

import jdk.nashorn.internal.objects.NativeString;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Sample text", text -> ("ABC " + text + " ABC"));
        poemBeautifier.beautify("Sample text", text -> (toUpperCase(text)));
        poemBeautifier.beautify("Sample text", text -> ("-- " + toLowerCase(text) + " --"));
        poemBeautifier.beautify("Sample text", Glam::glamText);
    }
}