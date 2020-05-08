package com.example.RvGuide.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.RvGuide.model.AlgorithmEntity;

@Repository
public interface AlgorithmRepository extends JpaRepository<AlgorithmEntity, Integer> {
	
	@Query(value = "select * from user_algorithm where email = ?1",nativeQuery = true)
	List<AlgorithmEntity> getAlgorithmByEmail(String email);
	
	@Query(value ="select * from user_algorithm where algorithm_id= ?1 LIMIT 1",nativeQuery=true)
	AlgorithmEntity getAlgorithmbyId(int id);
	
	//@Query(value="",nativeQuery=true)
	//void updateAlgorithm(AlgorithmEntity entity); 
	
}
