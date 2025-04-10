document.addEventListener('DOMContentLoaded', function () {
    const articles = [
        { id: 19, title: "Exploring Ethical Safaris in Africa", summary: "Discover how ethical safaris in Africa prioritize animal welfare and conservation." },
        { id: 20, title: "The Truth About Elephant Sanctuaries in Thailand", summary: "Learn how to choose ethical elephant sanctuaries in Thailand that focus on rehabilitation." },
        { id: 21, title: "Marine Conservation Through Ethical Whale Watching", summary: "Explore how ethical whale watching supports marine conservation efforts." },
        { id: 22, title: "Volunteering at Wildlife Rescue Centers", summary: "Find out how volunteering at rescue centers can make a difference for wildlife." },
        { id: 23, title: "The Impact of Tourism on Sea Turtle Conservation", summary: "Understand the role of ethical tourism in protecting sea turtles." },
        { id: 24, title: "Birdwatching Tours: A Sustainable Way to Enjoy Wildlife", summary: "Discover how birdwatching tours can be a sustainable form of animal tourism." },
        { id: 25, title: "Ethical Animal Tourism in the Galápagos Islands", summary: "Learn about ethical practices in the Galápagos Islands for wildlife tourism." },
        { id: 26, title: "Protecting Big Cats Through Responsible Tourism", summary: "Explore how responsible tourism can help protect big cats like lions and tigers." },
        { id: 27, title: "The Role of Eco-Tourism in Saving Rainforests", summary: "Understand how eco-tourism contributes to rainforest conservation and wildlife protection." }
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
            articleLink.href = `/animal-tourism-article-details?id=${article.id}`; // Променен ендпойнт
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