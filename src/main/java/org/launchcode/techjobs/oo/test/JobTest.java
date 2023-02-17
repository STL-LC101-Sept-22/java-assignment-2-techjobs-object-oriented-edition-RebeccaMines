package org.launchcode.techjobs.oo.test;

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
        Job jobA = new Job();
        Job jobB = new Job();

        assertNotEquals(jobA, jobB);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(aJob.getName(), "Product tester");
        assertEquals(aJob.getEmployer().getValue(), "ACME");
        assertEquals(aJob.getLocation().getValue(), "Desert");
        assertEquals(aJob.getPositionType().getValue(), "Quality control");
        assertEquals(aJob.getCoreCompetency().getValue(), "Persistence");

        assertTrue(aJob.getName() instanceof String);
        assertTrue(aJob.getEmployer() instanceof Employer);
        assertTrue(aJob.getLocation() instanceof Location);
        assertTrue(aJob.getPositionType() instanceof PositionType);
        assertTrue(aJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job jobC = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobD = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobC.equals(jobD));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobE = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String job = jobE.toString();

        assertEquals(job.charAt(0), '\n');
        assertEquals(job.charAt(job.toString().length() - 1), '\n');
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

