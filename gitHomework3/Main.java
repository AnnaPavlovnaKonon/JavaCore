package homework3;

import java.util.Arrays;

public class Main {

    public static void changeArrayElements(Object[] array, int a, int b) {
        Object temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {

        Box<Apples> applesBox = new Box<>();
        applesBox.addFruit(new Apples());
        applesBox.addFruit(new Apples());
        applesBox.addFruit(new Apples());
        System.out.println("Вес первой коробки с яблоками: " + applesBox.getWeight());


        Box<Apples> applesBox2 = new Box<>();
        applesBox.addFruit(new Apples());
        applesBox.addFruit(new Apples());
        System.out.println("Вес первой коробки с яблоками: " + applesBox2.getWeight());

        applesBox.pourOverFruits(applesBox2);
        System.out.println("Вес первой коробки составил: " + applesBox.getWeight());
        System.out.println("Вес второй коробки составил: " + applesBox2.getWeight());

        Box<Oranges> orangesBox = new Box<>();
        orangesBox.addFruit(new Oranges());
        orangesBox.addFruit(new Oranges());
        orangesBox.addFruit(new Oranges());
        orangesBox.addFruit(new Oranges());
        System.out.println("Вес коробки с апельсинами: " + orangesBox.getWeight());


        System.out.println("Результат сравнения коробок: ");
        System.out.println(applesBox.compareTo(applesBox2));
    }

}
