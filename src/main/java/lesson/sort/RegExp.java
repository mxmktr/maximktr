package lesson.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by steve on 11/10/15.
 */
public class RegExp {
    public static void main(String[] args){

        String first = ("LSC|   1303-8696000-1|4|КОЛЕСНИК М.О.|ОКТЯБРСЬКИЙ|М.ПОЛТАВА|ВУЛ.|МИХАЙЛА ГРУШЕВСЬКОГО|21||1|44319|4|01" +
                "|4167|0|0|-123643|02|3337|0|0|151957|03|0|0|0|0|04|1741|0|0|16005|");

        String second = "The tutorial starts by asking what is a path? Then, the Path class, the primary entry point for the " +
                "package, is introduced. Methods in the Path class relating to syntactic operations are explained. The tutorial " +
                "then moves on to the other primary class in the package, the Files class, which contains methods that deal with file" +
                " operations. First, some concepts common to many file operations are introduced. The tutorial then covers methods for checking," +
                " deleting, copying, and moving files.";

        String third = "Compares this string to the, specified {@code StringBuffer}. Thed result you is {@code true} if and only if this {@code String} represents the same " +
                "sequence of are characters as the specified you {@code StringBuffer}";

        String[] s = second.split("\\W+");
        System.out.println(Arrays.toString(s));
        System.out.println(s[1]);


        ArrayList<String> list = new ArrayList<String>();
        System.out.println(list.size());
        System.out.println(args.length);


    }






}
