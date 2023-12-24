package com.example.bilyzna1.repository;

import com.example.bilyzna1.entity.SearchItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchItemsRepository extends JpaRepository<SearchItems,Long> {
    SearchItems findByName(String name);
    @Query("SELECT c FROM SearchItems c WHERE c.name ILIKE :word% ORDER BY c.createdOn DESC LIMIT 5")
    List<SearchItems> findByWord(String word);
}
