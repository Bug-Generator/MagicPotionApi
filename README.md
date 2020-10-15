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

### Answering the takehome questions
My data schema is made up of a singular orders collection that stores information about a magic potion order that contains all the metadata recieved in the post request. Over time, we definitely want to scale this application by adding more orders and keeping track of our customers. We will want to break down the orders collection into two different collections, one for users and another for orders. This way, we can open the door to doing better analytics and solving problems as the complexity grows. We may also want to create a collection for products as we add more magic potions to our inventory.

The API architecture is the traditional MVC model using REST with contracts delegated to different layers. In the controller laye, I have a RESTController class called `OrdersController` that has the endpoints, recieves the http requests, and returns responses. In the service layer, a class called `OrdersService` that recieves request bodies, validates the user's input and makes sure we don't send bad data to the database and throws exceptions where neccessary. Finaly in the repository layer, I have a class that does the querying of the database. 

The front-end is an angular application with reactive forms with the ability of hitting the api endpoints and taking orders. It currently has andgular reactive forms validation in the ts file requiring all fields and checking that the zip code and phone number fields are numeric and that the zip code is 5 characters long. I have also forced the quantity and state field to be a select input type with the options passed directly from string arrays. This validates that a user can only order up to three magic potions at a time, and that we do not get a state we do not recognize in an order. There is also validation in the api that checks to see if an order with the same name and address exists in the database to prevent a customer from ordering twice and throws the appropriate error. The total field is a disabled field and its value is automatically calculated from a function that subscribes to the quantity field and multiplied the user's selection by the given price in the specification.
Over time, as we add more products we want to use angular routing and have a products component, home component and an orders component. The home being the default route of the ng app containing all the products in our inventory available for ordering and a bit of metadata of our chosing about the product. Each product can have a link that will open the product component and give a user the ability to order that product hereby hitting the create order api endpoint.

With more time in a different environment, I would like to keep the tech stack, I would like to have the data schema to multiple collections that allows us to scale easily by updating the collections. I would also like to implement a form of user authentication that will help us show a user their order history. I would also like to have some admin only patch endpoints that will be governed with spring annotations that will help us update order, products or user documents in the db without having to do so manually.

The spring application has all routes tested with tests written in groovy and using the spock framework. With more time, I would like to add more unit tests to the service, repository and models classes. I would also like to add jest unit tests to the HomeComponent in the angular application



