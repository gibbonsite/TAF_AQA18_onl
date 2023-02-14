package tests.gui;

import models.Milestone;
import models.MilestoneBuilder;
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

        System.out.println(milestone1.toString());
        System.out.println(milestone2.toString());

        Assert.assertTrue(milestone1.equals(milestone2));
    }

    @Test
    public void lombokTest2() {
        MilestoneBuilder milestone1 = MilestoneBuilder.builder()
                .id(3)
                .name("ml_02")
                .completed(false)
                .build();
        MilestoneBuilder milestone2 = MilestoneBuilder.builder()
                .id(2)
                .name("ml_02")
                .completed(false)
                .build();

        var test = "String";
        System.out.println(milestone1.toString());

        Assert.assertTrue(milestone1.equals(milestone2));
    }

}
