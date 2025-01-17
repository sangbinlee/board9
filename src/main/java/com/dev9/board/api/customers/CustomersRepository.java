package com.dev9.board.api.customers;

import org.springframework.data.jpa.repository.JpaRepository;



//JpaRepository
//CrudRepository
//PagingAndSortingRepository
public interface CustomersRepository extends JpaRepository<Customers, Long> {

}
