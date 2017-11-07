package ro.pub.lmn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pub.lmn.entity.History;
import ro.pub.lmn.repository.HistoryRepository;

import java.util.List;

/**
 * Created by radug on 11/7/2017.
 */
@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public void save(History history){
        historyRepository.save(history);
    }

    public List<History> findAll(){
        return historyRepository.findAll();
    }
}
