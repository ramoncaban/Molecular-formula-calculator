package org.assignment2;

import java.util.Stack;

public class FormulaCalc { // testing commit

  public static void main(String[] args) {
    // Todo
    System.out.println(Algorithm("H")); // 1
    System.out.println(Algorithm("KBr")); // 54
    System.out.println(Algorithm("H2O")); // 10
    System.out.println(Algorithm("NaCl")); // 28
    System.out.println(Algorithm("C6H12O6")); // 96
    System.out.println(Algorithm("Ni(NO3)2")); // should be 90
    System.out.println(Algorithm("Co3(Fe(CN)6)2")); // should be 289

  }

  /**
   * Algorithm
   *
   * @param a Molecular formula
   * @return Total number of protons
   */
  public static int Algorithm(String a) {
    Stack<Integer> stack = new Stack<>();
    int protons = 0;
    int i = 0;
    
    while (i < a.length()) {
      char c = a.charAt(i);
      if (Character.isUpperCase(c)) {
        // Extract the element Symbol
        String element = String.valueOf(c);
        i++;
        while (i < a.length() && Character.isLowerCase(a.charAt(i))) {
          element += a.charAt(i);
          i++;
        }
        // Get the atomic number of the element and push it to the stack
        stack.push(getElementProtons(element));
      } else if (Character.isDigit(c)) {
        // Extract the coefficient
        int coefficient = 0;
        while (i < a.length() && Character.isDigit(a.charAt(i))) {
          coefficient = coefficient * 10 + (a.charAt(i) - '0');
          i++;
        }
        // Multiply the top of the stack with the coefficient
        int top = stack.pop();
        stack.push(top * coefficient);
      } else if (c == '(') {
        // Push the current protons count to the stack and reset protons to 0
        stack.push(protons);
        protons = 0;
        i++;
      } else if (c == ')') {
        // Multiply the protons count within the parentheses by the coefficient
        int coefficient = 0;
        i++;
        while (i < a.length() && Character.isDigit(a.charAt(i))) {
          coefficient = coefficient * 10 + (a.charAt(i) - '0');
          i++;
        }
        int partialProtons = protons * coefficient;
        protons = stack.pop() + partialProtons;
      }
    }
    // Sum up the remaining protons in the stack
    while (!stack.isEmpty()) {
      protons += stack.pop();
    }

    return protons;
  }

  private static int getElementProtons(String c) {

    switch (c) {
      case "H":
        return 1;
      case "He":
        return 2;
      case "Li":
        return 3;
      case "Be":
        return 4;
      case "B":
        return 5;
      case "C":
        return 6;
      case "N":
        return 7;
      case "O":
        return 8;
      case "F":
        return 9;
      case "Ne":
        return 10;
      case "Na":
        return 11;
      case "Mg":
        return 12;
      case "Al":
        return 13;
      case "Si":
        return 14;
      case "P":
        return 15;
      case "S":
        return 16;
      case "Cl":
        return 17;
      case "K":
        return 19;
      case "Ar":
        return 18;
      case "Ca":
        return 20;
      case "Sc":
        return 21;
      case "Ti":
        return 22;
      case "V":
        return 23;
      case "Cr":
        return 24;
      case "Mn":
        return 25;
      case "Fe":
        return 26;
      case "Ni":
        return 28;
      case "Co":
        return 27;
      case "Cu":
        return 29;
      case "Zn":
        return 30;
      case "Ga":
        return 31;
      case "Ge":
        return 32;
      case "As":
        return 33;
      case "Se":
        return 34;
      case "Br":
        return 35;
      case "Kr":
        return 36;
      case "Rb":
        return 37;
      case "Sr":
        return 38;
      case "Y":
        return 39;
      case "Zr":
        return 40;
      case "Nb":
        return 41;
      case "Mo":
        return 42;
      case "Tc":
        return 43;
      case "Ru":
        return 44;
      case "Rh":
        return 45;
      case "Pd":
        return 46;
      case "Ag":
        return 47;
      case "Cd":
        return 48;
      case "In":
        return 49;
      case "Sn":
        return 50;
      case "Sb":
        return 51;
      case "I":
        return 53;
      case "Te":
        return 52;
      case "Xe":
        return 54;
      default:
        return 0;
    }
  }
}
