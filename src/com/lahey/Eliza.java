package com.lahey;
/**
 * @author jack lahey
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Eliza {

    private static final HashMap<String, String> prependMap = new HashMap<String, String>();
    private static final File prependFile = new File("ResponsePrependFile.txt");
    private static final HashMap<String, String> replaceWordMap = new HashMap<String, String>();
    private static final File wordFile = new File("WordReplacementsFile.txt");


    public Eliza()
    {
        initReplacementMap();
        initPrependMap();
    }

    private void initReplacementMap(){
        String sKey = "";
        String sValue = "";

        //display for testing
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));

       try {

            Scanner scan  = new Scanner(wordFile);

            while (scan.hasNextLine()) {

                sKey = scan.next().toLowerCase();
                sValue = scan.next().toLowerCase();
                scan.nextLine();

                replaceWordMap.put(sKey, sValue);
            }
            scan.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }//end try catch

        //display for testing
//     Set set1 = replaceWordMap.entrySet();
//     Iterator iterator1 = set1.iterator();
//     while(iterator1.hasNext()) {
//         Map.Entry mentry1 = (Map.Entry) iterator1.next();
//         System.out.print("Key is: " + mentry1.getKey() + " & Value is: ");
//         System.out.println(mentry1.getValue());
//        }//end while(iterator1.hasNext())
//        System.out.println("\n");
//
    }//end private void initReplacementMap()


    private void initPrependMap() {
        String sKey = "";
        String sValue = "";

        try {

            Scanner scan  = new Scanner(prependFile);

            while (scan.hasNextLine()) {

                sKey = scan.next().toLowerCase();
                sValue = scan.nextLine().substring(1); //.toLowerCase();

                prependMap.put(sKey, sValue);
            }
            scan.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }//end try catch

        //display for testing
//        Set set1 = prependMap.entrySet();
//        Iterator iterator1 = set1.iterator();
//        while(iterator1.hasNext()) {
//            Map.Entry mentry1 = (Map.Entry) iterator1.next();
//            System.out.print("Key is: " + mentry1.getKey() + " & Value is: ");
//            System.out.println(mentry1.getValue());
//        }//end while(iterator1.hasNext())
//        System.out.println("\n");

    }//end private void initPrependMap()


    public String processResponse(String str) {
        ArrayList<String> wordList = new ArrayList<String>();

        StringBuffer strBuff = new StringBuffer();

        for (String word : str.split(" ")) {

            wordList.add(word.toLowerCase());
        }

        //find replacement words from replacment word file
        for (String word : wordList) {

            if( replaceWordMap.containsKey(word))
            {
                word = replaceWordMap.get(word);
                if(word.equalsIgnoreCase("I")){
                    word = word.toUpperCase();
                }
            }
            strBuff.append(word);
            strBuff.append(" ");
        }//end for (String word : wordList)


        String prependString = "I understand. You feel that";


        //find prepend from map
        for (String word : wordList) {

            if( prependMap.containsKey(word)) {
                prependString = prependMap.get(word);
            }

        }//end for (String word : wordList)

        strBuff.insert(0 , prependString + " ");

        strBuff.append("\b.\n");
        char chTemp = Character.toUpperCase(strBuff.charAt(0));
        strBuff.setCharAt(0,chTemp);

        return strBuff.toString();

    }//end public String processRespnse(String str)

}//end public class Eliza
