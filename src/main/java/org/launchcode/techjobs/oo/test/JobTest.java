package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId () {
        Job newJob = new Job();
        Job newJob2 = new Job();
        assertNotEquals(newJob.getId(), newJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields () {
        Job newJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(newJob3 instanceof Job);
        assertTrue(newJob3.getEmployer() instanceof Employer);
        assertTrue(newJob3.getLocation() instanceof Location);
        assertTrue(newJob3.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(newJob3.getPositionType() instanceof PositionType);
        assertEquals("Product tester", newJob3.getName());
        assertEquals("ACME", newJob3.getEmployer().getValue());
        assertEquals("Desert", newJob3.getLocation().getValue());
        assertEquals("Quality control", newJob3.getPositionType().getValue());
        assertEquals("Persistence", newJob3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality (){
        Job newJob = new Job();
        Job newJob2 = new Job();
        assertFalse(newJob.getId() == newJob2.getId());
    }


    @Test
    public void testToStringPrintsFieldsInCorrectFormat(){
        Job newJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String output =
                "\nId: " + newJob3.getId() +
                        "\nName: " + newJob3.getName() +
                        "\nEmployer: " + newJob3.getEmployer() +
                        "\nLocation: " + newJob3.getLocation() +
                        "\nPosition Type: " + newJob3.getPositionType() +
                        "\nCore Competency: " + newJob3.getCoreCompetency()
                        +"\n";

        assertEquals(output, newJob3.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job newJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        newJob3.getLocation().setValue("");
        newJob3.getCoreCompetency().setValue("");

        String output =
                "\nId: " + newJob3.getId() +
                        "\nName: " + newJob3.getName() +
                        "\nEmployer: " + newJob3.getEmployer() +
                        "\nLocation: Data is not available." +
                        "\nPosition Type: " + newJob3.getPositionType() +
                        "\nCore Competency: Data is not available."
                        +"\n";

        assertEquals(output, newJob3.toString());

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job newJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals( '\n',newJob3.toString().charAt(0));
        assertEquals('\n',newJob3.toString().charAt(newJob3.toString().length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job newJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String output =

                "\nId: " + newJob3.getId() +
                        "\nName: " + newJob3.getName() +
                        "\nEmployer: " + newJob3.getEmployer() +
                        "\nLocation: " + newJob3.getLocation() +
                        "\nPosition Type: " + newJob3.getPositionType() +
                        "\nCore Competency: Data is not available.";

        assertEquals("\nId: "
                + newJob3.getId()+ "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence" +
                "\n", newJob3.toString());

    }
}