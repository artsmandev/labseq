## 🧩 LabSeq API

Returning **a** value from the **labseq**
_sequence_.

### 📜 The labseq, `l(n)`, sequence is defined as follows:
---

> n = 0 => `l(0)` = 0\
> n = 1 => `l(1)` = 1\
> n = 2 => `l(2)` = 0\
> n = 3 => `l(3)` = 1\
> n > 3 => `l(n)` = `l(n-4)` + `l(n-3)`

### 📜 Example of the first sequence values:
---

>0\
>1\
>0\
>1\
>1\
>1\
>1\
>2\
>2\
>2\
>3\
>[…]

### 📜 Rules
---

1. The _endpoint_ created should be in the form _\<baseurl>/labseq/_**{n}**;
2. where **{n}** represents the **index** _of the sequence’s(single) value to return_;
3. The _index may be any_ **non-negative integer number**;
4. Should use a caching mechanism to take advantage of previous calculations to speed up future calculations.\
4.1 This caching mechanism must be used in the algorithm's intermediate calculations (if applicable), and not only in the endpoint's invocations.
5. Calculation performance is also a plus - calculation of l(10000) must be correctly returned under 10s.

### 🔖 Summary
---

This is a simple project using:
1. JDK 21 `✔︎`
2. Maven 3 `✔︎`
2. Spring Boot 3
3. OpenAPI 3

`✔︎` Yep, they needed to be installed in your machine.

### ⚽️ How to play
---

1. 👻 Clone the repo:
   > git clone git@github.com:artsmandev/labseq.git

2. 🏃🏻‍➡️ Run the app:
   > mvn spring-boot:run

3. 🎯 Go to OpenAPI Specification Documentation:

   > http://localhost:8080/swagger-ui.html

4. 🎮 Rock it!
