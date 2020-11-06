package com.closa.data.dao;

import com.closa.data.model.MenuFunction;
import com.closa.data.model.MenuGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface mfRepository extends JpaRepository<MenuFunction, Long> {
    Page<MenuFunction> getAllByMfGroup(MenuGroup group, Pageable pageable);
}
