package com.web.spartaspring2.repository;

import com.web.spartaspring2.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
