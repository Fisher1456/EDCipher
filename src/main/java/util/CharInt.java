package util;

import algo.Cipher;

import java.util.HashMap;

public class CharInt {
    private HashMap<Character, Integer> charIntMap = new HashMap<>();
    private char letter;
    private int index;

    public CharInt(char letter) {
        this.letter = letter;
        this.index = toInt(letter);
    }

    public CharInt(int index) {
        if (index < 0 || index > 25) {
            throw new IllegalArgumentException("index value incorrect: " + index);
        }

        this.letter = toChar(index);
        this.index = index;
    }

    public char getLetter() {
        return letter;
    }

    public int getIndex() {
        if (index < 0 || index > 25) {
            throw new IllegalArgumentException("index value incorrect: " + index);
        }

        return index;
    }

    public void shiftBy(int shift) {
        index += shift;
        index = WrapAround.wrap(index);
        letter = toChar(index);
    }

    public void shiftTo(char letter) {
        this.letter = letter;
        index = toInt(letter);
    }

    private static int toInt(char c) {
        return switch (c) {
            case 'A' -> 0;
            case 'a' -> 100;
            case 'B' -> 1;
            case 'b' -> 101;
            case 'C' -> 2;
            case 'c' -> 102;
            case 'D' -> 3;
            case 'd' -> 103;
            case 'E' -> 4;
            case 'e' -> 104;
            case 'F' -> 5;
            case 'f' -> 105;
            case 'G' -> 6;
            case 'g' -> 106;
            case 'H' -> 7;
            case 'h' -> 107;
            case 'I' -> 8;
            case 'i' -> 108;
            case 'J' -> 9;
            case 'j' -> 109;
            case 'K' -> 10;
            case 'k' -> 110;
            case 'L' -> 11;
            case 'l' -> 111;
            case 'M' -> 12;
            case 'm' -> 112;
            case 'N' -> 13;
            case 'n' -> 113;
            case 'O' -> 14;
            case 'o' -> 114;
            case 'P' -> 15;
            case 'p' -> 115;
            case 'Q' -> 16;
            case 'q' -> 116;
            case 'R' -> 17;
            case 'r' -> 117;
            case 'S' -> 18;
            case 's' -> 118;
            case 'T' -> 19;
            case 't' -> 119;
            case 'U' -> 20;
            case 'u' -> 120;
            case 'V' -> 21;
            case 'v' -> 121;
            case 'W' -> 22;
            case 'w' -> 122;
            case 'X' -> 23;
            case 'x' -> 123;
            case 'Y' -> 24;
            case 'y' -> 124;
            case 'Z' -> 25;
            case 'z' -> 125;
            case '0' -> 200;
            case '1' -> 201;
            case '2' -> 202;
            case '3' -> 203;
            case '4' -> 204;
            case '5' -> 205;
            case '6' -> 206;
            case '7' -> 207;
            case '8' -> 208;
            case '9' -> 209;
            default -> -1;
        };
    }

    private static char toChar(int i) {
        return switch (i) {
            case 0 -> 'A';
            case 1 -> 'B';
            case 2 -> 'C';
            case 3 -> 'D';
            case 4 -> 'E';
            case 5 -> 'F';
            case 6 -> 'G';
            case 7 -> 'H';
            case 8 -> 'I';
            case 9 -> 'J';
            case 10 -> 'K';
            case 11 -> 'L';
            case 12 -> 'M';
            case 13 -> 'N';
            case 14 -> 'O';
            case 15 -> 'P';
            case 16 -> 'Q';
            case 17 -> 'R';
            case 18 -> 'S';
            case 19 -> 'T';
            case 20 -> 'U';
            case 21 -> 'V';
            case 22 -> 'W';
            case 23 -> 'X';
            case 24 -> 'Y';
            case 25 -> 'Z';
            case 100 -> 'a';
            case 101 -> 'b';
            case 102 -> 'c';
            case 103 -> 'd';
            case 104 -> 'e';
            case 105 -> 'f';
            case 106 -> 'g';
            case 107 -> 'h';
            case 108 -> 'i';
            case 109 -> 'j';
            case 110 -> 'k';
            case 111 -> 'l';
            case 112 -> 'm';
            case 113 -> 'n';
            case 114 -> 'o';
            case 115 -> 'p';
            case 116 -> 'q';
            case 117 -> 'r';
            case 118 -> 's';
            case 119 -> 't';
            case 120 -> 'u';
            case 121 -> 'v';
            case 122 -> 'w';
            case 123 -> 'x';
            case 124 -> 'y';
            case 125 -> 'z';
            case 200 -> '0';
            case 201 -> '1';
            case 202 -> '2';
            case 203 -> '3';
            case 204 -> '4';
            case 205 -> '5';
            case 206 -> '6';
            case 207 -> '7';
            case 208 -> '8';
            case 209 -> '9';
            default -> '!';
        };
    }
}
