package org.greta.dao;

import org.greta.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositroy  extends JpaRepository<Client, Long>{

}
