import java.util.Scanner;

public class while_loop {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String n="suraj";
        while (true){
            System.out.println("enter string ");
        String a=sc.nextLine();
            switch (a){
                case "suraj":
                    System.out.println("suraj printed");
                    if(n.equals("suraj")){
                        System.out.println("break in if");
                        System.exit(1);
                    }
                    break;
                case "aghav":
                    System.out.println("aghav printed");
                    break;
                case "abc":
                    System.out.println("abc");
                    break;
                default:
                    System.out.println("default");
                    break;
            }

        }
    }
}
