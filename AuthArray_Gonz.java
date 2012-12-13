/*
* Brandon Gonzalez
* Login Athorization using arrays :D
*/

import java.util.Scanner;

/**
* Main class taht checks the login thingy
*/
public class AuthArray_Gonz
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String user, pass;
        int PASSCOUNT = 0;
        int USERCOUNT = 0;
        boolean found = false;

        User[] testUsers = new User[4];
        
        testUsers[0] = new User("cow", "swag");
        testUsers[1] = new User("bg451", "password");
        testUsers[2] = new User("Monty", "Bell19!");
        testUsers[3] = new User("Blindy", "f0013g01d");
        
        while(USERCOUNT < 3 && !found)
        {

            System.out.printf("\nPlease enter your username: ");
            user = input.nextLine();
            
            for(int i = 0; i < testUsers.length; ++i) //Runs through each object in the array to find the name
            {
                if(testUsers[i].authLogin(user)) // Checks to see if the name exists;
                { 
                    found = true;
                    while(PASSCOUNT < 3) //Allows for 3 password attempts
                    {
                        System.out.println("Enter your password: ");
                        pass = input.nextLine();
                        if(testUsers[i].authPassword(pass))
                        {
                            System.out.println("WELCOME " + testUsers[i].getName());
                            break;
                        } else {
                            System.out.println("That password is incorrect!");
                            PASSCOUNT++;
                        }
                    }
                }
            }
            
            if(!found)
            {
                System.out.println("Your username was not found");
                USERCOUNT++;
            }
        }
    }
}
/**
* User class
* Constructor needs 2 parameters
* Usage: User(Username, Password)
*/
class User
{
    private String username;
    private String password;
    
    public User(String name, String pass) 
    {
        username = name;
        password = pass;
    }

    public User()
    {
        username = "";
        password = "";
    }

    public void setName()
    {
        Scanner input = new Scanner(System.in);

        System.out.printf("Please enter your desired username: ");
        username = input.nextLine();
    }

    public void setPass()
    {
        
        Scanner input = new Scanner(System.in);

        System.out.printf("\nPlease enter your desired password");
        password = input.nextLine();      
    }

    public String getName()
    {
        return username;
    }

    public boolean authLogin(String user)
    {
        if (user.equals(username))
            return true;
        else
            return false;
    }

    public boolean authPassword(String pass)
    {
        if(pass.equals(password)) 
        
            return true;
        else
            return false;
    }
}
