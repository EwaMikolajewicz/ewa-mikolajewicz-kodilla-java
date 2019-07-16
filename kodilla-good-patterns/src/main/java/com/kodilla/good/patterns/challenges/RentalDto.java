package com.kodilla.good.patterns.challenges;

public class RentalDto {
    public User user;
    public boolean isOrdered;

    public RentalDto(final User user, final boolean isOrdered) {
        this.user = user;
        this.isOrdered = isOrdered;
    }

    public User getUser() {
        return user;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
