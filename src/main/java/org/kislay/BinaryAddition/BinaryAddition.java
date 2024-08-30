package org.kislay.BinaryAddition;

public class BinaryAddition {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int aEndPosition = a.length() - 1;
        int bEndPosition = b.length() - 1;
        int carry = 0;
        while (aEndPosition >= 0 || bEndPosition >= 0) {
            int aValue = aEndPosition >= 0 ? a.charAt(aEndPosition) - '0' : 0;
            int bValue = bEndPosition >= 0 ? b.charAt(bEndPosition) - '0' : 0;
            int currPosSum = aValue+bValue+carry;
            carry = switch (currPosSum) {
                case 0 -> {
                    stringBuilder.insert(0, '0');
                    yield 0;
                }
                case 1 -> {
                    stringBuilder.insert(0, '1');
                    yield 0;
                }
                case 2 -> {
                    stringBuilder.insert(0, '0');
                    yield 1;
                }
                case 3 -> {
                    stringBuilder.insert(0, '1');
                    yield 1;
                }
                default -> carry;
            };
            aEndPosition--;
            bEndPosition--;
        }
        if (carry == 1) {
            stringBuilder.insert(0, '1');
        }
        return stringBuilder.toString();
    }
}
