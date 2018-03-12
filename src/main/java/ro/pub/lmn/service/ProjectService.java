package ro.pub.lmn.service;

import ro.pub.lmn.entity.Project;
import ro.pub.lmn.entity.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    public List<ProjectDTO> getAll();
    public void save(Project project);
    public void  delete(Project project);
    public void update(Project project);
}
