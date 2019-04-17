package forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int uniqueID;
    private final String userName;
    private final Sex sex;
    private final LocalDate birthDate;
    int postsQuantity;
    private final LocalDate today = LocalDate.now();

    public enum Sex {
        M,
        F
    }

    public ForumUser(final int uniqueID, final String userName, final Sex sex, final int year, final int month, final int day, int postsQuantity) {
        this.uniqueID = uniqueID;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = LocalDate.of(year, month, day);
        this.postsQuantity = postsQuantity;

    }


    public LocalDate getToday() {
        return today;
    }

    public Sex getSex() {
        return sex;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    @Override
    public String toString() {
        return userName +
                ", sex: " + sex +
                ", birthDate: " + birthDate +
                ", postsQuantity: " + postsQuantity;
    }
}