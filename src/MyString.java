import java.util.Arrays;
import java.util.stream.IntStream;

public class MyString {
    private final char[] c;

    MyString() {
        this.c = null;
    }
    MyString(char[] c) {
        this.c = c;
    }
    MyString(MyString original) {
        this.c = original.c;
    }
    MyString(String original) {
        this.c = original.toCharArray();
    }

    boolean isEmpty() {
        assert c != null;
        return c.length == 0;
    }

    int length() {
        return c.length;
    }

    int compareTo(MyString anotherString) {
        for (int i = 0; i < anotherString.c.length && i < c.length; i++) {
            if(c[i] < anotherString.c[i]) return c[i] - anotherString.c[i];
            else if(c[i] > anotherString.c[i]) return c[i] - anotherString.c[i];
        }
        if(c.length > anotherString.c.length) return 1;
        else if(c.length < anotherString.c.length) return -1;
        return 0;
    }

    public MyString concat(MyString str) {
        char[] st = new char[str.c.length + this.c.length];
        MyString mst = new MyString(st);
        int count = 0;
        for (int i = 0; i < this.c.length; i++) {
            st[i] = this.c[i];
            count++;
        }
        for (int j = 0; j < str.c.length; j++) {
            st[count++] = str.c[j];
        }
        return mst;
    }

    void print() {
        assert c != null;
        for (char value : c) {
            System.out.print(value);
        }
    }

    char CharAt(int index) {
        assert c != null;
        return c[index];
    }

    public MyString substring(int begin, int end) {
        if(end > c.length) {
            return new MyString();
        }

        int newLength = end - begin;
        char[] newArray = new char[newLength];
        IntStream.range(begin, end).forEach(i -> newArray[i - begin] = c[i]);

        return new MyString(newArray);
    }

    public MyString trim() {
        int begin = 0;
        int end = c.length;

        {
            int i = 0;
            while (i < c.length) {
                if(c[i] != ' ') break;
                i++;
                begin++;
            }
        }

        int i = c.length - 1;
        while (i >= 0) {
            if(c[i] != ' ') break;
            i--;
            end--;
        }

        return substring(begin, end);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyString myString = (MyString) o;
        return Arrays.equals(c, myString.c);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(c);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.c);
    }

}