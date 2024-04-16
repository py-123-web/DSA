package entity;

/**
 *
 * @author Hor Pei Yu
 */
public class Course implements Comparable<Course> {

    private String courseCode;
    private String courseName;
    private String classType;
    private String semester;
    private Integer creditHour;
    private String faculty;
    private Double fees;
    private String programmeCode;
    private String status;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(Integer creditHour) {
        this.creditHour = creditHour;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Course(String courseCode, String courseName, String classType, String semester, Integer creditHour, String faculty, Double fees, String status) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.classType = classType;
        this.semester = semester;
        this.creditHour = creditHour;
        this.faculty = faculty;
        this.fees = fees;
        this.status = status;
    }

    public Course(String courseCode, String courseName, String classType, String semester, Integer creditHour, String faculty, Double fees, String programmeCode, String status) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.classType = classType;
        this.semester = semester;
        this.creditHour = creditHour;
        this.faculty = faculty;
        this.fees = fees;
        this.programmeCode = programmeCode;
        this.status = status;
    }

    @Override
    public int compareTo(Course o) {
        return this.courseCode.compareTo(o.courseCode);
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//
//        Course otherCourse = (Course) obj;
//
//        if ((courseCode == null && otherCourse.courseCode != null)
//                || (courseCode != null && !courseCode.equals(otherCourse.courseCode))) {
//            return false;
//        }
//
//        if ((courseName == null && otherCourse.courseName != null)
//                || (courseName != null && !courseName.equals(otherCourse.courseName))) {
//            return false;
//        }
//
//        return true;
//    }
}
