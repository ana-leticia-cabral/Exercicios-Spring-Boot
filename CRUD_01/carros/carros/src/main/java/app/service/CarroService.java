package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;

import app.repository.CarroRepository;

import java.util.List;


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

	public Carro findById(Long id) {

		return this.carroRepository.findById(id).orElse(null);
		
	}

	public String updateById(Long id, Carro carro) {

		if (this.findById(id) == null) {
			return "Carro não encontrado!";
		} else {
			Carro carroEncontrado = this.findById(id);
			carroEncontrado.setNome(carro.getNome());
			carroEncontrado.setMarca(carro.getMarca());
			carroEncontrado.setModelo(carro.getModelo());
			carroEncontrado.setAnoFabricacao(carro.getAnoFabricacao());
			
			this.carroRepository.save(carroEncontrado);

			return "Carro atualizado com sucesso!";
		}

	}

	public String deleteById(Long id) {
        if(this.findById(id) == null) {
        	return "Carro não encontrado!";
        } else {
        	this.carroRepository.deleteById(id);
    		return "Carro deletado com sucesso!";
        }
		

	}
}
