import { currentMonth } from './seasons.js';

// visar recept i en ruta
export function createMealCard(meal) {
  const ingredients = [];
  return `
<div class="meal-card">
    <img src="${meal.strMealThumb}" alt="${meal.strMeal}" class="meal-image">
    <div class="content">
        <h3 class="meal-name">${meal.strMeal}</h3>
        <div class="details">
            <p><strong>Category:</strong> ${meal.strCategory}</p>
            <p><strong>Area:</strong> ${meal.strArea}</p>
            <p><strong>Instructions:</strong> ${meal.strInstructions}</p>
            <h4>Ingredients:</h4>
            <ul>
                ${ingredients.map(item => `<li>${item}</li>`).join('')}
            </ul>
            <a href="${meal.strYoutube}" target="_blank">Watch Video</a>
        </div>
    </div>
</div>
  `;
}

// anropa funktionen "createMealCard"
export function displayMeals(meals) {
  const recommendationsElement = document.getElementById('recommendations');
  if (!recommendationsElement) {
    console.error('Element with id="recommendations" not found');
    return;
  }

  recommendationsElement.innerHTML = `
    <h2>Meal Recommendations for ${currentMonth}</h2>
    ${meals.map(meal => createMealCard(meal)).join('')}
  `;
}
