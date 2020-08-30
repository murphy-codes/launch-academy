if (document.getElementById("fetch-random-article")) {
  const getRandomArticle = () => {
    fetch("http://localhost:3000/articles.json")
      .then(response => response.json())
      .then(responseBody => {
        let articles = responseBody.articles;
        let article = articles[Math.floor(Math.random() * articles.length)];
        let articleElement = document.createElement("div");
        for (let field of Object.keys(article)) {
          let fieldElement = document.createElement("p");
          fieldElement.textContent += article[field];
          articleElement.appendChild(fieldElement);
        };
        let newEntry = document.createElement("li");
        newEntry.appendChild(articleElement);
        document.getElementById("random-articles-list").appendChild(newEntry);
      })
      .catch((response => console.log(response)));
  };

  document.getElementById("fetch-random-article").addEventListener("click", getRandomArticle);
};



