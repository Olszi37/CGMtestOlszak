package com.example;

import junit.framework.TestCase;

public class TextFormatterImplTest
    extends TestCase{

    public void testGetSplittedInHalfText(){
        String sentence = "Some sentence to split. This is long sentence. ";

        TextFormatter formatter = new TextFormatterImpl();

        assertEquals("Some sentence to split. ", formatter.getSplittedInHalfText(sentence).get(0));
        assertEquals("This is long sentence. ", formatter.getSplittedInHalfText(sentence).get(1));
    }

    public void testGetSplittedInHalfTextOtherScenario(){
        String sentence = "Some sentence to be splitted. This is long sentence. ";

        TextFormatterImpl formatter = new TextFormatterImpl();

        assertEquals("Some sentence to be ", formatter.getSplittedInHalfText(sentence).get(0));
        assertEquals("splitted. This is long sentence. ", formatter.getSplittedInHalfText(sentence).get(1));
    }

    public void testGetPieceOfText(){
        String sentence = "Some sentence to get trimmed. ";

        TextFormatter formatter = new TextFormatterImpl();
        assertEquals("Some sentence to get ", formatter.getPieceOfText(sentence, 20, 0));
    }

    public void testGetPieceOfTextShortSentence(){
        String sentence = "Some sentence.";

        TextFormatter formatter = new TextFormatterImpl();
        assertEquals("Some sentence.", formatter.getPieceOfText(sentence, 30, 0));
    }
}
