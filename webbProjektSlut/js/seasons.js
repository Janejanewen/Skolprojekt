export { seasonalData, currentMonth };

const seasonalData = {
  January: 
  [
    "Brussels Sprouts", "Baby Potatoes", "Kale", "Yellow Beet", "Yellow Onion", "Jerusalem Artichoke", "Rutabaga", "Carrots", "Parsnip", "Potatoes", "Celeriac", "Red Onion", "White Cabbage", "Apple"
  ],
  February: 
  [
    "Baby Potatoes", "Yellow Beet", "Yellow Onion", "Jerusalem Artichoke", "Rutabaga", "Carrot", "Parsnip", "Potatoes", "Celeriac", "Red Onion", "White Cabbage", "Apple"
  ],
  March: 
  [
    "Baby Potatoes", "Yellow Onion", "Cucumber", "Rutabaga", "Carrot", "Celeriac", "Red Onion", "Beetroot", "Matured Table Potatoes", "Apples"
  ],
  April:
  [
    "Baby Potatoes", "Cucumber", "Carrot", "Nettles", "Wild Garlic", "Celeriac", "Matured Table Potatoes", "Tomato", "Apples"
  ],
  May: 
  [
    "New Potatoes", "Chives", "Cucumber", "Iceberg Lettuce", "Rhubarb", "Spring Onion", "Matured Table Potatoes", "Asparagus", "Tomato", "Apples"
  ],
  June: 
  [
    "Cauliflower", "Broccoli", "Dill", "New Potatoes", "Cucumber", "Chives", "Kale", "Iceberg Lettuce", "Strawberries", "Spring Onion", "Bunched Carrot", "Bunched Beetroot", "Crisp Lettuce", "Rutabaga", "Parsley", "Rhubarb", "Chinese Cabbage", "Asparagus", "Spinach", "Pointed Cabbage", "Apple"
  ],
  July: 
  [
    "Sweet Cherries", "Cauliflower", "Blueberries", "Broad Beans", "Broccoli", "Green Beans", "Dill", "Fennel", "New Potatoes", "Yellow Beet", "Cucumber", "Chives", "Kale", "Raspberries", "Iceberg Lettuce", "Strawberries", "Chanterelles","Spring Onion", "Bunched Carrot", "Bunched Beetroot", "Rutabaga", "Cherries", "Chioggia Beet", "Leek", "Rhubarb", "Beetroot", "Red Cabbage", "Chinese Cabbage", "Savoy Cabbage","Snap Beans", "Sugar Snap Peas", "Spinach", "Pointed Cabbage", "Tomato", "Wax Beans", "White Cabbage", "Zucchini", "Apple"
  ],
  August:
  [
  "Sweet Cherries", "Celery", "Cauliflower", "Blueberries", "Broad Beans", "Broccoli", "Green Beans", "Dill", "Fennel", "Cucumber", "Chives, in Bunches", "Raspberries", "Iceberg Lettuce", "Strawberries", "Porcini Mushrooms", "Spring Onion, Yellow/Red", "Bunched Carrot", "Bunched Beetroot", "Dill Flowers", "Herbs in Pot", "Rutabaga", "Cherries", "Lingonberries",  "Corn on the Cob", "Carrot", "Horseradish", "Parsley", "Plums", "Pumpkin", "Leek", "Pears", 
  "Rhubarb", "Beetroot", "Chinese Cabbage", "Savoy Cabbage", "Sugar Snap Peas", "Summer Potatoes", "Spinach", "Pointed Cabbage", "Stalk Celery", "Black Kale (Cavolo Nero)", "Tomato", "Funnel Chanterelles", "White Cabbage", "Zucchini", "Apple (Discovery, Alice, Transparente Blanche)"
  ],

  September: 
  [
  "Celery", "Cauliflower", "Broccoli", "Brussels Sprouts", "Fennel", "Cucumber", 
  "Jerusalem Artichoke", "Iceberg Lettuce", "Chanterelles", "Herbs in Pot", "Kohlrabi","Rutabaga", "Onion (Yellow, Red)", "Corn", "Carrot", "Parsnip", "Parsley", "Potatoes", "Pumpkin", "Leek", "Pears (Carola, Conference, Herzogin Elsa) (Swedish)", "Celeriac", "Beetroot", "Red Cabbage", "Chinese Cabbage", "Savoy Cabbage", "Spinach","Pointed Cabbage", "Stalk Celery", "Tomato", "Funnel Chanterelles", "White Cabbage","Zucchini", "Apple (Alice, Discovery, Katja, Summerred, Gravenstein, Aroma, Saga, Rubinola)"
  ],
  October: 
  [
  "Celery", "Cauliflower", "Broccoli", "Brussels Sprouts", "Baby Potatoes", "Kale", "Yellow Onion", "Jerusalem Artichoke", "Chanterelles", "Herbs in Pot", "Kohlrabi", "Rutabaga", "Lingonberries", "Onion", "Carrot", "Parsnip", "Horseradish", "Parsley", "Potatoes", "Pumpkin", "Leek", "Pears (Alexander Lukas)", "Celeriac", "Red Onion", "Beetroot", "Red Cabbage", "Savoy Cabbage", "Matured Table Potatoes", "Pointed Cabbage", "Stalk Celery", "Tomato", "White Cabbage", "Apple (Aroma, Saga, Rubinola, Santana, Ingrid Marie)"
  ],

  November: 
  [
  "Cauliflower", "Brussels Sprouts", "Baby Potatoes", "Kale", "Yellow Onion", "Jerusalem Artichoke", "Chanterelles", "Herbs in Pot", "Rutabaga", "Onion", "Carrot", "Parsnip", "Parsley", "Potatoes", "Pumpkin", "Leek", "Celeriac", "Red Onion", "Beetroot", "Red Cabbage", "Savoy Cabbage", "Matured Table Potatoes", "Pointed Cabbage", "White Cabbage", "Apple"
  ],

  December: 
  [
    "Brussels Sprouts", "Baby Potatoes", "Kale", "Yellow Onion", "Jerusalem Artichoke", "Rutabaga", "Carrot", "Celeriac", "Beetroot", "Red Cabbage", "White Cabbage", "Apple"
  ]
};

const monthNames = [
  "January", "February", "March", "April", "May", "June", 
  "July", "August", "September", "October", "November", "December"
];
const currentMonth = monthNames[new Date().getMonth()];

