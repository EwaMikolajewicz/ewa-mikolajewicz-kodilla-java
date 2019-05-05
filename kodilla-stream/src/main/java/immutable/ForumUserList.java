package immutable;

import java.util.ArrayList;
import java.util.List;

public final class ForumUserList {
    private final List<ForumUser> theForumUserList = new ArrayList<>();

    public ForumUserList() {
        theForumUserList.add(new ForumUser(0, "User Test1", ForumUser.Sex.M, 1975,5,17,1));
        theForumUserList.add(new ForumUser(1, "User Test2", ForumUser.Sex.M, 1975,5,17,0));
        for (int i = 2; i < 30; i++) {
            if (i %2  == 0) {
                theForumUserList.add(new ForumUser(i, "User" + i, ForumUser.Sex.M, 1948 + 3*i, 7, 31-i, i * 13-25));
            } else {
                theForumUserList.add(new ForumUser(i, "User" + i, ForumUser.Sex.F, 1968 + i, 11, i, 123 + i * 14));
            }
        }
    }

    public List<ForumUser> getForumUserList() {
        return new ArrayList<>(theForumUserList);
    }
}