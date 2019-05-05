package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies(){
        //Given
        User user1 = new Millenials("Millenials1");
        User user2 = new YGeneration("Generation_Y");
        User user3 = new ZGeneration("Generation_Z");

        //When
        String user1ShouldShare = user1.sharePost();
        System.out.println("Millenials1 should share: " + user1ShouldShare);

        String user2ShouldShare = user2.sharePost();
        System.out.println("Generation_Y should share: " + user2ShouldShare);

        String user3ShouldShare = user3.sharePost();
        System.out.println("Generation_Z should share: " + user3ShouldShare);

        //Then
        Assert.assertEquals("Facebook", user1ShouldShare);
        Assert.assertEquals("Twitter", user2ShouldShare);
        Assert.assertEquals("Snapchat", user3ShouldShare);
    }

    @Test
    public void testIndividualSharingStrategy(){

        //Given
        User user = new ZGeneration("Godzilla");

        //When
        String johnShouldShare = user.sharePost();
        System.out.println("Godzilla should share: " + johnShouldShare);
        user.setSocialPublisher(new FacebookPublisher());
        johnShouldShare = user.sharePost();
        System.out.println("Godzilla now should share: " + johnShouldShare);

        //Then
        Assert.assertEquals("Facebook", johnShouldShare);
    }
}
