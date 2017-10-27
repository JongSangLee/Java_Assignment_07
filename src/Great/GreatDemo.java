package Great;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GreatDemo {

    ArrayList<Great> greats = new ArrayList<Great>();
    Scanner scan = null;

    public static void main(String[] args) {
        GreatDemo demo = new GreatDemo();
        demo.doit();
    }

    void doit() {
        readAll();
        printAll();
        search();
    }

    void openFile(String fileName) {
        try {
            scan = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void readAll() {
        openFile("great1.txt");
        Great great = null;

        while (scan.hasNext()) {
            great = new Great();
            great.read(scan);
            greats.add(great);
        }
    }

    void printAll() {
        for (Great great : greats)
            great.print();
    }

    static boolean isInteger(String s) {
        return s != null && s.matches("\\d+");
    }

    void search() {
        scan = new Scanner(System.in);

        while (true) {

            System.out.print("\n검색어를 입력하세요..(종료 y) : ");
            String kwd = scan.nextLine();

            if (kwd.equals("y")) break;

            for (Great g : greats) {
                int flag = g.compare(kwd);
                switch (flag) {
                    case 1:
                        g.print();
                        break;
                    case 2:
                        System.out.println(g.name);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}

