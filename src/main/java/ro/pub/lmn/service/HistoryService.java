package ro.pub.lmn.service;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import ro.pub.lmn.entity.History;
        import ro.pub.lmn.entity.dto.HistoryDTO;
        import ro.pub.lmn.repository.HistoryRepository;

        import java.util.ArrayList;
        import java.util.Comparator;
        import java.util.List;
        import java.util.stream.Collectors;

/**
 * Created by radug on 11/7/2017.
 */
@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    private final EntityToDTOAndLanguageService entityToDTOAndLanguageService;

    @Autowired
    public HistoryService(HistoryRepository historyRepository, EntityToDTOAndLanguageService entityToDTOAndLanguageService) {
        this.historyRepository = historyRepository;
        this.entityToDTOAndLanguageService = entityToDTOAndLanguageService;
    }

    public void save(History history){
        historyRepository.save(history);
    }

    public List<HistoryDTO> findAll(String language){
        List<History> historyList = historyRepository.findAll();
        List<HistoryDTO> historyDTOList = new ArrayList<>();
        for(History history : historyList){
            historyDTOList.add((HistoryDTO) entityToDTOAndLanguageService.setLanguageForDTO(history, HistoryDTO.class, language));
        }
        historyDTOList = historyDTOList.stream().sorted((h1, h2) -> h2.getStart() - h1.getStart()).collect(Collectors.toList());
        return historyDTOList;
    }
}

