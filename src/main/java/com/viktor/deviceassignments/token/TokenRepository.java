package com.viktor.deviceassignments.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query(value = """
      select t from Token t inner join Employee e\s
      on t.employee.id = e.id\s
      where e.id = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<Token> findAllValidTokenByEmployee(Long id);

    Optional<Token> findByToken(String token);
}
