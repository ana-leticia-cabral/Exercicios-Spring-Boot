package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Livro;

@Service
public class LivroService {

	private List<Livro> livrosSalvos = new ArrayList<>();
    
	private int id = 0;
    
	public String create(Livro livro) {
	    	id += 1;
	    	livro.setIdLivro(id);
		livrosSalvos.add(livro);
		return "Livro salvo com sucesso!";
	}

	public Livro findById(int id) {
		if (livrosSalvos == null || livrosSalvos.isEmpty()) {
			return null;
		}

		for (Livro l : livrosSalvos) {
			if (l.getIdLivro() == id) {
				return l;
			}
		}
		return null;
	}

	public List<Livro> read() {
		return livrosSalvos;
	}

	public String updateById(int id, Livro livro) {
		if (findById(id) == null) {
			return null;
		} else {

			Livro livroEncontrado = findById(id);

			livroEncontrado.setTitulo(livro.getTitulo());
			livroEncontrado.setAutor(livro.getAutor());
			livroEncontrado.setEditora(livro.getEditora());
			livroEncontrado.setAno(livro.getAno());

			return "Livro atualizado com sucesso!";

		}
	}

	public String deleteById(int id) {
		if (findById(id) == null) {
			return null;
		} else {
			Livro livroEncontrado = findById(id);
			livrosSalvos.remove(livroEncontrado);

			return "Livro removido com sucesso!";
		}
	}
}
