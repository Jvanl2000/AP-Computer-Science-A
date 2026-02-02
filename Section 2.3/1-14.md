# Recurrence Relations & Closed Forms (Solutions)

> Note: The prompt accidentally repeats the number **11**. I keep the same order, but label the later items **11a** and **11b** for clarity.

---

## 1) Sequence: 1, 1, 1, 1, 1, 1, ...

**Recurrence + initial condition**

* a₁ = 1
* aₙ = aₙ₋₁ for n ≥ 2

---

## 2) Sequence: 1, 2, 3, 4, 5, 6, 7, ...

**Recurrence + initial condition**

* a₁ = 1
* aₙ = aₙ₋₁ + 1 for n ≥ 2

---

## 3) Sequence: 2, 4, 6, 8, 10, 12, 14, ...

**Recurrence + initial condition**

* a₁ = 2
* aₙ = aₙ₋₁ + 2 for n ≥ 2

---

## 4) Sequence: 1, -1, 1, -1, 1, -1, ...

**Recurrence + initial condition**

* a₁ = 1
* aₙ = −aₙ₋₁ for n ≥ 2

---

## 5) Sequence: 1, 5, 17, 53, 161, 485, ...

Check the pattern:

* 1 → 5: 3(1) + 2 = 5
* 5 → 17: 3(5) + 2 = 17
* 17 → 53: 3(17) + 2 = 53

**Recurrence + initial condition**

* a₁ = 1
* aₙ = 3aₙ₋₁ + 2 for n ≥ 2

---

## 6) Sequence: 2, 8, 128, 32768, 2147483648, ...

Notice:

* 8 = 2 · 2²
* 128 = 2 · 8²
* 32768 = 2 · 128²

**Recurrence + initial condition**

* a₁ = 2
* aₙ = 2(aₙ₋₁)² for n ≥ 2

---

## 7) Sequence: 2, 3, 5, 8, 13, 21, 34, ... (Fibonacci-type)

**Recurrence + initial conditions**

* a₁ = 2
* a₂ = 3
* aₙ = aₙ₋₁ + aₙ₋₂ for n ≥ 3

---

## 8) Closed form for #3

From #3: a₁ = 2 and aₙ = aₙ₋₁ + 2.

This is an arithmetic sequence with common difference 2:

**aₙ = 2n**

Quick check: n = 1 → 2, n = 2 → 4, n = 3 → 6, etc.

---

## 9) Closed form for #4

From #4: a₁ = 1 and aₙ = −aₙ₋₁.

This alternates signs:

**aₙ = (−1)^(n−1)**

Quick check: n = 1 → 1, n = 2 → −1, n = 3 → 1, ...

---

## 10) Closed form for #5

From #5: a₁ = 1, aₙ = 3aₙ₋₁ + 2.

**Solve:**

1. Particular solution: try a constant a = c
   c = 3c + 2
   −2c = 2
   c = −1

2. Homogeneous solution: aₙ^(h) = C · 3^(n−1)

3. Combine: aₙ = C · 3^(n−1) − 1

4. Use a₁ = 1:
   1 = C · 3^0 − 1
   1 = C − 1
   C = 2

**Answer:**
**aₙ = 2 · 3^(n−1) − 1**

---

## 11a) Closed form for #6

From #6: a₁ = 2, aₙ = 2(aₙ₋₁)².

Let aₙ = 2^(bₙ). Then:

2^(bₙ) = 2(2^(bₙ₋₁))² = 2^(1 + 2bₙ₋₁)

So:

* bₙ = 1 + 2bₙ₋₁
* b₁ = 1

This solves to:

**bₙ = 2^n − 1**

Therefore:

**aₙ = 2^(2^n − 1)**

Check quickly:

* n=1: 2^(2−1)=2¹=2
* n=2: 2^(4−1)=2³=8
* n=3: 2^(8−1)=2⁷=128
* n=4: 2^(16−1)=2¹⁵=32768
* n=5: 2^(32−1)=2³¹=2147483648

---

