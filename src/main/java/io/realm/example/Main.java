package io.realm.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;



public class Main {

    public static void main(String args[]) throws IOException {
        AuthorManager authorManager = new AuthorManager();
        AuthorsREPL repl = new AuthorsREPL(authorManager);
        repl.start();
        authorManager.getRealm().close();
        System.exit(0);
    }
}
