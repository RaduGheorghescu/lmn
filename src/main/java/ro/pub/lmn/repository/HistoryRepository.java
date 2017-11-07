package ro.pub.lmn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.pub.lmn.entity.History;

/**
 * Created by radug on 11/7/2017.
 */
public interface HistoryRepository extends JpaRepository<History, Long>{
}
