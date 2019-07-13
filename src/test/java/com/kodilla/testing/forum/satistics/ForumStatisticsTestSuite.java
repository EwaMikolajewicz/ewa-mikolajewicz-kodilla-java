package com.kodilla.testing.forum.satistics;

import com.kodilla.testing.forum.statistics.ForumStatistics;
import com.kodilla.testing.forum.statistics.Statistics;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    private static int testCounterS = 0;
    private static int testCounterF = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("\nAll tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounterS++;
        System.out.println("\nPreparing to execute test #" + testCounterS + "...\n");
    }

    @After
    public void afterEveryTest() {
        testCounterF++;
        System.out.println("\nTest #" + testCounterF + " is finished.");
    }

    @Test
    public void testCalculateAdvStatisticsWithZeroPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        List<String> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add("User" + i);
        }
        int postCount = 0;
        int commentsCount = 24;

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);

        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);

        //When
        forumStatistics.showStatistics(statisticsMock);
        List<Double> mockList = forumStatistics.calculateAdvStatistics(statisticsMock);

        double numberOfPosts = mockList.get(1);
        double numberOfComments = mockList.get(2);
        double averOfPostsPerUser = mockList.get(3);
        double averOfCommentsPerUser = mockList.get(4);
        double averOfCommentsPerPost = mockList.get(5);

        //Then
        Assert.assertEquals(24, numberOfComments, 0.01);
        Assert.assertEquals(0, numberOfPosts, 0);
        Assert.assertEquals(0, averOfPostsPerUser, 0.001);
        Assert.assertEquals(0, averOfCommentsPerPost, 0.1);
        Assert.assertEquals(2.4, averOfCommentsPerUser, 0.00);
    }

    @Test
    public void testCalculateAdvStatisticsWithNoComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            users.add("User" + i);
        }

        int postCount = 100;
        int commentCount = 0;

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);

        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);

        //When
        List<Double> mockList = forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics(statisticsMock);

        double numberOfComments = mockList.get(2);
        double averOfPostsPerUser = mockList.get(3);
        double averOfCommentsPerUser = mockList.get(4);
        double averOfCommentsPerPost = mockList.get(5);

        //Then
        Assert.assertEquals(0, numberOfComments, 0);
        Assert.assertEquals(8.3333, averOfPostsPerUser, 0.0001);
        Assert.assertEquals(0, averOfCommentsPerPost, 0);
        Assert.assertEquals(0, averOfCommentsPerUser, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWithNoUsers() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<>();

        int postCount = 100;
        int commentCount = 12;

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);

        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);

        //When
        List<Double> mockList = forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics(statisticsMock);

        double numberOfUsers = mockList.get(0);
        double averOfPostsPerUser = mockList.get(3);
        double averOfCommentsPerUser = mockList.get(4);
        double averOfCommentsPerPost = mockList.get(5);

        //Then

        Assert.assertEquals(0, numberOfUsers, 0);
        Assert.assertEquals(0, averOfPostsPerUser, 0);
        Assert.assertEquals( 0.12, averOfCommentsPerPost, 0.001);
        Assert.assertEquals(0, averOfCommentsPerUser, 0);

    }

    @Test
    public void testCalculateAdvStatisticsWithLessCommentsThenPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            users.add("User" + i);
        }

        int postCount = 1000;
        int commentCount = 12;

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);

        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);

        //When
        List<Double> mockList = forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics(statisticsMock);

        double numberOfUsers = mockList.get(0);
        double numberOfPosts = mockList.get(1);
        double averOfPostsPerUser = mockList.get(3);
        double averOfCommentsPerUser = mockList.get(4);
        double averOfCommentsPerPost = mockList.get(5);

        //Then
        Assert.assertEquals(100, numberOfUsers, 0);
        Assert.assertEquals(1000, numberOfPosts, 0);
        Assert.assertEquals(10, averOfPostsPerUser, 0);
        Assert.assertEquals(0.012, averOfCommentsPerPost, 0.0001);
        Assert.assertEquals(0.12, averOfCommentsPerUser, 0);

    }

    @Test
    public void testCalculateAdvStatisticsWithLessPostThenComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            users.add("User" + i);
        }
        int postCount = 20;
        int commentCount = 90;

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);

        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);

        //When
        List<Double> mockList = forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics(statisticsMock);

        double averOfPostsPerUser = mockList.get(3);
        double averOfCommentsPerUser = mockList.get(4);
        double averOfCommentsPerPost = mockList.get(5);

        //Then
        Assert.assertEquals(0.4, averOfPostsPerUser, 0);
        Assert.assertEquals(4.5, averOfCommentsPerPost, 0.001);
        Assert.assertEquals(1.8, averOfCommentsPerUser, 0);

    }

    @Test
    public void testCalculateAdvStatisticsWithAllZero() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        int postCount = 0;
        int commentCount = 0;

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);

        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);

        //When
        List<Double> mockList = forumStatistics.calculateAdvStatistics(statisticsMock);
        forumStatistics.showStatistics(statisticsMock);


        double averOfPostsPerUser = mockList.get(3);
        double averOfCommentsPerUser = mockList.get(4);
        double averOfCommentsPerPost = mockList.get(5);

        //Then
        Assert.assertEquals(0, averOfPostsPerUser, 0);
        Assert.assertEquals(0, averOfCommentsPerPost, 0);
        Assert.assertEquals(0, averOfCommentsPerUser, 0);

    }
}
