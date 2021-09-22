package homework4;

/* Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
   В этот телефонный справочник с помощью метода add() можно добавлять записи,
   а с помощью метода get() искать номер телефона по фамилии.
 */

import java.util.HashMap;

public class Phonebook {

    private HashMap<String, String> phoneBook = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        phoneBook.put(surname, phoneNumber);
        System.out.println("Добавлен номер телефона " + surname);
    }


    public void get(String surname) {
        System.out.println("Номер телефона " + surname + ": " + phoneBook.get(surname));
    }

    public static void main(String[] args) {
        Phonebook phoneBook = new Phonebook();
        phoneBook.add("Иванов", "+79123456789");
        phoneBook.add("Петров", "+79998887766");
        phoneBook.add("Ковалев", "+79112223344");
        phoneBook.add("Кузнецов","+79000000000");

        phoneBook.get("Кузнецов");
        phoneBook.get("Иванов");
        phoneBook.get("Петров");
        phoneBook.get("Ковалев");
    }
}
