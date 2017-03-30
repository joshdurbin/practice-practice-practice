
public class StringOperations {

    private StringOperations() {
    }

    public static String inPlaceReverse(final String stringToReverse) {

        final StringBuilder builder = new StringBuilder(stringToReverse);

        for (int i = 0; i < builder.length() / 2; i++) {

            final char tmp = builder.charAt(i);
            final int otherEnd = builder.length() - i - 1;

            builder.setCharAt(i, builder.charAt(otherEnd));
            builder.setCharAt(otherEnd, tmp);
        }

        return builder.toString();
    }

    public static Boolean containsUniqueCharacters(final String stringToScrutinize) {

        // 256 for the number of known ascii characters
        final Boolean[] characterHits = new Boolean[256];

        // set all markers to false
        for (Integer i = 0; i < 256; i++) {
            characterHits[i] = false;
        }

        for (Integer i = 0; i < stringToScrutinize.length(); i++) {

            final char characterAtPosition = stringToScrutinize.charAt(i);

            if (characterHits[characterAtPosition] == true) {

                // duplicate hit, thus the string does not contain unique characters
                return false;
            } else {

                characterHits[characterAtPosition] = true;
            }
        }

        return true;
    }
}
