package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class Comment {
    private String text;

    public Comment() {
        this.text = UUID.randomUUID().toString();
    }
}
