package kamenov.naturalnaturefinalapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WellnessArticlesController {

    private static final Map<Long, Map<String, String>> wellnessArticles = new HashMap<>();

    static {
        wellnessArticles.put(10L, Map.of(
                "title", "The Benefits of Aromatherapy for Stress Relief",
                "content", "<p>Aromatherapy uses essential oils to improve physical and emotional health. Scents like lavender and eucalyptus can reduce stress, improve sleep, and enhance mood...</p>",
                "image", "/images/aromatherapy.jpg"
        ));
        wellnessArticles.put(11L, Map.of(
                "title", "Herbal Remedies for Natural Healing",
                "content", "<p>Herbs like chamomile, ginger, and turmeric have been used for centuries to treat various ailments naturally...</p>",
                "image", "/images/herbal-remedies.jpg"
        ));
        wellnessArticles.put(12L, Map.of(
                "title", "The Role of Nature Walks in Mental Health",
                "content", "<p>Walking in nature reduces anxiety, boosts mood, and enhances cognitive function...</p>",
                "image", "/images/nature-walks.jpg"
        ));
        wellnessArticles.put(13L, Map.of(
                "title", "Yoga for Holistic Wellness",
                "content", "<p>Yoga combines physical postures, breathing exercises, and meditation to promote holistic wellness...</p>",
                "image", "/images/yoga.jpg"
        ));
        wellnessArticles.put(14L, Map.of(
                "title", "Sound Therapy: Healing Through Vibrations",
                "content", "<p>Sound therapy uses vibrations from instruments like singing bowls to reduce stress and balance energy...</p>",
                "image", "/images/sound-therapy.jpg"
        ));
        wellnessArticles.put(15L, Map.of(
                "title", "The Impact of Forest Bathing on Well-being",
                "content", "<p>Forest bathing, or Shinrin-yoku, involves immersing yourself in nature to reduce stress and improve health...</p>",
                "image", "/images/forest-bathing.jpg"
        ));
        wellnessArticles.put(16L, Map.of(
                "title", "Mindful Eating for Emotional Health",
                "content", "<p>Mindful eating involves paying full attention to the eating experience, which can reduce emotional eating...</p>",
                "image", "/images/mindful-eating.jpg"
        ));
        wellnessArticles.put(17L, Map.of(
                "title", "The Benefits of Hydrotherapy for Physical Health",
                "content", "<p>Hydrotherapy uses water to relieve pain, improve circulation, and promote relaxation...</p>",
                "image", "/images/hydrotherapy.jpg"
        ));
        wellnessArticles.put(18L, Map.of(
                "title", "Building a Sustainable Self-Care Routine",
                "content", "<p>A sustainable self-care routine includes eco-friendly products and practices that nurture both you and the environment...</p>",
                "image", "/images/self-care.jpg"
        ));
    }

    @GetMapping("/wellness-article-details")
    public String wellnessArticleDetails(@RequestParam("id") Long id, Model model) {
        Map<String, String> article = wellnessArticles.get(id);
        if (article == null) {
            return "redirect:/wellness"; // Ако статията не съществува, връщаме към основната страница
        }
        model.addAttribute("article", article);
        return "wellness-article-details";
    }
    @GetMapping("/wellness")
    public String nutrition(Model model) {
        model.addAttribute("pageTitle", "Natural Wellness Therapies");
        return "wellness";
    }
}
