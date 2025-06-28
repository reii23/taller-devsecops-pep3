package com.prestabanco.PrestaBanco.Repositories;

import com.prestabanco.PrestaBanco.Entities.MCStatusEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MCStatusRepository extends JpaRepository<MCStatusEntity, Integer> {

    MCStatusEntity findByStatus(String status);

}
