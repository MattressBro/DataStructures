package Final;

import java.util.LinkedList;
import java.util.Scanner;

public class portfolioProject {
    static class Person {
        String firstName;
        String lastName;
        int age;

        Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName + ", Age: " + age;
        }
    }

    static class PersonQueue {
        private LinkedList<Person> queue;

        PersonQueue() {
            queue = new LinkedList<>();
        }

        void addPerson(Person person) {
            queue.add(person);
        }

        void displayQueue() {
            for (Person person : queue) {
                System.out.println(person);
            }
        }

        void quickSortByLastName() {
            quickSort(0, queue.size() - 1, (p1, p2) -> p2.lastName.compareTo(p1.lastName));
        }

        void quickSortByAge() {
            quickSort(0, queue.size() - 1, (p1, p2) -> Integer.compare(p2.age, p1.age));
        }

        private void quickSort(int low, int high, java.util.Comparator<Person> comparator) {
            if (low < high) {
                int pi = partition(low, high, comparator);
                quickSort(low, pi - 1, comparator);
                quickSort(pi + 1, high, comparator);
            }
        }

        private int partition(int low, int high, java.util.Comparator<Person> comparator) {
            Person pivot = queue.get(high);
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (comparator.compare(queue.get(j), pivot) > 0) {
                    i++;
                    Person temp = queue.get(i);
                    queue.set(i, queue.get(j));
                    queue.set(j, temp);
                }
            }
            Person temp = queue.get(i + 1);
            queue.set(i + 1, queue.get(high));
            queue.set(high, temp);
            return i + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonQueue personQueue = new PersonQueue();

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // consume newline
            personQueue.addPerson(new Person(firstName, lastName, age));
            System.out.println("");
        }

        System.out.println("Queue contents:");
        personQueue.displayQueue();

        System.out.println("\nQueue sorted by last name (descending):");
        personQueue.quickSortByLastName();
        personQueue.displayQueue();

        System.out.println("\nQueue sorted by age (descending):");
        personQueue.quickSortByAge();
        personQueue.displayQueue();
    }
}
