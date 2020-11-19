package neu.sqat;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GreetingKata {
    public String greet(String... name) throws IllegalArgumentException {
        // handle null and empty input
        if (name == null || name[0].equals("")) {
            return "Hello, my friend.";
        }

        // string preprocess
        List<String> processedName = stringPreprocess(name);

        // handle multiple names
        List<String> upperNames = getUpperNames(processedName);
        List<String> lowerNames = getLowerNames(processedName);

        String lower = getLowerString(lowerNames);
        String upper = getUpperString(upperNames);

        String lowerPrefix = (lower.equals("")) ? "" : "Hello, ";
        String mid = (lower.equals("") || upper.equals("")) ? "" : " AND ";
        String upperPrefix = (upper.equals("")) ? "" : "HELLO ";

        return lowerPrefix + lower + mid + upperPrefix + upper;
    }

    // match uppercase
    public boolean isUppercase(String name) {
        Pattern p = Pattern.compile("[A-Z]+");
        return p.matcher(name).matches();
    }

    // match valid char
    public boolean isValidChar(String name) {
        Pattern p = Pattern.compile("[A-Za-z\\s,]+");
        return p.matcher(name).matches();
    }

    // string preprocess
    public List<String> stringPreprocess(String... name) throws IllegalArgumentException {
        List<String> names = new ArrayList<>();
        for (String value : name) {
            String[] tmp = value.split("");
            boolean flag = false;
            StringBuilder item = new StringBuilder();

            for (String s : tmp) {
                switch (s) {
                    case ",":
                        // between quotes
                        if (flag) item.append(s);
                        else {    // else
                            if (isValidChar(item.toString())) {
                                names.add(item.toString());
                                item.delete(0, item.length());
                            } else throw new IllegalArgumentException("Illegal Input!");
                        }
                        break;
                    case "\"":
                        flag = !flag;
                        break;
                    case " ":
                        if (flag) item.append(s);
                        break;
                    default:
                        item.append(s);
                        break;
                }
            }
            if (isValidChar(item.toString())) {
                names.add(item.toString());
                item.delete(0, item.length());
            } else throw new IllegalArgumentException("Illegal Input!");
        }
        return names;
    }

    // split upper and lower
    public List<String> getUpperNames(List<String> name) {
        List<String> upperNames = new ArrayList<>();
        for (String n : name) {
            if (isUppercase(n)) {
                upperNames.add(n);
            }
        }
        return upperNames;
    }

    // split upper and lower
    public List<String> getLowerNames(List<String> name) {
        List<String> lowerNames = new ArrayList<>();
        for (String n : name) {
            if (!isUppercase(n)) {
                lowerNames.add(n);
            }
        }
        return lowerNames;
    }

    // handle lower names
    public String getLowerString(List<String> lowerNames) {
        if (!lowerNames.isEmpty()) {
            StringBuilder lower = new StringBuilder(lowerNames.get(0));

            for (int i=1; i<lowerNames.size()-1; i++) {
                lower.append(", ").append(lowerNames.get(i));
            }

            if (lowerNames.size() >= 2) {
                if (lowerNames.size() > 2) {
                    lower.append(", and ").append(lowerNames.get(lowerNames.size() - 1));
                } else {
                    lower.append(" and ").append(lowerNames.get(lowerNames.size() - 1));
                }
            }
            lower.append(".");

            return lower.toString();

        } else
            return "";
    }

    // handle upper names
    public String getUpperString(List<String> upperNames) {
        if (!upperNames.isEmpty()) {
            StringBuilder upper = new StringBuilder(upperNames.get(0));

            for (int i=1; i<upperNames.size()-1; i++) {
                upper.append(", ").append(upperNames.get(i));
            }

            if (upperNames.size() >= 2) {
                if (upperNames.size() > 2) {
                    upper.append(", AND ").append(upperNames.get(upperNames.size() - 1));
                } else {
                    upper.append(" AND ").append(upperNames.get(upperNames.size() - 1));
                }
            }
            upper.append("!");

            return upper.toString();

        } else
            return "";
    }

    public static void main(String[] args) {

    }

}
