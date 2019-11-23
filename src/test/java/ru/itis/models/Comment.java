package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class Comment {
    private String text;

    private static SimpleDateFormat formatter;

    static {
        formatter = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
    }
    public Comment() {
        this.text = "Test comment: " + formatter.format(new Date());
    }
}
