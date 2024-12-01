package org.aeo_day_1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        AocRequest data = new AocRequest();
        List<String> input = data.fetch();
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        List<Integer> distance = new ArrayList<Integer>();

        for (int i = 0; i < input.size(); i++) {
            if (i % 2 != 0) {
                list1.add(input.get(i));
            } else {
                list2.add(input.get(i));
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);

        for (int i = 0; i < list1.size(); i++) {
            distance.add(Math.abs(Integer.parseInt(list1.get(i)) - Integer.parseInt(list2.get(i))));
        }

        int total_distance = distance.stream().reduce(0, Integer::sum);
        System.out.println("The total distance: " + total_distance);
    }
}


