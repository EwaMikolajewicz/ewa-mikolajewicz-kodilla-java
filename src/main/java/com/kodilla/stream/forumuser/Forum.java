package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    final List<ForumUser> theListOfForumUsers = new ArrayList<>();

    public Forum(){
        theListOfForumUsers.add(new ForumUser(1, "Frodo", ForumUser.Sex.M, 2004,3,12,123));
        theListOfForumUsers.add(new ForumUser(2, "Calineczka", ForumUser.Sex.F, 1985,12,2,3));
        theListOfForumUsers.add(new ForumUser(3, "Gandalf", ForumUser.Sex.M, 1990,11,30,0));
        theListOfForumUsers.add(new ForumUser(4, "Gemma85", ForumUser.Sex.F, 1984,11,12,58));
        theListOfForumUsers.add(new ForumUser(5, "Frida", ForumUser.Sex.F, 2004,3,3,123));
        theListOfForumUsers.add(new ForumUser(6, "Gemma1", ForumUser.Sex.M, 1998,4,1,1000));
        theListOfForumUsers.add(new ForumUser(7, "Zuza", ForumUser.Sex.F, 2014,12,6,1));
        theListOfForumUsers.add(new ForumUser(8, "Frodo", ForumUser.Sex.M, 1970,1,1,584));
        theListOfForumUsers.add(new ForumUser(9, "Zenek8", ForumUser.Sex.M, 1991,5,20,3));
        theListOfForumUsers.add(new ForumUser(10, "Wojtek", ForumUser.Sex.M, 1999,9,11,145));
        theListOfForumUsers.add(new ForumUser(11, "Ada", ForumUser.Sex.F, 2004,10,2,10));
    }

    public List<ForumUser> getList(){
        return new ArrayList<>(theListOfForumUsers);
    }
}
