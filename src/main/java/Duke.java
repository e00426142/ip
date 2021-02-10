import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

import java.util.ArrayList;
import java.util.Scanner;
public class Duke {
    private static final String line = "____________________________________________________________\n";

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);


        String greet = "____________________________________________________________\n" +
                " Hello! I'm Duke\n" +
                "____________________________________________________________";
        String exit = "Bye. Hope to see you again!\n" +
                "____________________________________________________________\n";
        System.out.println(logo);
        System.out.println(greet);
        System.out.print(" What can I do for you?\n");
        System.out.print(line);

        String input;
        Scanner userInput = new Scanner(System.in);
        input = userInput.nextLine();
        ArrayList<Task> tasks = new ArrayList<>();

        while (!input.equals("bye")) {

            if (input.contains("todo")) {
                int dividerPosition = input.indexOf(" ");
                String t = input.substring(dividerPosition + 1);
                if(dividerPosition==-1 || t.equals("") || !input.contains(" ")){
                    System.out.print(line);
                    System.out.print("I don't quite understand." +  "\n" + "Please enter the command again." + "\n");
                    System.out.print(line);
                } else {
                    tasks.add(new Todo(t));
                    System.out.print(line + "Got it. I've added this task:" + "\n" + new Todo(t) + "\n" + "Now you have " + tasks.size() + " tasks in the list." + "\n" + line );
                }

            } else if (input.contains("deadline")) {
                int dividerPosition = input.indexOf(" ");
                int dividerPosition_1 = input.indexOf("/");
                String d = input.substring(dividerPosition + 1, dividerPosition_1);
                String by = input.substring(dividerPosition_1 + 4);
                if(dividerPosition==-1 || d.equals("") || !input.contains(" ")){ 
                    System.out.print(line);
                    System.out.print("I don't quite understand." +  "\n" + "Please enter the command again." + "\n");
                    System.out.print(line);
                } else {
                    tasks.add(new Deadline(d, by));
                    System.out.print(line + "Got it. I've added this task:" + "\n" + new Deadline(d,by) + "\n" + "Now you have " + tasks.size() + " tasks in the list." + "\n" + line);
                }

            } else if (input.contains("event")) {
                int dividerPosition = input.indexOf(" ");
                int dividerPosition_1 = input.indexOf("/");
                String e = input.substring(dividerPosition + 1, dividerPosition_1);
                String at = input.substring(dividerPosition_1 + 4);
                if(dividerPosition==-1 || e.equals("") || !input.contains(" ")){
                    System.out.print(line);
                    System.out.print("I don't quite understand." +  "\n" + "Please enter the command again." + "\n");
                    System.out.print(line);
                } else {
                    tasks.add(new Event(e, at));
                    System.out.print(line + "Got it. I've added this task:" + "\n"  + new Event(e, at) + "\n" + "Now you have " + tasks.size() + " tasks in the list." + "\n" + line);
                }

            } else if (input.equals("list")) {
                if (tasks.size() == 0) {
                    System.out.print(line);
                    System.out.print("You have zero task at the moment." + "\n");
                    System.out.print(line);
                } else {

                    System.out.print(line);
                    System.out.print("Here are the tasks in your list: " + "\n");

                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.print(i + 1 + "." + tasks.get(i)+ "\n");
                    }
                    System.out.print(line);
                }

            } else if (input.contains("done")) {

                int dividerPosition = input.indexOf(" ");
                String taskNo = input.substring(dividerPosition + 1);
                try{
                    int taskIndex = Integer.parseInt(taskNo) - 1;
                    if (dividerPosition == -1 || taskNo.equals("") || !input.contains(" ")) {
                        System.out.print(line);
                        System.out.print("I don't quite understand." +  "\n" + "Please enter the command again." + "\n");
                        System.out.print(line);
                    }
                    if (taskIndex >=tasks.size()) {
                        System.out.print(line);
                        System.out.print("You have no such task." + "\n");
                        System.out.print(line);
                    }
                    else {
                        tasks.get(taskIndex).markAsDone();
                        System.out.print(line);
                        System.out.print("Nice! I've marked this task as done:" + "\n" + tasks.get(taskIndex) + "\n");
                        System.out.print(line);
                    }
                } catch (NumberFormatException e) {
                    System.out.print(line);
                    System.out.print("I don't quite understand." +  "\n" + "Please enter the command again." + "\n");
                    System.out.print(line);
                }
            } else {
                System.out.print(line);
                System.out.print("Sorry, I didnt get you." + "\n" + "Please enter the command again." + "\n");
                System.out.print(line);
            }
            input = userInput.nextLine();
        }
        System.out.println(exit);


    }
}
