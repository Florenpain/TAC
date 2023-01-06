package com.example.app.placeholder;

import com.example.Champion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<Champion> LISTE_CHAMPIONS = new ArrayList<Champion>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, Champion> CHAMPIONS_MAP = new HashMap<String, Champion>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createPlaceholderItem(i));
        }
    }

    private static void addItem(Champion champion) {
        LISTE_CHAMPIONS.add(champion);
        CHAMPIONS_MAP.put(champion.getId(), champion);
    }

    private static Champion createPlaceholderItem(int position) {
        ArrayList<String> tags = new ArrayList<String>();
        tags.add("Fighter");
        Champion champion = new Champion();
        champion.setId(""+position);
        champion.setName("Champion " + position);
        return champion;
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }
}