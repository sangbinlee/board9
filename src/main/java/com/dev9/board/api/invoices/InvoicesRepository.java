package com.dev9.board.api.invoices;

import org.springframework.data.jpa.repository.JpaRepository;



//JpaRepository
//CrudRepository
//PagingAndSortingRepository
public interface InvoicesRepository extends JpaRepository<Invoices, Long> {

}
