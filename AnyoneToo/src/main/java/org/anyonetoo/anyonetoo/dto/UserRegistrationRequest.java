package org.anyonetoo.anyonetoo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistrationRequest {
    private String id; // 사용자 ID
    private String password; // 비밀번호
    private String name;     // 이름
    private Long age;        // 나이
    private String role;     // 역할 (e.g., "consumer", "seller")
}