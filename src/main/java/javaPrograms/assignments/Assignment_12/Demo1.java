package javaPrograms.assignments.Assignment_12;

public class Demo1 {
    public static void main(String[] args) {
        int x[][] = new int[4][];
        x[0] = new int[1];
        x[1] = new int[2];
        x[2] = new int[3];
        x[3] = new int[4];
        int a,b,c=0;
        for(a=0;a<4;a++){
            for(b=0;b<a+1;b++){
                x[a][b]=c;
                c++;
            }
        }

        for(a=0;a<4;a++){
            for(b=0;b<a+1;b++){
                System.out.println(" "+x[a][b]);
                c++;
            }
            System.out.println();
        }
    }
}
