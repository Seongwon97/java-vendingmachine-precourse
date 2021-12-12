# 🚀 미션 간단 설명
이번 미션은 우리가 일상생활에서 쉽게 볼 수 있는 자판기를 코드로 구현하는 미션입니다.
<br>미션 코드의 진행 순서는 다음과 같습니다.
1. 자판기가 보유한 금액을 입력합니다.
2. 1에서 입력된 금액으로 자판기는 랜덤하게 동전을 생성한다. (보유한 동전 출력)
3. 자판기에서 판매할 상퓸 리스트를 입력합니다.
4. 음료를 구매할 투입 금액을 입력합니다.
5. 구매할 음료를 입력한다.

위의 4,5번을 잔돈이 상품의 최저 가격보다 적거나, 모든 상품이 소진 된 경우까지 반복한다.

6. 잔돈을 반환한다. (잔돈이 부족한 경우 반환할 수 있는 금액만 반환한다.)

<hr>

## 🔒 제약사항 & 만들어야 할 필수 메서드
### 1. Coin
1. 다음 Coin클래스를 활용해야 한다.
```java
public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
}
```


### 2. 입력
#### 2.1. 입력 조건
1. 상품명, 가격, 수량은 쉼표(`,`)로 구분하며 개별 상품은 대괄호(`[]`)로 묶어 세미콜론(`:`)으로 구분한다.
```
[콜라,1500,20];[사이다,1000,10]
```
2. 옳바르지 않는 입력이 들어오면 `IllegalArgumentException`를 발생 시키고 "[ERROR]"로 시작하는 에러 메시지 출력 후 재입력을 받는다.
3. 사용자의 입력은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
4. 입력 받아야 할 값 list
   - 자판기가 보유한 금액
   - 상품 list
   - 투입금액
   - 구입할 상품명

#### 2.2. 잘못된 입력 정리 (예외 상황)
- [자판기가 보유한 금액] 금액이 숫자가 아닌 경우 
- [자판기가 보유한 금액] 금액이 음수인 경우
- [자판기가 보유한 금액] 10원으로 나누어 떨어지지 않는 경우
- [상품] 개별 상품이 세미콜론(`:`)을 기준으로 나뉘지 않은 경우
- [상품] 세미콜론(`:`)을 기준으로 개별 상품으로 나누었을 때 각각의 개별상품이 대괄호(`[]`)로 묶이지 않은 경우
- [상품] 개별 상품의 가격 수량이 쉼표(`,`)로 구분되지 않은 경우
- [상품] 개별 상품의 상품명, 가격, 수량 중 값이 누락된 것이 있을 경우
- [상품 - 상품명] 문장의 시작이 공백으로 시작하는 경우
- [상품 - 가격] 가격이 숫자가 아닌 경우
- [상품 - 가격] 가격이 음수인 경우
- [상품 - 가격] 상품 가격이 100원보다 작은 경우
- [상품 - 가격] 상품 가격이 10원으로 나누어 떨어지지 않는 경우
- [상품 - 수량] 수량이 숫자가 아닌 경우
- [상품 - 수량] 수량이 음수인 경우
- [투입금액] 투입 금액이 숫자가 아닌 경우
- [투입금액] 투입 금액이 음수인 경우
- [구매할 상품] 구매할 상품이 없는 상품인 경우

### 3. 출력
#### 3.1 출력 조건
- 잔돈은 반환된 동전만 출력한다.
- 예외 상황 발생 시 `[ERROR]`로 시작하는 에러 문구를 출력해야한다.
- 전체적인 출력 예시
```
자판기가 보유하고 있는 금액을 입력해 주세요.
450

자판기가 보유한 동전
500원 - 0개
100원 - 4개
50원 - 1개
10원 - 0개

상품명과 가격, 수량을 입력해 주세요.
[콜라,1500,20];[사이다,1000,10]

투입 금액을 입력해 주세요.
3000

투입 금액: 3000원
구매할 상품명을 입력해 주세요.
콜라

투입 금액: 1500원
구매할 상품명을 입력해 주세요.
사이다

투입 금액: 500원
잔돈
100원 - 4개
50원 - 1개
```

### 4. 그 외의 제약사항
- JDK 8 버전 사용
- Indent depth를 2까지만 허용
- 3항 연산자 사용 금지
- 메서드는 최대한 한가지 기능만!
- 메서드의 길이가 15라인을 넘지 않도록 구현
- Else 사용 금지! -> if절에서 return 하는 방식으로 구현하도록!
- Random, Scanner API대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms, Console API를 활용!
- src/test/java 디렉터리의 ApplicationTest에 있는 모든 테스트 케이스가 성공해야 한다.

>**3주 차 미션의 목표는 여러 개의 클래스를 분리한 후 서로 관계를 맺어 하나의 프로그램을 완성하는 경험을 하는 것이다!**
> <br> 2주차 과제때 부족하였던 클래스 분리와 클래스간의 관계를 맺는 것에 신경을 써보자!!

<hr>

