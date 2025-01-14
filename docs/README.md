## 🛹 다리 건너기
위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.
- 위아래 두 칸으로 이루어진 다리를 건너야 한다.
    - 다리는 왼쪽에서 오른쪽으로 건너야 한다.
    - 위아래 둘 중 하나의 칸만 건널 수 있다.
- 다리의 길이를 숫자로 입력받고 생성한다.
    - 다리를 생성할 때 위 칸과 아래 칸 중 건널 수 있는 칸은 0과 1 중 무작위 값을 이용해서 정한다.
    - 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다.
    - 무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.
- 다리가 생성되면 플레이어가 이동할 칸을 선택한다.
    - 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다.
    - 이동한 칸을 건널 수 있다면 O로 표시한다. 건널 수 없다면 X로 표시한다.
- 다리를 끝까지 건너면 게임이 종료된다.
- 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다.
    - 재시작해도 처음에 만든 다리로 재사용한다.
    - 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

## 🚀 기능 목록
### Controller
#### 요청 수신
- [X] 게임 시작 -> View
- [X] 다리의 길이를 입력 -> Service
- [X] 이동할 칸을 입력 -> Service
- [X] 현재 게임 결과 출력 -> View
- [X] 게임 재시작 여부를 입력 -> Service
- [X] 최종 게임 결과 출력 -> View

### View
#### 입력과 출력 
- [X] 게임 시작 문구를 출력 - OutputView#printBridgeGameStartMessage()
- [X] 다리의 길이를 입력 - InputView#readBridgeSize()
- [X] 이동할 칸 입력 - InputView#readMoving()
- [X] 현재 게임 결과 출력 - OutputView#printMap()
  - List<라운드 결과>
  - 다리 칸의 구분은 |(앞뒤 공백 포함) 문자열로 구분
- [X] 게임 실패 시 게임 재시작 여부 입력 - InputView#readGameCommand()
- [X] 최종 게임 결과 출력 - OutputView#printResult()
  - [X] 현재 게임 결과
  - [X] 게임 성공 여부
  - [X] 총 시도한 횟수: : 게임 재시작 시 + 1

### Service
#### Valid 후 요청 처리
- [X] 다리의 길이를 검증 - Validator#validBridgeLength()
- [X] 다리 데이터 저장 - BridgeGame#setBridge()
  - [X] 다리의 길이만큼 다리를 생성한다. - BridgeMaker#makeBridge()
    - [X] 다리의 건널 수 있는 칸을 정한다. - BridgeMaker#getCrossableMoving()
      - [X] 0과 1중 무작위 값을 생성한다. - BridgeRandomNumberGenerator#generate()
      - [X] 0이면 아래 칸(D), 1이면 위 칸(U)을 건널 수 있다. - Moving#findByNumber()
- [X] 이동할 칸 검증 - Validator#validMoving()
- [X] 플레이어가 이동 - BridgeGame#move()
  - [X] 라운드 데이터 저장
    - [X] 플레이어가 이동할 칸 - Moving
    - [X] 라운드 결과 - RoundResult
      - 이동할 수 있는 칸을 선택한 경우 O 표시
      - 이동할 수 없는 칸을 선택한 경우 X 표시
- [X] 게임 실패 시 게임 재시작 여부 검증 - Validator#validGameCommand()

### Exception
#### 예외 처리
- [X] 숫자가 아니면 예외 처리
- [X] 다리의 길이가 3 이상 20 이하가 아니면 예외 처리 
- [X] U(위 칸)와 D(아래 칸)가 아니면 예외 처리 
- [X] R(재시작)과 Q(종료)가 아니면 예외 처리 
