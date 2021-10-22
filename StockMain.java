import java.util.*;
import java.io.*;

class Stock
{
    String productName;
    String productCode;
    int price;
    int numberOfItems;

    void getProductDetails()
    { 
        int total = price*numberOfItems;
        System.out.println("Product:"+productName+"\n"+"Code:"+productCode+"\n"+"Price:"+price+"Rs"+"\n"+"Number:"+numberOfItems+"\n"+"Total:"+total+"Rs"+"\n");
    }
    void beforeExit()throws IOException
    {
        File file=new File("C:\\oop_programs\\oop_project\\meds.txt");
        FileWriter fr2=new FileWriter(file,true);   
        int total=price*numberOfItems;
        fr2.write("Name : "+productName+"\n");
        fr2.write("Code : "+productCode+"\n");
        fr2.write("Number of Items : "+numberOfItems+"\n");
        fr2.write("Price : "+price+"Rs\n");
        fr2.write("Total : "+total+"Rs\n ");
        fr2.write("********************************************\n");
        fr2.flush();
        fr2.close();
    }
    void beforeExit2()throws IOException
    {
        File file2=new File("C:\\oop_programs\\oop_project\\surg.txt");
        FileWriter fr3=new FileWriter(file2,true);   
        int total = price*numberOfItems;
        fr3.write("Name : "+productName+"\n");
        fr3.write("Code : "+productCode+"\n");
        fr3.write("Number of Items : "+numberOfItems+"\n");
        fr3.write("Price : "+price+"Rs\n");
        fr3.write("Total : "+total+"Rs\n");
        fr3.write("********************************************\n");
        fr3.flush();
        fr3.close();
    }
    Stock(String productName,String productCode, int price, int numberOfItems)  
    {
        this.productName= productName;
        this.productCode=productCode;
        this.price = price;
        this.numberOfItems = numberOfItems;
    }
}

