package malinatrash;

import java.util.Random;

public class Strings {
    private String sentence;

    public Strings() {
        this.sentence = setRandomSentence(5) + " " + setRandomSentence(2) + " " + setRandomSentence(7);
    }

    public Strings(String sentence) {
        this.sentence = sentence;
    }

    public Strings(Strings example) {
        this.sentence = example.sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String setRandomSentence(int size) {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }

    public String doSecondTask() {
        String[] split = sentence.split(" ");
        String result = "";

        for(int i = split.length - 1; i >= 0; --i) {
            result = result + split[i] + " ";
        }

        String trimedRes = result.trim();
        return trimedRes;
    }

    public String doThirdTask() {
        String replaceString = sentence.replaceAll("[бвгджзйклмнпрстфхцщшъБВГДЖЗЙКЛМНПРСТФХЦШЩЪ]", "-");
        return replaceString;
    }

    public int doFourthTask(int minLenght) {
        String[] words = sentence.split(" ");
        int count = 0;

        for(int i = 0; i < words.length; ++i) {
            if (words[i].length() == minLenght) {
                ++count;
            }
        }
        return count;
    }

    public String getSentence() {
        return this.sentence;
    }
}
