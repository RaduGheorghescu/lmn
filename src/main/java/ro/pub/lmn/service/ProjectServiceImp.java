package ro.pub.lmn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pub.lmn.entity.Project;
import ro.pub.lmn.entity.dto.ProjectDTO;
import ro.pub.lmn.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImp implements ProjectService{

    private final ProjectRepository projectRepository;
    private final EntityToDTOAndLanguageService entityToDTOAndLanguageService;

    @Autowired
    public ProjectServiceImp(ProjectRepository projectRepository, EntityToDTOAndLanguageService entityToDTOAndLanguageService) {
        this.projectRepository = projectRepository;
        this.entityToDTOAndLanguageService = entityToDTOAndLanguageService;
    }

    @Override
    public List<ProjectDTO> getAll() {
        List<Project> projectList = projectRepository.findAll();
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        for(Project Project : projectList){
            projectDTOList.add((ProjectDTO) entityToDTOAndLanguageService.setLanguageForDTO(Project, ProjectDTO.class));
        }
        projectDTOList = projectDTOList.stream().sorted((h1, h2) -> h2.getStartDate().compareTo(h1.getStartDate())).collect(Collectors.toList());
        return projectDTOList;
    }

    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void delete(Project project) {
        projectRepository.delete(project);
    }

    @Override
    public void update(Project project) {
        projectRepository.save(project);
    }

}
