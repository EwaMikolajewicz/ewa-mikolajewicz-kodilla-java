package com.kodilla.patterns.builder.bigmac;

import java.util.HashSet;
import java.util.Set;

public final class Bigmac {

    private final String bun;
    private final String sauce;
    private final int burgers;

    public enum Ingredients {
        onion,
        mushrooms,
        cheese,
        salad,
        chilli_peppers,
        cucumber,
        bacon,
        shrimp
    }

    private final Set<Ingredients> ingredients;

    private static final String WITH_SESAME = "with sesame";
    private static final String NO_SESAME = "without sesame";

    public static class BigmacBuilder {
        private String bun;
        private String sauce;
        private int burgers;
        private Set<Ingredients> ingredients = new HashSet<>();

        public BigmacBuilder bun(String bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder ingredient(Ingredients ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, sauce, burgers, ingredients);
        }
    }

    private Bigmac(String bun, String sauce, int burgers, Set<Ingredients> ingredients) {
        if (!bun.equals(NO_SESAME) && !bun.equals(WITH_SESAME)) {
            throw new IllegalStateException("Choose your bun between 'with sesame' or 'without sesame'");
        } else {
            this.bun = bun;
            this.sauce = sauce;
            this.burgers = burgers;
            this.ingredients = new HashSet<>(ingredients);
        }
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public Set<Ingredients> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {

        return "Your BigMac: " +
                "bun '" + bun + '\'' +
                ", with: " + burgers + " burgers, "
                + sauce + " sauce and ingredients: "
                + ingredients;
    }
}


