- [x] 디지털 논리 게이트 함수
  - [x] AND
  - [x] OR
  - [x] NAND
  - [x] XOR
- [ ] 반쪽덧셈과 전체덧셈
  - [x] sum
  - [x] carry
  - [x] halfadder
  - [ ] fulladder
- [ ] 1바이트 덧셈기

# 디지털 논리 게이트 함수 구현

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

# 반쪽덧셈과 전체덧셈

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
        boolean[] halfAdderResult = halfAdder(bitA, bitB);
        
        return new boolean[]{halfAdderResult[0], sum(halfAdderResult[1], carry)};
    }
```

<p>
코드를 짰는데 값이 제대로 나오지 않아 구현이 잘못된 것 같습니다. 단순히 노트에 bitA, bitB, carry 값을 적고 계산하면 쉽게 답이 나오는 것 같은데 이걸 코드로 표현하려니 갑자기 머리에 과부하가 오는 듯 합니다. 내일 동료들 코드 리뷰때 참고하여 구현할 수 있도록 해보겠습니다.
</p>