# Week01

## 문제
### 
1. 백준 18258 (queue2)
2. 백준 2178 (미로 탐색)
3. 프로그래머스 '바탕화면 정리'
4.

## 학습 내용 정리
[no1. 백준 18258](https://www.acmicpc.net/problem/18258)
- queue 메소드
  -  boolean add() : Adds an element to the queue. Throws an exception if capacity limits are violated.
                    : 
  
  - peek() : Retrieves, but does not remove. <br> return the head of this queue, or null if this queue is empty
  - poll() : Retrieves and removes the head of this queue, or returns null if this queue is empty.
           : 

- Collection 메소드
  - size() : return the number of elements in this collection
           : 

- LinkedList 메소드
  - getLast() : return last element in this list, or throws NoSuchElementException if the list is empty.
                 : 

******

[no2. 백준 2718](https://www.acmicpc.net/problem/2178)
  
- 관련 개념 
  - DFS(깊이 우선 탐색)
    * 한 경로를 끝까지 탐색한 후 다른 경로 탐색
    * 스택 또는 재귀 사용해서 구현
    * 메모지 사용이 BFS 보다 적음
    * 모든 노드 방문이 목적일 때 적합 
  - BFS(너비 우선 탐색)
      * 같은 레벨의 노드들을 먼저 탐색
      * 최단 경로 찾기에 적합
      * 큐를 사용해서 구현
      * 같은 레벨의 모든 노드를 저장해야하기 때문에 메모리를 더 많이 사용