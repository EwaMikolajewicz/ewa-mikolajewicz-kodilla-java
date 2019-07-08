package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
   private TaskListDao taskListDao;

   @Test
    public void testFindByListName(){
       //Given
       TaskList taskList1 = new TaskList("List nr 1", "Description 1");
       TaskList taskList2 = new TaskList("List nr 2", "Description 2");
       TaskList taskList3 = new TaskList("List nr 1", "Description 1");
       TaskList taskList4 = new TaskList("List nr 2", "Description 3");

       //When
       taskListDao.save(taskList1);
       taskListDao.save(taskList2);
       taskListDao.save(taskList3);
       taskListDao.save(taskList4);

       //Then
       Assert.assertEquals(2, taskListDao.findByListName("List nr 1").size());
       Assert.assertEquals(2, taskListDao.findByListName("List nr 2").size());
       Assert.assertNotSame("Jednak te same",taskList1, taskList3);

       //CleanUp
       taskListDao.deleteAll();
   }
}
