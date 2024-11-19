package org.anyonetoo.anyonetoo.controller;

import lombok.RequiredArgsConstructor;
import org.anyonetoo.anyonetoo.domain.User;
import org.anyonetoo.anyonetoo.dto.KakaoVideoSearchResponse;
import org.anyonetoo.anyonetoo.service.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

@RestController
@RequestMapping("/kakao")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @GetMapping("/search/{query}")
    public ResponseEntity<KakaoVideoSearchResponse> search(HttpServletRequest req, @PathVariable String query) {
        User user = (User) req.getAttribute("user");
        String userId = user.getId();
        System.out.println(userId);

        KakaoVideoSearchResponse response = videoService.search(query);
        return ResponseEntity.ok(response);
    }
}
