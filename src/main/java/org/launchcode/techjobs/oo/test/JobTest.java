package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.*;
import java.util.Objects;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job aJob = new Job();
        Job anotherJob = new Job();

        assertNotEquals(aJob.getId(), anotherJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(aJob.getName() instanceof String);
        assertEquals("Product tester", aJob.getName());
        assertTrue(aJob.getEmployer() instanceof Employer);
        assertEquals("ACME", aJob.getEmployer().getValue());
        assertTrue(aJob.getLocation() instanceof Location);
        assertEquals("Desert", aJob.getLocation().getValue());
        assertTrue(aJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", aJob.getPositionType().getValue());
        assertTrue(aJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", aJob.getCoreCompetency().getValue());


    }

    @Test
    public void testJobsForEquality() {
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job anotherJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertFalse(aJob.equals(anotherJob));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobE = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String job = jobE.toString();

        assertEquals(job.toString().charAt(0), '\n');
        assertEquals(job.toString().charAt(job.toString().length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobF = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String jobInfo = '\n' +
                "ID: " + jobF.getId() + '\n' +
                "Name: " + jobF.getName() + '\n' +
                "Employer: " + jobF.getEmployer() + '\n' +
                "Location: " + jobF.getLocation() + '\n' +
                "Position Type: " + jobF.getPositionType() + '\n' +
                "Core Competency: " + jobF.getCoreCompetency() + '\n';

        String jobOutput = jobF.toString();
        assertEquals(jobInfo, jobOutput);
    }

    @Test
    public void testToStringHandlesEmptyField()
    {
        Job jobH = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        String jobInfo = String.format("\nID: %d\n" +

                "Name: Data not available\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n"+
                "Position Type: Data not available\n" +
                "Core Competency: Data not available\n",jobH.getId(),jobH.getName(), jobH.getEmployer(), jobH.getLocation(), jobH.getPositionType(), jobH.getCoreCompetency());
        assertEquals(jobInfo, jobH.toString());
    }



}

