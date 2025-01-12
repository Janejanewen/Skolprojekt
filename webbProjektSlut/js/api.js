import { seasonalData, currentMonth } from './seasons.js';

const seasonalItems = seasonalData[currentMonth] || [];
let searchedKeywords = new Set(); 

// hämta data från API
export async function fetchMealData() {
  let allMeals = [];
  let attempts = 0;

  while (allMeals.length < 10 && attempts < 20) { // max 20 försök för att hämta 10 recept

    // inte uppera nyckelord
    const availableKeywords = seasonalItems.filter(item => !searchedKeywords.has(item)); 
    if (availableKeywords.length === 0) break; 
    const keyword = availableKeywords[Math.floor(Math.random() * availableKeywords.length)]; 
    searchedKeywords.add(keyword); 

    // hämta recept
    try {
      const response = await fetch(`https://www.themealdb.com/api/json/v1/1/search.php?s=${encodeURIComponent(keyword)}`);
      
      if (!response.ok) {
        console.error('Network response was not ok');
        continue;
      }

      const data = await response.json();
      const meals = data.meals || [];

      allMeals = [...new Set([...allMeals, ...meals])];
    } catch (error) {
      console.error('Error fetching meals:', error);
    }

    attempts++;

    // break när det finns 10 recept
    if (allMeals.length >= 10) {
      break;
    }
  }
  return allMeals;
}
