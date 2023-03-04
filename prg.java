import java.util.*;
public class prg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n = sc.nextInt();
        int at[] = new int[n];
        int bt[] = new int[n];
        int p[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the AT of p:"+(i+1));
            at[i] = sc.nextInt();
            System.out.println("Enter the BT of p:"+(i+1));
            bt[i] = sc.nextInt();
            p[i] = i;
        }
        int temp, temp1, temp2;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (at[j - 1] >= at[j]) {
                    if (at[j - 1] == at[j]) {
                        if (bt[j - 1] > bt[j]) {
                            temp = at[j - 1];
                            at[j - 1] = at[j];
                            at[j] = temp;
                            temp2 = bt[j - 1];
                            bt[j - 1] = bt[j];
                            bt[j] = temp2;
                            temp1 = p[j - 1];
                            p[j - 1] = p[j];
                            p[j] = temp1;
                            break;
                        }
                    } else {
                        temp = at[j - 1];
                        at[j - 1] = at[j];
                        at[j] = temp;
                        temp2 = bt[j - 1];
                        bt[j - 1] = bt[j];
                        bt[j] = temp2;
                        temp1 = p[j - 1];
                        p[j - 1] = p[j];
                        p[j] = temp1;
                    }
                }
            }
        }
        System.out.println("P:"+(p[0]+1)+" is running");
        int num = bt[0]+at[0];int t=0;
        double min, max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (at[j] > num) {
                    j = j - 1;
                    for (int a = i; a <= j - 1; a++) {
                        double s = num - at[a];
                        min = 1 + (s / bt[a]);
                        for (int b = a + 1; b <= j; b++) {
                            s = num - at[b];
                            max = 1 + (s / bt[b]);
                            if (max > min) {
                                temp = at[a];
                                at[a] = at[b];
                                at[b] = temp;
                                temp2 = bt[a];
                                bt[a] = bt[b];
                                bt[b] = temp2;
                                temp1 = p[a];
                                p[a] = p[b];
                                p[b] = temp1;
                            }
                        }
                    }
                    for(int v=i;v<n;v++) {
                        if (v <= j) {
                            double pp1 = num - at[v];
                            double pp = 1 + (pp1) / bt[v];
                            System.out.println("Priority of P" + (p[v]+1) + ":" + pp);
                        } else {
                            System.out.println("Priority of P" + (p[v]+1) + ":0");
                        }
                    }
                    System.out.println("P:"+(p[i]+1)+" is running");
                    num = num + bt[i];
                    t=j+1;
                    break;
                }
                if (j == n - 1) {
                    for (int a = i; a <= j - 1; a++) {
                        double s = num - at[a];
                        min = 1 + (s / bt[a]);
                        for (int b = a + 1; b <= j; b++) {
                            s = num - at[b];
                            max = 1 + (s / bt[b]);
                            if (max > min) {
                                temp = at[a];
                                at[a] = at[b];
                                at[b] = temp;
                                temp2 = bt[a];
                                bt[a] = bt[b];
                                bt[b] = temp2;
                                temp1 = p[a];
                                p[a] = p[b];
                                p[b] = temp1;
                            }
                        }
                    }
                    for(int v=i;v<n;v++) {
                            double pp1 = num - at[v];
                            double pp = 1 + (pp1) / bt[v];
                            System.out.println("Priority of P" + (p[v]+1) + ":" + pp);
                    }
                    System.out.println("P:"+(p[i]+1)+" is running");
                    num=num+bt[i];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(p[i] + 1 + "  ");
        }
        System.out.println();
        int d=0;int start=at[0];
        for (int i = 0; i < n; i++) {
            if(i==0){
            System.out.println("Waiting time of P:"+(p[i]+1)+" is 0");
            d=start+bt[0];
            }
            else
            {
                System.out.println("Waiting time of P:"+(p[i]+1)+" is :"+(d-at[i]));
                d=d+bt[i];
            }
        }
        double sum=d;
        double avg=sum/n;
        System.out.println("Average waiting time ="+avg);
    }
}