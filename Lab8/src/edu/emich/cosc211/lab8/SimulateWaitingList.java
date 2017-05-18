package edu.emich.cosc211.lab8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.emich.cosc211.util.GenericArrayList;
import edu.emich.cosc211.util.GenericLinkedList;
import edu.emich.cosc211.util.Queue;
import edu.emich.cosc211.util.Student;

public class SimulateWaitingList {
    static final String FILENAME = "students.txt";
    static final int MAX_CLASSROOM = 10;

    @SuppressWarnings("rawtypes")
	public static void main(String[] args) {
        final Queue<Student> waitingList = new LinkedQueue();
        final GenericArrayList<Student> classList = new GenericArrayList<>(MAX_CLASSROOM);

        try {
            loadStudentsToQueueFromFilename(waitingList, FILENAME);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }

        final Scanner keyboard = new Scanner(System.in);

        int command;
        do {

            System.out.println("1) Look at first in list");
            System.out.println("2) Add another to the waitlist");
            System.out.println("3) Add student to class from waitlist");
            System.out.println("4) Remove student from classroom");
            System.out.println("5) Add max possible students from waitlist to classroom");
            System.out.println("0) Exit");

            command = keyboard.nextInt();

            switch (command) {
                case 1:
                	System.out.println(((GenericLinkedList) waitingList).getHead());
                    break;
                case 2:
                	keyboard.nextLine();
                	System.out.println("Which is the name of the student?");
                	String name = keyboard.nextLine();
                	System.out.println("What is the students EID?");
                	String eid = keyboard.nextLine();
                	System.out.println("What is the students year?");
                	String year = keyboard.nextLine();
                	waitingList.offer(new Student(name, eid, year));
                    break;
                case 3:
                	Student waiting = waitingList.poll();
                	classList.add(waiting);
                    break;
                case 4:
                	System.out.println("What is the index of the student you want to remove?");
                	int index = keyboard.nextInt();
                	classList.remove(index);
                    break;
                case 5:
                	for(int i = classList.size(); i < MAX_CLASSROOM; i++){
                		Student waiting2 = waitingList.poll();
                		classList.add(waiting2);
                		classList.remove(waiting2);
                	}
                    break;
                case 0:
                    System.out.println("Goodbye");
                default :
                    break;
            }
        } while (command != 0);

        keyboard.close();
    }

    /**
     * @param waitingList
     * @param pathname
     * @throws FileNotFoundException
     */
    private static void loadStudentsToQueueFromFilename(final Queue<Student> waitingList, String pathname)
            throws FileNotFoundException {
        final Scanner fileIn = new Scanner(new FileInputStream(new File(pathname)));
        while (fileIn.hasNext()) {
            final String studentName = fileIn.next() + " " + fileIn.next();
            final String studentEid = fileIn.next();
            final String studentYear = fileIn.next();

            final Student additional = new Student(studentName, studentEid, studentYear);


        }
        fileIn.close();
    }
}
