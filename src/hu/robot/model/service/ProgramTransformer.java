package hu.robot.model.service;

public class ProgramTransformer {

    public String toNewFormat(String oldFormat) {
        String actual = oldFormat + "_";
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (int i = 1; i < actual.length(); i++) {
            if (actual.charAt(i - 1) == actual.charAt(i)) {
                counter++;
            } else {
                if (counter > 1) {
                    sb.append(counter);
                }
                sb.append(actual.charAt(i - 1));
                counter = 1;
            }
        }
        return sb.toString();
    }

    public String toOldFormat(String newFormat) {
        StringBuilder oldFormat = new StringBuilder();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < newFormat.length(); i++) {
            char character = newFormat.charAt(i);
            if (isNumber(character)) {
                number.append(character);
            } else {
                int limit = number.length() > 0 ? Integer.parseInt(number.toString()) : 1;
                for (int db = 0; db < limit; db++) {
                    oldFormat.append(character);
                }
                number = new StringBuilder();
            }
        }
        return oldFormat.toString();
    }

    private boolean isNumber(char character) {
        return character >= '0' && character <= '9';
    }
}
