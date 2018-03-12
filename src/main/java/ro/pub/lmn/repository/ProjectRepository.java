package ro.pub.lmn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.pub.lmn.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
}
