# Spring Market

![image](https://user-images.githubusercontent.com/112923814/206835670-2683c2ba-89d0-4509-bf81-4e5d2678ebca.png)
<br/>
[![spring-market](https://github.com/SpringMarket/Market/actions/workflows/gradle.yml/badge.svg)](https://github.com/SpringMarket/Market/actions/workflows/gradle.yml)


# 🌏 프로젝트 소개
- **국내 최대 수량의 의류 데이터 (10,000,000)** 를 보유한 쇼핑몰입니다.



✔ [Spring Market 이용해보기 Click!](https://www.notion.so/1-3b015d8a07d149148b5fea36c4035ceb) <br>
✔ [Spring Market 팀 노션 Click!](https://www.notion.so/1-3b015d8a07d149148b5fea36c4035ceb)
<br/><br/>
# ⚙ InfraStructure 

<img src ="https://user-images.githubusercontent.com/112923814/206205534-6b2cf6e1-9461-4258-bbc1-f54b762be4b8.jpg"/></a>      

# ⚙ ERD
<details>
<summary><strong> OPEN </strong></summary>
<div markdown="1">       
<br>

![image](https://user-images.githubusercontent.com/112923814/207008488-d2395e48-ea03-4744-aa31-492b1d4fecf6.png)

</div>
</details>


# 🕹 Tech Stack
<img src ="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white"/></a>
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"></a>
<img src ="https://img.shields.io/badge/Spring Securit-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white"/></a>
<img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
<br>
<img src ="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"/></a>
<img src ="https://img.shields.io/badge/Amazon AWS-232F3E?style=for-the-badge&logo=Amazon AWS&logoColor=white"/></a>
<img src ="https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=Redis&logoColor=white"/></a> 

<details>
<summary><strong>📣버전</strong></summary>
<div markdown="1">    
  
### **Application**
  
- **JAVA 11**
- **Spring Boot** _2.7.0
- **Spring Security** _0.11.2
- **JPA**
- **Query DSL** _5.0.0
- **Full Text Search**

### **Data**

- **AWS RDS - MySQL** _8.028
- **AWS ElastiCache for Redis** _7.0.4
- **AWS S3**
- **Faker** (faker_15.2.0)

### **CI/CD**

- **Github Action**
- **AWS EC2**
- **AWS Elastic Beanstalk**

### **Monitoring**

- **Cloud Watch**
- **AWS OpenSearch**
- **Logback**

### **TestCode**

- **Junit 5**
- **Mock**
- **TestContainer**

### **Front**

- **React - yarn**
</div>
</details>


<details>
<summary><strong>📣기술 & 라이브러리 사용 이유</strong></summary>
<div markdown="1">   
  <br/>
  

|기술 스택| 사용 이유|
|:--|:--|
|Query DSL|현준|
|Full Text Search| 현준 |
|RDS- MySQL| 현준 |
|AWS ElastiCache for Redis| 제윤 |
|Faker| 수영 |
|Github Action| 수영 |
|AWS Elastic Beanstalk| 제윤 |
|Cloud Watch| 제윤 |
|AWS OpenSearch| 제윤 |
|Logback| 수영 |
|Junit 5| 수영 |
|TestContainer|제윤|
|React|제윤|

</div>
</details>
<br/>

## 🔥 주요 기능


#### 조회 기능
- 메인 페이지 로딩 속도는 플랫폼 첫 인상에 큰 영향을 주기 때문에 100ms 이내를 목표
- 쇼핑몰 홈페이지 로딩 속도가 2초 이상이라면 고객이 해당 페이지를 떠날 확률이 높기 때문에 고객의 서비스 체류 시간을 높이기 위해서
필터링 조회 속도를 2초 이내를 목표, 상세 조회는 500ms 이내를 목표

<details>
<summary><strong> 1⃣ Redis Sorted Set으로 메인 페이지 로딩 최적화 & 파이프라인 구축</strong></summary>
<div markdown="1">     
<br>

  - Redis 파이프라인을 구축하여 메인페이지에 노출할 인기 상품 데이터를 Redis에 캐싱
  - Redis에 캐싱된 데이터를 사용해 메인 페이지 조회 성능 % 개선, 평균 로딩 속도 ~ms로 목표 달성
</div>
</details>

<details>
<summary><strong> 2⃣ Redis에 캐싱된 데이터로 상품 상세조회</strong></summary>
<div markdown="1"> 
<br>

  - 카테고리별 인기 상품 ~개를 Redis에 캐싱, 캐싱된 상품의 상세페이지 조회 성능 % 개선
</div>
</details>

<details>
<summary><strong> 3⃣ 결합 인덱스 추가, 커버링 인덱스 적용</strong></summary>
<div markdown="1">       
<br>

  - 조회수+pk로 결합 인덱스를 추가하여 조회순, 날짜순 정렬 시 성능 저하의 가장 큰 원인이었던 sort 부하를 해결
  - QueryDSL은 서브쿼리를 지원하지 않기 때문에 커버링 인덱스를 활용해 페이징 조회 성능을 1900% 개선 
</div>
</details>

<details>
<summary><strong> 4⃣ Full Text Search로 키워드 검색</strong></summary>
<div markdown="1">    
<br>

  - 키워드 조회 시 인덱스를 사용하지 않는 like 키워드 방식과 비교해 인덱스를 사용하여 조회하는 full-text-search 방식으로 변경하여 약 634% 성능 개선
</div>
</details>

<details>
<summary><strong> 5⃣ 데이터 반정규화</strong></summary>
<div markdown="1">       
<br>

  - 쿼리문에서 join문을 제거를 위해 데이터 반정규화를 하여 조회수, 재고수 테이블을 상품 테이블과 병합하여 조회 성능을 66.6% 개선
</div>
</details>
<br/>

#### 주문 기능
  - 대규모 트래픽에서 많은 사용자들이 상품 주문 시 주문과 재고 데이터가 일관되게 관리가 되지 않으면 서비스에 대한 신뢰도에 치명적인 영향을 끼치기 때문에 주문 기능에서 동시성 이슈 관리가 매우 중요
  - ~ 행사 시 주문 데이터를 참고해 초당 ~ 건 상품 주문 시 동시성 이슈 제어를 목표 

<details>
<summary><strong> 1⃣ Pessimistic Lock으로 동시성 제어</strong></summary>
<div markdown="1">   
<br>

  - 트랜잭션이 시작될 때 MySQL DB에 Exclusive Lock을 걸어 Lock 해제 전에 다른 트랜잭션에서는 데이터를 읽거나 수정할 수 없게 하여 Race Condition을 해결
  
</div>
</details>

<details>
<summary><strong> 2⃣ 최적의 Connection Pool Size 설정으로 데드락 문제 해결</strong></summary>
<div markdown="1">       
<br>
  - Pessimistic Lock은 데드락 발생 가능성이 있어 JMeter 부하테스트를 통해 데드락을 회피할 수 있는 최적의 Connection Pool Size인 20으로 설정
  - 부하테스트 결과 1000명의 사용자가 10초 간 같은 상품 주문은 모두 성공하였고 데이터 정합성도 달성
</div>
</details>
<br/>


## 💉 프로젝트 관리
#### ✔ 애플리케이션 배포
- Github Actions + Elastic Beanstalk 사용으로 CI/CD 환경을 구축했습니다.
- ALB를 활용한 Trigger 기반 오토 스케일링으로 유동적인 트래픽에 효율적으로 대응하고 있습니다.
- Github Actions CI 동작 시 Gradle 세팅을 캐싱해 더욱 생산성을 높였습니다.
- 인터넷 보안 환경을 위해 HTTPS를 적용했습니다.
#### ✔ 모니터링
- Cloud Watch를 사용하여 로그 + 성능 지표를 모니터링 하고 있습니다.
- CPU가 70%를 초과하면 경보가 발생하는 알림 프로세스를 구축했습니다. 
#### ✔ 테스트 커버리지 ?%
- 과감한 코드 리팩토링과 자신있는 배포를 위해서 ?% 미달성 시 배포가 되지 않도록 제한을 걸었습니다.
- 불필요한 프로덕션 코드를 전부 제거하고 모든 코드를 이해하고 싶었습니다.
- <details><summary><strong>클린코드 中</strong></summary><div markdown="1">       <br/>얼마만큼의 코드를 자동화한 단위 테스트로 계산해야 할까? 대답할 필요조차 없다.<br/> 모조리 다 해야 한다. 모.조.리! 100% 테스트 커버리지를 권장하냐고? 권장이 아니라 강력히 요구한다. <br/>작성한 코드는 한 줄도 빠짐없이 전부 테스트해야 한다. 군말은 필요 없다. ― 클린코드 (로버트 마틴 저)

</div>
</details>
<br/>

## 🎯 트러블 슈팅

<details>
<summary><strong>📌 조회/정렬 시 두개의 Index가 적용되지 않는 이슈가 발생했습니다. </strong></summary>
<div markdown="1">       

#### ❗ 문제상황
  - 필터링 조회에서 full-text-search로 키워드 검색을 하면 60sec 가까이 나오게 됩니다.
  - 필터링 조회에서 정렬은 필수적으로 해야하는데 where절에서 full-text-search로 키워드 조회를 하면 제목에 걸린 full-text-index가 쿼리문에 적용되기 때문에 정렬 컬럼으로 인덱스를 사용할 수 없어 sort 부하 해결이 안됩니다.
  
#### 💡 Solution :
  - (INDEX 활용) 필터링 조회 시 정렬 컬럼으로 인덱스를 사용하기 위해 키워드 검색은 contains문을 사용하였습니다.
  - (full-text-index 활용)정렬 없이 full-text-search를 사용한 키워드 검색만 하는 기능을 추가하였습니다.
 
#### ✔ 결과
  - 키워드에 따른 속도 편차는 있지만 평균 500ms로 약 11,900%의 성능향상 효과를 얻었습니다.
</div>
</details>

<details>
<summary><strong>📌 쿼리문 동작 시 cross join이 발생하여 성능 이슈가 발생했습니다. </strong></summary>
<div markdown="1">       

#### ❗ 문제상황
  - 조회 쿼리가 나갈 때 DB 로그를 보니 cross join이 발생한 것을 확인했습니다.
  (cross join 은 카다시안곱을 수행하여 join하기 때문에 너무 많은 데이터를 가져와 성능이 저하됩니다.)
  
#### 💡 Solution :
  - (inner join 명시적 사용) join을 명시적으로 사용하지 않은 쿼리문에서 자동으로 cross join이 발생되고 있었기 때문에 join이 필요한 테이블에 inner join을 추가하여 명시적으로 join을 해주었습니다.
 
#### ✔ 결과
  - 조회 시 기존에 cross join으로 나가던 쿼리문이 inner join 바뀌었습니다.
  - 200만건 기준 필터링 조회 시 평균 8초, 성능 200%까지 개선되었습니다. 
</div>
</details>

<details>
<summary><strong>📌 10,000 건의 상품 데이터 Cache Warmup 동작 시 극심한 Latency의 지연이 발생했습니다.</strong> </summary>
<div markdown="1">       

#### ❗ 문제상황
  - 상품 데이터의 빠른 조회와 DB 부하 분산을 위해 캐싱은 필수였습니다.
  - 하지만 TCP 기반으로 동작하는 Redis에 1만 건의 데이터를 개별로 Input 할 때 타임아웃 + 극심한 Latency 지연이 발생했습니다.
  
![Warmup NonePipeline Logic - Postman2 ](https://user-images.githubusercontent.com/112923814/206866704-34a1e734-5478-4d00-b12a-edfe693f02dd.png)
  
#### 💡 Solution : Redis Pipeline 구축
  - 작업의 단위를 직접 구축해서 요청이 가능해졌습니다. ( 다중 Insert 가능 )
  
#### ✔ 결과
  - 10,000건의 TCP 통신이 10건(+1000)으로 축소되었습니다.
  - 통신 자료 추가 첨부
  
![warmup rank ](https://user-images.githubusercontent.com/112923814/206866707-21c54446-dd68-4b61-ba97-92056cf27581.png)



</div>
</details>

<details>
<summary><strong>📌 높은 트래픽 상황에도 상품이 클릭될 때마다 조회수 Update 쿼리가 동작했습니다.</strong></summary>
<div markdown="1">       
  
#### ❗ 문제상황
  - 높은 트래픽이 발생할 때 조회가 일어날 때마다 발생하는 Update 쿼리는 서버에 큰 무리가 있었습니다. (CPU ?%)
  
#### 💡 Solution : Cache Write Back
  - 조회수를 캐시에 모아 일정 주기 배치 작업을 통해 DB에 반영
  - 싱글쓰레드인 Redis의 특성상 Atomic하게 Increment를 처리할 수 있다.
  - 조회 기능의 많은 I/O와 함께 발생하는 Update 쿼리를 컨트롤할 수 있다.  
  
#### ✔ 결과
  - 클릭 시마다 발생했던 Update 쿼리 -> 1시간 주기로 배치작업
  - 결과 자세하게 작성 필요.. (CPU ?%)

</div>
</details>

<details>
<summary><strong>📌 AWS 인스턴스 성능 튜닝</strong></summary>
<div markdown="1">       

#### ❗ 문제상황
  - 스케일업 이전에 프리티어 인스턴스로 성능 최적화를 진행해보고자 했습니다.
  
#### 💡 Solution : Step 3
   - Step 1. DB 읽기 전용 복제본을 생성해 Read 요청을 분산합니다.
   - Step 2. Hikari Connection Pool 최적의 개수를 찾아야 했습니다.
   > Cache Write Back 전략으로 조회수를 관리하고 있었기에 Connection Pool 확장이 필요했습니다.
   - Step 3. Time_Wait 소켓의 최적화가 필요했습니다.
   > 낮은 성능의 DB로 대규모 상품 데이터를 핸들링하는 상황이기에 남아있는 모든 소켓에서 요청마다
   > TCP handshake가 발생하는데에서 생기는 불필요한 성능 낭비를 없애야 했습니다.

  
#### ✔ 결과
  - Step 1. Main DB에는 Write 요청만을 동작시키고 Replica DB에 Read 동작을 분산 요청해 스트레스 테스트가 %%% ( CPU 안정화 )
  - Step 2. Jmeter 부하테스트를 통해 에러율이 가장 낮아지는 Connection Pool Size를 찾았습니다.
  > Default Size인 10개에서 20개로 확장하니 동시 주문 150건 기준 에러율이 300% 하락했습니다.   
  - Step 3. KeepAlive 적용을 통해 매 요청마다 새로운 세션을 만들지 않고, 1024개의 세션을 연결한 뒤 그 연결을 통해 요청을 처리하게 만들었습니다.

</div>
</details>

<br/>

## 🧑‍💻팀원

|송제윤|윤수영|계현준|
|:--|:--|:--|
|jy|sy|hj|

