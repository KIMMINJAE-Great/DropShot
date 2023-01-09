package com.dropshot.backend.repository;

import com.dropshot.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
     Member findByUsername(String username);

    @Query("select m from Member m where m.username = :username ")
    Member getUsernameFromMember(String username);
}
//    @Query("select m from MyOwnRecipe m where id=:idm ")
//    List<Object[]> getRecipeId(Long idm);
