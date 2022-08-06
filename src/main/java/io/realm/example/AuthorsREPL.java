package io.realm.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class AuthorsREPL {
    public AuthorsREPL(AuthorManager authorManager) {
        this.authorManager = authorManager;
    }

    private AuthorManager authorManager;

    public void start() throws IOException {
        displayAuthors();
        System.out.println("Add a new author? (yes/no)\t: ");
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        String continueAdding = reader.readLine();

        while (continueAdding.toLowerCase().equals("yes")) {
            System.out.println("First Name\t: ");
            String firstName = reader.readLine();
            System.out.println("Last Name\t: ");
            String lastName = reader.readLine();
            System.out.println("Age\t: ");
            Integer age = Integer.parseInt(reader.readLine());

            addAuthor(firstName, lastName, age);
            displayAuthors();

            // continue yes/no
            System.out.println("Add a new author? (yes/no)");
            continueAdding = reader.readLine();
        }
    }

    private void addAuthor(String firstName, String lastName, Integer age) {
        authorManager.addAuthor(firstName, lastName, age);
    }
    private void displayAuthors() {
        System.out.println("First Name\tLast Name\tAge");
        Iterator authors = authorManager.findAuthors().iterator();
        while(authors.hasNext()) {
            Author a = (Author) authors.next();
            System.out.println(a.getFirstName() + "\t" + a.getLastName() + "\t" + a.getAge());
        }
    }
}
