# Week 1 Assignment — 5 Problems
**CodInClub powered by BridgeLabz**

This repository contains clean, modular, and well-tested Java implementations for all 5 problems from the Week 1 assignment.

---

## Problems Summary

### 1. The Exam Hall Seat Duplication Checker
- **File:** `ExamHallSeatDuplicationChecker.java`
- **Method Signature:** `void checkDuplicateSeats(int[] seatNumbers)`
- **Concepts:** Arrays, nested loops, conditional logic, basic output formatting.
- **Constraint:** Uses arrays and loops only — no Collections classes.
- **Sample Input/Output:**
  - Input: `{101, 102, 103, 102, 105}`
    - Output: `Duplicate Seat Number Found: 102`
  - Input: `{101, 102, 103, 104, 105}`
    - Output: `No Duplicate Seats Found`

---

### 2. The Typing Speed Test Accuracy Checker
- **File:** `TypingSpeedTestAccuracyChecker.java`
- **Method Signature:** `void checkTypingAccuracy(String original, String typed)`
- **Concepts:** String traversal, `charAt()`, loops, conditional logic, percentage calculation.
- **Sample Input/Output:**
  - Input: `original="hello world", typed="hello worlt"`
    - Output: `Matched: 10/11 | Accuracy: 90.91% | First Mismatch at position 11 ('d' vs 't')`
  - Input: `original="coding", typed="coding"`
    - Output: `Matched: 6/6 | Accuracy: 100.00% | No Mismatches`

---

### 3. The Traffic Signal Streak Analyzer
- **File:** `TrafficSignalStreakAnalyzer.java`
- **Method Signature:** `void findLongestStreak(String signalLog)`
- **Concepts:** String traversal, character comparison, loops, tracking a running maximum.
- **Sample Input/Output:**
  - Input: `"RRGGGYRR"`
    - Output: `Longest Streak: 'G' repeated 3 times`
  - Input: `"RRRRYYGG"`
    - Output: `Longest Streak: 'R' repeated 4 times`

---

### 4. The Warehouse Inventory Balancer
- **File:** `WarehouseInventoryBalancer.java`
- **Method Signature:** `void analyzeInventory(int[] sectionA, int[] sectionB)`
- **Concepts:** Arrays, loops, sum accumulation, conditional comparison, tracking maximum with its index.
- **Sample Input/Output:**
  - Input: `sectionA={20,15,30}, sectionB={25,10,30}`
    - Output: `Section A Total: 65 | Section B Total: 65 | Status: Balanced | Highest Quantity: 30 (Section A, Item 3)`

---

### 5. The Movie Review Word Length Profiler
- **File:** `MovieReviewWordLengthProfiler.java`
- **Method Signature:** `void classifyWordLengths(String review)`
- **Concepts:** String splitting (`split()`), loops, conditional logic, counting/categorization.
  - Short: 1–4 letters
  - Medium: 5–8 letters
  - Long: 9+ letters
- **Sample Input/Output:**
  - Input: `"This movie was absolutely fantastic and thrilling"`
    - Output: `Short: 3 | Medium: 1 | Long: 3`

---

## How to Compile and Run

### 1. Compile all files
```bash
javac *.java
```

### 2. Run All Demonstrations
```bash
java Main
```

To launch the interactive selection menu:
```bash
java Main --menu
```

### 3. Run Individual Programs
```bash
java ExamHallSeatDuplicationChecker
java TypingSpeedTestAccuracyChecker
java TrafficSignalStreakAnalyzer
java WarehouseInventoryBalancer
java MovieReviewWordLengthProfiler
```

Add `--interactive` to run any individual program in interactive input mode, for example:
```bash
java ExamHallSeatDuplicationChecker --interactive
```
