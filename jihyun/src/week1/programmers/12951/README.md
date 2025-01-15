# [Programmers] 12951. JadenCase 문자열 만들기

---

## 1. 문제 URL
[JadenCase 문자열 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12951)

## 2. 문제 요약
모든 단어의 첫 문자는 대문자, 그 외의 알파벳은 전부 소문자여야 한다.

## 3. 해결 과정
### 사용한 알고리즘
- String 함수의 toUpperCase(), toLowerCase()

### 풀이
- 주어진 문자열의 가장 첫번째 알파벳을 대문자로 변환
- i번째 알파벳을 소문자로 변환
- i-1번째 알파벳이 공백일 경우, 그 다음에 오는 알파벳 대문자로 변환
- 배열을 문자열로 변환한 후, 반환
