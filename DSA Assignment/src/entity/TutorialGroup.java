package entity;

import adt.*;
import java.util.Iterator;

/**
 *
 * @author Low Jia Yu
 */
public class TutorialGroup implements Comparable<TutorialGroup> {
    private String tutorialGroupName;
    private int groupNo;
    private int noOfStudent;
    private SortedArrayList<Student> enrolledStudents;
    private SortedArrayList<Programme> programmes;

    public TutorialGroup(String tutorialGroupName) {
        this.tutorialGroupName = tutorialGroupName;
    }

    public TutorialGroup(String tutorialGroupName, int noOfStudents) {
        this.tutorialGroupName = tutorialGroupName;
    }

    public TutorialGroup(String tutorialGroupName, int groupNo, int noOfStudent) {
        this(tutorialGroupName, groupNo, noOfStudent, null);
    }
    
    public TutorialGroup(String tutorialGroupName, int groupNo, int noOfStudent, Programme programmeCode) {
        this.tutorialGroupName = tutorialGroupName;
        this.groupNo = groupNo;
        this.noOfStudent = noOfStudent;
        this.enrolledStudents = new SortedArrayList<>();
        this.programmes = new SortedArrayList<>();
    }

    public String getTutorialGroupName() {
        return tutorialGroupName;
    }

    public void setTutorialGroupName(String tutorialGroupName) {
        this.tutorialGroupName = tutorialGroupName;
    }

    public int getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(int groupNo) {
        this.groupNo = groupNo;
    }

    public int getNoOfStudent() {
        return noOfStudent;
    }

    public void setNoOfStudent(int noOfStudent) {
        this.noOfStudent = noOfStudent;
    }

     public SortedListInterface<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(SortedArrayList<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public SortedListInterface<Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(SortedArrayList<Programme> programmes) {
        this.programmes = programmes;
    }


    public void addProgramme(Programme programme) {
        programmes.add(programme);
    }

     public void addStudent(Student student) {
        enrolledStudents.add(student);
        noOfStudent++;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TutorialGroup)) {
            return false;
        }
        TutorialGroup other = (TutorialGroup) object;
        if ((this.tutorialGroupName == null && other.tutorialGroupName != null) || (this.tutorialGroupName != null && !this.tutorialGroupName.equals(other.tutorialGroupName))) {
            return false;
        }
        return true;
    }
    
    public int compareTo(TutorialGroup tutorialGroup) {
        if (tutorialGroupName.compareTo(tutorialGroup.getTutorialGroupName()) > 0) {
            return 1;
        } else if (tutorialGroupName.compareTo(tutorialGroup.getTutorialGroupName()) == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return String.format("%-25s %-15d", tutorialGroupName, noOfStudent);
    }

    public boolean removeStudentById(String studentId) {
    boolean studentRemoved = false;
    Iterator<Student> iterator = enrolledStudents.iterator();
    while (iterator.hasNext()) {
        Student student = iterator.next();
        if (student.getStudId().equals(studentId)) {
            iterator.remove();
            noOfStudent--;
            studentRemoved = true;
            break; // Stop searching after the first matching student is removed
        }
    }
    return studentRemoved;
}

  
}
 