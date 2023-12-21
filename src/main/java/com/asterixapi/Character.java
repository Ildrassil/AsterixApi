package com.asterixapi;

import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;


@With
public record Character(
        @Id  String id,
        String name,
        int age,
        String profession

) {
}
