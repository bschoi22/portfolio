# 팀 프로젝트
프로젝트명: 재고관리를 위한 ERP 시스템

## 🚀 프로젝트 소개 
Spring(MVC) 기반의 ERP 시스템으로, 효율적인 재고 관리 및 물류 흐름 최적화를 위한 ERP 시스템입니다. 
이 시스템은 입고, 출고, 재고 조회, 파손 관리 등의 기능을 제공하여 정확한 재고 파악을 지원합니다. 
또한, 재고 현황을 시각화하여 한눈에 확인할 수 있도록 하고, 원활한 재고 운영을 위한 다양한 관리 기능을 제공합니다.

## 📌 주요 기능  
✅ **회원 관리**: 로그인, 회원가입, 권한 관리  
✅ **상품 관리**: 상품 등록, 수정, 삭제, 검색  
✅ **주문 관리**: 주문 생성, 상태 변경, 주문 내역 조회  
✅ **재고 관리**: 실시간 재고 조회 및 관리

## 🛠️ 기술 스택  
<pre>
|   구분    |     기술     |
|   언어    | Java(JDK11), HTML/CSS, JavaScript |
|   서버    | Apache Tomcat 9.0.85 |
| 프레임워크 | Spring , MyBatis 3.5.14 |
|    DB     | Oracle 19c |
|    IDE    | STS (Spring Tool Suite) 3 |
| 라이브러리 | Lombok 1.18.34 , jQuery |
</pre>
## 📂 프로젝트 폴더 구조
<pre>
📂 Spring_ERP
 ├── 📂 src
 │   ├── 📂 main
 │   │   ├── 📂 java
 │   │   │   ├── 📂 auth          # 로그인 인증 관련 로직
 │   │   │   ├── 📂 controller    # REST API 컨트롤러
 │   │   │   ├── 📂 dto           # 데이터 전송 객체 (DTO)
 │   │   │   ├── 📂 mapper        # MyBatis 매퍼 (인터페이스 + XML 포함)
 │   │   │   ├── 📂 repository    # 데이터 액세스 계층 (DAO, Repository)
 │   │   │   ├── 📂 service       # 비즈니스 로직 처리
 │   │   │   ├── 📂 util          # 공통 유틸리티 클래스
 │   │   ├── 📂 webapp
 │   │   │   ├── 📂 META-INF
 │   │   │   ├── 📂 WEB-INF
 │   │   │   │   ├── 📂 spring          # Spring 설정 관련 XML 파일들
 │   │   │   │   │   ├── 📂 appServlet
 │   │   │   │   │   │   ├── servlet-context.xml  # Spring MVC 설정
 │   │   │   │   │   │   ├── tiles.xml            # Tiles 레이아웃 설정
 │   │   │   │   │   │   ├── mybatis-config.xml   # MyBatis 설정 파일
 │   │   │   │   │   │   ├── root-context.xml     # 애플리케이션 컨텍스트 설정
 │   │   │   │   │   │   ├── security-context.xml # Spring Security 설정
 │   │   │   │   │   ├── web.xml                   # 웹 애플리케이션 설정 파일
 │   │   │   │   ├── 📂 views           # JSP 뷰 파일이 위치하는 폴더
 ├── .gitignore     # Git 제외 파일 설정
 ├── pom.xml        # Maven 의존성 관리 파일
 ├── README.md      # 프로젝트 설명 파일
</pre>

## 🔥 주요 API 및 코드 샘플
### 1️⃣ 재고 목록 조회 API
```java
@GetMapping("/inventory_list")
public Map<String, Object> inventoryProductList(@RequestParam Map<String, Object> map) {
    return inventoryService.getselectProductInventoryPageList(map);
}
```
<pre>
설명: GET /inventory/inventory_list 요청 시, 재고 목록을 조회합니다.
파라미터: @RequestParam Map<String, Object> map → 동적 조회 조건 지원
반환값: Map<String, Object> 형태로 재고 리스트 반환
특징: 서비스 레이어 (inventoryService)를 호출하여 데이터 조회
</pre>
### 2️⃣ 특정 재고 상세 조회 API
```java
@GetMapping("/inventory_modify_view/{inventoryId}")
public Inventory inventoryModifyView(@PathVariable int inventoryId) {
    return inventoryService.getselectProductInventoryUpdate(inventoryId);
}
```
<pre>
설명: GET /inventory/inventory_modify_view/{inventoryId}를 호출하면 특정 재고의 상세 정보를 반환합니다.
파라미터: @PathVariable int inventoryId → 조회할 재고의 ID
반환값: Inventory 객체
</pre>
### 3️⃣ 재고 추가 API
```java
@PostMapping("/inventory_add")
public String inventoryAdd(@RequestBody Inventory inventory) {
    inventoryService.addInventory(inventory);
    return "success";
}
```
<pre>
설명: POST /inventory/inventory_add 요청으로 새로운 재고를 추가합니다.
파라미터: @RequestBody Inventory inventory → JSON 데이터를 받아 Inventory 객체로 매핑
반환값: "success" 문자열 (실제로는 ResponseEntity 사용을 추천)
</pre>
### 4️⃣ 재고 삭제 API
```java
@DeleteMapping("/inventory_remove/{idx}")
public String productRemove(@PathVariable int idx) {
    inventoryService.removeInventory(idx);
    return "success";
}
```
<pre>
설명: DELETE /inventory/inventory_remove/{idx}를 호출하면 해당 ID의 재고를 삭제합니다.
파라미터: @PathVariable int idx → 삭제할 재고 ID
</pre>
