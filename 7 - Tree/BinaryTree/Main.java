package com.proglang;

import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    BinaryTree tree = new BinaryTree();


		Queue<Integer> dataQueue;
		boolean quit=false, isInvert=false;
		int data, action;

		displayOption();
		while (!quit) {
			System.out.print("Enter option: ");
			action = scanner.nextInt();
			switch (action) {
				case 0:
					displayOption();
					break;

				case 1:
					System.out.print("Enter Data: ");
					data = scanner.nextInt();
					if (isInvert) {
						tree.insertInvert(data);
					} else {
						tree.insert(data);
					}
					break;

				case 2:
					System.out.print("Enter Data: ");
					data = scanner.nextInt();
					if (isInvert) {
						tree.deleteInvert(data);
					} else {
						tree.delete(data);
					}
					tree.showLevelOrder();
					break;

				case 3:
					tree.invert();
					isInvert = (isInvert) ? false : true;
					break;

				case 4:
					tree.showInOrder();
					break;

				case 5:
					tree.showPreOrder();
					break;

				case 6:
					tree.showPostOrder();
					break;

				case 7:
					tree.showLevelOrder();
					break;

				case 8:
					if (isInvert) {
						dataQueue = tree.sortDesc();
					} else {
						dataQueue = tree.sortAsc();
					}
					System.out.println(dataQueue);
					dataQueue.clear();
					break;

				case 9:
					if (isInvert) {
						dataQueue = tree.sortAsc();
					} else {
						dataQueue = tree.sortDesc();
					}
					System.out.println(dataQueue);
					dataQueue.clear();
					break;

				case 10:
					System.out.print("InOrder: ");
					tree.showInOrder();
					System.out.print("preOrder: ");
					tree.showPreOrder();
					System.out.print("postOrder: ");
					tree.showPostOrder();
					System.out.print("levelOrder: ");
					tree.showLevelOrder();
					break;

				case 11:
					System.out.print("search Data: ");
					int[] searchData = tree.search(scanner.nextInt());
					if (searchData[0]==-1) {
						System.out.println("Data is not exist in tree.");
					} else if (searchData[0]==0) {
						System.out.println("Root Node: " + searchData[1]);
					} else {
						System.out.println("Parent of search element: " + searchData[1]);
					}
					break;

				default:
					quit = true;
					break;
			}
		}
		scanner.close();
	}

	public static void displayOption() {
		String[] options = {"Display Options", "insert", "delete", "invertTree", "inOrder", "preOrder", "postOrder", "levelOrder", "Ascending", "Descending", "show All order", "search", "exit"};
		for (int i=0; i<options.length; i++) {
			System.out.println(i + " " + options[i]);
		}
	}
}