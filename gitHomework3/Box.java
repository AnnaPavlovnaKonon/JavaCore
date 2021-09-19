package homework3;

import java.util.ArrayList;

public class Box <T extends Fruits> {
    private ArrayList<T> fruitsList = new ArrayList<>();

    public Box() {
        this.fruitsList = new ArrayList<>();
    }

    public ArrayList<T> getFruitsList() {
        return fruitsList;
    }

    public void setFruitsList(ArrayList<T> fruitsList) {
        this.fruitsList = fruitsList;
    }

    // добавляем фрукты
    public void addFruit(T fruits) {
        fruitsList.add(fruits);
    }

    // узнаем вес
    public float getWeight() {
        float weight = 0;
        for (T fruits : fruitsList) {
            weight = fruitsList.size() * fruits.getWeight();
        }
        return weight;
    }

    // пересыпаем
    public void pourOverFruits(Box<T> box) {
        box.getFruitsList().addAll(fruitsList);
        fruitsList.clear();
    }

    @Override
    public String toString() {
        return "В коробке: " +
                fruitsList;
    }

    // сравниваем
    public boolean compareTo(Box<?> other) {
        return this.getWeight() == other.getWeight();
    }

}
