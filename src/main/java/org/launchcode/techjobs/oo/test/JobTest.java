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
    public void testSettingJobId() {
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertEquals(testJob1.getId(), testJob2.getId(), 1);
        assertNotEquals(testJob1.getId(), testJob2.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob1 = new Job("Technician", new Employer("Bayer"), new Location("Chesterfield"), new PositionType("R&D"), new CoreCompetency("PCR"));
        assertTrue(testJob1.getName() instanceof String);
        assertTrue(testJob1.getEmployer() instanceof Employer);
        assertTrue(testJob1.getLocation() instanceof Location);
        assertTrue(testJob1.getPositionType() instanceof PositionType);
        assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Technician", testJob1.getName());
        assertEquals("Bayer", testJob1.getEmployer().getValue());
        assertEquals("Chesterfield", testJob1.getLocation().getValue());
        assertEquals("R&D", testJob1.getPositionType().getValue());
        assertEquals("PCR", testJob1.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Technician", new Employer("Bayer"), new Location("Chesterfield"), new PositionType("R&D"), new CoreCompetency("PCR"));
        Job testJob2 = new Job("Technician", new Employer("Bayer"), new Location("Chesterfield"), new PositionType("R&D"), new CoreCompetency("PCR"));
        assertFalse(testJob1.equals(testJob2));

    }

    @Test


}
