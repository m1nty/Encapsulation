
****************************************************************
MyDate Class
****************************************************************
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java;

/**
 *
 * @author m1nty
 */
//this intializes the mydate class with two different constructors which run depending on the parameters are given
public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(){//if no parameterse given then this constructor runs
        this.year = 1990;
        this.month = 1;
        this.day = 1;
    }
    public MyDate(int theYear, int theMonth, int theDay){//this calls the set function and uses the returned values as assignments
        set(theYear, theMonth, theDay);
        
        this.year = theYear;
        this.month = theMonth;
        this.day = theDay;
    }
    public boolean set(int theYear,int theMonth, int theDay)//this set function uses a series of logic operands to evalulate conditions
    {
        if((theYear>=0)&((theMonth>=1)&(theMonth<=12))&((theDay>=1)&(theDay<=31))){//checks to see if the month and year and day are valid as described
            if((theMonth==1)|(theMonth==3)|(theMonth==5)|(theMonth==7)|(theMonth==8)|(theMonth==10)|(theMonth==12)){//checks the months with 31 days
            this.year=theYear;//assigns following if they do have 31 days
            this.month = theMonth;
            this.day = theDay;
            return true;
            
        }
        if((theMonth==4)|(theMonth==6)|(theMonth==11)|(theMonth==9)){//checks to see if month is a month that has 30 days
        if(theDay>30){
            this.year=1990;//if its these months and its greater than 30 days then default assigned
            this.month=1;
            this.day=1;
            return false;
            }
        this.year = theYear;//if 30 then continues with assignments
        this.month = theMonth;
        this.day = theDay;
        return true;
           
        }
        if(theMonth==2){//checks leap year month of february
            if(theYear%4==0){//cehcks if year is mulitple of 4
                if(theDay>29){//checks if days is greater than 29, if it is then default assigned cause thats not possible.
                    this.year = 1990;
                    this.month = 1;
                    this.day = 1;
                    return false;
                
                
                }
                else{//if not greater than 29 days then it continues assignment
                    this.year = theYear;
                    this.month = theMonth;
                    this.day = theDay; 
                    return true;}
            }
            if(theYear%4!=0){//if the years not a multiple of 4 and it has greater than 28 days it gets default assignment
                if(theDay>28){
                    this.year = 1990;
                    this.month = 1;
                    this.day =1;
                    return false;
            
                }// if not then it continues with assignment.
            this.year = theYear;
            this.month = theMonth;
            this.day = theDay;
            return true;
               
            }
        
        }
    }//if all above conditions false then default assigned
        this.year=1990;
        this.month=1;
        this.day=1;
        return false;
        
      
}//the foloiwng 3 methods are getters for the year month and day respectivley
    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public MyDate copy(){//this method duplicates the date which can be used for assignment or copying
        MyDate duplicate = new MyDate(year,month,day);
        return duplicate;
        
    }
   
    public String toString(){//this puts the values in string form with proper form as specified.
        return (month + "/" + day + "/" + year);
        
    }

}
****************************************************************
Employee Class
****************************************************************

