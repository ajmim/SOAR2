package coursewebsite.models;

import coursewebsite.Database.Database;

import java.util.ArrayList;

public class User{
    
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    protected double balance;
    protected ArrayList<Course> userCourses;
    protected ArrayList<Transaction> userTransactions;

    public User(String username, String firstName, String lastName, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = Integer.toString(password.hashCode());
        this.balance = 0;
        this.userCourses = new ArrayList<>();
        this.userTransactions = new ArrayList<>();

    }


    public String getUsername() {
        return username;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public double getBalance(){return balance;}
    public ArrayList<Course> getUserCourses() {
        return this.userCourses;
    }

    public void addUserCourse(Course course) { this.userCourses.add(course); }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = Integer.toString(password.hashCode());
    }
    public void setBalance(double balance) {this.balance = balance;}
    public void addBalance(double amount) { this.balance += amount; }

    public boolean isPasswordCorrect(String password) {
        return Integer.toString(password.hashCode()).equals(this.password);
    }
    public ArrayList<Transaction> getTransactions() {
        return this.userTransactions;
    }
    public void addTransaction(Transaction transaction){this.userTransactions.add(transaction);}

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) {
            return false;
        }
        User that = (User) o;
        return that.getUsername().equals(this.username);
    }

   @Override
    public String toString() {
        return "Username: " + this.username
                + "\nFirst name: " + this.firstName
                + "\nLast name: " + this.lastName
                + "\nEmail: " + this.email
                + "\nBalance: " + this.balance 
                + "\n" + this.userCourses.toString();
    }

    
}