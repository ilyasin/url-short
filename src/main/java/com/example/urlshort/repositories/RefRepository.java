package com.example.urlshort.repositories;

import com.example.urlshort.entities.Ref;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefRepository extends JpaRepository<Ref, Long> {
    public Optional<Ref> findByShortKey(String shortKey);
}
