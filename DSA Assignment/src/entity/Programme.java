package entity;
/**
 *
 * @author USER Low Jia Yu & Hor Pei Yu
 */
import adt.*; 
import java.util.Iterator;
import java.util.Objects;

public class Programme implements Comparable<Programme>, Iterable<TutorialGroup> {
    private String progCode;
    private String progName;
    private SortedArrayList<TutorialGroup> tutorialGroups; // Changed to SortedArrayList

    public Programme(String progCode, String progName) {
        this.progCode = progCode;
        this.progName = progName;
        this.tutorialGroups = new SortedArrayList<>(); // Initialize the SortedArrayList
    }
    public String getProgCode() {
        return progCode;
    }

    public void setProgCode(String progCode) {
        this.progCode = progCode;
    }

    public String getProgName() {
        return progName;
    }

    public void setProgName(String progName) {
        this.progName = progName;
    }

    public SortedListInterface<TutorialGroup> getTutorialGroups() {
        return tutorialGroups;
    }

    // Getters and setters
    public void setTutorialGroups(SortedArrayList<TutorialGroup> tutorialGroups) {    
        this.tutorialGroups = tutorialGroups;
    }

    // Method to add a TutorialGrp to the programme
    public void addTutorialGroup(TutorialGroup tutorialGrp) {
        tutorialGroups.add(tutorialGrp);
    }

    public void removeTutorialGroup(TutorialGroup tutorialGrp) {
        tutorialGroups.remove(tutorialGrp);
    }
    
    public Programme(String progCode) {
        this.progCode = progCode;
        // this.courseList = new SortedArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-15s",
                progCode, progName, tutorialGroups);
    }

    @Override
    public int compareTo(Programme otherProg) {
        // Compare based on studId or any other attribute that defines the natural order
        return this.progCode.compareTo(otherProg.progCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Programme prog = (Programme) o;
        return Objects.equals(progCode, prog.progCode);
    }


    // Implement Iterable
    @Override
    public Iterator<TutorialGroup> iterator() {
        return tutorialGroups.iterator();
    }
}
