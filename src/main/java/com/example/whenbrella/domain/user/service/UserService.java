package com.example.whenbrella.domain.user.service;
import com.example.whenbrella.domain.auth.dto.SignUpReq;
import com.example.whenbrella.domain.user.domain.User;
import com.example.whenbrella.domain.user.repository.UserRepository;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User createUser(SignUpReq request){
        if(userRepository.existsByUsername(request.username())){
            log.error("이미 존재하는 계정입니다.");
            throw new IllegalArgumentException("이미 존재하는 계정입니다.");
        }

        User user = request.toEntity();
        log.info("{} 계정 생성",request.username());
        return userRepository.save(user);
    }
}
