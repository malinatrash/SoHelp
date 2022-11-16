package malinatrash;
import java.util.Scanner;

public class Menu {
    private static Strings strings;
    private static Array array;

    public static void start() {
        mainMenu();
    }

    private static int readChoice() {
        Scanner in = new Scanner(System.in);
        int readed;
        try {
            readed = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Ошибка! Допустим только ввод значений пунктов меню");
            readed = readChoice();
        }
        return readed;
    }

    private static void inputArrayMenu() {
        int choice;
        do {
            System.out.println("Меню ввода матрицы");
            System.out.println("1 - Заполнить случайными элементами");
            System.out.println("2 - Ввести в ручную");
            System.out.println("0 - Выход\n");

            choice = readChoice();

            switch(choice) {
                case 1:
                    array = new Array();
                    break;
                case 2:
                    System.out.print("Введите размерность матрицы: ");
                    array = new Array(readChoice());
                    array.fill();
                    break;
                case 0:
                    break;
                default: System.out.println("Такой комадны не существует!");
            }
        } while (choice != 0);
    }

    private static void showMatrixMenu() {
        int choice = -1;
        do {
            try {
                System.out.println("\nМеню работы с матрицей");
                System.out.println("1 - Создать новую матрицу");
                System.out.println("2 - Вывести матрицу");
                System.out.println("3 - Сохранить матрицу в файл");
                System.out.println("4 - Прочитать матрицу из файла");
                System.out.println("5 - Вывести результат работы программы");
                System.out.println("0 - Выход\n");

                choice = readChoice();

                switch (choice) {
                    case 1:
                        inputArrayMenu();
                        break;
                    case 2:
                        array.printMatrix();
                        break;
                    case 3:
                        StorageManager.shared.arrayToFile(array.getArray(), "data.bin");

                        break;
                    case 4:
                        int[][] readedArray = StorageManager.shared.arrayFromFile("data.bin");
                        array = new Array(readedArray);
                        break;
                    case 5:
                        System.out.println("Самый встречающийся элемент матрицы - " + array.doTask());
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Такой комадны не существует!");
                }
            } catch (NullPointerException e) {
                System.out.println("\nСначала необходимо заполнить массив!\n");
            }

        }while (choice != 0);
    }

    private static void mainMenu() {
        int choice;
        do {
            System.out.println("\nГлавное меню");
            System.out.println("1 - Задача на работу с матрицей");
            System.out.println("2 - Задача на работу со строкми");
            System.out.println("0 - Выход\n");

            choice = readChoice();

            switch(choice) {
                case 1: showMatrixMenu();
                case 2: showSentenceMenu();
                case 0:
                    System.out.println("Штатный выход из программы...");
                    break;
                default: System.out.println("Такой комадны не существует!");
            }
        } while (choice != 0);
    }

    private static void showSentenceMenu() {
        Scanner in = new Scanner(System.in);
        int choice = -1;
        do {
            try {


                System.out.println("\nМеню работы со строками");
                System.out.println("1 - Создать новую строку");
                System.out.println("2 - Вывести строку");
                System.out.println("3 - Сохранить строку в файл");
                System.out.println("4 - Прочитать строку из файла");
                System.out.println("5 - Выполнить задание 2");
                System.out.println("6 - Выполнить задание 3");
                System.out.println("7 - Выполнить задание 4");
                System.out.println("0 - Выход\n");

                choice = readChoice();

                switch (choice) {
                    case 1:
                        inputSentenceMenu();
                        break;
                    case 2:
                        System.out.println("Полученная строка: " + strings.getSentence());
                        break;
                    case 3:
                        StorageManager.shared.sentenceToTextFile(strings.getSentence(), "data.txt");
                        break;
                    case 4:
                        String readedSentence = StorageManager.shared.sentenceFromTextFile("data.txt");
                        strings = new Strings(readedSentence);
                        break;
                    case 5:
                        System.out.println("Результат выполения задания 2: " + strings.doSecondTask());
                        break;
                    case 6:
                        System.out.println("Результат выполения задания 3: " + strings.doThirdTask());
                        break;
                    case 7:
                        System.out.print("Введите необходимое количество символов в слове: ");
                        int minLen = readChoice();
                        System.out.println("Результат выполения задания 4: " + strings.doFourthTask(minLen));
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Такой комадны не существует!");
                }
            } catch (NullPointerException e) {
                System.out.println("\nСначала введите строку!\n");
            }
        } while (choice != 0);
    }

    private static void inputSentenceMenu() {
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Меню ввода  строки\n");
            System.out.println("1 - Заполнить случайными символами");
            System.out.println("2 - Ввести в ручную");
            System.out.println("0 - Выход\n");

            choice = readChoice();

            switch(choice) {
                case 1:
                    strings = new Strings();
                    break;
                case 2:
                    System.out.print("Введите строку: ");
                    strings = new Strings(in.nextLine());
                    break;
                case 0:
                    break;
                default: System.out.println("Такой комадны не существует!");
            }
        } while (choice != 0);
    }
}

