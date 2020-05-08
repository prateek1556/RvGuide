package com.example.RvGuide.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.RvGuide.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query(value = "select * from auth_role where role_name = ?1",nativeQuery = true) //nativeQuery = true//("From auth_user where role_name =?")  //@Query("From user where firstname= ?1") //@Query(value = "SELECT u FROM User u WHERE u.userID  = :id")
	public Role findByRole(String role);
}
