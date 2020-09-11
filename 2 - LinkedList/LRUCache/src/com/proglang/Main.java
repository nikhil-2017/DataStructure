package com.proglang;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter maxSize of LRU cache : ");
        int maxSize = scanner.nextInt();
	    LRUCache lruCache = new LRUCache(maxSize);

	    boolean quit = false;
	    int action;
	    char key;

	    displayOption();
	    while (!quit) {
            System.out.print("Enter option : ");
            action = scanner.nextInt();
	        switch (action) {
                case 0:
                    displayOption();
                    break;

                case 1:
                    System.out.print("Enter key: ");
                    key = scanner.next().charAt(0);
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    lruCache.insertKeyValuePair(key, value);
                    break;

                case 2:
                    System.out.print("Enter key: ");
                    key = scanner.next().charAt(0);
                    System.out.println(key + " : " + lruCache.getValueFromKey(key));
                    break;

                case 3:
                    lruCache.displayCacheKeyValuePair();
                    break;

                case 4:
                    key = lruCache.getMostLeastRecent();
                    System.out.println("MostLeastRecent: " + key + " : " + lruCache.cache.get(key).value);
                    break;

                case 5:
                    key = lruCache.getLeastRecent();
                    System.out.println("LeastRecentUsed: " + key + " : " + lruCache.cache.get(key).value);
                    break;

                default:
                    quit = true;
                    break;

            }
        }
	    scanner.close();
    }

    public static void displayOption() {
        String[] options = {"display options", "put", "get", "display", "mostRecent", "leastRecent", "exit"};
        for (int i=0; i< options.length; i++) {
            System.out.println(i + ": " + options[i]);
        }
    }
}
