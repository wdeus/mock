package br.edu.fatec.sjc;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumberAscOrder<T extends Number> {

    private CustomStack<T> customStack;
    public NumberAscOrder(CustomStack<T> customStack) {
        this.customStack = customStack;
    }

    public List<T> sort() throws StackEmptyException {
        if (customStack.isEmpty()) {
            throw new StackEmptyException();
        }

        List<T> sortedList = new ArrayList<>();

        for (int i = 0; i < customStack.size(); i++) {
            sortedList.add(customStack.pop());
        }

        sortedList.sort(Comparator.comparingDouble(Number::doubleValue));

        return sortedList;
    }
}
