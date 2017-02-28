package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MOlszi on 2017-02-28.
 */
public class TextFormatterImpl implements TextFormatter {
    public void showText(String text) {
        List<String> texts = getSplittedInHalfText(text);

        int cursorPosition1 = 0;
        int cursorPosition2 = 0;

        while(cursorPosition1 < texts.get(0).length() || cursorPosition2 < texts.get(1).length()) {

            String chunk1 = getPieceOfText(texts.get(0), 45, cursorPosition1);
            String chunk2 = getPieceOfText(texts.get(1), 45, cursorPosition2);

            cursorPosition1 += chunk1.length();
            cursorPosition2 += chunk2.length();

            System.out.printf("%-50.45s %-50.45s%n", chunk1, chunk2);
        }
    }

    public List<String> getSplittedInHalfText(String text) {

        List<String> halfs = new ArrayList<String>();

        int pointToCut = text.length() / 2;

        while(text.charAt(pointToCut) != ' ')
            pointToCut--;

        halfs.add(text.substring(0, pointToCut + 1));
        halfs.add(text.substring(pointToCut + 1, text.length()));

        return halfs;
    }

    public String getPieceOfText(String text, int limit, int cursorPosition) {

        int pointToCut = cursorPosition + limit;

        if(pointToCut >= text.length()){
            return text.substring(cursorPosition);
        }
        else{
            while(text.charAt(pointToCut) != ' '){
                pointToCut--;
            }
            return text.substring(cursorPosition, pointToCut + 1);
        }
    }
}
