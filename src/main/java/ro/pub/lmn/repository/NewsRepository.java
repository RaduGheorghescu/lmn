package ro.pub.lmn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.pub.lmn.entity.News;

public interface NewsRepository extends JpaRepository<News, Long>{
}
