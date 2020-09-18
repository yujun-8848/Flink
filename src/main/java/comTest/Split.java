package comTest;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Split {

    private static final int split_num = 250;
    public static final String DATA = "C:\\Users\\Administrator\\Desktop\\out.bcp";

    public static void main(String[] args) throws Exception {

//        BufferedWriter[] out = new BufferedWriter[250];
//        for (int i = 0; i < 250; i++) {
//            String outPath = DATA + "_" + i;
//            out[i] = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPath)));
//        }
//
//        BufferedReader in = new BufferedReader(new FileReader(DATA));
//        int flag = 0;
//        String line;
//        while ((line = in.readLine()) != null) {
//            out[flag % 250].append(line).append("\n");
//            flag++;
//        }
//        in.close();
//
//        for (int i = 0; i < 250; i++) {
//            out[i].close();
//        }

//        BufferedReader in = new BufferedReader(new FileReader(DATA));
//        int flag = 0;
//
//        int[] nums = new int[1_000_000];
//
//        String line;
//        while ((line = in.readLine()) != null) {
//            nums[flag++] = Integer.parseInt(line);
//            flag++;
//        }
//        in.close();
//        Arrays.sort(nums);




    }

}
