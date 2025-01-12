import { fetchMealData } from './api.js';
import { displayMeals } from './display.js';

//Visa tio rekommendationer
fetchMealData()
  .then(allMeals => 
    {
    displayMeals(allMeals.slice(0, 10));
    })
  .catch(error => 
    {
    console.log('Error:', error);
    });
    

    // sökfunktion
  const searchButton = document.getElementById('searchButton');
  searchButton.addEventListener('click', function () {
      const query = document.getElementById('query').value.trim();
      if (query) {
          const resultsWindow = window.open('results.html?query=' + encodeURIComponent(query), '_blank');
          resultsWindow.focus();
      } else {
          alert('Please enter a search term.');
      }
  });