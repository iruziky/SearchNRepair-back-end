package app.service;
import app.entity.ScrapingLink;
import app.repository.ScrapingLinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScrapingLinkService {

    private final ScrapingLinkRepository repository;

    public ScrapingLinkService(ScrapingLinkRepository repository) {
        this.repository = repository;
    }

    public ScrapingLink save(ScrapingLink link) {
        return repository.save(link);
    }

    public List<ScrapingLink> listAll() {
        return repository.findAll();
    }
    
    public String updateById(ScrapingLink link, Long id) {
        if (repository.existsById(id)) {
            link.setId(id);
            repository.save(link);
            return "Link atualizado com sucesso!";
        } else {
            throw new RuntimeException("Link com ID " + id + " não encontrado.");
        }
    }

    public Optional<ScrapingLink> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
