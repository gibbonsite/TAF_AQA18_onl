package tests;

import models.Milestone;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestoneTest {
    @Test
    public void lombokTest1() {
        Milestone milestone1 = new Milestone();
        milestone1.setId(1);
        milestone1.setName("ml_01");
        milestone1.setCompleted(true);

        Milestone milestone2 = new Milestone();
        milestone2.setId(2);
        milestone2.setName("ml_01");
        milestone2.setCompleted(true);

        System.out.println(milestone1);
        System.out.println(milestone2);

        Assert.assertTrue(milestone1.equals(milestone2));
    }
}
