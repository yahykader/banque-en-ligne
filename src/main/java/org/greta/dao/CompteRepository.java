package org.greta.dao;

import org.greta.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository  extends JpaRepository<Compte, String>{


}
