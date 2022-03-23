import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    static int n,i;
    static String []PName=new String[1000000];
    static float []temperature=new float[1000000];
    static int []oxygen = new int[1000000];
    static int []age=new int[1000000];
    static int []ID=new int[1000000];

    //N1
    static int n1=0,remaining_patients;
    static String []Hospital_name=new String[10000];
    static String hospital;
    static float []Temperature_criteria=new float[10000];
    static int[]Oxygen_levels=new int[10000];
    static int[]beds=new int[10000];
    static int[]Recovery=new int[1000000];
    static String[]Patient_hospital=new String[1000000];

    public static void main(String [] args){
        System.out.println("Enter no. of Patients");
        n=s.nextInt();
        remaining_patients=n;
        System.out.println("Enter your Details in this order-Name Temperature Oxygen Age");
        for(i=0;i<n;i++) {
            PName[i]=s.next();
            temperature[i]=s.nextFloat();
            oxygen[i]=s.nextInt();
            age[i]=s.nextInt();
            ID[i]=i+1;
            Recovery[i]=-1;
        }
        int q;
       do{
        System.out.println("Enter your query no.");
            q=s.nextInt();
            switch(q){
            case 1: N1();
            break;
            case 2: N2();
            break;
            case 3:N3();
            break;
            case 4:N4();
            break;
            case 5:N5();
            break;
            case 6:N6();
            break;
            case 7:N7();
            break;
            case 8:N8();
            break;
            case 9:N9();
            break;
        } }while(q<10 && q>0);
    }

    public static void N1(){
        System.out.println("Name of Hospital");
        Hospital_name[n1]=s.next();
        System.out.println("Temperature criteria- ");
        Temperature_criteria[n1]=s.nextFloat();
        System.out.println("Oxygen levels- ");
        Oxygen_levels[n1]=s.nextInt();
        System.out.println("No.of Available Beds- ");
        beds[n1]=s.nextInt();

        if(beds[n1]>0 && remaining_patients>0) {
            System.out.println("Admission Status-OPEN");
            remaining_patients -= beds[n1];

            for (i = 0; i < n; i++)
                if (oxygen[i] >= Oxygen_levels[n1] && Recovery[i] == -1 && beds[n1] > 0) {
                    System.out.println("Recovery days for admitted patient ID " + ID[i]);
                    Recovery[i] = s.nextInt();
                    Patient_hospital[i] = Hospital_name[n1];
                    beds[n1]--;
                }

            for (i = 0; i < n; i++)
                if (temperature[i] <= Temperature_criteria[n1] && Recovery[i] == -1 && beds[n1] > 0) {
                    System.out.println("Recovery days for admitted patient ID " + ID[i]);
                    Recovery[i] = s.nextInt();
                    Patient_hospital[i] = Hospital_name[n1];
                    beds[n1]--;
                }
        }
        else
            System.out.println("Admission Status- CLOSED");

            n1+=1;
    }
    public static void N2(){
        System.out.println("Account ID removed of admitted patients");
        for(i=0;i<n;i++)
            if(Recovery[i]>=0){
                System.out.println(ID[i]);
                age[i]=-1;
            }


    }
    public static void N3(){
        System.out.println("Accounts removed of institute whose admission is closed");
        for(i=0;i<n1;i++)
            if(beds[i]<1)
                System.out.println(Hospital_name[i]);
        }
    public static void N4(){
        System.out.println(remaining_patients>-1?remaining_patients:0);
    }
    public static void N5(){
        int c=0;
        for(i=0;i<n1;i++)
            if(beds[i]>0)
                c++;
        System.out.println(c+" number of institutes admitting patients currently");
    }
    public static void N6(){
        hospital=s.next();
        for(i=0;i<n1;i++)
            if(Hospital_name[i].equalsIgnoreCase(hospital)){
                System.out.println(Hospital_name[i]);
                System.out.println("Temperature should be<="+Temperature_criteria[i]);
                System.out.println("Oxygen levels should be>="+Oxygen_levels[i]);
                System.out.println("Number of beds Available beds-"+(beds[i]>-1?beds[i]:0));
                System.out.println("Admission Status-"+(beds[i]>0?"OPEN":"CLOSED"));
            }}
    public static void N7(){
        System.out.println("ID number");
        int Id=s.nextInt()-1;
                System.out.println("Temperature is "+temperature[Id]+"\nOxygen levels is "+oxygen[Id]);
                if(Recovery[Id]!=-1) {
                    System.out.println(" Admission Status-Admitted");
                    System.out.println(" Admission Institute- " + Patient_hospital[Id]);
                }
                else
                    System.out.println("Admission Status-Not Admitted");
    }
    public static void N8(){
        for(i=0;i<n;i++)
            System.out.println(ID[i]+" "+PName[i]);
        }
    public static void N9()throws NullPointerException{
        hospital=s.next();
        for(i=0;i<n;i++)
        if(Patient_hospital[i].equalsIgnoreCase(hospital)) {
            System.out.println(PName[i] + ",recovery time is " + Recovery[i] + " days");
        }
    }
}

