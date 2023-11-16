package test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleApplication {

    private Dictionary dict1;
    private Dictionary dict2;

    public ConsoleApplication(Dictionary dict1, Dictionary dict2){
        this.dict1 = dict1;
        this.dict2 = dict2;
    }

    public void run() throws IOException {
        Scanner in = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Choose dict 1 or 2. For exit press 0");
                int numberDict = in.nextInt();
                boolean change = true;
                while (change) {
                    switch (numberDict) {
                        case 1 -> {
                            System.out.println("Enter a filename: ");
                            String filename = in.next();
                            File file = new File(filename);
                            try {
                                boolean created = file.createNewFile();
                                if (created) {
                                    System.out.println("completed.");
                                } else {
                                    System.out.println("already.");
                                }
                            } catch (IOException e) {
                                System.out.println("error: " + e.getMessage());
                            }
                            dict1.setFilePath(filename);
                            while (change) {
                                System.out.println("Choose an action: ");
                                System.out.println("1) Print the dictionary to the console");
                                System.out.println("2) Delete an entry by key");
                                System.out.println("3) Find a record by key");
                                System.out.println("4) Add entry");
                                System.out.println("0) Exit");

                                int option1 = in.nextInt();
                                switch (option1) {
                                    case 1 -> dict1.printDictionary();
                                    case 2 -> {
                                        System.out.println("Enter the key");
                                        String removeKey = in.next();
                                        dict1.removeItem(removeKey);
                                    }
                                    case 3 -> {
                                        System.out.println("Who your nado?");
                                        String answer = in.next();
                                        dict1.searchItem(answer);
                                    }
                                    case 4 -> {
                                        System.out.println("Enter the key");
                                        String key = in.next();
                                        System.out.println("Enter the value");
                                        String value = in.next();
                                        dict1.addItem(key, value);
                                    }
                                    case 0 -> {
                                        System.out.println("Completion");
                                        change = false;
                                    }
                                    default -> System.out.println("Choose correct number");
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("Enter a filename: ");
                            String filename1 = in.next();
                            File file1 = new File(filename1);
                            try {
                                boolean created = file1.createNewFile();
                                if (created) {
                                    System.out.println("completed.");
                                } else {
                                    System.out.println("already.");
                                }
                            } catch (IOException e) {
                                System.out.println("error: " + e.getMessage());
                            }
                            dict2.setFilePath(filename1);
                            while (change) {
                                System.out.println("Choose an action: ");
                                System.out.println("1) Print the dictionary to the console");
                                System.out.println("2) Delete an entry by key");
                                System.out.println("3) Find a record by key");
                                System.out.println("4) Add entry");
                                System.out.println("0) Exit");

                                int option2 = in.nextInt();
                                switch (option2) {
                                    case 1 -> dict2.printDictionary();
                                    case 2 -> {
                                        System.out.println("Enter the key");
                                        String removeKey = in.next();
                                        dict2.removeItem(removeKey);
                                    }
                                    case 3 -> {
                                        System.out.println("Who your nado?");
                                        String answer = in.next();
                                        dict2.searchItem(answer);
                                    }
                                    case 4 -> {
                                        System.out.println("Enter the key");
                                        String key = in.next();
                                        System.out.println("Enter the value");
                                        String value = in.next();
                                        dict2.addItem(key, value);
                                    }
                                    case 0 -> {
                                        System.out.println("Completion");
                                        change = false;
                                    }
                                    default -> System.out.println("Choose correct number");
                                }
                            }
                        }
                        case 0 -> {
                            return;

                        }
                        default -> {

                            System.out.println("Choose correct number");
                            change = false;
                        }
                    }
                }
            }
        }catch (Exception ex){System.out.println("Error");}
    }

}
