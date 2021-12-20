package com.proretention.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proretention.entity.Branches;


@Repository
public interface BranchesRepository extends JpaRepository<Branches, Long> {

	Branches getByBranchKey(String branchKey);

	



	
}
