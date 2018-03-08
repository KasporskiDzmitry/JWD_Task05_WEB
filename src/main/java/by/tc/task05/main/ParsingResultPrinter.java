package by.tc.task05.main;

import by.tc.task05.entity.Food;

import java.util.List;

/**
 * Created by Дима on 05.03.2018.
 */
public class ParsingResultPrinter {

    public static void printResult(List<Food> menu) {
        for (Food food : menu) {
            System.out.println("**************************");
            System.out.println("Name: " + food.getName());
            System.out.println("ID: " + food.getId());
            System.out.println("Price: " + food.getPrice());
        }
    }
}
