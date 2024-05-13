import java.util.Random;
import java.util.Scanner;
public class BlackJack{
    public static void main(String[] args){

        Random num=new Random();                //used to generate random card values
        Scanner option=new Scanner(System.in);  //used to scan user input as he chooses whether to hit or stay
        String continueChoice="";
        do{
            int firstCard=num.nextInt(10)+2;        
            int secondCard=num.nextInt(10)+2;  
            int dealerFirstCard=num.nextInt(10)+2;  
            int dealerSecondCard=num.nextInt(10)+2; 
            int sums=twoCardsAdd(firstCard,secondCard);   //assigning sums to the value that twoCardsAdd returns (This is to get the user's total after he receives his  2 cards)
            int dealerSums=twoCardsAdd(dealerFirstCard,dealerSecondCard);//assigning dealerSums to the value that twoCardsAdd returns(This is to get the dealer's total after he receives his  2 cards)
            int already=0;
            if(continueChoice.equalsIgnoreCase("")){
                System.out.println("##  Welcome to Eustace's BlackJack Game   ##");
            }
            System.out.println("\nYou get a "+firstCard+" and "+secondCard);//showing card values to user
            System.out.println("Your total is: "+sums+"\n");
            System.out.println("The dealer has a "+dealerFirstCard+" showing,and a hidden card.");
            System.out.println("Dealer total is unknown. \n");
            System.out.print("Would you like to \"hit\" or \"stay\"?");
            String myOption=option.nextLine();
            if(myOption.equalsIgnoreCase("hit")){

                int drawCard=num.nextInt(10)+2;
                int newSums=threeCardsAdd(firstCard,secondCard,drawCard);//assigning newSums to the value of threeCardsAdd method(The threeCardsAdd method returns the sum of all 3 cards of the user)
                int total=newSums;//this is to store newSums temporarily as total,so that we are able to use the value in the if statements
                System.out.println("You drew a "+drawCard);
                System.out.println("Your new total is :"+newSums);
                if(total>21){
                    System.out.println("\nThe dealer's hidden card was: "+dealerSecondCard);
                    System.out.println("The dealer's total was: "+dealerSums);
                    System.out.println("Your total is: "+newSums);
                    System.out.println("\nYou LOST!");
                }
                else if(total==21){
                    System.out.println("\nThe dealer's hidden card was: "+dealerSecondCard);
                    System.out.println("The dealer's total was: "+dealerSums);
                    System.out.println("Your total is: "+newSums);
                    System.out.println("\nYou WINN!");
                }
                else{
                    String[] dealerOptions2=new String[2];
                    //Assigning "hit" and "stay" to the dealerOptions2 array
                    dealerOptions2[0]="hit";
                    dealerOptions2[1]="stay";

                    //Getting a random number between 0 and 1 which will be used to choose the dealer choice
                    int probability=num.nextInt(2);
                
                    //assigning the dealer choice to a random option in the dealerOptions2 array
                    String dealerChooses=dealerOptions2[probability];

                    int dealerDrawCard=num.nextInt(10)+2;//the dealer draws a third card at random
                    int dealerNewSums=threeCardsAdd(dealerFirstCard,dealerSecondCard,dealerDrawCard);
                    int check=dealerNewSums;

                    System.out.println("\nOkay the dealer's turn.");
                    System.out.println("His hidden card was: "+dealerSecondCard);
                    System.out.println("His total was: "+dealerSums);
                    if(dealerChooses.equals("hit")){
                        System.out.println("\nDealer chooses to "+dealerChooses);
                        System.out.println("He draws a "+dealerDrawCard);
                        System.out.println("His new total is: "+dealerNewSums);
                        if(check>16){
                            System.out.println("\nDealer stays.\n");
                            System.out.println("Dealer total is: "+dealerNewSums);
                            System.out.println("Your total is: "+newSums);
                            System.out.println("\nYou WINN!");

                        }
                        else if(check==16){
                            System.out.println("\nDealer total is: "+dealerNewSums);
                            System.out.println("Your total is: "+newSums);
                            System.out.println("\nYou LOST!");
                        }
                    }
                    else{
                        System.out.println("\nDealer chooses to "+dealerChooses);
                        System.out.print("Do you want to go next round(yes or no): ");
                        continueChoice=option.nextLine();
                        already=1;
                    }

                    }
            }
            else{
                    System.out.print("Do you want to go next round(yes or no): ");
                    continueChoice=option.nextLine();
                    already=1;
            }
            if(already!=1){
                System.out.print("\nDo you want to go next round(yes or no): ");
                continueChoice=option.nextLine();
            }
        

        }while(continueChoice.equalsIgnoreCase("yes"));
        System.out.print("Good game!");
        option.close();
    }
    public static int twoCardsAdd(int num1,int num2){
        return num1+num2;
    }
    public static int threeCardsAdd(int num1,int num2,int num3){
        return num1+num2+num3;
    }
}
