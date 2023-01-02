package com.dropshot.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {

    private String id;

    private int password;

    private String email;

    private String nickname;

    private String birthday;

    private LocalDateTime regDate;
    private LocalDateTime modDate;

    @Builder.Default
    private Set<String> role= new HashSet<>();
}
