package com.gautamthapa.javapractice.string;

import java.util.Arrays;

/*
 * StringMethods Class contains all String class methods example
 * Ref: https://www.programiz.com/java-programming/library/string/split
 * */
public class StringMethods {

    public static void main(String[] args) {

        substringMethod();
        replaceAllMethod();
        replaceMethod();
        lengthMethod();
        compareToIgnoreCaseMethod();
        compareToMethod();
        splitMethod();
    }

    private static void substringMethod() {
        System.out.println("** substringMethod **");

        //The Java String substring() method extracts a substring from the string and returns it.
        // syntax: string.substring(int startIndex, int endIndex) => Here, string is an object of the String class.
        // startIndex - the begining index
        // endIndex (optional) - the ending index

    }

    private static void replaceAllMethod() {
        System.out.println("** replaceAllMethod **");
        // The Java String replaceAll() method replaces each substring that matches the regex of the string with the specified text.
        // Syntax: string.replaceAll(String regex, String replacement) => Here, string is an object of the String class.
        // Parameters: regex - a regex (can be a typical string) that is to be replaced, replacement - matching substrings are replaced with this string
        // The replaceAll() method returns a new string where each occurrence of the matching substring is replaced with the replacement string.

        String str1 = "aabbaaac";
        String str2 = "Learn223Java55@";

        // regex for sequence of digits
        String regex="\\d+";

        // all occurrences of "aa" is replaceAll with "zz"
        System.out.println(str1.replaceAll("aa", "zz")); // zzbbzzac

        // replace a digit or sequence of digits with a whitespace
        System.out.println(str2.replaceAll(regex, " ")); // Learn Java @

        // The replaceAll() method can take a regex or a typical string as the first argument. It is because a typical string in itself is a regex. \ ^ $ . | ? * + {} [] ()
        // If you need to match substring containing these metacharacters, you can either escape these characters using \ or use the replace() method.
        String str = "+a-+b";
        String regex1 = "\\+";

        // replace "+" with "#" using replaceAll()
        // need to espace "+"
        System.out.println(str.replaceAll(regex1, "#")); // #a-#b


        // replace "+" with "#" using replace()
        System.out.println(str.replace("+", "#")); // #a-#b






    }

    private static void replaceMethod() {
        System.out.println("** replaceMethod **");
        // The Java String replace() method replaces each matching occurrences of the old character/text in the string with the new character/text.
        // syntax: string.replace(char oldChar, char newChar) or string.replace(CharSequence oldText, CharSequence newText) => Here, string is an object of the String class.
        // oldChar - the character to be replaced in the string
        // newChar - matching characters are replaced with this character
        // oldText - the substring to be replaced in the string
        // newText - matching substrings are replaced with this string
        // The replace() method returns a new string where each occurrence of the matching character/text is replaced with the new character/text.
        // If the character to be replaced is not in the string, replace() returns the original string.

        String str1="abc cba";
        // all occurrences of 'a' is replaced with 'z'
        System.out.println(str1.replace('a', 'z')); // zbc cbz

        // all occurences of 'L' is replaced with 'J'
        System.out.println("Lava".replace('L', 'J')); // Java

        // character not in the string
        System.out.println("Hello".replace('4', 'J')); // Hello

        String str2 = "C++ Programming";

        // all occurrences of "C++" is replaced with "Java"
        System.out.println(str2.replace("C++", "Java")); // Java Programming

        // all occurences of "aa" is replaced with "zz"
        System.out.println("aa bb aa zz".replace("aa", "zz")); // zz bb zz zz

        // substring not in the string
        System.out.println("Java".replace("C++", "C")); // Java

        // It is important to note that the replace() method replaces substrings starting from the start to the end. For example,
        System.out.println("GGGGH".replace("GGG", "P"));
    }

    private static void lengthMethod() {
        System.out.println("** lengthMethod **");
        // The Java String length() method returns the length of the string.
        // syntax: string.length() => Here, string is an object of the String class.
        // The length() method returns the length of the given string.
        // The length is equal to the number of char values (code units) in the string.

        String str1="Java";
        String str2="";

        System.out.println(str1.length());
        System.out.println(str2.length());
        System.out.println("Java".length());
        System.out.println("Java\n".length());
        System.out.println("Learn Java".length());
    }

