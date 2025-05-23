package app.service;

import app.entity.Smartphone;
import app.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService {

    @Autowired
    private SmartphoneRepository repository;

    public String save(Smartphone smartphone) {
        repository.save(smartphone);
        return "Smartphone salvo com sucesso!";
    }

    public String save(List<Smartphone> smartphones) {
        repository.saveAll(smartphones);
        return "Lista de smartphones salva com sucesso!";
    }

    public List<Smartphone> listAll() {
        return repository.findAll();
    }

    public String updateById(Smartphone smartphone, Long id) {
        if (repository.existsById(id)) {
            smartphone.setId(id);
            repository.save(smartphone);
            return "Smartphone atualizado com sucesso!";
        } else {
            throw new RuntimeException("Smartphone com ID " + id + " não encontrado.");
        }
    }

    public String deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Smartphone deletado com sucesso!";
        } else {
            throw new RuntimeException("Smartphone com ID " + id + " não encontrado.");
        }
    }
}
