# Day 1 Live-Coding Session — 5 Problems
**BridgeLabz / CodInClub**

Clean, modular, and fully tested Java implementations for all 5 problems from the Day 1 Live-Coding Session.

---

## Problems & Method Signatures

### 1. Rock-Paper-Scissors Game
- **File:** `RockPaperScissorsGame.java`
- **Method Signature:** `String playRound(String playerMove, String computerMove)`
- **Concepts:** Random number generation, conditional logic, loops, arrays for round tables, formatted/tabular output, percentage calculation.
- **Rules:**
  - Rock beats Scissors
  - Scissors beats Paper
  - Paper beats Rock
  - Equal moves result in Draw
- **Output:** Tabular round-by-round summary and overall statistics (Wins, Losses, Draws, Win %).

---

### 2. Palindrome Checker (3 Approaches)
- **File:** `PalindromeChecker.java`
- **Method Signatures:**
  - `boolean isPalindromeIterative(String text)`
  - `boolean isPalindromeRecursive(String text)`
  - `boolean isPalindromeArrayReversal(String text)`
- **Concepts:** Loops, recursion, array manipulation, string comparison, comparing implementation trade-offs.
- **Sample Output:**
  - `"madam"` -> `Iterative: Palindrome | Recursive: Palindrome | Array Reversal: Palindrome`
  - `"hello"` -> `Iterative: Not Palindrome | Recursive: Not Palindrome | Array Reversal: Not Palindrome`

---

### 3. BMI Calculator for a Team
- **File:** `BmiCalculator.java`
- **Method Signatures:**
  - `String getBmiStatus(double bmi)`
  - `void printWellnessReport(double[] heights, double[] weights)`
- **Concepts:** Parallel arrays, arithmetic operations, conditional logic, formatted tabular output.
- **Classification:**
  - BMI < 18.5 -> Underweight
  - 18.5 – 24.9 -> Normal
  - 25 – 29.9 -> Overweight
  - >= 30 -> Obese

---

### 4. First Non-Repeating Character
- **File:** `FirstNonRepeatingCharacter.java`
- **Method Signature:** `char findFirstNonRepeatingChar(String text)`
- **Concepts:** Character frequency counting, loops, array-based counting, early-exit scanning.
- **Sample Output:**
  - `"swiss"` -> `First Non-Repeating Character: 'w'`
  - `"aabbcc"` -> `No Non-Repeating Character Found`

---

### 5. Reverse Customer Name
- **File:** `ReverseCustomerName.java`
- **Method Signature:** `String reverseCustomerName(String customerName)`
- **Concepts:** String traversal, character array manipulation, string reconstruction.
- **Sample Output:**
  - `"Sunil"` -> `Original Name: Sunil` | `Reversed Name: linuS`

---

## How to Compile and Run

### Compile All Files:
```bash
javac *.java
```

### Run All 5 Problems:
```bash
java Main
```

### Interactive Menu Mode:
```bash
java Main --menu
```

### Run Individual Problems:
```bash
java RockPaperScissorsGame
java PalindromeChecker
java BmiCalculator
java FirstNonRepeatingCharacter
java ReverseCustomerName
```

To run an individual program in interactive input mode, add `--interactive`:
```bash
java RockPaperScissorsGame --interactive
java PalindromeChecker --interactive
java BmiCalculator --interactive
java FirstNonRepeatingCharacter --interactive
java ReverseCustomerName --interactive
```
