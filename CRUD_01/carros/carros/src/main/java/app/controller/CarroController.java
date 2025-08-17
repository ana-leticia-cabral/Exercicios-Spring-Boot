package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Carro;
import app.service.CarroService;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

	@Autowired
	private CarroService carroService;

	// Insere um novo carro com os dados do JSON
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Carro carro) {

		try {
			String mensagem = this.carroService.save(carro);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu algo errado ao salvar!", HttpStatus.BAD_REQUEST);
		}

	}

	// Retorna a lista de carros
	@GetMapping("/read")
	public ResponseEntity<List<Carro>> read() {
		try {

			return new ResponseEntity<List<Carro>>(CarroService.read(), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// Retorna o carro com id = {id}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Carro> findById(@PathVariable int id) {
		try {
			Carro carro = this.carroService.findById(id);
			return new ResponseEntity<>(carro, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// Altera os dados do carro com id = {id} com os dados do JSON
	@PutMapping("/updateById/{id}")
	public ResponseEntity<String> updateById(@PathVariable int id, @RequestBody Carro carro) {
		try {
			String mensagem = this.carroService.updateById(id, carro);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Algo deu errado ao atualizar os dados!", HttpStatus.BAD_REQUEST);
		}
	}

	// Deletar o carro com id = {id}
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
		try {
			String mensagem = this.carroService.deleteById(id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Algo deu errado ao excluir os dados!", HttpStatus.BAD_REQUEST);
		}
	}

}
