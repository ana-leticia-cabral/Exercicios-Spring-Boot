package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Livro;
import app.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	public String save(Livro livro) {
		this.livroRepository.save(livro);
		return "Livro salvo com sucesso!";
	}

	public Livro findById(Long id) {
		return this.livroRepository.findById(id).orElse(null); // retorna null se não achar.

	}

	public List<Livro> read() {
		return this.livroRepository.findAll();
	}

	public String updateById(Long id, Livro livro) {
		if (this.findById(id) == null) {
			return "Livro não encontrado!";
		} else {
			Livro livroEncontrado = this.findById(id);
			livroEncontrado.setTitulo(livro.getTitulo());
			livroEncontrado.setAutor(livro.getAutor());
			livroEncontrado.setEditora(livro.getEditora());
			livroEncontrado.setAno(livro.getAno());
			
			this.livroRepository.save(livroEncontrado);

			return "Livro atualizado com sucesso!";
		}
	}

	public String deleteById(Long id) {
		if(this.findById(id) == null) {
			return "Livro não encontrado!";
		} else {
		    this.livroRepository.deleteById(id);
		    return "Livro deletado com sucesso!";
		}
	}
}
