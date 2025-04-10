package kamenov.naturalnaturefinalapp.web;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AnimalTourismController {

    private static final Map<Long, Map<String, String>> animalTourismArticles = new HashMap<>();

    static {
        animalTourismArticles.put(19L, Map.of(
                "title", "Exploring Ethical Safaris in Africa",
                "content", "<p>Ethical safaris in Africa offer travelers a chance to observe wildlife in their natural habitats without causing harm. These safaris prioritize animal welfare by maintaining a safe distance and avoiding disruptive behaviors. Many safari operators work with conservation organizations to protect endangered species like rhinos and lions. Travelers can witness the beauty of the African savanna while supporting local communities through sustainable tourism. Ethical safaris often employ local guides, ensuring that economic benefits stay within the region. They also educate visitors about the importance of preserving biodiversity and combating poaching. By choosing ethical safaris, you contribute to the protection of Africa’s iconic wildlife. This form of tourism promotes a deeper understanding of the delicate balance of ecosystems. It also encourages travelers to advocate for conservation efforts worldwide. Responsible safaris are a model for how tourism can coexist with nature. They create lasting memories while ensuring that wildlife thrives for future generations.</p>",
                "image", "/images/african-safari.jpg"
        ));
        animalTourismArticles.put(20L, Map.of(
                "title", "The Truth About Elephant Sanctuaries in Thailand",
                "content", "<p>Elephant sanctuaries in Thailand vary widely in their practices, making it crucial to choose ethical ones. True sanctuaries focus on rehabilitation, providing a safe space for elephants rescued from logging or tourism industries. They prohibit riding and performances, allowing elephants to live as naturally as possible. Visitors can observe these majestic animals while learning about their history and the challenges they face. Ethical sanctuaries often collaborate with veterinarians to ensure the elephants’ health and well-being. Supporting these sanctuaries helps fund their efforts to rescue more elephants from abusive conditions. However, some places falsely advertise as sanctuaries while still exploiting animals for profit. Researching and choosing accredited sanctuaries ensures your visit has a positive impact. This approach helps shift the tourism industry toward compassion and sustainability. By making informed choices, travelers can help protect Thailand’s elephants for future generations.</p>",
                "image", "/images/elephant-sanctuary.jpg"
        ));
        animalTourismArticles.put(21L, Map.of(
                "title", "Marine Conservation Through Ethical Whale Watching",
                "content", "<p>Ethical whale watching is a powerful tool for marine conservation, allowing travelers to observe whales without disturbing them. Operators follow strict guidelines, such as maintaining a safe distance and limiting the number of boats in an area. This minimizes stress on whales and ensures their natural behaviors are not disrupted. Many whale watching tours also contribute to research, collecting data on whale populations and migration patterns. Travelers learn about the threats facing whales, such as ocean pollution and climate change. Supporting ethical operators helps fund conservation efforts and raises awareness about marine ecosystems. These tours often employ marine biologists who educate visitors about the importance of protecting our oceans. Ethical whale watching fosters a sense of wonder and responsibility toward marine life. It also encourages travelers to advocate for policies that protect whales and their habitats. This form of tourism shows how humans can coexist with marine wildlife sustainably.</p>",
                "image", "/images/whale-watching.jpg"
        ));
        animalTourismArticles.put(22L, Map.of(
                "title", "Volunteering at Wildlife Rescue Centers",
                "content", "<p>Volunteering at wildlife rescue centers offers a hands-on way to support ethical animal tourism and conservation. These centers rehabilitate injured or orphaned animals, preparing them for release back into the wild. Volunteers assist with tasks like feeding, cleaning enclosures, and monitoring animal health. This work provides critical support to underfunded centers while giving volunteers a deeper understanding of wildlife challenges. Many centers also educate visitors about the threats facing local species, such as habitat loss and poaching. Volunteering fosters a sense of connection with animals and a commitment to their protection. It’s a rewarding experience that directly contributes to the well-being of wildlife. Volunteers often leave with a renewed passion for conservation and a desire to spread awareness. This form of tourism ensures that animals receive the care they need to thrive. It also inspires others to get involved in ethical travel practices.</p>",
                "image", "/images/rescue-center.jpg"
        ));
        animalTourismArticles.put(23L, Map.of(
                "title", "The Impact of Tourism on Sea Turtle Conservation",
                "content", "<p>Ethical tourism plays a vital role in sea turtle conservation by supporting programs that protect these endangered creatures. Many coastal destinations offer turtle-watching tours that follow strict guidelines to avoid disturbing nesting sites. These tours educate travelers about the threats facing sea turtles, such as plastic pollution and illegal poaching. Revenue from ethical tourism often funds conservation efforts, including beach cleanups and hatchery programs. Travelers can participate in night patrols to monitor nesting turtles, ensuring their safety from predators. Supporting ethical operators helps reduce the demand for exploitative practices, like selling turtle shells. This form of tourism fosters a sense of responsibility toward protecting marine life. It also provides economic incentives for local communities to preserve turtle habitats. Ethical tourism ensures that sea turtles can thrive for future generations. By making informed choices, travelers can help save these ancient creatures.</p>",
                "image", "/images/sea-turtle.jpg"
        ));
        animalTourismArticles.put(24L, Map.of(
                "title", "Birdwatching Tours: A Sustainable Way to Enjoy Wildlife",
                "content", "<p>Birdwatching tours offer a sustainable way to enjoy wildlife while supporting conservation efforts. These tours take travelers to diverse habitats, from rainforests to wetlands, to observe birds in their natural environments. Ethical operators ensure minimal disturbance by keeping groups small and maintaining a safe distance. Many tours contribute to bird conservation by funding research and habitat restoration projects. Travelers learn about the ecological roles of birds, such as pollination and seed dispersal. Birdwatching fosters a deeper appreciation for biodiversity and the importance of protecting natural habitats. It’s a low-impact activity that can be enjoyed by people of all ages. Supporting ethical birdwatching tours helps preserve ecosystems for future generations. This form of tourism encourages travelers to advocate for environmental protection. It’s a perfect example of how tourism can coexist with nature harmoniously.</p>",
                "image", "/images/birdwatching.jpg"
        ));
        animalTourismArticles.put(25L, Map.of(
                "title", "Ethical Animal Tourism in the Galápagos Islands",
                "content", "<p>The Galápagos Islands are a model for ethical animal tourism, with strict regulations to protect their unique wildlife. Visitors can observe animals like giant tortoises and marine iguanas in their natural habitats without causing harm. Tour operators follow guidelines set by the Galápagos National Park, such as limiting group sizes and using designated paths. This ensures that tourism has a minimal impact on the islands’ delicate ecosystems. Revenue from tourism funds conservation efforts, including the protection of endangered species. Travelers learn about the islands’ biodiversity and the importance of preserving it for future generations. Ethical tourism in the Galápagos fosters a sense of wonder and responsibility toward nature. It also supports local communities by providing sustainable job opportunities. This approach shows how tourism can benefit both wildlife and people. The Galápagos Islands are a shining example of sustainable travel done right.</p>",
                "image", "/images/galapagos.jpg"
        ));
        animalTourismArticles.put(26L, Map.of(
                "title", "Protecting Big Cats Through Responsible Tourism",
                "content", "<p>Responsible tourism plays a crucial role in protecting big cats like lions, tigers, and leopards from extinction. Ethical tours focus on observing these majestic animals in the wild, rather than in captivity or staged environments. Operators work with conservation organizations to monitor populations and combat poaching. Travelers learn about the threats facing big cats, such as habitat loss and illegal hunting. Supporting ethical tourism helps fund anti-poaching patrols and habitat restoration projects. It also provides economic incentives for local communities to protect big cats rather than hunt them. This form of tourism fosters a deeper appreciation for the beauty and importance of big cats in ecosystems. By choosing responsible tours, travelers contribute to the survival of these iconic species. Ethical tourism ensures that big cats can roam free for generations to come. It’s a powerful way to make a difference while exploring the wild.</p>",
                "image", "/images/big-cats.jpg"
        ));
        animalTourismArticles.put(27L, Map.of(
                "title", "The Role of Eco-Tourism in Saving Rainforests",
                "content", "<p>Eco-tourism plays a vital role in saving rainforests by providing sustainable alternatives to deforestation and exploitation. Ethical tours in rainforests like the Amazon focus on low-impact activities, such as guided hikes and wildlife observation. These tours educate travelers about the importance of rainforests as habitats for countless species, including monkeys, birds, and jaguars. Revenue from eco-tourism funds conservation efforts, such as reforestation and anti-logging initiatives. Local communities benefit through job opportunities as guides, artisans, and hospitality workers. This economic incentive encourages locals to protect their forests rather than destroy them for short-term gain. Eco-tourism fosters a sense of global responsibility for preserving these vital ecosystems. It also inspires travelers to advocate for policies that protect rainforests worldwide. By supporting ethical tourism, you help ensure that rainforests remain a sanctuary for wildlife. This form of travel shows how humans can live in harmony with nature.</p>",
                "image", "/images/rainforest.jpg"
        ));
    }

    @GetMapping("/animal-tourism")
    public String animalTourism(Model model) {
        model.addAttribute("pageTitle", "Ethical Animal Tourism");
        return "animal-tourism";
    }

    @GetMapping("/animal-tourism-article-details")
    public String animalTourismArticleDetails(@RequestParam("id") Long id, Model model) {
        Map<String, String> article = animalTourismArticles.get(id);
        if (article == null) {
            return "redirect:/animal-tourism"; // Ако статията не съществува, връщаме към основната страница
        }
        model.addAttribute("article", article);
        return "animal-tourism-article-details";
    }
}