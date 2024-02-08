import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.event.ListDataEvent;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> mylist = new ArrayList<>();
        mylist.add((int) (Math.random() * 9 + 1));
        for(int i = 0; i < mylist.size(); i++) {
            System.out.printf("mylist %2d : %3d\n", i, mylist.get(i));
        }

        System.out.print("Geben sie eine Zahl zwischen 1 und 9 an: ");
        Scanner sc = new Scanner(System.in);
        int searchFor = sc.nextInt();
        int countToSearch = 0;
        ArrayList<Integer> indices = new ArrayList<>();
        
        for(int i = 0; i < mylist.size(); i++) {
            if(mylist.get(i) == searchFor) {
                countToSearch++;
                indices.add(i);
            }
        }

        System.out.printf("Die Zahl %2d kommt %3d mal in der liste vor.", searchFor, countToSearch);
        indices.forEach(x -> System.out.print(String.format("%d, ", x)));

        mylist.remove(searchFor);

        for(int i = 0; i < mylist.size(); i++) {
            if(mylist.get(i) == 5) mylist.add(i, 0);
        }
        mylist.forEach(x -> System.out.print(String.format("%d, ", x)));
    }
}
