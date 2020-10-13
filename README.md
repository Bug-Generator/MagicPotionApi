# MagicPotionApi
Delivering wizardry 🧙🏽‍♂️

Welcome all ye black magic aficionados. From Hogwarts freshmen to decorated wizards of our time 🎩. 

To get started, clone or download this repository. 

## Dependencies
This is a spring boot application utilizing gradle for dependency management and MongoDB to store all the voodoo data. Here are a few things you will need installed on your computer to have a groovy experience running this application. 
- `Java JDK 11` (https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) 

You may have to create an account with Oracle to download but, hey, by the time you get your magic potions you may be able to change their mind 😉

- `MongoDB` (https://www.mongodb.com/try/download/community)

If you have a mac and would like to use homebrew this is a nice article to get all setup (https://treehouse.github.io/installation-guides/mac/mongo-mac.html)
On a windows machine this is a very helpful article from our buddies at freecodecamp (https://www.freecodecamp.org/news/learn-mongodb-a4ce205e7739/)

- `Mongo Compass` (https://www.mongodb.com/try/download/compass) 

Optional -- this is mongo's tool providing you a nice GUI for your data, quite uncommon to have a CLI screen in your secret lab amirite

- `Postman` (https://www.postman.com/downloads/)

Optional but my guess is you will want to be able to test the endpoints in this api to see if your potions will make it to the lab 

## Getting the data layer ready
Once you have mongo installed on your computer, you want to create the database and collection that will power this api

- In your localhost instance of mongo you will want to create a database called `magicPotions` keep in mind that it is important the db name be camel-cased
- In the `magicPotions` db, create a collection named `orders` 

[**Here**](https://www.guru99.com/create-read-update-operations-mongodb.html) is an article that walks you through creating a database and collection in mongo

As this is a NoSQL db, there is no rigid structure to the documents(rows) we store in the collections(tables) so we will populate it with already defined models in the api.

## Running the api
Once all of the above is done and you have mongo up and running its time to run the application. You may choose to do so from an IDE of your choice which is typically trivial or from your terminal. If you choose to run it from the terminal, simply navigate to the root folder of the repository and run the ff comands
- `./gradlew clean build` -- runs unit tests, download all app dependecies specified in `build.gradle` and builds the application
- `./gradlew bootRun` -- runs the application on port 8080

## Using the endpoints
Once the application is running, we can use postman to hit some of the endpoints. 
- Make a `POST` request to `http://localhost:8080/api/magic/`
- In the request body paste the below snippet to have an idea of what the model for this api looks like
```
{
    "firstName": "Harry",
    "lastName": "Potter",
    "email": "hpotter@hogwarts.edu",
    "address": {
        "street1": "1 Hogwarts castle rd",
        "street2": "Rm 304",
        "city": "Highlands",
        "state": "NJ",
        "zip": "12345"
    },
    "phone": "1234567890",
    "quantity": "1",
    "total": "49.99",
    "payment": {
        "ccNum": "1234456778971234",
        "exp": "2021-03"
    }
}
```



