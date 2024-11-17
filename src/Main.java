import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст: ");

        String userImput = scanner.nextLine();

        System.out.println("Вы ввели: " + userImput);
        textModifier(userImput);
    }
    public static String textModifier(String text){

        String result = removeExtraSpaces(text);

        String replacing = swapCharacters(result);

        //заменяем все знаки + на !
        String modifiedText = replacing.replace("+", "!");

        String sumNumbers = modifiedText;
        StringBuilder resultSum = new StringBuilder();
        int sum = 0;

        //обход исходного текста
        for (char c : sumNumbers.toCharArray()) {
            if (Character.isDigit(c)) {
                //если символ цифра, добовляем его к сумме
                sum += Character.getNumericValue(c);
            } else {
                //если символ не цифра, добовляем его в результат
                resultSum.append(c);
            }
        }
        //если сумма больше 0, добовляем её к результату
        if (sum > 0) {
            resultSum.append(" ").append(sum);
        }
        System.out.println(resultSum.toString().trim());
        return result;
    }

    public static String removeExtraSpaces(String text){

        StringBuilder sb = new StringBuilder();
        boolean lastWasSpase = false;

        for (char c : text.toCharArray()) {
            if (c == ' ') {
                if (!lastWasSpase) {
                    sb.append(c);
                    lastWasSpase = true;
                }
            } else {
                sb.append(c);
                lastWasSpase = false;
            }
        }

        // удаляем возможный пробел в конце строки
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();

    }

    public static String swapCharacters(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-') {
                if (i > 0 && i < input.length() - 1) {
                    //убедимся что минус не на краю
                    //получаем символы с лева и права
                    char leftChar = input.charAt(i - 1);
                    char rightChar = input.charAt(i + 1);

                    //заменяем символы в результатирующей строке
                    result.setCharAt(result.length() - 1, rightChar);
                    result.append(leftChar);

                    //пропускаем символ '-' и следующий символ
                    i++;  //пропустим символ с права от '-'
                }
            } else {
                //добовляем символ в результат, если не минус
                result.append(input.charAt(i));
            }
        }

        return result.toString();
    }




}