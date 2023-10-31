package javaPrograms.assignments.Assignment_12;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        LocalDate local = LocalDate.of(2020,3,30);
        local = local.minusWeeks(-4L);
        System.out.println(local);
    }
}
