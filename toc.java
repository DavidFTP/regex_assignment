import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TOC {
    public static String filePath = "D:\\College\\Year 4\\Second term\\Computation Theory\\regex_assignment\\Assignment 1\\input.txt";
    public static String problem9 = "D:\\College\\Year 4\\Second term\\Computation Theory\\regex_assignment\\Assignment 1\\problem9file.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(
                        filePath))) {
            String line;
            int pNumber;

            for (int i = 0; i < 10; i++) {
                reader.readLine(); // reading a line to skip it since it's the problem number
                pNumber = i + 1;
                System.out.println(pNumber);
                while (!(line = reader.readLine()).equals("end")) {
                    assign_problem(line, pNumber);
                }
                System.out.println("x");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void assign_problem(String s, int n) {
        switch (n) {
            case 1:
                one(s);
                break;
            case 2:
                two(s);
                break;
            case 3:
                three(s);
                break;
            case 4:
                four(s);
                break;
            case 5:
                five(s);
                break;
            case 6:
                six(s);
                break;
            case 7:
                seven(s);
                break;
            case 8:
                eight(s);
                break;
            case 9:
                nine(problem9);
                break;
            case 10:
                ten(s);
                break;
            default:
                break;
        }
    }

    public static void one(String s) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.matches() ? "valid email" : "invalid email");
    }

    public static void two(String s) {
        String regex = "^(\\(\\d{3}\\)|\\d{3})-?\\d{3}-?\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.matches() ? "valid phone number" : "invalid phone number");
    }

    public static void three(String s) {
        String regex = "^(?:(?:19|20)\\d\\d[-/.](?:0[1-9]|1[0-2])[-/.](?:0[1-9]|[12][0-9]|3[01])|(?:(?:0[1-9]|[12][0-9]|3[01])[-/.](?:0[1-9]|1[0-2])[-/.](?:19|20)\\d\\d)|(?:0?[1-9]|[12][0-9]|3[01])[-/.](?:0?[1-9]|1[0-2])[-/.](?:19|20)\\d\\d)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.matches() ? "valid date" : "invalid date");
    }

    public static void four(String s) {
        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        // System.out.println(s);
        System.out.println(matcher.matches() ? "valid IP address" : "invalid IP address");
    }

    public static void five(String s) {
        String regex = "^[a-zA-Z_][a-zA-Z0-9_]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.matches() ? "valid C++ variable name" : "invalid C++ variable name");
    }

    public static void six(String s) {
        String regex = "^(?!.*[bB]{3})[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.find() ? "valid string" : "invalid string, has 3 consecutive b's");

    }

    public static void seven(String s) {
        String regex = "((aa)*ab(bb)*((aa)*a)*)|((bb)*ba(aa)*((bb)*b)*)|((aa)*((bb)*b)((aa)*a))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        int count = 0;

        while (matcher.find()) {
            count++;
        }
        matcher.reset();
        System.err.println("*" + s + "*");
        System.out.println("Number of matched substrings: " + count);
        while (matcher.find()) {
            System.out.println("Matched substring: " + matcher.group() + " Start index: " + matcher.start()
                    + " End index: " + (matcher.end()));
        }
    }

    public static void eight(String s) {
        String regex = "\\b(\\w{3})\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        matcher.reset();
        System.out.println("*" + s + "*");
        if (count > 0) {
            System.out.println("number of matched words: " + count);
            while (matcher.find()) {
                String word = matcher.group(1);
                int startIndex = matcher.start(1);
                int endIndex = matcher.end(1);

                System.out.println("matched word: " + word);
                System.out.println("start index: " + startIndex + ", end index: " + endIndex);
            }
        } else {
            System.out.println("No word matches");
        }
    }

    public static void nine(String filePath) {
        System.out.println("*problem9file.txt*");
        String regex = "\\b(https?):/\\S+\\b";

        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            int urlCount = 0;

            List<String> links = new ArrayList<>();
            List<Integer> lines = new ArrayList<>();
            List<Integer> startIndecies = new ArrayList<>();
            List<Integer> endIndecies = new ArrayList<>();

            // Loop through the lines of the file
            while ((line = reader.readLine()) != null) {
                lineNumber++;

                // Create a matcher for the current line
                Matcher matcher = pattern.matcher(line);

                // Find and print URLs in the current line
                while (matcher.find()) {
                    urlCount++;
                    String url = matcher.group();
                    links.add(url);
                    lines.add(lineNumber);
                    int startIndex = matcher.start();
                    startIndecies.add(startIndex);
                    int endIndex = matcher.end();
                    endIndecies.add(endIndex);
                }
            }
            System.out.println("Number of URLs found: " + urlCount);
            if (urlCount > 0) {
                for (int i = 0; i < urlCount; i++) {
                    System.out.println("URL: " + links.get(i));
                    System.out.println("Line: " + lines.get(i));
                    System.out.println("start index: " + startIndecies.get(i) + ", end index: " + endIndecies.get(i));
                }
            } else {
                System.out.println("No URLs found in the text.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ten(String s) {
        String regex = "^([-+]?\\d*\\.?\\d*([a-zA-Z]+)?([-+*/]))*([-+]?\\d*\\.?\\d*([a-zA-Z]+)?)?=(?:([-+]?\\d*\\.?\\d*([a-zA-Z]+)?([-+*/]))*([-+]?\\d*\\.?\\d*([a-zA-Z]+)?)?)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        // System.out.println(s);
        if (!s.startsWith("=") && !s.endsWith("="))
            System.out.println(matcher.matches() ? "valid mathematical expression" : "invalid mathematical expression");
        else
            System.out.println("invalid mathematical expression");
    }
}