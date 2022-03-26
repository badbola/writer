package com.natwest.writer.repository;

import com.natwest.writer.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Divyanshu Singh on 26-03-2022
 */

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
