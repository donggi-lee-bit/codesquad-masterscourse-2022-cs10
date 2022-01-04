- [x] 디지털 논리 게이트 함수
  - [x] AND
  - [x] OR
  - [x] NAND
  - [x] XOR
- [x] 반쪽덧셈과 전체덧셈
  - [x] sum
  - [x] carry
  - [x] halfadder
  - [x] fulladder
- [x] 1바이트 덧셈기

# 논리 게이트 함수 구현

```java
public boolean myAnd(boolean bitA, boolean bitB) {

        if (bitA & bitB == true) {
            return true;
        }
        return false;
    }
```
<p>
AND 논리 함수는 매개변수가 둘 다 참일 때 true를 반환한다. 하나라도 false면 false를 반환한다
</p>

<br>

```java
public boolean myOr(boolean bitA, boolean bitB) {

        if (bitA | bitB == true) {
            return true;
        }
        return false;
    }
```
<p>
OR 논리 함수는 한 쪽의 값이 참이면 true를 반환한다. 둘 다 false일 때 false를 반환한다
</p>

<br>

```java
public boolean myNand(boolean bitA, boolean bitB) {

        if (bitA & bitB == true) {
            return false;
        }
        return true;
    }
```

<p>
NAND 논리 함수는 AND 논리 함수의 반대로 값을 반환한다. AND 에서 true를 반환할 때 false를 반환한다.
</p>

<br>

```java
public boolean myXor(boolean bitA, boolean bitB) {

        if (bitA == bitB) {
            return false;
        }
        return true;
    }
```

<p>
XOR 논리 함수는 값이 서로 다를 때 참을 반환한다. 같은 때는 false를 반환한다.
</p>

<br>

# 반가산기 전가산기

```java
private boolean sum(boolean bitA, boolean bitB) {
        DigitalLogicFunction dlf = new DigitalLogicFunction();
        return dlf.myXor(bitA, bitB);
    }
```

<p>
이진 덧셈에서 합은 앞서 디지털 논리 게이트 함수의 XOR 논리 함수와 같다. 반환 값을 XOR 논리 함수의 반환값으로 사용했다
</p>

<br>

```java
private boolean carry(boolean bitA, boolean bitB) {
        DigitalLogicFunction dlf = new DigitalLogicFunction();
        return dlf.myAnd(bitA, bitB);
    }
```

<p>
carry 메서드는 AND 논리 함수와 같아 AND 논리 함수의 반환값을 반환해주었다.
</p>

<br>

```java
private boolean[] halfAdder(boolean bitA, boolean bitB) {
        return new boolean[]{carry(bitA, bitB), sum(bitA, bitB)};
    }
```

<p>
반가산기 반환 값으로 각각 carry와, sum을 반환하여서 만든 메서드를 사용해서 반환해주었다.
</p>

## 전가산기

```java
public boolean[] fullAdder(boolean bitA, boolean bitB, boolean carry) {
        boolean[] firstHalfAdder = halfAdder(bitA, bitB);
        boolean sum = firstHalfAdder[1];

        boolean[] secondHalfAdder = halfAdder(carry, sum);
        boolean carryOut = dlf.or(firstHalfAdder[0], secondHalfAdder[0]);
        boolean sumOut = secondHalfAdder[1];
        return new boolean[]{carryOut, sumOut};
        }
```

<p>
동료들과 코드 리뷰를 가졌을 때 얻은 힌트를 토대로 구현하였습니다. 설계도를 참고하여 반가산기에 매개변수를 넣어주었더니 쉽게 해결 할 수 있었습니다. 다른 사람이 사용할 수 있도록 가독성 있는 코드를 작성하려고 신경 쓰게 됐습니다.
</p>

<br>

# 바이트 덧셈기

```java
final static int CARRY = 0;
    final static int SUM = 1;

    public boolean[] byteAdder(boolean[] byteA, boolean[] byteB) {
        boolean[] answer = new boolean[9];
        boolean carry = false;
        int len = answer.length - 1;
        boolean[] res = new boolean[len];

        for (int i = 0; i < len; i++) {
            res = fullAdder(byteA[i], byteB[i], carry);
            carry = res[CARRY];
            answer[i] = res[SUM];
        }
        answer[8] = res[CARRY];

        return answer;
    }
```

<p>
정해진 배열 사이즈가 있다는 가정하에 덧셈기를 구현했습니다. 포문을 돌면서 전가산기 메서드에서 반환 받은 SUM 값을 answer 배열에 넣어주었습니다. 포문이 끝난 후 마지막 CARRY 값을 answer 배열에 넣어주어 반환하였습니다.
</p>