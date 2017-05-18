package Project2;

import java.io.IOException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is the name of the file you would like to use?");
		String fileName = keyboard.nextLine();

		FileWriter fw = new FileWriter(fileName);

		Stacks undo = new Stacks();
		Stacks redo = new Stacks();

		int command;
		do {
			command = getCommandOption(keyboard);

			switch (command) {
			case 0:
				fw.printToFile(fileName);
				keyboard.close();
				break;
			case 1:
				keyboard.nextLine();
				System.out.println("What would you like to add?");
				String newLine = keyboard.nextLine();
				fw.addLine(newLine);
				undo.push("<" + newLine);
				break;
			case 2:
				String toDelete = fw.get(fw.size - 1);
				fw.remove();
				fw.removeNthLine(fileName, fw.size - 1);
				undo.push(">" + toDelete);
				break;
			case 3:
				// undo
				if (!undo.isEmpty()) {
					String toUndo = undo.pop();
					if (toUndo.indexOf('<') == 0) {
						toUndo = toUndo.replaceFirst("<", "");
						System.out.println(toUndo);
						fw.remove();
						fw.removeNthLine(toUndo, fw.size - 1);
						redo.push(">" + toUndo);
					} else {
						toUndo = toUndo.replaceFirst(">", "");
						System.out.println(toUndo);
						fw.addLine(toUndo);
						redo.push("<" + toUndo);
					}
				} else {
					System.out.println("There is nothing to undo");
				}
				break;
			case 4:
				if (!redo.isEmpty()) {
					String toRedo = redo.pop();
					if (toRedo.indexOf('<') == 0) {
						toRedo = toRedo.replaceFirst("<", "");
						System.out.println(toRedo);
						fw.remove();
						fw.removeNthLine(toRedo, fw.size - 1);
						undo.push(">" + toRedo);
					} else if (redo.isEmpty()) {
						System.out.println("There's nothing to undo.");
					} else {
						toRedo = toRedo.replaceFirst(">", "");
						System.out.println(toRedo);
						fw.addLine(toRedo);
						undo.push("<" + toRedo);
					}
				} else {
					System.out.println("There is nothing to redo.");
				}
				break;
			case 5:
				fw.print();
				break;
			default:
				break;
			}
		} while (command != 0);
		keyboard.close();

	}

	private static int getCommandOption(Scanner keyboard) {
		int command;
		System.out.println("1) Add Line");
		System.out.println("2) Delete Line");
		System.out.println("3) Undo");
		System.out.println("4) Redo");
		System.out.println("5) Print");
		System.out.println("0) Save and exit");
		command = keyboard.nextInt();
		return command;
	}
}