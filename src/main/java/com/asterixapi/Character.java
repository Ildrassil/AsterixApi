package com.asterixapi;

import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;


@With
public record Character(
        @Field
        String id,
        @Field
        String name,
        @Field
        int age,
        @Field
        String profession

) {
}
