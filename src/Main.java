import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        makeDir("C:/Games", log);
        makeDir("C:/Games/src", log);
        makeDir("C:/Games/src/main", log);
        makeFile("C:/Games/src/main", "Main.java", log);
        makeFile("C:/Games/src/main", "Utils.java", log);
        makeDir("C:/Games/src/test", log);
        makeDir("C:/Games/res", log);
        makeDir("C:/Games/res/drawables", log);
        makeDir("C:/Games/res/vectors", log);
        makeDir("C:/Games/res/icons", log);
        makeDir("C:/Games/savegames", log);
        makeDir("C:/Games/temp", log);
        makeFile("C:/Games/temp", "temp.txt", log);

        System.out.println(log);

        writeToFile("C:/Games/temp/temp.txt", log);

    }

    public static boolean makeDir(String path, StringBuilder sb) {
        File dir = new File(path);
        if (dir.mkdir()) {
            sb.append("Каталог " + path + " создан" + "\n");
            return true;
        } else {
            sb.append(dir.exists() ?
                    "Каталог " + path + " уже существует" + "\n" :
                    "Каталог " + path + " не создан" + "\n");
        }
        return false;
    }

    public static boolean makeFile(String path, String fileName, StringBuilder sb) {
        File file = new File(path, fileName);
        try {
            if (file.createNewFile()) {
                sb.append("Файл " + path + "/" +fileName + " создан" + "\n");
                return true;
            } else {
                sb.append(file.exists() ?
                        "Файл " + path + "/" + fileName + " уже существует" + "\n" :
                        "Файл " + path + "/" + fileName + " не создан" + "\n");
            }
        } catch (IOException e) {
            sb.append("Файл не создан! Ошибка - " + e.getMessage() + "\n");
        }
        return false;
    }

    public static boolean writeToFile(String path, StringBuilder sb) {
        try (FileWriter writer = new FileWriter(path, false)) {
            writer.write(String.valueOf(sb));
            writer.flush();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
