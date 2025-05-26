package app.controller;

import app.entity.ScrapingLink;
import app.service.ScrapingLinkService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/links")
public class ScrapingLinkController {

    private final ScrapingLinkService service;

    public ScrapingLinkController(ScrapingLinkService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<ScrapingLink> save(@RequestBody ScrapingLink link) {
        ScrapingLink saved = service.save(link);
        return ResponseEntity.ok(saved);
    }
    
    @PostMapping("/saveList")
    public ResponseEntity<String> save(@RequestBody List<ScrapingLink> links) {
    	try {
			String response = service.save(links);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao adicionar links!", HttpStatus.BAD_REQUEST);
		}
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<ScrapingLink>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }
    
    @PatchMapping("/updateById/{id}")
	public ResponseEntity<String> updateById(@RequestBody ScrapingLink scrapingLink, @PathVariable Long id) {
		try {
			String response = service.updateById(scrapingLink, id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao atualizar link!", HttpStatus.BAD_REQUEST);
		}
	}

    @GetMapping("/findById/{id}")
    public ResponseEntity<ScrapingLink> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
