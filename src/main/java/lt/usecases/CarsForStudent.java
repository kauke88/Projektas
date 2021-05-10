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
import lt.entities.Student;
import lt.persistence.CarsDAO;
import lt.persistence.CoursesDAO;
import lt.persistence.StudentsDAO;

@Model
public class CarsForStudent implements Serializable {

    @Inject
    private CarsDAO carDAO;

    @Inject
    private StudentsDAO studentsDAO;

    @Getter @Setter
    private Student student;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer teamId = Integer.parseInt(requestParameters.get("studentId"));
        this.student = studentsDAO.findOne(teamId);
    }

}