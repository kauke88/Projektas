package lt.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lt.mybatis.dao.CourseMapper;
import lt.mybatis.dao.StudentMapper;
import lt.mybatis.model.Student;

@Model
public class CoursesForStudentMyBatis implements Serializable {

    @Inject
    private CourseMapper courseMapper;

    @Inject
    private StudentMapper studentMapper;

    @Getter @Setter
    private Student student;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer teamId = Integer.parseInt(requestParameters.get("studentId"));
        this.student = studentMapper.selectByPrimaryKey(teamId);
    }

}