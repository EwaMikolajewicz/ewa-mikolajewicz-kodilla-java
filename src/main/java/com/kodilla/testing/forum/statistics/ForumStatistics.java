package com.kodilla.testing.forum.statistics;

import java.util.ArrayList;
import java.util.List;

public class ForumStatistics {
    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double postsPerUserAverage;
    private double commentsPerUserAverage;
    private double commentsPerPostAverage;

    public ForumStatistics(Statistics statistics) {
        this.usersCount = statistics.usersNames().size();
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();
    }

    public List<Double> calculateAdvStatistics(Statistics statistics) {
        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
        if (statistics.usersNames().size() == 0 && statistics.postsCount() == 0) {
            postsPerUserAverage = 0;
            commentsPerUserAverage = 0;
            commentsPerPostAverage = 0;
        } else {
            if (!(statistics.usersNames().size() == 0)) {
                if (!(statistics.postsCount() == 0)) {
                    postsPerUserAverage = (double) statistics.postsCount() / statistics.usersNames().size();
                    commentsPerUserAverage = (double) statistics.commentsCount() / statistics.usersNames().size();
                    commentsPerPostAverage = (double) statistics.commentsCount() / statistics.postsCount();
                } else {
                    postsPerUserAverage = (double) statistics.postsCount() / statistics.usersNames().size();
                    commentsPerUserAverage = (double) statistics.commentsCount() / statistics.usersNames().size();
                    commentsPerPostAverage = 0;
                }

            } else {
                postsPerUserAverage = 0;
                commentsPerUserAverage = 0;
                commentsPerPostAverage = (double) statistics.commentsCount() / statistics.postsCount();
            }
        }

        List<Double> calcList = new ArrayList<>();
        calcList.add((double) usersCount);
        calcList.add((double) postsCount);
        calcList.add((double) commentsCount);
        calcList.add(postsPerUserAverage);
        calcList.add(commentsPerUserAverage);
        calcList.add(commentsPerPostAverage);
        return calcList;
    }

    public void showStatistics(Statistics statistics) {
        System.out.println("Number of users: " + calculateAdvStatistics(statistics).get(0) +
                "\nNumber of post: " + calculateAdvStatistics(statistics).get(1) +
                "\nNumber of comments: " + calculateAdvStatistics(statistics).get(2) +
                "\nAverage post per user: " + calculateAdvStatistics(statistics).get(3) +
                "\nAverage comments per user: " + calculateAdvStatistics(statistics).get(4) +
                "\nAverage comments per post: " + calculateAdvStatistics(statistics).get(5));
    }
}

