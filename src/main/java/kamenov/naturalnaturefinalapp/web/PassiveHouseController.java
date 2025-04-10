package kamenov.naturalnaturefinalapp.web;

import kamenov.naturalnaturefinalapp.entity.Article;
import kamenov.naturalnaturefinalapp.entity.PassiveHouse;
import kamenov.naturalnaturefinalapp.service.ArticleService;
import kamenov.naturalnaturefinalapp.service.PassiveHouseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PassiveHouseController {

    private final PassiveHouseService passiveHouseService;
    private final ArticleService articleService;

    public PassiveHouseController(PassiveHouseService passiveHouseService,
                                  ArticleService articleService) {
        this.passiveHouseService = passiveHouseService;
        this.articleService = articleService;
        initializeData();
    }

    private void initializeData() {
        // Инициализация на Passive Houses
        List<PassiveHouse> allPassiveHouses = passiveHouseService.getAllPassiveHouses();
        if (allPassiveHouses.isEmpty()) {
            System.out.println("PassiveHouseController: Initializing Passive Houses...");
            passiveHouseService.savePassiveHouse(new PassiveHouse(
                    "Understanding Eco-Friendly Homes: A Comprehensive Guide",
                    "Eco-friendly homes are designed to minimize environmental impact " +
                            "through energy efficiency," +
                            " sustainable materials, and renewable energy sources. Learn the basics of passive house design.",
                    "/images/house-5.jpg",
                     "Energy Efficiency","https://www.youtube.com/embed/eRBNnfXXF4w"
            ));
            passiveHouseService.savePassiveHouse(new PassiveHouse(
                    "Principles of Sustainable Home Design for Your Next Home Improvement",
                    "Sustainable home design focuses on reducing energy consumption, using natural light, and incorporating eco-friendly materials. Discover key principles to apply in your next project.",

                    "/images/home-design.jpg",
                    "Energy Efficiency",
                    "https://www.youtube.com/embed/oIddRKVH6H0"));
            passiveHouseService.savePassiveHouse(new PassiveHouse(
                    "Building the Passive House: Steps to Achieve an Eco-Friendly House",
                    "Building a passive house involves careful planning, from site selection to insulation. Follow these steps to create an energy-efficient home.",

                    "/images/passive-house-build.jpg",
                    "Energy Efficiency",
                    "https://www.youtube.com/embed/passive-house-build-video"
            ));
            passiveHouseService.savePassiveHouse(new PassiveHouse(
                    "An Insight into Green Home: Environmentally Friendly Approaches in House Construction",
                    "Solar power systems are a cornerstone of green homes. Learn how to integrate solar panels into your home for sustainable energy.",

                    "/images/solar-city-anime.jpeg",
                    "Solar Power Systems",
                    "https://www.youtube.com/embed/Fezmkc9X3eE"
            ));
            passiveHouseService.savePassiveHouse(new PassiveHouse(
                    "Going Beyond the Basics: Insulation, Energy Efficiency, and Ways to Heat and Cool Your Eco-Home",
                    "Solar energy can be used for heating and cooling. Explore advanced techniques to maximize energy efficiency in your eco-home.",

                    "/images/solar-city-2.jpeg",
                    "Solar Power Systems",
                    "https://www.youtube.com/embed/Bx0aDeru_Xw"
            ));
            passiveHouseService.savePassiveHouse(new PassiveHouse(
                    "Popular Sustainable Living Techniques: Energy Efficient Appliances, Rainwater Collection, and Renewable Energy Use in Homes",
                    "Rainwater collection systems can significantly reduce water usage. Learn how to implement them in your home.",
                    "Water Conservation","/images/water-anime.jpg",
                    "https://www.youtube.com/embed/N6wJa4j5dO4"

            ));
            passiveHouseService.savePassiveHouse(new PassiveHouse(
                    "Transition into an Eco-Friendly Building: Make Your Home More Sustainable with Energy Star-rated Appliances and Fixtures",
                    "Water-saving fixtures and Energy Star-rated appliances can transform your home into a sustainable haven. Discover the best options.",
                    "/images/water-anime-2.jpg",
                    "Water Conservation",
                    "https://www.youtube.com/embed/V9ODb6YAeFc"

            ));
            passiveHouseService.savePassiveHouse(new PassiveHouse(
                    "Making the Smart Choice: Leverage Prefab Homes and Eco-Friendly Building Materials for Reduced Energy Use",
                    "Wind turbines can provide renewable energy for prefab homes. Learn how to integrate them into your eco-friendly design.",

                    "/images/wind-1.jpg",
                    "Wind Turbines",
                            "https://www.youtube.com/embed/itd5kg7GsfA"
            ));
            passiveHouseService.savePassiveHouse(new PassiveHouse(
                    "Reconfiguring Existing Homes: Ideas to Transform Your Home into an Energy-Efficient One",
                    "Retrofitting your home with wind turbines and other renewable energy sources can make it more sustainable. Get practical ideas here.",
                    "/images/wind-2.jpg",
                    "Wind Turbines",
                    "https://www.youtube.com/embed/nPvTH7Siclg"
            ));
            passiveHouseService.savePassiveHouse(new PassiveHouse(
                    "Earth-friendly Materials for Friendly Homes: Natural Materials in the Construction of Environmentally Friendly Homes",
                    "Using natural materials alongside wind energy can create a truly eco-friendly home. Explore the best materials to use.",

                    "/images/wind-anime.jpg",
                    "Wind Turbines",
                    "https://www.youtube.com/embed/Fezmkc9X3eE"
            ));
            System.out.println("PassiveHouseController: Passive Houses initialized.");
        } else {
            System.out.println("PassiveHouseController: Passive Houses already initialized. Count: " + allPassiveHouses.size());
        }

        // Инициализация на Articles
        String categoryPassiveHouses = "Passive Houses";
        Pageable pageable = PageRequest.of(0, 1); // Взимаме само една страница, за да проверим дали има статии
        Page<Article> articles = articleService.getArticlesByCategory("Passive Houses", pageable);
        if (articles.getTotalElements() == 0) {
            System.out.println("PassiveHouseController: Initializing Articles...");
            if (!articleService.existsByTitleAndCategory("The Future of Passive Houses", categoryPassiveHouses)) {
                articleService.saveArticle(new Article("The Future of Passive Houses",
                        "Exploring the latest trends in passive house design.",
                        categoryPassiveHouses, "/images/house-6.jpg"));
            }
            if (!articleService.existsByTitleAndCategory("How to Retrofit Your Home for Energy Efficiency", categoryPassiveHouses)) {
                articleService.saveArticle(new Article("How to Retrofit Your Home for Energy Efficiency",
                        "Practical tips for making your home more sustainable.",
                        "/images/home-fit-anime.jpg", categoryPassiveHouses));
            }
            if (!articleService.existsByTitleAndCategory("Solar Power: The Ultimate Guide", categoryPassiveHouses)) {
                articleService.saveArticle(new Article("Solar Power: The Ultimate Guide",
                        "Everything you need to know about solar energy in homes.",
                        "/images/solar-city-anime.jpeg", categoryPassiveHouses));
            }
            if (!articleService.existsByTitleAndCategory("Water Conservation Techniques for Every Home", categoryPassiveHouses)) {
                articleService.saveArticle(new Article("Water Conservation Techniques for Every Home",
                        "Simple ways to save water in your household.",
                        "/images/water-anime.jpg", categoryPassiveHouses));
            }
            if (!articleService.existsByTitleAndCategory("Wind Turbines for Residential Use", categoryPassiveHouses)) {
                articleService.saveArticle(new Article("Wind Turbines for Residential Use",
                        "A beginner's guide to wind energy at home.",
                        "/images/wind-1.jpg", categoryPassiveHouses));
            }
            if (!articleService.existsByTitleAndCategory("Eco-Friendly Materials 101", categoryPassiveHouses)) {
                articleService.saveArticle(new Article("Eco-Friendly Materials 101",
                        "The best materials for sustainable construction.",
                        "/images/101-anime.jpg", categoryPassiveHouses));
            }
            if (!articleService.existsByTitleAndCategory("Energy Star Appliances: Why They Matter", categoryPassiveHouses)) {
                articleService.saveArticle(new Article("Energy Star Appliances: Why They Matter",
                        "How Energy Star appliances can reduce your energy bills.",
                        "/images/energy-star.jpg", categoryPassiveHouses));
            }
            if (!articleService.existsByTitleAndCategory("Prefab Homes: The Future of Sustainable Living", categoryPassiveHouses)) {
                articleService.saveArticle(new Article("Prefab Homes: The Future of Sustainable Living",
                        "Why prefab homes are a smart choice for eco-conscious builders?\n" +
                                "Prefab Homes: The Future of Efficient Housing\n" +
                                "1. What Are Prefab Homes?\n" +
                                "Prefab homes (short for prefabricated homes) are residential structures where major components (walls, roof, interior elements)\n" +
                                "are manufactured off-site in a factory-controlled environment, then transported and assembled on the building site.\n" +
                                "This method revolutionizes traditional construction by prioritizing speed, precision, and sustainability.\n" +
                                "2. Types of Prefab Homes:\n" +
                                "Modular Homes: Built in sections (modules) that are stacked or joined on-site.\n" +
                                "Panelized Homes: Use pre-made wall panels for rapid assembly.\n" +
                                "Steel or Timber Frame Homes: Lightweight yet durable skeletal structures.\n" +
                                "Shipping Container Homes: Repurposed steel containers transformed into living spaces.\n" +
                                "Tiny Homes: Compact, mobile dwellings (often under 400 sq. ft).\n" +
                                "3. Key Advantages:\n" +
                                "Speed: 50–70% faster construction than traditional methods (typically 2–6 months).\n" +
                                "Cost-Effective: Reduced labor/material waste and predictable pricing.\n" +
                                "Eco-Friendly: Minimized construction waste; options for recycled/sustainable materials.\n" +
                                "Customization: Flexible designs to match modern aesthetics.\n" +
                                "Quality Control: Factory precision reduces defects and weather-related delays.\n" +
                                "4. Challenges to Consider:\n" +
                                "Design Limits: Complex architectural features may require customization.\n" +
                                "Transport Logistics: Costs vary by location and home size.\n" +
                                "Zoning Laws: Some regions have strict permits for prefab structures.\n" +
                                "5. Ideal For:\n" +
                                "Homeowners seeking affordable, fast-tracked housing.\n" +
                                "Minimalists and eco-conscious buyers.\n" +
                                "Investors in vacation rentals or ADUs (Accessory Dwelling Units).\n" +
                                "6. Prefab vs. Traditional Homes:\n" +
                                "Feature\tPrefab Homes\tTraditional Homes\n" +
                                "Build Time\t2–6 months\t6–18+ months\n" +
                                "Cost\tOften 10–20% lower\tHighly variable\n" +
                                "Sustainability\tHigh potential\tMore waste generated\n" +
                                "Why It Matters Now:\n" +
                                "With rising housing costs and climate concerns, prefab homes offer a scalable, efficient, \n" +
                                "and greener alternative—blending innovation with practicality.\n" +
                                "Pro Tip: Look for certifications like LEED or Passivhaus for ultra-efficient models.\n" +
                                "This version keeps your original structure but enhances readability with:\n" +
                                "Clearer headings and bullet points.",
                        "/images/prefab-house.jpg", categoryPassiveHouses));
            }
            // Статии за Transportation
//            articleService.saveArticle(new Article("The Rise of Electric Vehicles", "How electric cars are changing the future of transportation.", "Transportation", "/images/electric-vehicle.jpg"));
//            articleService.saveArticle(new Article("Sustainable Public Transport", "Exploring eco-friendly options for public transportation.", "Transportation", "/images/public-transport.jpg"));
//            articleService.saveArticle(new Article("Biking to Work: A Green Alternative", "Benefits of using a bicycle for your daily commute.", "Transportation", "/images/biking.jpg"));
//            articleService.saveArticle(new Article("The Future of Autonomous Vehicles", "How self-driving cars can reduce emissions.", "Transportation", "/images/autonomous-vehicle.jpg"));
//            System.out.println("PassiveHouseController: Articles initialized.");
        } else {
            System.out.println("PassiveHouseController: Articles already initialized. Count: " + articles.getTotalElements());
        }
    }

    @GetMapping("/passive-houses")
    public String getPassiveHouses(@RequestParam(defaultValue = "0") int page, Model model) {
        // Проверка за отрицателна страница
        if (page < 0) {
            page = 0;
        }

        // Добавяне на секциите за пасивни къщи
        List<PassiveHouse> energyEfficiency = passiveHouseService.getPassiveHousesByCategory("Energy Efficiency");
        List<PassiveHouse> solarPowerSystems = passiveHouseService.getPassiveHousesByCategory("Solar Power Systems");
        List<PassiveHouse> waterConservation = passiveHouseService.getPassiveHousesByCategory("Water Conservation");
        List<PassiveHouse> windTurbines = passiveHouseService.getPassiveHousesByCategory("Wind Turbines");

        System.out.println("PassiveHouseController: EnergyEfficiency size: " + (energyEfficiency != null ? energyEfficiency.size() : "null"));
        System.out.println("PassiveHouseController: SolarPowerSystems size: " + (solarPowerSystems != null ? solarPowerSystems.size() : "null"));
        System.out.println("PassiveHouseController: WaterConservation size: " + (waterConservation != null ? waterConservation.size() : "null"));
        System.out.println("PassiveHouseController: WindTurbines size: " + (windTurbines != null ? windTurbines.size() : "null"));

        model.addAttribute("energyEfficiency", energyEfficiency);
        model.addAttribute("solarPowerSystems", solarPowerSystems);
        model.addAttribute("waterConservation", waterConservation);
        model.addAttribute("windTurbines", windTurbines);

        // Пагинация за статии
        Pageable pageable = PageRequest.of(page, 3);
        Page<?> articles = articleService.getArticlesByCategory("Passive Houses", pageable);
        System.out.println("PassiveHouseController: Articles size: " + (articles != null ? articles.getContent().size() : "null"));
        System.out.println("PassiveHouseController: Total Pages: " + (articles != null ? articles.getTotalPages() : "null"));

        model.addAttribute("articles", articles != null ? articles.getContent() : List.of());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", articles != null ? articles.getTotalPages() : 0);
        model.addAttribute("hasPrevious", page > 0);
        model.addAttribute("hasNext", articles != null && page < articles.getTotalPages() - 1);

        return "passive-houses";
    }



//    @GetMapping("/passive-houses")
//    public String getPassiveHouses(@RequestParam(defaultValue = "1")
//                                       int page, Model model) {
//        if (page < 1) {
//            page = 1; // Ако page е отрицателен, го правим 0
//        }
//// Добавяне на секциите за пасивни къщи
//        List<PassiveHouse> energyEfficiency = passiveHouseService.getPassiveHousesByCategory("Energy Efficiency");
//        List<PassiveHouse> solarPowerSystems = passiveHouseService.getPassiveHousesByCategory("Solar Power Systems");
//        List<PassiveHouse> waterConservation = passiveHouseService.getPassiveHousesByCategory("Water Conservation");
//        List<PassiveHouse> windTurbines = passiveHouseService.getPassiveHousesByCategory("Wind Turbines");
//
//        System.out.println("Energy Efficiency: " + energyEfficiency);
//        System.out.println("Solar Power Systems: " + solarPowerSystems);
//        System.out.println("Water Conservation: " + waterConservation);
//        System.out.println("Wind Turbines: " + windTurbines);
//
//        model.addAttribute("energyEfficiency", energyEfficiency);
//        model.addAttribute("solarPowerSystems", solarPowerSystems);
//        model.addAttribute("waterConservation", waterConservation);
//        model.addAttribute("windTurbines", windTurbines);
//
//        // Пагинация за статии
//        Pageable pageable = PageRequest.of(page, 3);
//        Page<?> articles = articleService.getArticlesByCategory("Passive Houses", pageable);
//        System.out.println("Articles: " + articles.getContent());
//        System.out.println("Total Pages: " + articles.getTotalPages());
//
//        model.addAttribute("articles", articles.getContent());
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", articles.getTotalPages());
//        model.addAttribute("hasPrevious", page > 1);
//        model.addAttribute("hasNext", page < articles.getTotalPages() - 1);
//
//        return "passive-houses";
//    }
}
