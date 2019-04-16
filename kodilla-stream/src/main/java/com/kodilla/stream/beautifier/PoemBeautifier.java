package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String text, PoemDecorator poemDecorator) {

       String poemText = poemDecorator.decorate(text);
       System.out.println(poemText);
    }

}
