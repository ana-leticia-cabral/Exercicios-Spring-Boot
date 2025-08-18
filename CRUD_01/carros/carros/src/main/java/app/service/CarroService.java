package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.repository.CarroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;

	public String save(Carro carro) {

		this.carroRepository.save(carro);
		return "Carro salvo com sucesso!";
	}

	public List<Carro> read() {

		List<Carro> carro = this.carroRepository.findAll();
		return carro;

	}

	public Optional<Carro> findById(Long id) {

		Optional<Carro> carro = this.carroRepository.findById(id);
		return carro;
	}

	public String updateById(Long id, Carro carro) {

		this.updateById(id, carro);
		return "Carro atualizado com sucesso!";

	}

	public String deleteById(Long id) {

		this.carroRepository.deleteById(id);
		return "Carro deletado com sucesso!";

	}
}
