package com.example.whenbrella.domain.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String nickName;
    private String email;
    @Enumerated(EnumType.STRING)
    private Authority authority;
    private boolean isNotification;


    @Builder
    public User(Long id, String username, String password, String phone, boolean isNotification) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.isNotification = isNotification;
        this.authority = Authority.ROLE_USER;
    }

    public void updateNotification() {
        this.isNotification = !this.isNotification;
    }
}
