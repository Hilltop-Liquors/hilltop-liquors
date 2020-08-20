package com.codeup.hilltopliquors.repositories;

import com.codeup.hilltopliquors.models.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {

}
