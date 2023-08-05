package com.project.sns.repository;

import com.project.sns.model.entity.LikeEntity;
import com.project.sns.model.entity.PostEntity;
import com.project.sns.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeEntityRepository extends JpaRepository<LikeEntity, Integer> {

    Optional<LikeEntity> findByUserAndPost(UserEntity user, PostEntity post);

    // select * from "like" where post_id = 2 -> count(*)를 하면 row의 갯수를 반환한다, "like" 테이블을 LikeEntity 클래스로 사용하니까
    @Query(value = "SELECT COUNT(*) FROM LikeEntity entity WHERE entity.post =:post")
    Integer countByPost(@Param("post") PostEntity post);

//    List<LikeEntity> findAllByPost(PostEntity post);
}
