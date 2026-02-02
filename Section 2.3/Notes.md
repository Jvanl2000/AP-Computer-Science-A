# Recurrence Relations & Closed Forms (Solutions)

> Note: The prompt accidentally repeats the number **11**. I keep the *same* order of questions, but label the later items **11a, 11b** for clarity.

---

## 1) Sequence: 1, 1, 1, 1, 1, 1, ...

**Recurrence + initial condition**
- \(a_1 = 1\)
- \(a_n = a_{n-1}\) for \(n \ge 2\)

---

## 2) Sequence: 1, 2, 3, 4, 5, 6, 7, ...

**Recurrence + initial condition**
- \(a_1 = 1\)
- \(a_n = a_{n-1} + 1\) for \(n \ge 2\)

---

## 3) Sequence: 2, 4, 6, 8, 10, 12, 14, ...

**Recurrence + initial condition**
- \(a_1 = 2\)
- \(a_n = a_{n-1} + 2\) for \(n \ge 2\)

---

## 4) Sequence: 1, -1, 1, -1, 1, -1, ...

**Recurrence + initial condition**
- \(a_1 = 1\)
- \(a_n = -a_{n-1}\) for \(n \ge 2\)

---

## 5) Sequence: 1, 5, 17, 53, 161, 485, ...

Check the pattern:
- \(1 \mapsto 5\): \(3(1)+2=5\)
- \(5 \mapsto 17\): \(3(5)+2=17\)
- \(17 \mapsto 53\): \(3(17)+2=53\)

**Recurrence + initial condition**
- \(a_1 = 1\)
- \(a_n = 3a_{n-1} + 2\) for \(n \ge 2\)

---

## 6) Sequence: 2, 8, 128, 32768, 2147483648, ...

Notice:
- \(8 = 2\cdot 2^2\)
- \(128 = 2\cdot 8^2\)
- \(32768 = 2\cdot 128^2\)

**Recurrence + initial condition**
- \(a_1 = 2\)
- \(a_n = 2\,(a_{n-1})^2\) for \(n \ge 2\)

---

## 7) Sequence: 2, 3, 5, 8, 13, 21, 34, ...  (Fibonacci-type)

**Recurrence + initial conditions**
- \(a_1 = 2\)
- \(a_2 = 3\)
- \(a_n = a_{n-1} + a_{n-2}\) for \(n \ge 3\)

---

## 8) Closed form for #3

From #3: \(a_1=2\) and \(a_n=a_{n-1}+2\).

This is an arithmetic sequence with common difference 2:

\[
a_n = 2n
\]

(Quick check: \(n=1 \to 2\), \(n=2 \to 4\), \(n=3 \to 6\), etc.)

---

## 9) Closed form for #4

From #4: \(a_1=1\) and \(a_n=-a_{n-1}\).

This alternates signs:

\[
a_n = (-1)^{n-1}
\]

(Quick check: \(n=1 \to 1\), \(n=2 \to -1\), \(n=3 \to 1\), ...)

---

## 10) Closed form for #5

From #5: \(a_1=1\), \(a_n=3a_{n-1}+2\).

Solve using the standard method:

1. Particular solution: try constant \(a = c\).
   \[
   c = 3c + 2 \Rightarrow -2c = 2 \Rightarrow c = -1
   \]
2. Homogeneous solution: \(a_n^{(h)} = C\cdot 3^{n-1}\).
3. Combine:
   \[
   a_n = C\cdot 3^{n-1} - 1
   \]
4. Use \(a_1=1\):
   \[
   1 = C\cdot 3^{0} - 1 \Rightarrow C = 2
   \]

\[
\boxed{a_n = 2\cdot 3^{n-1} - 1}
\]

---

## 11a) Closed form for #6

From #6: \(a_1=2\), \(a_n = 2(a_{n-1})^2\).

Let \(a_n = 2^{b_n}\). Then:

\[
2^{b_n} = 2\left(2^{b_{n-1}}\right)^2 = 2^{1+2b_{n-1}}
\]
So
\[
b_n = 1 + 2b_{n-1}, \quad b_1=1
\]

Solve:
- This recurrence gives \(b_n = 2^n - 1\) (you can verify by induction).

Therefore:
\[
\boxed{a_n = 2^{2^n - 1}}
\]

Check quickly:
- \(n=1:\ 2^{2^1-1}=2^1=2\)
- \(n=2:\ 2^{3}=8\)
- \(n=3:\ 2^{7}=128\)
- \(n=4:\ 2^{15}=32768\)
- \(n=5:\ 2^{31}=2147483648\)

