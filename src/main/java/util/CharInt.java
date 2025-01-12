package util;

public final class CharInt {
    private CharInt() {

    }

    public static int toInt(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'a':
                return 100;
            case 'B':
                return 1;
            case 'b':
                return 101;
            case 'C':
                return 2;
            case 'c':
                return 102;
            case 'D':
                return 3;
            case 'd':
                return 103;
            case 'E':
                return 4;
            case 'e':
                return 104;
            case 'F':
                return 5;
            case 'f':
                return 105;
            case 'G':
                return 6;
            case 'g':
                return 106;
            case 'H':
                return 7;
            case 'h':
                return 107;
            case 'I':
                return 8;
            case 'i':
                return 108;
            case 'J':
                return 9;
            case 'j':
                return 109;
            case 'K':
                return 10;
            case 'k':
                return 110;
            case 'L':
                return 11;
            case 'l':
                return 111;
            case 'M':
                return 12;
            case 'm':
                return 112;
            case 'N':
                return 13;
            case 'n':
                return 113;
            case 'O':
                return 14;
            case 'o':
                return 114;
            case 'P':
                return 15;
            case 'p':
                return 115;
            case 'Q':
                return 16;
            case 'q':
                return 116;
            case 'R':
                return 17;
            case 'r':
                return 117;
            case 'S':
                return 18;
            case 's':
                return 118;
            case 'T':
                return 19;
            case 't':
                return 119;
            case 'U':
                return 20;
            case 'u':
                return 120;
            case 'V':
                return 21;
            case 'v':
                return 121;
            case 'W':
                return 22;
            case 'w':
                return 122;
            case 'X':
                return 23;
            case 'x':
                return 123;
            case 'Y':
                return 24;
            case 'y':
                return 124;
            case 'Z':
                return 25;
            case 'z':
                return 125;
            case '0':
                return 200;
            case '1':
                return 201;
            case '2':
                return 202;
            case '3':
                return 203;
            case '4':
                return 204;
            case '5':
                return 205;
            case '6':
                return 206;
            case '7':
                return 207;
            case '8':
                return 208;
            case '9':
                return 209;
            default:
                return -1;
        }
    }

    public static char toChar(int i) {
        switch (i) {
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            case 3:
                return 'D';
            case 4:
                return 'E';
            case 5:
                return 'F';
            case 6:
                return 'G';
            case 7:
                return 'H';
            case 8:
                return 'I';
            case 9:
                return 'J';
            case 10:
                return 'K';
            case 11:
                return 'L';
            case 12:
                return 'M';
            case 13:
                return 'N';
            case 14:
                return 'O';
            case 15:
                return 'P';
            case 16:
                return 'Q';
            case 17:
                return 'R';
            case 18:
                return 'S';
            case 19:
                return 'T';
            case 20:
                return 'U';
            case 21:
                return 'V';
            case 22:
                return 'W';
            case 23:
                return 'X';
            case 24:
                return 'Y';
            case 25:
                return 'Z';
            case 100:
                return 'a';
            case 101:
                return 'b';
            case 102:
                return 'c';
            case 103:
                return 'd';
            case 104:
                return 'e';
            case 105:
                return 'f';
            case 106:
                return 'g';
            case 107:
                return 'h';
            case 108:
                return 'i';
            case 109:
                return 'j';
            case 110:
                return 'k';
            case 111:
                return 'l';
            case 112:
                return 'm';
            case 113:
                return 'n';
            case 114:
                return 'o';
            case 115:
                return 'p';
            case 116:
                return 'q';
            case 117:
                return 'r';
            case 118:
                return 's';
            case 119:
                return 't';
            case 120:
                return 'u';
            case 121:
                return 'v';
            case 122:
                return 'w';
            case 123:
                return 'x';
            case 124:
                return 'y';
            case 125:
                return 'z';
            case 200:
                return '0';
            case 201:
                return '1';
            case 202:
                return '2';
            case 203:
                return '3';
            case 204:
                return '4';
            case 205:
                return '5';
            case 206:
                return '6';
            case 207:
                return '7';
            case 208:
                return '8';
            case 209:
                return '9';
            default:
                return '!';
        }
    }
}
