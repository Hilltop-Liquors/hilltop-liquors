package com.codeup.hilltopliquors.repositories;

import com.codeup.hilltopliquors.models.Category;
import com.codeup.hilltopliquors.models.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {


}
