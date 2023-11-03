package com.gallery.backend.repository;

import com.gallery.backend.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


//@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void saveTest(){
        User testUser = new User();
        testUser.setUserId("user1");
        testUser.setAdmin(false);
        testUser.setName("이용자1");
        testUser.setPassword("1234");
        testUser.setEmail("abcd@abcd.com");
        testUser.setPhoneNumber("01012341234");
        LocalDateTime currentTime = LocalDateTime.now();
        testUser.setBirthday("19990111");
        testUser.setCreatedAt(currentTime);

        userRepository.save(testUser);
    }
}