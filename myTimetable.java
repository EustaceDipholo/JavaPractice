import java.util.Random;
import java.util.Scanner;
public class myTimetable {
    public static void main(String[] args){
        String[] modules=new String[10];
        String[] firstDayWork=new String[4];
        String[] secondDayWork=new String[4];
        String[] thirdDayWork=new String[4];
        String[] fourthDayWork=new String[4];
        String[][] pastWork={firstDayWork,secondDayWork,thirdDayWork};
        Random random=new Random();
        int x;
        int y=-1;
        int z=-1;
        int p=-1;
        int first;
        int second;
        int third;
        int fourth;
        int thisFourth;
        int thisThird;
        modules[0]="Machine Learning";
        modules[1]="c++";
        modules[2]="Calculus";
        modules[3]="React";
        modules[4]="JavaScript";
        modules[5]="HTML_CSS";
        modules[6]="Python";
        modules[7]="Java";
        modules[8]="Linear Algebra";
        modules[9]="Node js";
        
        x=random.nextInt(10);
        do{
            y=random.nextInt(10);
        }while(y==x);
        do{
            z=random.nextInt(10);
        }while(z==x || z==y);
        do{
            p=random.nextInt(10);
        }while(p==x || p==y || p==z);
        firstDayWork[0]=modules[x];
        firstDayWork[1]=modules[y];
        firstDayWork[2]=modules[z];
        firstDayWork[3]=modules[p];
        System.out.println("Today you will be doing "+firstDayWork[0]+","+firstDayWork[1]+","+firstDayWork[2]+","+firstDayWork[3]);
        first=random.nextInt(4);
        do{
            second=random.nextInt(4);

        }while(second==first);
        secondDayWork[0]=firstDayWork[first];
        secondDayWork[1]=firstDayWork[second];
        do{
            third=random.nextInt(10);
        }while(third==x || third==y || third==z || third==p);
        secondDayWork[2]=modules[third];
        do{
            fourth=random.nextInt(10);

        }while(fourth==x || fourth==y || fourth==z || fourth==p || fourth==third);
        secondDayWork[3]=modules[fourth];
        System.out.println("Second day's work you will be doing "+secondDayWork[0]+","+secondDayWork[1]+","+secondDayWork[2]+","+secondDayWork[3]);
        first=random.nextInt(2);
        do{
            second=random.nextInt(4);

        }while(second<2 || second>3);
        thirdDayWork[0]=secondDayWork[first];
        thirdDayWork[1]=secondDayWork[second];
        do{
            thisThird=random.nextInt(10);
        }while(thisThird==x || thisThird==y || thisThird==z || thisThird==p || thisThird==third || thisThird==fourth);
        thirdDayWork[2]=modules[thisThird];
        do{
            thisFourth=random.nextInt(10);
        }while((thisFourth==x || thisFourth==y || thisFourth==z || thisFourth==p || thisFourth==third || thisFourth==fourth) || thisFourth==thisThird);
        thirdDayWork[3]=modules[thisFourth];
        System.out.println("Third day's work you will be doing "+thirdDayWork[0]+","+thirdDayWork[1]+","+thirdDayWork[2]+","+thirdDayWork[3]);
        do{
            int randomDay=random.nextInt(3);
            int finalFirst=random.nextInt(4);
            int finalSecond=random.nextInt(4);
            int finalThird=-1;
            int finalFourth=-1;
            fourthDayWork[0]=pastWork[randomDay][finalFirst];
            fourthDayWork[1]=pastWork[randomDay][finalSecond];
            for(int i=0;i<10;i++){
                if(!(i==x || i==y || i==z || i==p || i==third || i==fourth || i==thisThird || i==thisFourth)){
            
                    finalThird=i;
                }
            }
            for(int h=0;h<10;h++){
                if(!((h==x || h==y || h==z || h==p || h==third || h==fourth || h==thisThird || h==thisFourth || h==finalThird ) && finalThird!=-1)){
                    finalFourth=h;
                }
            }
            fourthDayWork[2]=modules[finalThird];
            fourthDayWork[3]=modules[finalFourth];
        }while(valid(fourthDayWork)==false);
        System.out.println("Fourth day's work you will be doing "+fourthDayWork[0]+","+fourthDayWork[1]+","+fourthDayWork[2]+","+fourthDayWork[3]);

    }
    public static boolean valid(String[] arr){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i!=j && arr[i]==arr[j]){
                    return false;
                }
            }
        }
        return true;
    }
    
}
