package com.lojadejogos.games.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.lojadejogos.games.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public List<Categoria> findAllByGeneroContainingIgnoreCase (String genero);
}
