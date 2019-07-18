package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    @Autowired
    Board board;

    @Test
    public void testTaskAdd() {
        //Given
        String task1 = "Paint bedroom";
        String task2 = "Cook dinner";
        String task3 = "Do your homework";
        board.getToDoList().getTasks().add(task1);
        board.getInProgressList().getTasks().add(task2);
        board.getInProgressList().getTasks().add(task2);
        board.getInProgressList().getTasks().add(task3);
        board.getDoneList().getTasks().add(task3);

        //When
        TaskList toDoTaskList = board.getToDoList();
        TaskList inProgresTaskList = board.getInProgressList();
        TaskList doneTaskList = board.getDoneList();

        //Then
        Assert.assertEquals(1, toDoTaskList.getTasks().size());
        Assert.assertEquals(3, inProgresTaskList.getTasks().size());
        Assert.assertEquals(inProgresTaskList.getTasks().get(0), inProgresTaskList.getTasks().get(1));
        Assert.assertEquals(1, doneTaskList.getTasks().size());
        Assert.assertTrue(toDoTaskList.getTasks().get(0).contains("bedroom"));
        Assert.assertEquals(task2, inProgresTaskList.getTasks().get(0));
        Assert.assertEquals("Tasks: [Do your homework]", doneTaskList.toString());
        Assert.assertNotNull(board);
    }
}
