package com.lahey;
import java.util.Scanner;

/**
 * @author Jack Lahey
 *
 * Assignment
 * You will be creating an interactive chat-bot type program.
 * Eliza is a therapist program that interacts with the user.
 * Your program will need to evaluate what the user asks
 * and turn the user's input into a question that sounds like
 * the therapist really cares.
 *
 * Eliza In Class Simple
 * Our first task is to develop a program with a running loop.
 * If the user types in "I am feeling great" or enter "Q",
 * the program will stop running. Your program should print out
 * the last input (as an output) every time before accepting new
 * input. Make sure you are accommodating for NO case-sensitivity.
 * (Q is the same as q)
 *
 * Eliza In Class Intermediate
 * You will continue creating an interactive chat-bot type program. Eliza is a therapist program
 * that interacts with the user. Your program will need to evaluate what the user asks and turn
 * the user's input into a question that sounds like the therapist really cares.
 *
 * Use HashMaps or String arrays to loop through user's input and implement the following:
 *
 * Replacements:
 *
 * replace i with you
 * replace me with you
 * replace my with your
 * replace am with are
 *
 * We will continue to build on top of this application throughout the week.
 *
 * Here's how the replacement works:
 *
 * The user enters something at the prompt: "my teacher hates me"
 *
 * The program will loop through that string and replace "my" with "your" and "me" with "you"
 * and then prepend the qualifier to the replacement string. So, my teacher hates me becomes
 * "Why do you say that your teacher hates you?" The replacement method returns the same words a
 * s the user entered only the replacement words have been swapped. Then the qualifier is prepended
 * to the user's words.
 *
 * Spend some time thinking how you would search through a string and replacing specific words.
 * Hint: read about the split  (Links to an external site.)Links to an external site.operator.
 *
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        String sInputString = "";
        String sQuitString = "I am feeling great";
        String sQuitQ   = "Q";

        Eliza eliza = new Eliza();

        System.out.print("Good day. What is your problem? ");
        do{
            System.out.print("Enter your response here or Q to quit: ");
            sInputString = scanInput.nextLine();

            System.out.println(eliza.processResponse(sInputString));

        }while( !(sInputString.equalsIgnoreCase(sQuitString)) && !(sInputString.equalsIgnoreCase(sQuitQ)));

    }//end public static void main(String[] args)

}//end public class Main
