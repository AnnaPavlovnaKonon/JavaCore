package homework1;

public class Course {
    private String courseName;
    Course [] courseArray;
    public Course(String courseName, Course[] courseArray) {
        this.courseName = courseName;
        this.courseArray = courseArray;
    }

    public Course() {
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public Course[] getCourseArray() {
        return courseArray;
    }

    public void setCourseArray(Course[] courseArray) {
        this.courseArray = courseArray;}



    public void doIt (Team t){
        for (Human h : t.teamArray) {
            for (Course c : courseArray) {
                c.doIt(h);
            }
        }
    }


}
