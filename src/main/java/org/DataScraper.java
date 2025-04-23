package org;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataScraper {

    public static List<FacialCleanser> scrapeFacialCleansersFromJson(String filename) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("File không tồn tại: " + filename);
                return new ArrayList<>();
            }

            // Đọc JSON thành mảng các node
            JsonNode rootNode = objectMapper.readTree(file);
            List<FacialCleanser> cleansers = new ArrayList<>();

            // Duyệt qua từng đối tượng JSON
            for (JsonNode node : rootNode) {
                String title = node.path("title").asText("");
                String brand = node.path("brand").asText("");
                String price = node.path("price").asText("");
                String originalPrice = node.path("original_price").asText("");
                String description = node.path("description").asText("");
                String rating = node.path("rating").asText("");
                String ratingCount = node.path("rating_count").asText("");

                // Lấy loại da từ trường specifications nếu có
                String skinType = "";
                if (node.has("specifications") && node.path("specifications").has("Loại_da")) {
                    skinType = node.path("specifications").path("Loại_da").asText();
                }

                // Tạo đối tượng FacialCleanser
                FacialCleanser cleanser = new FacialCleanser(title, brand, price, originalPrice, description, rating, ratingCount, skinType);
                cleansers.add(cleanser);
            }

            return cleansers;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static List<Sunscreen> scrapeSunscreensFromJson(String filename) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("File không tồn tại: " + filename);
                return new ArrayList<>();
            }

            // Đọc JSON thành mảng các node
            JsonNode rootNode = objectMapper.readTree(file);
            List<Sunscreen> sunscreens = new ArrayList<>();

            // Duyệt qua từng đối tượng JSON
            for (JsonNode node : rootNode) {
                String title = node.path("title").asText("");
                String brand = node.path("brand").asText("");
                String price = node.path("price").asText("");
                String originalPrice = node.path("original_price").asText("");
                String description = node.path("description").asText("");
                String rating = node.path("rating").asText("");
                String ratingCount = node.path("rating_count").asText("");

                // Lấy SPF từ JSON (giả sử có thể nằm trong specifications hoặc là trường riêng)
                String spf = "";
                if (node.has("specifications") && node.path("specifications").has("SPF")) {
                    spf = node.path("specifications").path("SPF").asText();
                } else if (node.has("spf")) {
                    spf = node.path("spf").asText();
                }

                // Tạo đối tượng Sunscreen
                Sunscreen sunscreen = new Sunscreen(title, brand, price, originalPrice, description, rating, ratingCount, spf);
                sunscreens.add(sunscreen);
            }

            return sunscreens;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static List<MoisturizerCream> scrapeMoisturizersFromJson(String filename) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("File không tồn tại: " + filename);
                return new ArrayList<>();
            }

            // Đọc JSON thành mảng các node
            JsonNode rootNode = objectMapper.readTree(file);
            List<MoisturizerCream> moisturizers = new ArrayList<>();

            // Duyệt qua từng đối tượng JSON
            for (JsonNode node : rootNode) {
                String title = node.path("title").asText("");
                String brand = node.path("brand").asText("");
                String price = node.path("price").asText("");
                String originalPrice = node.path("original_price").asText("");
                String description = node.path("description").asText("");
                String rating = node.path("rating").asText("");
                String ratingCount = node.path("rating_count").asText("");

                // Lấy loại da từ specifications nếu có
                String skinType = "";
                if (node.has("specifications") && node.path("specifications").has("Loại_da")) {
                    skinType = node.path("specifications").path("Loại_da").asText();
                }

                // Tạo đối tượng MoisturizerCream
                MoisturizerCream moisturizer = new MoisturizerCream(title, brand, price, originalPrice, description, rating, ratingCount, skinType);
                moisturizers.add(moisturizer);
            }

            return moisturizers;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}