public class Employee
{
    private MyDate dateOfHiring;//intializes fields
    private String firstName;
    private String lastName;

public Employee(int y, int m, int d, String fName, String lName){
    set(y,m,d,fName,lName);//calls set method 
}

public void set(int y, int m, int d, String fName, String lName){
    this.firstName=fName;//assigns the objects fields to the given values as input
    this.lastName=lName;
    this.dateOfHiring=new MyDate(y,m,d);
}

public String getFirstName(){return new String(firstName);}//returns firstname
public String getLastName(){return new String(lastName);}//returns lastname
public MyDate getHireday(){return dateOfHiring.copy();}//returns the date of hiring

public boolean hiredTheSameYear(Employee select){//checks to see if the select employee is hired the same year as the current object
    if(select.dateOfHiring.getYear()==this.dateOfHiring.getYear()){
        return true;
   
    }
    return false;
}


public boolean isOlderThan(Employee select){
//checks to see if current object is older than Employee select
//a set of logical operands are used to specify if employee is older by going through the year first month and then the day, and if all are equal then their same age
    if(select.dateOfHiring.getYear()>this.dateOfHiring.getYear()){//if slect year greater return true
        return true;
    }
    if(select.dateOfHiring.getYear()<this.dateOfHiring.getYear()){//if select year less t return false
        return false;
    }
    else{//if select year equal to this year continue
        if(select.dateOfHiring.getMonth()>this.dateOfHiring.getMonth()){//if select month greater return true
            return true;
        }
        if(select.dateOfHiring.getMonth()<this.dateOfHiring.getMonth()){//if  select month less return false
            return false;
        }
        else{//if select month equal to this month continue
            if(select.dateOfHiring.getDay()>this.dateOfHiring.getDay()){//if select day greater return true
                return true;
                }
            if(select.dateOfHiring.getDay()<=this.dateOfHiring.getDay()){//if select day less return false
                return false;
            } 
        }
    }
    return false;//if everything equal return false since there same age 
}


public static int[] hiredInMonth(Employee[] manyE, int theMonth){
    int count=0;
    for(int i=0;i<manyE.length;i++){//for loop goes through array and see how many times the month given occurs and stores this number in count variable
        if(manyE[i].dateOfHiring.getMonth()==theMonth){
            count+=1;
        }
    }   
    int months[];//array created to hold the positions of the specified month occurance within object
    months= new int[count];//must be size of the number of occurances of the given month
    int counter=0;
    for(int i=0;i<manyE.length;i++){//this for loop stores the index value of the similar month from the previous array as its elements. 
        if(manyE[i].dateOfHiring.getMonth()==theMonth){
            months[counter]=i;
            counter++;//counter incremented everytime if the condition is true 
            }
    }
    return months;//returns array which contains the positions
    }
    
    public String toString(){//prints out information about the employee
    return ("Employee name is " + firstName + " " + lastName + ". Their date of hire is : " + dateOfHiring.toString());
    }
}

****************************************************************
Test Class
****************************************************************

    public static void main(String[] args) {
        //Testing MyDate CLASS
        //creating MyDate objects to test
        MyDate d1 = new MyDate(1999, 2, 30);//for testing for leap year on non multiple of 4 year
        MyDate d2 = new MyDate(1998, 2, 29);//for testing for leap year on multiple of 4 year
        MyDate d3 = new MyDate();//for testing no parameter constructor
        //tests to see if value getters work
        System.out.println(d1.getYear());
        System.out.println(d1.getMonth());
        System.out.println(d1.getDay());
        //test to see if to string printing works
        System.out.println(d1.toString());
        System.out.println(d3.toString());
        //tests setter and also if not allowed input is assigned to default
        d1.set(1994,13,3);
        System.out.println(d1.toString());
        //testing copy function
        d1.set(1945 , 11, 11);
        d3 = d1.copy();
        System.out.println(d3.toString());
        
        //Testing Employee ClASS
        //creating employee objects to test
        Employee e1 = new Employee(1986,01,27,"Bobby","Brown");
        Employee e2 = new Employee(1800,5,7,"Joe","Fresh");
        
        //testing getters
        System.out.println(e1.getLastName());
        System.out.println(e1.getHireday());
        //testing toString method
        System.out.println(e2.toString());
        //testing setter method
        e1.set(1200,2,31, "Who","This");
        System.out.println(e1.toString());
        //testing if employees hired the same year, false and true cases.
        System.out.println(e1.hiredTheSameYear(e2));
        e2.set(1200,3,20, "bobby","shmurda");
        System.out.println(e1.hiredTheSameYear(e2));
        //testing hiredinmonth method
        Employee e3 = new Employee(1820,7,17,"Bird","theword");
        Employee e4 = new Employee(1890,5,4,"Min","ty");
        Employee e5 = new Employee(1870,5,6,"Bird","theword");
        Employee e6 = new Employee(1560,5,5,"Min","ty");
        Employee rand[] = {e3,e4,e5,e6};
        int x[];
        x = Employee.hiredInMonth(rand,5);
        //should print 3 because there are 3 objects with same month.
        System.out.println(x.length);
        //goes through for loop and prints index of where the same month occurs in array.
        for(int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }
        
        
    
    }
    
}
