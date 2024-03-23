import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TOC {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("D:\\College\\Year 4\\Second term\\Computation Theory\\Assignment 1\\input.txt"))) {
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
                nine("D:\\College\\Year 4\\Second term\\Computation Theory\\Assignment 1\\input.txt");
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
        System.out.println("Not solved yet");
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
        String regex = "(https?://\\S+)";

        // Compile the regex pattern
        Pattern urlPattern = Pattern.compile(regex);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int urlCount = 0;

            // First loop to find the number of URLs in the file
            while ((line = reader.readLine()) != null) {
                Matcher urlMatcher = urlPattern.matcher(line);
                while (urlMatcher.find()) {
                    urlCount++;
                }
            }
            System.out.println("Number of URlLs: " + urlCount);
            // Reset reader
            reader.close();
            try (BufferedReader newReader = new BufferedReader(new FileReader(filePath))) {
                int lineNumber = 0;

                // Second loop to extract everything else except URLs
                while ((line = newReader.readLine()) != null) {
                    lineNumber++;

                    // Create a matcher for the current line
                    Matcher matcher = urlPattern.matcher(line);

                    // Find and print URLs in the current line
                    while (matcher.find()) {
                        String url = matcher.group();
                        int startIndex = matcher.start();
                        int endIndex = matcher.end();

                        System.out.println("URL: " + url);
                        System.out.println("Line number: " + lineNumber);
                        System.out.println("Start index: " + startIndex + ", End index: " + endIndex);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ten(String s) {
        String reg = "^[+-]?(?:\\d*\\.?\\d*[a-zA-Z]|\\d+\\.\\d+|\\d+)(?:[+\\-/][+-]?(?:\\d\\.?\\d*[a-zA-Z]|\\d+\\.\\d+|\\d+))=[+-]?(?:\\d\\.?\\d*[a-zA-Z]|\\d+\\.\\d+|\\d+)(?:[+\\-/][+-]?(?:\\d\\.?\\d*[a-zA-Z]|\\d+\\.\\d+|\\d+))*$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(s);
        // System.out.println(s);
        System.out.println(matcher.matches() ? "valid mathematical expression" : "invalid mathematical expression");
    }
}