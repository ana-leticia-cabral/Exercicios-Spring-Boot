package app.service;

import org.springframework.stereotype.Service;

import app.entity.Carro;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService {

	private static List<Carro> carrosSalvos = new ArrayList<>();

	private int id = 0;

	// CREATE
	public String save(Carro carro) {
		id += 1;
		carro.setIdCarro(id);
		carrosSalvos.add(carro);
		return "Carro salvo com sucesso!";
	}

	// READ
	public static List<Carro> read() {
		if (carrosSalvos == null || carrosSalvos.isEmpty()) {
			return null;
		} else {
			return carrosSalvos;
		}

	}

	// FIND BY ID
	public Carro findById(int id) {

		if (carrosSalvos == null || carrosSalvos.isEmpty()) {
			return null;
		}
		for (Carro c : carrosSalvos) {
			if (c.getIdCarro() == id) {
				return c;
			}

		}
		return null; // Se não encontrar retornar null
	}

	// UPDATE
	public String updateById(int id, Carro carro) {

		if (findById(id) == null) {
			return "Carro não encontrado para atualizar os dados!";
		} else {
			Carro carroExistente = findById(id);

			carroExistente.setNome(carro.getNome());
			carroExistente.setMarca(carro.getMarca());
			carroExistente.setModelo(carro.getModelo());
			carroExistente.setAnoFabricacao(carro.getAnoFabricacao());

			return "Dados alterados com sucesso!";

		}
	}

	// DELETE
	public String deleteById(int id) {
		if (findById(id) == null) {
			return "Carro não encontrado!";
		} else {
			Carro carroExistente = findById(id);
			carrosSalvos.remove(carroExistente);
			return "Carro deletado com sucesso!";
		}
	}
}