# 🛠 구현할 기능 목록
- 자판기 클래스 생성
- 자판기를 실행시키는 메서드 생성
- 상품 클래스 생성
- 상품 리스트 클래스 생성
- 사용자 입력관련 메서드 구현
- 잘못된 입력을 판단하는 메서드 구현
  - [자판기가 보유한 금액] 금액이 숫자가 아닌 경우
  - [자판기가 보유한 금액] 금액이 음수인 경우
  - [자판기가 보유한 금액] 10원으로 나누어 떨어지지 않는 경우
  - [상품] 개별 상품이 세미콜론(`:`)을 기준으로 나뉘지 않은 경우
  - [상품] 세미콜론(`:`)을 기준으로 개별 상품으로 나누었을 때 각각의 개별상품이 대괄호(`[]`)로 묶이지 않은 경우
  - [상품] 개별 상품의 가격 수량이 쉼표(`,`)로 구분되지 않은 경우
  - [상품] 개별 상품의 상품명, 가격, 수량 중 값이 누락된 것이 있을 경우
  - [상품 - 상품명] 문장의 시작이 공백으로 시작하는 경우
  - [상품 - 가격] 가격이 숫자가 아닌 경우
  - [상품 - 가격] 가격이 음수인 경우
  - [상품 - 가격] 상품 가격이 100원보다 작은 경우
  - [상품 - 가격] 상품 가격이 10원으로 나누어 떨어지지 않는 경우
  - [상품 - 수량] 수량이 숫자가 아닌 경우
  - [상품 - 수량] 수량이 음수인 경우
  - [투입금액] 투입 금액이 숫자가 아닌 경우
  - [투입금액] 투입 금액이 음수인 경우
  - [구매할 상품] 구매할 상품이 없는 상품인 경우
- 초기 자판기의 보유한 동전 세팅하는 메서드 구현
  - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInList()`를 활용
- 음료를 구매하는 메서드 구현
  - 음료의 수량 감소
  - 투입 금액의 감소
  - 구매 상품의 재고가 0인 경우 예외상황 발생
  - 잔돈이 상품 구매하려는 상품 가격보다 적은 경우
- 모든 상품 품절 여부 판단 메서드 구현
- 잔돈 반환 메서드 구현




<hr>

# 📋 구현 체크 리스트
* [X] 자판기 클래스 생성
* [X] 자판기를 실행시키는 메서드 생성
* [X] 상품 클래스 생성
* [X] 상품 리스트 클래스 생성
* [ ] 사용자 입력관련 메서드 구현
  * [ ] 입력 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용하였는가?
* [ ] 잘못된 입력을 판단하는 메서드 구현
  * [ ] 잘못된 값을 입력할 경우 **IllegalArgumentException**을 발생시켰는가?
  * [ ] 잘못된 값에 대해 "[ERROR]"를 통한 메시지를 출력 후 입력을 다시 받았는가?
    * [ ] [자판기가 보유한 금액] 금액이 숫자가 아닌 경우
    * [ ] [자판기가 보유한 금액] 금액이 음수인 경우
    * [ ] [자판기가 보유한 금액] 10원으로 나누어 떨어지지 않는 경우
    * [ ] [상품] 개별 상품이 세미콜론(`:`)을 기준으로 나뉘지 않은 경우
    * [ ] [상품] 세미콜론(`:`)을 기준으로 개별 상품으로 나누었을 때 각각의 개별상품이 대괄호(`[]`)로 묶이지 않은 경우
    * [ ] [상품] 개별 상품의 가격 수량이 쉼표(`,`)로 구분되지 않은 경우
    * [ ] [상품] 개별 상품의 상품명, 가격, 수량 중 값이 누락된 것이 있을 경우
    * [ ] [상품 - 상품명] 문장의 시작이 공백으로 시작하는 경우
    * [ ] [상품 - 가격] 가격이 숫자가 아닌 경우
    * [ ] [상품 - 가격] 가격이 음수인 경우
    * [ ] [상품 - 가격] 상품 가격이 100원보다 작은 경우
    * [ ] [상품 - 가격] 상품 가격이 10원으로 나누어 떨어지지 않는 경우
    * [ ] [상품 - 수량] 수량이 숫자가 아닌 경우
    * [ ] [상품 - 수량] 수량이 음수인 경우
    * [ ] [투입금액] 투입 금액이 숫자가 아닌 경우
    * [ ] [투입금액] 투입 금액이 음수인 경우
    * [ ] [구매할 상품] 구매할 상품이 없는 상품인 경우
* [ ] 초기 자판기의 보유한 동전 세팅하는 메서드 구현
  * [ ] `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInList()`를 활용하였는가?
* [ ] 음료를 구매하는 메서드 구현
  * [ ] 음료의 수량 감소
  * [ ] 투입 금액의 감소
  * [ ] 구매 상품의 재고가 0인 경우 예외상황 발생
  * [ ] 잔돈이 상품 구매하려는 상품 가격보다 적은 경우
* [ ] 모든 상품 품절 여부 판단 메서드 구현
* [ ] 잔돈 반환 메서드 구현
  
<br>

* [ ] 출력 형태를 잘 지켰는가?
* [ ] JDK 8 버전을 사용하였는가?
* [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현하였는가?
* [ ] 3항 연산자를 사용하지 않고 구현하였는가?
* [ ] 모든 테스트케이스가 성공하는가?
* [ ] 모든 메서드의 길이가 15라인을 넘지 않았는가?
* [ ] Else를 사용하지 않았는가?
* [ ] 클래스 분리하는데 노력을 하였는가?
* [ ] 매직넘버 대신 상수(`static final`)로 코드의 가독성을 높였는가?
* [ ] 클래스를 상수, 멤버 변수, 생성자, 메서드 순으로 작성하며 구현 순서를 지켰는가?


