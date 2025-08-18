package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Carro;

// Definir o que vai salvar no repositório e o tipo de dado que vai ter no id
public interface CarroRepository extends JpaRepository<Carro, Long> {

}