---

## 11b) Verify \(A_n = 2n + 1\) solves \(A_n = 2A_{n-1} - 1\), \(A_1=3\)

**Base case (n = 1):**
\[
A_1 = 2(1)+1=3
\]
Matches \(A_1=3\).

**Recurrence check:**
Assume \(A_{n-1}=2(n-1)+1=2n-1\). Then
\[
2A_{n-1}-1 = 2(2n-1)-1 = 4n-2-1 = 4n-3
\]
But
\[
A_n = 2n+1
\]
These are not equal, so \(A_n=2n+1\) **does not** satisfy the recurrence \(A_n = 2A_{n-1}-1\).

✅ Likely typo: \(A_n = 2n+1\) *does* satisfy:
\[
A_n = A_{n-1} + 2,\quad A_1=3
\]
because
\[
A_{n-1}+2 = (2(n-1)+1)+2 = 2n+1
\]

If the recurrence truly is \(A_n = 2A_{n-1}-1\) with \(A_1=3\), then the correct closed form is:
\[
A_n = 2^n + 1
\]
since \(2^1+1=3\) and \(2(2^{n-1}+1)-1 = 2^n+1\).

---

## 12) \(S_n = n + S_{n-1}\), \(S_1=1\)

### First 6 terms
- \(S_1 = 1\)
- \(S_2 = 2 + 1 = 3\)
- \(S_3 = 3 + 3 = 6\)
- \(S_4 = 4 + 6 = 10\)
- \(S_5 = 5 + 10 = 15\)
- \(S_6 = 6 + 15 = 21\)

So: **1, 3, 6, 10, 15, 21**

### Verify \(S_n = \dfrac{n(n+1)}{2}\)

Assume \(S_{n-1}=\dfrac{(n-1)n}{2}\). Then:
\[
S_n = n + S_{n-1}
= n + \frac{(n-1)n}{2}
= \frac{2n}{2} + \frac{n(n-1)}{2}
= \frac{n(2 + n - 1)}{2}
= \frac{n(n+1)}{2}
\]
Verified.

---

## 13) \(S_n = S_{n-1} + n^2\), \(S_1=1\)

### First 6 terms
- \(S_1 = 1\)
- \(S_2 = 1 + 2^2 = 5\)
- \(S_3 = 5 + 3^2 = 14\)
- \(S_4 = 14 + 4^2 = 30\)
- \(S_5 = 30 + 5^2 = 55\)
- \(S_6 = 55 + 6^2 = 91\)

So: **1, 5, 14, 30, 55, 91**

### Verify \(S_n = \dfrac{n(n+1)(2n+1)}{6}\)

Assume \(S_{n-1}=\dfrac{(n-1)n(2n-1)}{6}\). Then:
\[
S_n = S_{n-1} + n^2
= \frac{(n-1)n(2n-1)}{6} + n^2
= \frac{(n-1)n(2n-1) + 6n^2}{6}
\]
Factor \(n\):
\[
= \frac{n\bigl((n-1)(2n-1) + 6n\bigr)}{6}
\]
Expand \((n-1)(2n-1)=2n^2-3n+1\):
\[
= \frac{n(2n^2-3n+1+6n)}{6}
= \frac{n(2n^2+3n+1)}{6}
\]
Factor \(2n^2+3n+1=(n+1)(2n+1)\):
\[
= \frac{n(n+1)(2n+1)}{6}
\]
Verified.

---

## 14) Multidimensional recurrence (Pascal / binomial style)

The recurrence described is the standard binomial-coefficient recurrence:

\[
\binom{n}{k} = \binom{n-1}{k-1} + \binom{n-1}{k}
\]
with boundary values:
- if \(k=0\) or \(k=n\), then \(\binom{n}{k}=1\)

Compute \(\binom{5}{3}\):

\[
\binom{5}{3}=\binom{4}{2}+\binom{4}{3}
\]

Now compute each:

\[
\binom{4}{2}=\binom{3}{1}+\binom{3}{2}
\]
\[
\binom{3}{1}=\binom{2}{0}+\binom{2}{1}=1+2=3
\]
\[
\binom{3}{2}=\binom{2}{1}+\binom{2}{2}=2+1=3
\]
So:
\[
\binom{4}{2}=3+3=6
\]

Also:
\[
\binom{4}{3}=\binom{3}{2}+\binom{3}{3}=3+1=4
\]

Finally:
\[
\binom{5}{3}=6+4=10
\]

\[
\boxed{\binom{5}{3}=10}
\]

---
