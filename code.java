import java.util.*;

class Person {
    String name;
    String id;
    String password;
    List<String> friends;
    public Person(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
        friends = new ArrayList<>();
    }
}

class SocialNetwork {
    List<Person> users;
    Map<String, Person> idToPersonMap;
    boolean[][] adjacencyMatrix;

    public SocialNetwork() {
        users = new ArrayList<>();
        idToPersonMap = new HashMap<>();
    }

    public void createAccount(String name, String password) {

        String id = generateUniqueId();

        if (!isValidPassword(password)) {
            System.out.println("Invalid password. Password must contain an uppercase letter, a lowercase letter, a digit, and a special character.");
            return;
        }

        Person person = new Person(name, id, password);
        users.add(person);
        idToPersonMap.put(id, person);


        int size = users.size();
        boolean[][] newMatrix = new boolean[size][size];


        if (adjacencyMatrix != null) {
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                    newMatrix[i][j] = adjacencyMatrix[i][j];
                }
            }
        }

        adjacencyMatrix = newMatrix;

        System.out.println("Account created successfully. Your unique ID is: " + id);
    }

    public void connectWithFriend(String userId, String friendId) {
        Person user = idToPersonMap.get(userId);
        Person friend = idToPersonMap.get(friendId);

        if (user == null || friend == null) {
            System.out.println("Invalid user ID or friend ID.");
            return;
        }

        user.friends.add(friendId);
        friend.friends.add(userId);

        int userIndex = users.indexOf(user);
        int friendIndex = users.indexOf(friend);

        adjacencyMatrix[userIndex][friendIndex] = true;
        adjacencyMatrix[friendIndex][userIndex] = true;

        System.out.println("Connected with friend successfully.");
    }

    public void showFriendsList(String userId) {
        Person user = idToPersonMap.get(userId);

        if (user == null) {
            System.out.println("Invalid user ID.");
            return;
        }

        System.out.println("Friends list of " + user.name + ":");
        for (String friendId : user.friends) {
            Person friend = idToPersonMap.get(friendId);
            System.out.println(friendId + " - " + friend.name);
        }
    }

    private String generateUniqueId() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    private boolean isValidPassword(String password) {
        // Check if the password contains an uppercase letter, a lowercase letter, a digit, and a special character
        return password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*[0-9].*") && password.matches(".*[^a-zA-Z0-9\\s].*");
    }
}

public class code {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialNetwork socialNetwork = new SocialNetwork();

        while (true) {
            System.out.println("------- Social Network -------");
            System.out.println("1. Create account");
            System.out.println("2. Connect with a friend");
            System.out.println("3. Show friends list");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();
                    socialNetwork.createAccount(name, password);
                }
                case 2 -> {
                    System.out.print("Enter your unique ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter your friend's unique ID: ");
                    String friendId = scanner.nextLine();
                    socialNetwork.connectWithFriend(userId, friendId);
                }
                case 3 -> {
                    System.out.print("Enter your unique ID: ");
                    String id = scanner.nextLine();
                    socialNetwork.showFriendsList(id);
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }
}
