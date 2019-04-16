package com.kodilla.stream.forumuser;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMaingg {
    public static void main(String[] args) {
        Forum theForumUserList = new Forum();
        Map<Integer, ForumUser> theResultSMapOfUsers = theForumUserList.getList().stream()
                .filter(user -> user.getSex() == ForumUser.Sex.M)
                .filter(user -> ((user.getToday().getYear() - user.getBirthDate().getYear())) >=20)
                .filter(user -> user.getPostsQuantity() >0)
                .collect(Collectors.toMap(ForumUser::getUniqueID, user -> user));
        System.out.println("# elements: " + theResultSMapOfUsers.size());
        theResultSMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}