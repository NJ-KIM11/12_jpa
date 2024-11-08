package com.ohgiraffers.chap05springdata.category.repository;

import com.ohgiraffers.chap05springdata.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRespository extends JpaRepository<Category, Integer> {
                                                        // 엔티티 클래스 이름, Id 의 타입



    Category findByCategoryCode(int categoryCode);
    // findBy 뒤에오는 메소드이름으로 jpa 에서 쿼리를 날린다. (where = CategoryCode)


    Category findByCategoryName(String categoryName);


}
