import GameCharacter.GameCharacter;
import location.hostilelocations.Cave;
import location.hostilelocations.Forest;
import location.hostilelocations.HostileLocation;
import location.hostilelocations.River;
import location.hostilelocations.enemy.Enemy;
import location.nonhositlelocations.Store;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private static final Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        GameCharacter player = start();
        game(player);
    }

    public static GameCharacter start() {

        System.out.println("Welcome to the \"Adventure in Stranded Island\"");
        System.out.println("Please select your character");
        System.out.println("1. Samurai");
        System.out.println("2. Archer");
        System.out.println("3. Knight");
        System.out.println("4. Godzilla");
        GameCharacter c1 = new GameCharacter();
        c1.SelectCharacter(input.nextInt());
        input.nextLine();
        System.out.println("You selected the " + c1.getName());
        System.out.println("Are you ready?  (Y/N) ");
        String isReady = input.nextLine();

        if (isReady.equalsIgnoreCase("y") || isReady.equalsIgnoreCase("n")) {
            if (isReady.equalsIgnoreCase("n")) start();
        } else {
            System.out.println("Invalid input! Restarting the game");
            start();
        }
        System.out.println("You find yourself in a far stranded island, with no other land exist in your sight. \n" + "You decide to leave this empty cold island by any means necessary. Strangely you find yourself in a heartwarming place \n" + "where you can spend your leisure time and rest. \n" + "After you start exploring the island you see some useful sights.\n" + "These are; Cave, Forest, River and surprisingly there is a store in this island which run by a man called \"Cuma\".");
        System.out.println("Be careful though! These locations may contain some dangerous folk inside.\n");
        System.out.println("Press enter to proceed");
        if (!(input.nextLine().equals(""))) {
            System.out.println("Invalid input! Restarting the game");
            start();
        }
        System.out.println("Eventually, you feel the need of checking your bag which survived from the crash. ");
        System.out.println("You have nothing in your bag currently.");

        return c1;


    }


    public static void game(GameCharacter p1) {
        p1.setHealth(p1.getHealthbar());
        System.out.println("\nYour money is " + p1.getMoney());
        System.out.println("What would you like to do?");
        System.out.println("D: display your items in your bag");
        System.out.println("A: Go on a new adventure!");
        System.out.println("S: Go to the Cuma's Store");
        System.out.println("C: Check your status on the quest items");
        System.out.println("Q: Quit the game");
        String choice = input.nextLine();
        switch (choice) {

            case "d":
            case "D":
                System.out.println(Arrays.toString(p1.displayBag()));
                game(p1);
                break;

            case "a":
            case "A":
                adventure(p1);
                break;
            case "s":
            case "S":
                Store store = new Store(p1);
                store.shopping();
                game(p1);
                break;
            case "q":
            case "Q":
                System.out.println("See you soon! :)");
                end();
                break;

            case "C":
            case "c":
                System.out.println(Arrays.toString(p1.getQuestItems()));
                if (p1.getQuestItems(0) && p1.getQuestItems(1) && p1.getQuestItems(2)) {
                    System.out.println("Congratulations " + p1.getName() + " ! You have acquired all of the quest items. Do you want to leave the island now? (y/n)");
                    String leave = input.nextLine();
                    if (leave.equalsIgnoreCase("y") || leave.equalsIgnoreCase("n")) {
                        if (leave.equalsIgnoreCase("n")) {
                            game(p1);
                        } else if (leave.equalsIgnoreCase("y")) {
                            System.out.println("Farewell Traveler...");
                            end();
                        }
                    } else {
                        System.out.println("Invalid input! Restarting the game");
                        game(p1);
                    }
                }
                break;
            default:
                System.out.println("Incorrect input pal! sorry :(");
                game(p1);

        }

    }

    public static void adventure(GameCharacter p1) {
        System.out.println("Your Health is: " + p1.getHealth());
        System.out.println("Your Money is: " + p1.getMoney());
        System.out.println("Which location would you like to choose?");
        System.out.println("1.Cave\n2.Forest\n3.River\n4.Return Safehouse");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {

            case 1:
                combat(new Cave(p1));
                break;

            case 2:
                combat(new Forest(p1));
                break;

            case 3:
                combat(new River(p1));
                break;

            case 4:
                game(p1);
                break;

            default:
                System.out.println("Incorrect input pal! sorry :(");
                adventure(p1);

        }
    }

    public static void combat(HostileLocation loc) {

        int random = (int) (Math.random() * 4);
        if (random == 0) {
            System.out.println("There are no remarkable enemies in the sight. You return after a quick walk in the " + loc.getName() + "...");
            adventure(loc.getChar());
        }
        System.out.println("There are " + random + " " + loc.getEnemy().getName() + "s in the " + loc.getName());
        System.out.println("Remaining health: " + loc.getChar().getHealth());
        System.out.println("Whatchu gonna do pal? \t R: run away! \t F: fight!");
        String choice = input.nextLine();
        if (choice.equalsIgnoreCase("r")) {
            System.out.println("You successfully ran away, coward :/");
            adventure(loc.getChar());
        }

        if (choice.equalsIgnoreCase("f")) {
            Enemy[] enemies = new Enemy[random];
            for (int i = 0; i < enemies.length; i++) {
                enemies[i] = loc.getEnemy();
            }
            int round = 1;

            while (enemies.length != 0) {

                System.out.println("--------------------ROUND " + round + "!!!  --------------------");
                for (int i = 1; i <= enemies.length; i++) {

                    enemies[i - 1].setHealth(enemies[i - 1].getHealth() - loc.getChar().getDamage());
                    System.out.println(enemies[i - 1].getName() + " got " + loc.getChar().getDamage() + " damage!");
                    if (enemies[i - 1].getHealth() <= 0) {
                        System.out.println("You killed a " + enemies[i - 1].getName() + " !");
                        Enemy temp = enemies[enemies.length - 1];
                        enemies[enemies.length - 1] = enemies[i - 1];
                        enemies[i - 1] = temp;
                        enemies = Arrays.copyOf(enemies, enemies.length - 1);
                        System.out.println("There are " + enemies.length + " " + loc.getEnemy().getName() + "s remaining");
                        if (i == 1) {
                            i--;
                        }
                    }
                }

                if (enemies.length == 0) {
                    System.out.println("Congrats my friend! You are victorious!!!");
                    loc.getChar().addMoney(random * loc.getEnemy().getCoin());
                    double luck = Math.random() * 100;
                    if (luck <= loc.getLuck()) {
                        if (!loc.getChar().getQuestItems(loc.getQuestItemPlace())) {
                            System.out.println("You have acquired the " + loc.getQuestItem() + " !");
                            loc.getChar().gotQuestItem(loc.getQuestItemPlace());
                        }
                    }
                    System.out.println("----------------------------------------------------");
                    break;
                }

                for (int i = 1; i <= enemies.length; i++) {
                    loc.getChar().setHealth(loc.getChar().getHealth() - loc.getEnemy().getDamage());
                    System.out.println("You got " + loc.getEnemy().getDamage() + " damage from the " + loc.getEnemy().getName() + " !");
                    System.out.println("Remaining Health: " + loc.getChar().getHealth());
                    if (loc.getChar().getHealth() <= 0) {
                        System.out.println("YOU ARE DİE!!!!!!!!!!!");
                        System.out.println("Game Over!");
                        System.out.println("Try again my friend. I believe in you :)");
                        end();
                    }

                }
                round++;
            }
        }

        adventure(loc.getChar());

    }


    public static void end() {
        System.exit(0);
    }


}
