package com.prestabanco.PrestaBanco.Repositories;

import com.prestabanco.PrestaBanco.Entities.MCTypesEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MCTypesRepository extends JpaRepository<MCTypesEntity, Integer> {

    MCTypesEntity findByType(String type);

}
