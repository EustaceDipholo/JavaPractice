//Build a simple task management application with features like adding,editing,and deleting tasks.Focus on user interaction and data persistance

//Create an ArrayList of type String to store the user tasks,
//If user is using for the first time,then only and add option should be shown.Otherwise options like editing and deleting tasks should be shown
import java.util.Scanner;
import java.util.ArrayList;
public class TodoListApplication{
    public static void main(String[] args){
        ArrayList<String> tasks=new ArrayList<String>();
        Scanner user=new Scanner(System.in);
        System.out.println("\n#####Todo List Application#####\n");
        System.out.print("Would like to add tasks to do during your day: ");
        String userChoice=user.nextLine();
        if(userChoice.equalsIgnoreCase("yes")){
            Scanner scanTask=new Scanner(System.in);
            System.out.println("Adding tasks.\nEnter the tasks:");
            System.out.print("task: ");
            String task=scanTask.nextLine();
            tasks.add(task);
            System.out.println("####Adding Successful####");
            System.out.print("\nWould you like to(view/add/edit/delete) tasks in your todo list: ");
            String choice=user.nextLine();
            while(choice.equalsIgnoreCase("view") || choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("delete") || choice.equalsIgnoreCase("edit")){
                if(choice.equalsIgnoreCase("view")){
                    choice=viewTasks(tasks,choice,user);
                }
                else if(choice.equalsIgnoreCase("add")){
                    choice=addTasks(tasks,choice,scanTask,user);
                }
                else if(choice.equalsIgnoreCase("delete")){
                    System.out.println("Deleting tasks.\nEnter the task to delete from todo list:");
                    System.out.print("task: ");
                    task=scanTask.nextLine();
                    tasks.remove(task);
                    System.out.println("####Delete Successful####");
                    System.out.print("\nWould you like to(view/add/edit/delete) tasks in your todo list: ");
                    choice=user.nextLine();
                }
                else{
                    System.out.println("Editing tasks.\nEnter the task to edit below.");
                    System.out.print("task: ");
                    task=scanTask.nextLine();
                    System.out.println("Enter the edited task below");
                    System.out.print("task: ");
                    String task2=scanTask.nextLine();
                    tasks.set(tasks.indexOf(task),task2);
                    System.out.println("####Editing Successful####");
                    System.out.print("\nWould you like to(view/add/edit/delete) tasks in your todo list: ");
                    choice=user.nextLine();
                }
            }
        }
        

        
    }
    static String viewTasks(ArrayList<String> myArray,String choice,Scanner user){
        System.out.println(myArray);
        System.out.print("Would you like to(add/edit/delete) tasks in your todo list: ");
        choice=user.nextLine();
        return choice;
    }
    static String addTasks(ArrayList<String> myArray,String choice,Scanner scanTask,Scanner user){
        System.out.println("Adding tasks.\nEnter the tasks:");
        System.out.print("task: ");
        String task=scanTask.nextLine();
        myArray.add(task);
        System.out.println("####Adding Successful####");
        System.out.print("\nWould you like to(view/add/edit/delete) tasks in your todo list: ");
        choice=user.nextLine();
        return choice;
    }
}