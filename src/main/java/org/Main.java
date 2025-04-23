package org;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Đường dẫn đến các file JSON
        String facialCleanserFile = "src/main/resources/facial_cleansers_data.json";
        String sunscreenFile = "src/main/resources/sunscream_data.,ojson";
        String moisturizerFile = "src/main/resources/moisturizer_cream_data.json";

        // Đọc dữ liệu từ file JSON với các phương thức mới
        List<FacialCleanser> facialCleansers = DataScraper.scrapeFacialCleansersFromJson(facialCleanserFile);
        List<Sunscreen> sunscreens = DataScraper.scrapeSunscreensFromJson(sunscreenFile);
        List<MoisturizerCream> moisturizerCreams = DataScraper.scrapeMoisturizersFromJson(moisturizerFile);

        System.out.println("Đã đọc được " + facialCleansers.size() + " sữa rửa mặt");
        System.out.println("Đã đọc được " + sunscreens.size() + " kem chống nắng");
        System.out.println("Đã đọc được " + moisturizerCreams.size() + " kem dưỡng ẩm");

        // Kết hợp tất cả các sản phẩm vào một danh sách
        List<Product> allProducts = new ArrayList<>();
        allProducts.addAll(facialCleansers);
        allProducts.addAll(sunscreens);
        allProducts.addAll(moisturizerCreams);

        // Tạo đối tượng SearchEngine
        SearchEngine searchEngine = new SearchEngine(allProducts);

        // Ví dụ tìm kiếm sản phẩm theo từ khóa
        List<Product> searchResults = searchEngine.searchByKeyword("dưỡng ẩm");

        System.out.println("\nKết quả tìm kiếm cho 'dưỡng ẩm':");
        // Hiển thị các sản phẩm tìm được
        for (Product product : searchResults) {
            product.displayDetails();
            System.out.println(AIAssistant.generateRecommendation(product));
            System.out.println("------------------------");
        }
    }
}