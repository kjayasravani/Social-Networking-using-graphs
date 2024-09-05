# Social Network Java Application

## Overview

This Java application provides a basic implementation of a social network. Users can create accounts, connect with friends, and view their friends list. The application uses an adjacency matrix to track connections between users.

## Features

- **Create Account**: Users can create a new account with a unique ID, name, and a password. The password must meet specific complexity requirements.
- **Connect with a Friend**: Users can establish a connection with another user by their unique IDs.
- **Show Friends List**: Users can view a list of their friends, including their names and IDs.

## Requirements

- Java 8 or higher

## How to Run

1. **Clone the Repository**: If you're using Git, you can clone the repository to your local machine.
   ```sh
   git clone <repository-url>

2. **Compile the Code**: Navigate to the directory containing the _code.java_ file and compile it using _javac_.
   ```sh
   javac code.java

3. **Run the Application**: Execute the compiled code class using _java_.
   ```sh
   java code

# Code Overview

## Classes

### Person
Represents a user with a name, unique ID, password, and a list of friends.

- **String name**: The name of the person.
- **String id**: The unique ID of the person.
- **String password**: The password of the person.
- **List<String> friends**: A list of IDs representing the person's friends.

### SocialNetwork
Manages the users and their connections.

- **List<Person> users**: List of all users in the network.
- **Map<String, Person> idToPersonMap**: Maps user IDs to `Person` objects.
- **boolean[][] adjacencyMatrix**: Adjacency matrix representing connections between users.

## Methods

- **createAccount(String name, String password)**: Creates a new account if the password is valid.
- **connectWithFriend(String userId, String friendId)**: Connects two users if both IDs are valid.
- **showFriendsList(String userId)**: Displays the list of friends for a given user ID.
- **generateUniqueId()**: Generates a unique ID for new users.
- **isValidPassword(String password)**: Checks if the password meets complexity requirements.

## Main Method

The main method provides a text-based interface allowing users to create accounts, connect with friends, and view their friends list.

## Usage

After starting the application, you'll be presented with a menu to:
- **Create an account**
- **Connect with a friend**
- **Show your friends list**
- **Exit the application**

Follow the prompts to interact with the application.

## Notes

Ensure that your password meets the following criteria:
- Contains at least one uppercase letter
- Contains at least one lowercase letter
- Contains at least one digit
- Contains at least one special character

The adjacency matrix is updated dynamically as users are added and connections are made.
