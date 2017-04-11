package org.batyrmalik;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static List<Knight> knights = new ArrayList<Knight>();

    public static void main(String[] args) throws InterruptedException {

        // constructor
        for (int i = 0; i < 6; i++) {
            knights.add(new Knight(i + 1));
        }
        knights.get(0).setCurrent(true);

        while (knights.size() > 1) {
            Knight current = getCurrent(knights);
            Knight next = getNext(knights);
            hit(current, next);
        }

        System.out.println(knights.get(0).getId() + " wins");
    }

    private static void hit(Knight current, Knight next) {
        int damage = throwDice();
        next.setHits(next.getHits() - damage);
        current.setCurrent(false);
        next.setCurrent(true);
        System.out.println(current.getId() + "(" + current.getHits() + ")" + " hits " + next.getId() + "(" + next.getHits() + ")" + " for " + damage);
        if (next.getHits() < 0) {
            System.out.println(next.getId() + " dies!");
            getNext(knights).setCurrent(true);
            knights.remove(next);
        }
    }

    private static int throwDice() {
        int result = new Random().nextInt(6);
        return result + 1;
    }

    private static Knight getNext(List<Knight> knights) {
        boolean afterCurrent = false;
        for (Knight knight : knights) {
            if (knight.isCurrent())
                afterCurrent = true;
            if (afterCurrent && !knight.isCurrent())
                return knight;
        }
        return knights.get(0);
    }

    private static Knight getCurrent(List<Knight> knights) {
        for (Knight knight : knights) {
            if (knight.isCurrent())
                return knight;
        }
        return null;
    }


}
