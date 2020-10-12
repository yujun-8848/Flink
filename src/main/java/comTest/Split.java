package comTest;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Split {

    private static final int split_num = 2500;
    public static final String DATA = "D:\\IdeaProjects\\flink\\src\\main\\resources\\Random";

    public static final String SPLIT_PATH = "D:\\IdeaProjects\\flink\\src\\main\\resources\\Data";

    public static final String SORT_PATH = "D:\\IdeaProjects\\flink\\src\\main\\resources\\SortData";

    public static ExecutorService service;

    public static LinkedList<String> list = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        createRandom();
        split(split_num);
        getPath(list, SPLIT_PATH);
//        sortFile(list);
        // LinkedList<String> linkedList = new LinkedList<>();
        //  getPath(list, SORT_PATH);
        merge(list);


    }

    public static void merge(LinkedList<String> list) throws Exception {
        while (list.size() > 1) {
            String path1 = list.pollFirst();
            String path2 = list.pollFirst();
            String outPath = SPLIT_PATH + System.currentTimeMillis();
            createFile(outPath);
            compare(path1, path2, outPath);
            if (!deleteFile(path1)) {
                System.out.println("文件删除异常:" + path1);
            }
            if (!deleteFile(path2)) {
                System.out.println("文件删除异常" + path2);
            }
            list.addFirst(outPath);
        }

    }

    private static void createFile(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println(file.getName() + " is create.");
            }
        }
    }

    public static boolean deleteFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

    public static void compare(String path1, String path2, String outPath) throws IOException {
        File file1 = new File(path1);
        File file2 = new File(path2);
        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        String line1;
        String line2;
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outPath)));
        while ((line1 = reader1.readLine()) != null && (line2 = reader1.readLine()) != null) {
            if (Integer.parseInt(line1) < Integer.parseInt(line2)) {
                writer.append(line1).append("\n");
            } else {
                writer.append(line2).append("\n");
            }
        }
        while ((line1 = reader1.readLine()) != null) {
            writer.append(line1).append("\n");
        }
        while ((line2 = reader1.readLine()) != null) {
            writer.append(line2).append("\n");
        }
        writer.close();
        reader1.close();
        reader2.close();

    }

    /**
     * 路径加到list中
     *
     * @param list
     */
    public static void getPath(LinkedList<String> list, String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            list.add(files[i].getAbsolutePath());
        }

    }

    /**
     * 对文件内容进行排序
     *
     * @param list
     * @throws IOException
     */
    public static void sortFile(LinkedList<String> list) throws IOException {
        Set<Integer> set = new TreeSet<>();
        BufferedReader br;
        BufferedWriter bw;
        for (int i = 0; i < list.size(); i++) {
            String path = list.get(i);
            File file = new File(path);
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                set.add(Integer.parseInt(line));
            }
            bw = new BufferedWriter(new FileWriter(new File(SPLIT_PATH + "\\" + i)));
            for (Integer integer : set) {
                bw.append(String.valueOf(integer)).append("\n");
            }
            set.clear();
            System.out.println("文件" + i + "已排好序");
            br.close();
            bw.close();
        }
    }

    /**
     * 切分数据
     *
     * @param nums 切分个数
     * @throws IOException
     */
    public static void split(int nums) throws IOException {
        BufferedWriter[] out = new BufferedWriter[nums];
        for (int i = 0; i < nums; i++) {
            String outPath = SPLIT_PATH + "\\" + i;
            out[i] = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPath)));
        }
        BufferedReader in = new BufferedReader(new FileReader(DATA));
        int flag = 0;
        String line;
        while ((line = in.readLine()) != null) {
            out[flag % nums].append(line).append("\n");
            flag++;
        }
        in.close();
        for (int i = 0; i < nums; i++) {
            out[i].close();
        }

    }

    public static void createRandom() throws IOException {
        String CLASS_PATH = "D:\\IdeaProjects\\flink\\src\\main\\resources\\Random";
        Set<Integer> set;
        Random r = new Random();
        FileWriter writer = new FileWriter(CLASS_PATH);
        int n = Integer.MAX_VALUE / 10;
        for (int i = 0; i < 10; i++) {
            set = new HashSet<>();
            long start = System.currentTimeMillis();
            while (set.size() < 25_000_000) {
                int num;
                while ((num = Math.abs(r.nextInt())) >= n) ;
                num += n * i;
                set.add(num);
            }
            System.out.println(i + "\t" + (System.currentTimeMillis() - start) + "ms");
            for (Integer integer : set) {
                writer.append(String.valueOf(integer)).append("\n");
            }
        }

        writer.close();
    }

    /**
     * 生成数据
     *
     * @param path
     * @throws IOException
     */
    public static void createNum(String path) throws IOException {
        service = Executors.newFixedThreadPool(100);
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        Set<Integer> set = map.keySet();
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 2500000; i++) {
                        set.add(random.nextInt());
                    }
                }
            });
        }

        for (Integer integer : set) {
            br.write(integer);
            br.newLine();
        }
        br.close();
        service.shutdown();
    }

}
