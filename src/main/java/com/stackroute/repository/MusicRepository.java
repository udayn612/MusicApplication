package com.stackroute.repository;

import com.stackroute.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music,Integer> {
}
