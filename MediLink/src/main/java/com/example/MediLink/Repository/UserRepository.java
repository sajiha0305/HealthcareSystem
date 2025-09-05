package com.example.MediLink.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MediLink.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

	@Query(nativeQuery = true,value="SELECT * FROM public.users where email=:email;")
	List<UserEntity> findByEmail(String email);

}
