document.addEventListener('DOMContentLoaded', function () {
    const articles = [
        { id: 10, title: "The Benefits of Aromatherapy for Stress Relief", summary: "Discover how aromatherapy can reduce stress and promote relaxation.", content: "<p>Aromatherapy uses essential oils to improve physical and emotional health. Scents like lavender and eucalyptus can reduce stress, improve sleep, and enhance mood...</p>", image: "/images/aromatherapy.jpg" },
        { id: 11, title: "Herbal Remedies for Natural Healing", summary: "Learn about herbal remedies that support natural healing.", content: "<p>Herbs like chamomile, ginger, and turmeric have been used for centuries to treat various ailments naturally...</p>", image: "/images/herbal-remedies.jpg" },
        { id: 12, title: "The Role of Nature Walks in Mental Health", summary: "Explore how nature walks can improve your mental well-being.", content: "<p>Walking in nature reduces anxiety, boosts mood, and enhances cognitive function...</p>", image: "/images/nature-walks.jpg" },
        { id: 13, title: "Yoga for Holistic Wellness", summary: "Discover the benefits of yoga for mind, body, and spirit.", content: "<p>Yoga combines physical postures, breathing exercises, and meditation to promote holistic wellness...</p>", image: "/images/yoga.jpg" },
        { id: 14, title: "Sound Therapy: Healing Through Vibrations", summary: "Learn how sound therapy can promote relaxation and healing.", content: "<p>Sound therapy uses vibrations from instruments like singing bowls to reduce stress and balance energy...</p>", image: "/images/sound-therapy.jpg" },
        { id: 15, title: "The Impact of Forest Bathing on Well-being", summary: "Explore the Japanese practice of forest bathing for wellness.", content: "<p>Forest bathing, or Shinrin-yoku, involves immersing yourself in nature to reduce stress and improve health...</p>", image: "/images/forest-bathing.jpg" },
        { id: 16, title: "Mindful Eating for Emotional Health", summary: "Learn how mindful eating can improve your emotional well-being.", content: "<p>Mindful eating involves paying full attention to the eating experience, which can reduce emotional eating...</p>", image: "/images/mindful-eating.jpg" },
        { id: 17, title: "The Benefits of Hydrotherapy for Physical Health", summary: "Discover how hydrotherapy can support physical wellness.", content: "<p>Hydrotherapy uses water to relieve pain, improve circulation, and promote relaxation...</p>", image: "/images/hydrotherapy.jpg" },
        { id: 18, title: "Building a Sustainable Self-Care Routine", summary: "Learn how to create a self-care routine that’s good for you and the planet.", content: "<p>A sustainable self-care routine includes eco-friendly products and practices that nurture both you and the environment...</p>", image: "/images/self-care.jpg" }
    ];

    const articlesPerPage = 3;
    let currentPage = 1;
    const totalPages = Math.ceil(articles.length / articlesPerPage);

    const articlesList = document.getElementById('articles-list');
    const prevButton = document.getElementById('prev-page');
    const nextButton = document.getElementById('next-page');
    const pageInfo = document.getElementById('page-info');

    function displayArticles(page) {
        articlesList.innerHTML = '';
        const start = (page - 1) * articlesPerPage;
        const end = start + articlesPerPage;
        const paginatedArticles = articles.slice(start, end);

        paginatedArticles.forEach(article => {
            const articleCard = document.createElement('div');
            articleCard.classList.add('article-card');
            const articleLink = document.createElement('a');
            articleLink.href = `/wellness-article-details?id=${article.id}`; // Променен ендпойнт
            articleLink.textContent = article.title;
            const articleTitle = document.createElement('h3');
            articleTitle.appendChild(articleLink);
            const articleSummary = document.createElement('p');
            articleSummary.textContent = article.summary;
            articleCard.appendChild(articleTitle);
            articleCard.appendChild(articleSummary);
            articlesList.appendChild(articleCard);
        });

        pageInfo.textContent = `Page ${page} of ${totalPages}`;
        prevButton.disabled = page === 1;
        nextButton.disabled = page === totalPages;
    }

    prevButton.addEventListener('click', () => {
        if (currentPage > 1) {
            currentPage--;
            displayArticles(currentPage);
        }
    });

    nextButton.addEventListener('click', () => {
        if (currentPage < totalPages) {
            currentPage++;
            displayArticles(currentPage);
        }
    });

    displayArticles(currentPage);
});