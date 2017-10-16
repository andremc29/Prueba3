package com.desafiolatam.prueba3.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonContent {

    public static final List<PokemonItem> ITEMS = new ArrayList<PokemonItem>();

 public static final Map<String, PokemonItem> ITEM_MAP = new HashMap<String, PokemonItem>();

    private static final int COUNT = 25;

    static {
        for (int i = 1; i <= COUNT; i++) {
            addItem(createPokemonItem(i));
        }
    }

    private static void addItem(PokemonItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PokemonItem createPokemonItem(int position) {
        return new PokemonItem(String.valueOf(position), "Item " + position);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public static class PokemonItem {
        public final String id;
        public final String content;

        public PokemonItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
