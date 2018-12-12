package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {
    ArrayList<Integer> lista;

    public OddNumbersExterminator() {
        lista = new ArrayList<Integer>();
    }

    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        return evenNumbers;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(i * 3 + 17);
        System.out.println("Lista wyjściowa: ");
        for (Integer lista : list) {
            System.out.println(lista);
        }
        OddNumbersExterminator oddExterminator = new OddNumbersExterminator();
        oddExterminator.exterminate(list);
        System.out.println("Lista po usunięciu nieparzystych z listy wyjściowej: ");
        if (oddExterminator.exterminate(list).size() == 0) {
            System.out.println("lista pusta");
        } else {
            for (Integer evenLista : oddExterminator.exterminate(list))

                System.out.println(evenLista);
        }
    }
}