## 11b) Verify Aₙ = 2n + 1 is a solution to Aₙ = 2Aₙ₋₁ − 1 with A₁ = 3

**Base case (n = 1):**

* A₁ = 2(1) + 1 = 3 ✅ matches A₁ = 3

**Check the recurrence:**
If Aₙ = 2n + 1, then:

* Aₙ₋₁ = 2(n−1) + 1 = 2n − 1

Compute the right-hand side:

* 2Aₙ₋₁ − 1 = 2(2n − 1) − 1 = 4n − 2 − 1 = 4n − 3

But the left-hand side is:

* Aₙ = 2n + 1

Since 2n + 1 ≠ 4n − 3 (for general n), **Aₙ = 2n + 1 is NOT a solution** to Aₙ = 2Aₙ₋₁ − 1.

✅ Likely typo: Aₙ = 2n + 1 **does** satisfy:

* Aₙ = Aₙ₋₁ + 2, with A₁ = 3

Extra: If the recurrence truly is Aₙ = 2Aₙ₋₁ − 1 with A₁ = 3, then the correct closed form is:

* **Aₙ = 2^n + 1**

---

## 12) Sₙ = n + Sₙ₋₁ with S₁ = 1

### First 6 terms

* S₁ = 1
* S₂ = 2 + 1 = 3
* S₃ = 3 + 3 = 6
* S₄ = 4 + 6 = 10
* S₅ = 5 + 10 = 15
* S₆ = 6 + 15 = 21

Sequence: **1, 3, 6, 10, 15, 21**

### Verify closed form: Sₙ = n(n + 1) / 2

Assume Sₙ₋₁ = (n−1)n / 2.

Then:
Sₙ = n + Sₙ₋₁
= n + (n−1)n / 2
= 2n/2 + n(n−1)/2
= [n(2 + n − 1)] / 2
= n(n + 1) / 2 ✅ verified

---

## 13) Sₙ = Sₙ₋₁ + n² with S₁ = 1

### First 6 terms

* S₁ = 1
* S₂ = 1 + 2² = 5
* S₃ = 5 + 3² = 14
* S₄ = 14 + 4² = 30
* S₅ = 30 + 5² = 55
* S₆ = 55 + 6² = 91

Sequence: **1, 5, 14, 30, 55, 91**

### Verify closed form: Sₙ = n(n + 1)(2n + 1) / 6

Assume Sₙ₋₁ = (n−1)n(2n−1) / 6.

Then:
Sₙ = Sₙ₋₁ + n²
= ( (n−1)n(2n−1) / 6 ) + n²
= [ (n−1)n(2n−1) + 6n² ] / 6
= [ n((n−1)(2n−1) + 6n) ] / 6

Compute (n−1)(2n−1) = 2n² − 3n + 1:
= [ n(2n² − 3n + 1 + 6n) ] / 6
= [ n(2n² + 3n + 1) ] / 6

Factor 2n² + 3n + 1 = (n + 1)(2n + 1):
= n(n + 1)(2n + 1) / 6 ✅ verified

---

## 14) Multidimensional recurrence (Pascal / binomial style)

The recurrence described is the standard binomial coefficient recurrence:

C(n, k) = C(n−1, k−1) + C(n−1, k)

Boundary values:

* If k = 0 or k = n, then C(n, k) = 1

Find C(5, 3):

C(5, 3) = C(4, 2) + C(4, 3)

Compute C(4, 2):

* C(4, 2) = C(3, 1) + C(3, 2)

Compute C(3, 1):

* C(3, 1) = C(2, 0) + C(2, 1) = 1 + 2 = 3

Compute C(3, 2):

* C(3, 2) = C(2, 1) + C(2, 2) = 2 + 1 = 3

So:

* C(4, 2) = 3 + 3 = 6

Compute C(4, 3):

* C(4, 3) = C(3, 2) + C(3, 3) = 3 + 1 = 4

Finally:

* C(5, 3) = 6 + 4 = **10**

**Answer: C(5, 3) = 10**

---
