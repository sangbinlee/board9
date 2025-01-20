package com.dev9.board.api.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



//JpaRepository
//CrudRepository
//PagingAndSortingRepository
public interface UsersRepository extends JpaRepository<Users, Long> {

	List<Users> findByEmail(String email);
}
