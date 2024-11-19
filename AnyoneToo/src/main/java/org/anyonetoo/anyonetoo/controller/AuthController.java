package org.anyonetoo.anyonetoo.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.anyonetoo.anyonetoo.domain.Consumer;
import org.anyonetoo.anyonetoo.domain.Seller;
import org.anyonetoo.anyonetoo.domain.User;
import org.anyonetoo.anyonetoo.dto.CommonResponseDTO;
import org.anyonetoo.anyonetoo.dto.LoginRequestDTO;
import org.anyonetoo.anyonetoo.dto.UserRegistrationRequest;
import org.anyonetoo.anyonetoo.repository.ConsumerRepository;
import org.anyonetoo.anyonetoo.repository.SellerRepository;
import org.anyonetoo.anyonetoo.repository.UserRepository;
import org.anyonetoo.anyonetoo.security.Encoder;
import org.anyonetoo.anyonetoo.security.JwtUtil;
import org.anyonetoo.anyonetoo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final ConsumerRepository consumerRepository;
    private final SellerRepository sellerRepository;
    private final Encoder encoder;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

//    @GetMapping("/check")
//    public ResponseEntity<String> check(@PathVariable String checkId){
//        userService.checkUser(checkId);
//        return ResponseEntity.ok()
//    }

//    @PostMapping("/join/seller")
//    public ResponseEntity<String> join(@RequestBody UserJoinRequestDTO userJoinRequestDto) {
//        userService.registerUser(userJoinRequestDto);
//        return ResponseEntity.ok("Registration successful");
//    }
//
//    @PostMapping("/join/consumer")
//    public ResponseEntity<String> join(@RequestBody UserJoinRequestDTO userJoinRequestDto) {
//        userService.registerUser(userJoinRequestDto);
//        return ResponseEntity.ok("Registration successful");
//    }
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegistrationRequest request) {
        try {
            // 예외를 처리하도록 함
            String encryptedPassword = encoder.encrypt(request.getPassword());
            userService.register(request, encryptedPassword);
            return ResponseEntity.ok("User registered successfully!");
        } catch (NoSuchAlgorithmException e) {
            // 예외 처리 (예: 500 내부 서버 오류)
            return ResponseEntity.status(400).body("Encryption algorithm not found");
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<CommonResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletResponse res) throws NoSuchAlgorithmException {
//        // 먼저 consumer 테이블에서 조회
//        Consumer consumer = consumerRepository.findById(loginRequestDTO.getId())
//                .orElse(null); // 없으면 null 반환
//
//        // consumer가 없으면 seller 테이블에서 조회
//        if (consumer == null) {
//            Seller seller = sellerRepository.findById(loginRequestDTO.getId())
//                    .orElseThrow(() -> new NullPointerException("가입된 적 없는 아이디입니다."));
//
//            // 비밀번호 검증
//            if (!encoder.encrypt(loginRequestDTO.getPassword()).equals(seller.getPassword())) {
//                return ResponseEntity.status(400).body(new CommonResponseDTO("비밀번호가 올바르지 않습니다.", 400));
//            }
//
//            // JWT 토큰 추가
//            jwtUtil.addToken(seller.getId(), res);
//
//            return ResponseEntity.status(200).body(new CommonResponseDTO("로그인 성공", 200));
//        }
//
//        // 비밀번호 검증
//        if (!encoder.encrypt(loginRequestDTO.getPassword()).equals(consumer.getPassword())) {
//            return ResponseEntity.status(400).body(new CommonResponseDTO("비밀번호가 올바르지 않습니다.", 400));
//        }
//
//        // JWT 토큰 추가
//        jwtUtil.addToken(consumer.getId(), res);
//
//        return ResponseEntity.status(200).body(new CommonResponseDTO("로그인 성공", 200));
//    }

//    @PostMapping("/login")
//    public ResponseEntity<CommonResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletResponse res) throws NoSuchAlgorithmException {
//        // 먼저 consumer 테이블에서 조회
//        User user = userRepository.findById(loginRequestDTO.getId())
//                .orElse(null); // 없으면 null 반환
//
//        // 비밀번호 검증
//        if (!encoder.encrypt(loginRequestDTO.getPassword()).equals(user.getPassword())) {
//            return ResponseEntity.status(400).body(new CommonResponseDTO("비밀번호가 올바르지 않습니다.", 400));
//        }
//
//        // JWT 토큰 추가
//        jwtUtil.addToken(user.getId(), res);
//
//        return ResponseEntity.status(200).body(new CommonResponseDTO("로그인 성공", 200));
//    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO) throws NoSuchAlgorithmException {
        // 사용자 조회
        User user = userRepository.findById(loginRequestDTO.getId())
                .orElse(null);

        // 사용자 존재 여부 및 비밀번호 확인
        if (user == null || !encoder.encrypt(loginRequestDTO.getPassword()).equals(user.getPassword())) {
            return ResponseEntity.status(400).body("Invalid username or password");
        }

        // JWT 토큰 생성
        String token = jwtUtil.createToken(user.getId());

        // 토큰 반환
        return ResponseEntity.ok(token);
    }


}
