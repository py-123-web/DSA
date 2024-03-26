
package entity;

/**
 *
 * @author pyhor
 */
public class Course implements Comparable<Course> {
   private String courseCode;
   private String courseName;
   private String classType;
   private String programme;
   private String semester;
   private Integer creditHour;
   private String faculty;

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

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
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

   public Course(String courseCode, String courseName, String classType, String programme, String semester, Integer creditHour, String faculty) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.classType = classType;
        this.programme = programme;
        this.semester = semester;
        this.creditHour = creditHour;
        this.faculty = faculty;
    }

    public Course(String programme) {
        this.programme = programme;
    }

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public Course(String courseCode, String courseName, String programme) {
      this.courseCode = courseCode;
      this.courseName = courseName;
      this.programme = programme;
    }


    @Override
  public int compareTo(Course o) {
    return programme.compareTo(o.programme);
  }
  @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Course otherCourse = (Course) obj;

        if ((courseCode == null && otherCourse.courseCode != null)
                || (courseCode != null && !courseCode.equals(otherCourse.courseCode))) {
            return false;
        }

        if ((courseName == null && otherCourse.courseName != null)
                || (courseName != null && !courseName.equals(otherCourse.courseName))) {
            return false;
        }

        return true;
    }
}
