package lt.mybatis.model;

public class StudentCourse {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENT_COURSE.COURSE_ID
     *
     * @mbg.generated Mon May 03 21:30:09 GST 2021
     */
    private Integer courseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STUDENT_COURSE.STUDENT_ID
     *
     * @mbg.generated Mon May 03 21:30:09 GST 2021
     */
    private Integer studentId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENT_COURSE.COURSE_ID
     *
     * @return the value of PUBLIC.STUDENT_COURSE.COURSE_ID
     *
     * @mbg.generated Mon May 03 21:30:09 GST 2021
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENT_COURSE.COURSE_ID
     *
     * @param courseId the value for PUBLIC.STUDENT_COURSE.COURSE_ID
     *
     * @mbg.generated Mon May 03 21:30:09 GST 2021
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STUDENT_COURSE.STUDENT_ID
     *
     * @return the value of PUBLIC.STUDENT_COURSE.STUDENT_ID
     *
     * @mbg.generated Mon May 03 21:30:09 GST 2021
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STUDENT_COURSE.STUDENT_ID
     *
     * @param studentId the value for PUBLIC.STUDENT_COURSE.STUDENT_ID
     *
     * @mbg.generated Mon May 03 21:30:09 GST 2021
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}