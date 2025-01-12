import { createMealCard } from './display.js';

const urlParams = new URLSearchParams(window.location.search);
const query = urlParams.get('query');

// visa i results.html
if (query) {
    fetchRecipes (query);
} else {
    document.getElementById('results').innerHTML = '<p>No search query provided.</p>';
}

//funktionerna
// hämta recept från API
function fetchRecipes(query) {
    fetch(`https://www.themealdb.com/api/json/v1/1/search.php?s=${encodeURIComponent(query)}`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Error: ${response.status} - ${response.statusText}`);
            }
            return response.json();
        })
        .then(data => displayResults(data))
        .catch(error => {
            document.getElementById('results').innerHTML = `<p>${error.message}</p>`;
        });
}

// visa sökresultat
function displayResults(data) {
    const resultsDiv = document.getElementById('results');
    resultsDiv.innerHTML = ''; // tömmer div innan ny sökning

    if (data.meals && data.meals.length > 0) {
        data.meals.forEach(meal => {
            const recipeHTML = createMealCard(meal); // använd createMealCard
            const recipeDiv = document.createElement('div'); // skapa en container
            recipeDiv.classList.add('meal-container');
            recipeDiv.innerHTML = recipeHTML; // fyll containern med HTML
            resultsDiv.appendChild(recipeDiv); // lägg till containern i DOM
        });
    } else {
        resultsDiv.innerHTML = '<p>No recipes found.</p>';
    }
}




