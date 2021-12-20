package com.pro.sensitivedetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.sensitivedetails.entity.SensitiveEntity;

@Repository
public interface SensitiveDetailsRepository extends JpaRepository<SensitiveEntity, Long> {

	SensitiveEntity getById(int id);

}
