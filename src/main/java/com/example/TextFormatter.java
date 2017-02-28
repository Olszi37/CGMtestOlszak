package com.example;

import java.util.List;

/**
 * Created by MOlszi on 2017-02-28.
 */
public interface TextFormatter {

    public void showText(String text);

    public List<String> getSplittedInHalfText(String text);

    public String getPieceOfText(String text, int limit, int cursorPosition);
}
