package com.lahey;

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
        initReplacementHash();
         initPrependHash();
    }

    private void initReplacementHash(){
        String sFirstWord = "";
        String sSecondWord = "";

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        /********************************************************
         * Get replacement pairs from file and load into hashmap
         */
        try {

            Scanner scan  = new Scanner(wordFile);

            while (scan.hasNextLine()) {

                sFirstWord = scan.next().toLowerCase();
                sSecondWord = scan.next().toLowerCase();
                scan.nextLine();

                replaceWordMap.put(sFirstWord, sSecondWord);
            }
            scan.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }//end try catch

        Set set2 = replaceWordMap.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry) iterator2.next();
            System.out.print("Key is: " + mentry2.getKey() + " & Value is: ");
            System.out.println(mentry2.getValue());
        }

    }//end private void initReplacementHash()


    private void initPrependHash() {

        System.out.println("Init prepend hash");

    }//end private void initPrependHash()

//    public  String prependReply(String sReply) {
//
//            StringBuffer strBuff = new StringBuffer();
//
//        //find appropriate prepend and concat
//
//        return strBuff.toString();
//
//    }//end private void initPrependHash()

    public String processResponse(String str) {
        ArrayList<String> wordList = new ArrayList<String>();

        StringBuffer strBuff = new StringBuffer();

        for (String word : str.split(" ")) {

            wordList.add(word);
        }

        for (String word : wordList) {

            if( replaceWordMap.containsKey(word))
            {
                word = replaceWordMap.get(word);
            }
            strBuff.append(word);
            strBuff.append(" ");
        }

        //prepend the buffer

        prependBuffer(strBuff);


        strBuff.append("\b.\n");
        char chTemp = Character.toUpperCase(strBuff.charAt(0));
        strBuff.setCharAt(0,chTemp);

        return strBuff.toString();
    }//end public String processRespnse(String str)

    private void prependBuffer(StringBuffer buff){

        String prependString = "You feel that ";

        buff.insert(0 , prependString);

    }

}//end public class Eliza
