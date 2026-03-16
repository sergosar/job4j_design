package ru.job4j.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Brackets {
    static Map<Character, Character> map = new HashMap<>();

    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        init();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                characterStack.add(c);
            }
            if (c == '}' || c == ']' || c == ')') {
                char bracket = map.get(c);
                if (!characterStack.isEmpty() && characterStack.peek().equals(bracket)) {
                    characterStack.pop();
                } else {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }

    private void init() {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }
}