    private static void compareToIgnoreCaseMethod() {
        System.out.println("** compareToIgnoreCaseMethod **");
        // The Java String compareTo() method compares two strings lexicographically (in the dictionary order), ignoring case differences.
        // syntax: string.compareToIgnoreCase(String str) => Here, string is an object of the String class.
        // compareToIgnoreCase() Parameters: str - the string to be compared
        // compareToIgnoreCase() Return Value
        // returns 0 if the strings are equal, ignoring case considerations
        // returns a negative integer if the string comes before the str argument in the dictionary order
        // returns a positive integer if the string comes after the str argument in the dictionary order

        String str1="Learn Java";
        String str2="learn Java";
        String str3="Learn Kotlin";
        int result;

        // compare str1 and str2
        result = str1.compareToIgnoreCase(str2);
        System.out.println("result1: "+result);

        // compare str1 and str3
        result = str1.compareToIgnoreCase(str3);
        System.out.println("result2: "+result);

        // compare str3 and str1
        result = str3.compareToIgnoreCase(str1);
        System.out.println("result3: "+result);
    }

    private static void compareToMethod() {
        System.out.println("** compareToMethod **");
        // The Java String compareTo() method compares two strings lexicographically (in the dictionary order). The comparison is based on the Unicode value of each character in the strings.
        // syntax: string.compareTo(String str) => Here, string is an object of the String class.
        // compareTo() Parameters: str - the string to be compared
        // compareTo() Return Value:
        // returns 0 if the strings are equal
        // returns a negative integer if the string comes before the str argument in the dictionary order
        // returns a positive integer if the string comes after the str argument in the dictionary order
        // If you need to compare two strings ignoring case differences, use the Java String compareToIgnoreCase() method.

        String str1 = "Learn Java";
        String str2 = "Learn Java";
        String str3 = "Learn Kotlin";
        String str4 = "learn Java";

        int result;

        // comparing str1 and str2
        result = str1.compareTo(str2);
        System.out.println("result1 : " + result);


        // comparing str1 and str3
        result = str1.compareTo(str3);
        System.out.println("result2 : " + result);

        // comparing str3 and str1
        result = str3.compareTo(str1);
        System.out.println("result3 : " + result);

        // comparing str1 and str4 this check with case sensitive
        result = str1.compareTo(str4);
        System.out.println("result4 : " + result);

//        // comparing str1 with null throw error
//        result = str1.compareTo(null);
//        System.out.println("result5 : " + result);

    }

    private static void splitMethod() {
        System.out.println("** splitMethod **");
        // The Java String split() method divides the string at the specified regex and returns an array of substrings.
        // Syntax: string.split(String regex, int limit) => string is an object of the String class.
        /*
        * split() Parameters
        The string split() method can take two parameters:
        * regex - the string is divided at this regex (can be strings)
        * limit (optional) - controls the number of resulting substrings
        * If the limit parameter is not passed, split() returns all possible substrings.
        * split() Return Value returns an array of substrings
        * */

        String vowels = "a:e:i:op:u";
        String[] vowelsArray = vowels.split(":");
        System.out.println("Result = " + Arrays.toString(vowelsArray));


        //split() With limit Parameter
        // If the limit parameter is 0 or negative, split() returns an array containing all substrings.
        // If the limit parameter is positive (let's say n), split() returns the maximum of n substrings.

        // splitting using ":"

        // limit -2 array contain all substring
        String[] result = vowels.split(":", -2);
        System.out.println("limit -2 array contain all substring result = " + Arrays.toString(result));

        // limit is 0; array contains all substrings
        result = vowels.split(":", 0);
        System.out.println("limit is 0; array contains all substrings result = " + Arrays.toString(result));

        // limit is 2; array contains a maximum of 2 substrings
        result = vowels.split(":", 2);
        System.out.println("limit is 2; array contains a maximum of 2 substrings result = " + Arrays.toString(result));

        // limit is 4; array contains a maximum of 4 substrings
        result = vowels.split(":", 4);
        System.out.println("limit is 4; array contains a maximum of 4 substrings result = " + Arrays.toString(result));

        // limit is 10; array contains a maximum of 10 substrings
        result = vowels.split(":", 10);
        System.out.println("limit is 10; array contains a maximum of 10 substrings result = " + Arrays.toString(result));


        // splitting the string "+"
        vowels = "a+e+i+o+u";
        result = vowels.split("\\+");
        System.out.println("split + = " + Arrays.toString(result));
    }
}
