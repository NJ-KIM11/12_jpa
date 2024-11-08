package com.ohgiraffers.chap05springdata.category.service;

import com.ohgiraffers.chap05springdata.category.entity.Category;
import com.ohgiraffers.chap05springdata.category.repository.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository categoryRespository;

    public List<Category> selectAllCategory() {

        List<Category> categoryList = categoryRespository.findAll();
        if(categoryList.isEmpty()) {
            return null;
        }
        return categoryList;
    }


    public Category selectCategoryByCode(int categoryCode) {
        Category category = categoryRespository.findByCategoryCode(categoryCode);

        if(Objects.isNull(category)) {
            return null;
        }
        return category;
    }

    public Category insertCategory(String categoryName) {

        // 이름 중복 체크
        Category foundCategory = categoryRespository.findByCategoryName(categoryName);

        if(!Objects.isNull(foundCategory)) {
            return null;
        }

        Category insertCategory = new Category();
        insertCategory.setCategoryName(categoryName);

        Category result = categoryRespository.save(insertCategory);
        /*
        *  save() 는 jpa 에서 EntityManager 를 통해 데이터를 저장하는 메소드
        *  기본적으로, jpa 는 트랜잭션 내에서 자동으로 커밋을 처리한다.
        *  새로운 엔티티의 경우 : db에 저장하고 저장한 객체 반환
        *  기존에 존재하는 엔티티의 경우 : 해당 엔티티의 정보를 업데이트하고 업데이트한 객체 반환
        * */
        return result;

    }

    public Category updateCategory(int categoryCode, String categoryName) {

        Category foundCategory = categoryRespository.findByCategoryCode(categoryCode);

        if(Objects.isNull(foundCategory)) {
            return null;
        }

        foundCategory.setCategoryName(categoryName);
        Category result = categoryRespository.save(foundCategory);
        return result;
    }


    public boolean deleteCategory(Integer categoryCode) {

        Category category = categoryRespository.findById(categoryCode).orElse(null);
        // findById 를 쓰려면  없는 경우도 처리해주어야 한다(optional 타입의 처리)
        // orElse(null)    :    null 반환

        if(category == null){
            return false;
        }
        categoryRespository.delete(category);       // delete()메소드의 리턴값은 void 이다.
        // delete() 실행시 삭제 실패하면 에러발생
        // 위에서 category 없는 경우를 걸러줬기 때문에 성공을 염두에 두고 return true!
        return true;
    }
}