class StockMain
{
    public static void main(String args[])throws IOException
    {
        ArrayList<Stock> medicine = new ArrayList<Stock>();
        ArrayList<Stock> surgical = new ArrayList<Stock>();
        Stock m = new Stock("Cold Kit-3 Plus  10x1","CK",36,29);
        Stock m1 = new Stock("Azithral 500 mg  5x1","Az-500",93,38);
        Stock m2 = new Stock("Cetrizine 10mg 10x1","Ce-10",17,56);
        Stock m3 = new Stock("Oflox 200 mg  10x1","Of-200",55,20);
        Stock m4 = new Stock("Amlodac 5 mg  30x1","Am-5",65,27);
        Stock m5 = new Stock("Progynova 2 mg  28x1","Pr-2",360,15);

        medicine.add(m);
        medicine.add(m1);
        medicine.add(m2);
        medicine.add(m3);
        medicine.add(m4);
        medicine.add(m5);

        Stock s = new Stock("Accu-Chek Instant S Blood Glucose Meter with 10 test strips","AC",846,19);
        Stock s1 = new Stock("One Touch Glucometer Verio Flex with 10 strips","OT",1400,13);
        Stock s2 = new Stock("Flamingo Lumbar Sacro Belt","FL",560,7);
        Stock s3 = new Stock("Dr Morepen Digital Thermometer","DT",120,17);

        surgical.add(s);
        surgical.add(s1);
        surgical.add(s2);
        surgical.add(s3);

        Administrator adm = new Administrator();
        Scanner sc = new Scanner(System.in);
        String userName;
        String pass;
        int ch;
        boolean suc = false;
        boolean bo=true;
        boolean boo=false;
        int j=6;
        int q=4;
        int k,i,a,a2;
        System.out.println("\n1 for Admin Login\n2 for user Login\n");
        ch = sc.nextInt();
        sc.nextLine();
        switch(ch)
        {
            case 1:
            {
                while(!suc)
                {
                    System.out.println("Enter username: ");
                    userName = sc.nextLine();
                    System.out.println("Enter password: ");
                    pass = sc.nextLine();
                    
                    suc = adm.adminLogin(userName, pass);
                    if(suc == true)
                    {
                        System.out.println("Successfully Logged in!!");
                        suc = true;
                    }
                    else
                    {
                        System.out.println("Enter vaild Credentials!!!");
                    }
                }
                break;
            } 

            case 2: 
            {   
                while(!suc)
                {
                    System.out.println("Enter username: ");
                    userName = sc.nextLine();
                    System.out.println("Enter password: ");
                    pass = sc.nextLine();
                    User u = new User();
                    suc = u.userLogin(userName, pass);
                    if(suc == true)
                    {
                        System.out.println("Successfully Logged in!!");
                        suc = true;
                    }
                    else
                    {
                        System.out.println("Enter vaild Credentials!!!");
                    }
                }
                break;
            }
            default:
            {
                System.out.println("Enter valid option!!!");
                break;                
            }
        }
            Scanner scan = new Scanner(System.in);
            while(bo)
            {
                System.out.println("Enter M-Medicine and S-Surgical");
                String a1=scan.next();
                switch(a1)
                {
                    case "M":case "m":
                    System.out.println("\n1-Add New Medicine Stock \n2-Add to Existing Medicine Stock \n3-Remove from existing Medicine stock \n4-View Medical stock \n5-Print file and exit\n");
                    a2=scan.nextInt();
                    switch(a2)
                    {
                        case 1:
                        System.out.println("Enter name and code");
                        String med1=scan.next();
                        String code1=scan.next(); 
                        int pri1,quantity1;
                        boolean success = false;
                        while (!success) 
                        {
                            try 
                            {
                                System.out.print("Enter price and quantity: ");
                                pri1 = scan.nextInt();
                                   //System.out.print("Enter quantity: ");
                                quantity1 = scan.nextInt();
                                Stock med=new Stock(med1,code1,pri1,quantity1);
                                medicine.add(j,med);
                                ++j;
                                  // System.out.println("You entered " + num);
                                success = true;
                            } catch (InputMismatchException e) 
                            {
                             scan.next();
                             System.out.println("You have entered invalid data. Enter some details again");
                        }
                    }
                    break;
                    case 2:
                    System.out.println("Enter code and quantity added");
                    String code2=scan.next();
                    int quantity2=scan.nextInt();
                    boolean success5=true;
                    for(k=0; k<j; k++)
                    {
                        if(medicine.get(k).productCode.equals(code2))
                        {
                            a=medicine.get(k).numberOfItems+quantity2;
                            medicine.get(k).numberOfItems=a;
                            success5=false;
                        }
                    }
                    if(success5)
                    {
                        System.out.println("Product Code not found");
                    }
                    break;
                    case 3:
                    System.out.println("Enter code and quantity sold");
                    String code3=scan.next();
                    int quantity3=scan.nextInt();
                    boolean success3=true;

                    for(k=0; k<j; k++)
                    {
                        if(medicine.get(k).productCode.equals(code3))
                        {
                            if(medicine.get(k).numberOfItems<quantity3)
                            {
                                System.out.println("Stock underflow");
                            }
                            else
                            {
                                medicine.get(k).numberOfItems=medicine.get(k).numberOfItems-quantity3;
                            }
                            success3 = false;
                            break;
                        }
                    }
                    if(success3) 
                    {

                        System.out.println("Product Code not found");
                    }
                    break;
                    case 4:
                    for(k=0;k<j;k++)
                    {    
                        medicine.get(k).getProductDetails();
                    }
                    break;
                    case 5:
                    for(k=0;k<j;k++)
                    {    
                        medicine.get(k).beforeExit();
                    }
                    File file=new File("C:\\oop_programs\\oop_project\\meds.txt");
                    FileReader fr=new FileReader(file);  
                    int z;    
                    while((z=fr.read())!=-1)    
                        System.out.print((char)z);
                    fr.close();
                    bo=false;
                    return;
                    default:
                    System.out.println("Enter valid input");
                }
                break;
                case "S":case "s":
                System.out.println("\n1-Add New Surgical Stock \n2-Add to Existing Surgical Stock \n3-Remove from Existing Surgical Stock \n4-View surgical stock \n5-Print file and exit\n");
                a2=scan.nextInt();
                switch(a2)
                {
                    case 1:
                    System.out.println("Enter name and code");
                    String sur4=scan.next();
                    String code4=scan.next();
                    boolean success1=false;
                    int pri4,quantity4;
                    while(!success1)
                    {
                        try
                        {
                            System.out.println("Enter price and quantity: ");
                            pri4=scan.nextInt();
    //System.out.println("Enter quantity");
                            quantity4=scan.nextInt();
                            Stock sug = new Stock(sur4,code4,pri4,quantity4);
                            surgical.add(q,sug);
                            ++q;
                            success1=true;
                        }
                        catch(InputMismatchException e)
                        {
                            scan.next();
                            System.out.println("You have entered invalid data. Enter some details again");
                        }
                    }
                    break;
                    case 2:
                    System.out.println("Enter code and quantity added");
                    String code5=scan.next();
                    int quantity5=scan.nextInt();
                    boolean success6=true;
                    for(k=0; k<q; k++)
                    {
                        if(surgical.get(k).productCode.equals(code5))
                        {
                            surgical.get(k).numberOfItems=surgical.get(k).numberOfItems+quantity5;
                            success6=false;
    //System.out.println("Product Code not found");
                        }
    //System.out.println("Product Code not found");
                    }
                    if(success6)
                    {
                        System.out.println("Product Code not found");
                    }
                    break;
                    case 3:
                    System.out.println("Enter code and quantity sold");
                    String code6=scan.next();
                    int quantity6=scan.nextInt();
                    boolean success4=true;
                    for(k=0; k<q; k++)
                    {
                        if(surgical.get(k).productCode.equals(code6))
                        {
                            if(quantity6<=surgical.get(k).numberOfItems)
                                surgical.get(k).numberOfItems=surgical.get(k).numberOfItems-quantity6;
                            else
                            {
                                System.out.println("Stock Underflow");
                                success4=false;
                            }
                        }
                    }
                    if(success4)
                    {
                        System.out.println("Product Code not found");
                    }
                    break;
                    case 4:
                    for(k=0;k<q;k++)
                    {
                        surgical.get(k).getProductDetails();
                    }
                    break;
                    case 5:
                    for(k=0;k<q;k++)
                    {    
                        surgical.get(k).beforeExit2();
                    }
                    File file2=new File("C:\\oop_programs\\oop_project\\surg.txt");
                    FileReader fr4=new FileReader(file2);  
                    int z;    
                    while((z=fr4.read())!=-1)    
                        System.out.print((char)z);
                    fr4.close();
                    bo=false;
                    return;
                    default:    
                    System.out.println("Enter valid input");
                }
                break;
                default:
                System.out.println("Enter valid input");
            }
        }
    }
}