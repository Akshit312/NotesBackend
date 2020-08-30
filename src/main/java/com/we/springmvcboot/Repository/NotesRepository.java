package com.we.springmvcboot.Repository;

import com.we.springmvcboot.Entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

    Notes findByIdAndDeletedFalse(long id);
}
