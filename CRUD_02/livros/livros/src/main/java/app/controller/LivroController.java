package app.controller;

import java.util.List;

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

import app.entity.Livro;
import app.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Livro livro) {
		try {
			String mensagem = this.livroService.create(livro);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Algo deu erro ao salvar o livro!", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Livro> findById(@PathVariable int id) {
		try {
			Livro livro = this.livroService.findById(id);
			return new ResponseEntity<Livro>(livro, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/read")
	public ResponseEntity<List<Livro>> read() {
		try {
			return new ResponseEntity<List<Livro>>(this.livroService.read(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateById(@PathVariable int id, @RequestBody Livro livro) {
		try {
			String mensagem = this.livroService.updateById(id, livro);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Algo deu errado ao atualizar os dados!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
		try {
			String mensagem = this.livroService.deleteById(id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Algo deu errado ao deletar o livro!", HttpStatus.BAD_REQUEST);
		}
		
	}

}
