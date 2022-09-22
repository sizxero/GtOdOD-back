<div align=center>
  <h1> 👍 GOOD To Do List; GtOdOD 📝 - BE server </h1>
</div>


## ⚙ Tech Stacks
 <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white"> <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=Spring Security&logoColor=white"> 

## 🌏 API 설계


| 분류     | method | url                         | 기능          |
|--------|--------|-----------------------------|-------------|
| 회원관리   | POST   | /user                       | 회원가입        |
| 회원관리   | POST   | /user/login                 | 로그인         |
| 회원관리   | GET    | /user/id?str={userid}       | 아이디 중복 체크   |
| 회원관리   | GET    | /user/nick?str={usernick}   | 닉네임 중복 체크   |
| 회원관리   | GET    | /user/findnick?str={userid} | 아이디로 닉네임 찾기 |
| 카테고리관리 | GET    | /ctg                        | 카테고리 조회     |
| 카테고리관리 | POST   | /ctg                        | 카테고리 등록     |
| todo관리 | GET    | /todo                       | todo 조회 |
| todo관리 | POST   | /todo                       | todo 등록     |
| todo관리 | PUT    | /todo                       | todo 수정     |
| todo관리 | DELETE | /todo?id={userid}           | todo 삭제     |


## 📂 Directory 


    ㄴ src
        ㄴ main
            ㄴ java
                ㄴ com.sizxero.GtOdOD
                    ㄴ config
                        ㄴ WebConfig.java
                        ㄴ WebSecurityConfig.java
                    ㄴ controller
                    ㄴ dto
                        ㄴ category
                        ㄴ todo
                        ㄴ user
                    ㄴ entity
                    ㄴ repository
                    ㄴ security
                        ㄴ JwtAuthenticationFilter.java
                        ㄴ TokenProvider.java
                    ㄴ service
                    ㄴ GtOdOdApplication.java

            ㄴ resource
                ㄴ application.yml
        ㄴ test