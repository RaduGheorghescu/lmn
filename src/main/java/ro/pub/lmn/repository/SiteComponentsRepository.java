package ro.pub.lmn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.pub.lmn.entity.SiteComponents;

public interface SiteComponentsRepository extends JpaRepository<SiteComponents, String>{
}
