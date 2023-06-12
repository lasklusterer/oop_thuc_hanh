package hust.soict.cs01.aims.cart;

import hust.soict.cs01.aims.media.Media;

import java.util.ArrayList;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.printf("Added media %s to cart\n", media.getTitle());
        } else {
            System.out.println("Store is full!");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.printf("Removed media %s from cart\n", media.getTitle());
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
}