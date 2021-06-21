package com.yener.happypoint.repository.dynamodb;

import com.yener.happypoint.entity.Star;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface StarRepository extends CrudRepository<Star, String> {

    Star findStarById(String id);

}
