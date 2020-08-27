fetch("https://the-cocktail-db.p.rapidapi.com/random.php", {
    "method": "GET",
    "headers": {
        "x-rapidapi-host": "the-cocktail-db.p.rapidapi.com",
        "x-rapidapi-key": "key"
    }
})


.then(response => response.json())
    .then(

        data =>
            // console.log(data))
            getCocktail(data))

    .catch(err => {
        console.log(err);
    });

function getCocktail(cocktail){

    // console.log( cocktail.drinks[0].strDrinkThumb + " " + cocktail.drinks[0].strDrink);
    let drinkSection = document.querySelector('#drink-section');
    let drinkName = document.createElement('h2');
    drinkName.innerHTML = cocktail.drinks[0].strDrink;
    drinkSection.appendChild(drinkName);

    let img = document.createElement('img');
    img.src = cocktail.drinks[0].strDrinkThumb;

    drinkSection.appendChild(img);
    for(let i=1; i<16; i++){
        // console.log(i);
        if(cocktail.drinks[0][`strIngredient${i}`] == null || cocktail.drinks[0][`strIngredient${i}`] == '' ){
            break;
        }

        let ingredient = document.createElement('ons-list-item');
        ingredient.innerHTML = cocktail.drinks[0][`strMeasure${i}`] + ': ' + cocktail.drinks[0][`strIngredient${i}`];
        drinkSection.appendChild(ingredient);

    }

    let card = document.createElement('ons-card');
    card.innerHTML = cocktail.drinks[0].strInstructions;

    drinkSection.appendChild(card);

}
