package com.project.sns.service;

import com.project.sns.exception.ErrorCode;
import com.project.sns.exception.SnsApplicationException;
import com.project.sns.model.entity.PostEntity;
import com.project.sns.model.entity.UserEntity;
import com.project.sns.repository.PostEntityRepository;
import com.project.sns.repository.UserEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;
    @MockBean
    private PostEntityRepository postEntityRepository;
    @MockBean
    private UserEntityRepository userEntityRepository;

    @Test
    void 포스트작성이_성공한경우() {
        String title = "title";
        String body = "body";
        String userName = "userName";

        //mocking
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.of(mock(UserEntity.class)));
        when(postEntityRepository.save(any())).thenReturn(mock(PostEntity.class));

        //create 했을 때 오류가 나면 안 된다 그리고 이걸 하려면 mockBean이 필요 -> PostEntityRepository
        Assertions.assertDoesNotThrow(() -> postService.create(title, body, userName));
    }

    @Test
    void 포스트작성시_요청한유저가_존재하지않는경우(){
        String title = "title";
        String body = "body";
        String userName = "userName";

        //mocking
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.empty());
        when(postEntityRepository.save(any())).thenReturn(mock(PostEntity.class));

        SnsApplicationException e = Assertions.assertThrows(SnsApplicationException.class, () -> postService.create(title, body, userName));
        Assertions.assertEquals(ErrorCode.USER_NOT_FOUND, e.getErrorCode());
    }
}
