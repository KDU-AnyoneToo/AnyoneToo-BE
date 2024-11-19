package org.anyonetoo.anyonetoo.service;

import lombok.RequiredArgsConstructor;
import org.anyonetoo.anyonetoo.domain.Consumer;
import org.anyonetoo.anyonetoo.domain.Seller;
import org.anyonetoo.anyonetoo.domain.User;
import org.anyonetoo.anyonetoo.dto.CommonResponseDTO;
import org.anyonetoo.anyonetoo.dto.UserRegistrationRequest;
import org.anyonetoo.anyonetoo.repository.ConsumerRepository;
import org.anyonetoo.anyonetoo.repository.SellerRepository;
import org.anyonetoo.anyonetoo.repository.UserRepository;
import org.anyonetoo.anyonetoo.security.Encoder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.anyonetoo.anyonetoo.dto.LoginRequestDTO;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ConsumerRepository consumerRepository;
    private final SellerRepository sellerRepository;
    private final Encoder encoder;

    public void register(UserRegistrationRequest request, String encryptedPassword) {
        // User 생성 및 저장
        User user = User.builder()
                .id(request.getId())
                .password(encryptedPassword)
                .build();
        userRepository.save(user);
        // Role에 따라 Consumer 또는 Seller 생성
        if ("consumer".equalsIgnoreCase(request.getRole())) {
            Consumer consumer = Consumer.builder()
                    .user(user)
                    .name(request.getName())
                    .age(request.getAge())
                    .build();
            consumerRepository.save(consumer);
        } else if ("seller".equalsIgnoreCase(request.getRole())) {
            Seller seller = Seller.builder()
                    .user(user)
                    .name(request.getName())
                    .age(request.getAge())
                    .build();
            sellerRepository.save(seller);
        }
    }

//    public void checkUser(String checkId){
//
//    }

//    public void registerUser(UserJoinRequestDTO userJoinRequestDto) {
//        User newUser = userJoinRequestDto.toEntity(passwordEncoder);
//        userRepository.save(newUser);  // 역할 설정 부분 삭제
//    }
//
//    // 사용자 로그인 처리
//    public String login(String userId, String userPassword) {
//        // 사용자 조회
//        User user = userRepository.findByUserId(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        // 비밀번호 검증
//        if (!passwordEncoder.matches(userPassword, user.getUserPassword())) {
//            throw new RuntimeException("Invalid password");
//        }
//
//        // 사용자 권한 가져오기
//        List<String> roles = Collections.singletonList("ROLE_USER"); // 또는 DB에서 roles를 조회
//
//        // JWT 토큰 생성
//        return jwtTokenProvider.createToken(userId, roles);
//    }

}
