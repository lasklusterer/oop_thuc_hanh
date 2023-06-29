package hust.soict.cs01.aims.mediaconcontainer.cart;

import hust.soict.cs01.aims.mediaconcontainer.MediaContainer;
import hust.soict.cs01.aims.media.Media;

import java.util.ArrayList;

public class Cart implements MediaContainer {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
        } else {
            System.out.println("Store is full!");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
        } else {
            System.out.println("Media not found");
        }
    }

    public float totalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Search methods
    public void searchById(int id) {
        for (Media item : itemsOrdered) {
            if (item.getId() == id) {
                System.out.println("Found media!");
                System.out.println(item);
                return;
            }
        }
        System.out.println("No match!");
    }
/*
    public void searchByTitle(String title) {
        for (Media item : itemsOrdered) {
            if (item.isMatch(title)) {
                System.out.println("Found media!");
                System.out.println(item);
                return;
            }
        }
        System.out.println("No match!");
    }
*/

    @Override
    public Media searchByTitle(String title) {
        for (Media item : itemsOrdered) {
            if (item.isMatch(title)) {
                return item;
            }
        }
        return null; // No match found
    }

    public void placeOrder() {
        itemsOrdered.clear();
    }

    public void sortByTitleCost() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }

    public void print() {
        System.out.print("""
                ***********************CART***********************\s
                Ordered Items:
                """);
        int i = 0;
        for (Media item : itemsOrdered) {
            System.out.printf("%d. %s\n", i + 1, item.toString());
            i++;
        }
        System.out.printf("""
                Total cost: %.2f$
                ***************************************************
                """, totalCost());
    }

    public int currentItemsCount() {
        return itemsOrdered.size();
    }
}