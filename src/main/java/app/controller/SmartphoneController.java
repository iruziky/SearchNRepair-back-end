package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Smartphone;
import app.service.SmartphoneService;
import org.springframework.ui.Model;


@RequestMapping("/smartphones")
@RestController
@CrossOrigin(origins = "*")
public class SmartphoneController {

	@Autowired
	SmartphoneService smartphoneService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Smartphone smartphone) {
		try {
			String response = smartphoneService.save(smartphone);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao adicionar smartphone!", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/saveList")
	public ResponseEntity<String> saveList(@RequestBody List<Smartphone> smartphones) {
		try {
			String response = smartphoneService.save(smartphones);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao adicionar smartphones!", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/listAll")
	public ResponseEntity<List<Smartphone>> listAll() {
		try {
			List<Smartphone> smartphones = smartphoneService.listAll();
			return new ResponseEntity<>(smartphones, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/catalog")
    public String getSmartphonesCard(Model model) {
        model.addAttribute("smartphones", smartphoneService.listAll());
        return "smartphones";
    }

	@PatchMapping("/updateById/{id}")
	public ResponseEntity<String> updateById(@RequestBody Smartphone smartphone, @PathVariable Long id) {
		try {
			String response = smartphoneService.updateById(smartphone, id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao atualizar smartphone!", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		try {
			String response = smartphoneService.deleteById(id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao deletar smartphone!", HttpStatus.BAD_REQUEST);
		}
	}
}
