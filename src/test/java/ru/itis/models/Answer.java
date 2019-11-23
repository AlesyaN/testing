package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class Answer {
    private String text;

    private static SimpleDateFormat formatter;

    static {
        formatter = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
    }

    public Answer() {
        this.text = "Test answer: " + formatter.format(new Date());
    }
}
