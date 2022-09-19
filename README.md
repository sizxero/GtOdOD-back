<div align=center>
  <h1> 👍 GOOD To Do List; GtOdOD 📝 - BE server </h1>
</div>


## ⚙ Tech Stacks
 <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white"> <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=Spring Security&logoColor=white"> 

## 🌏 API 설계


| 분류     | method | url               | 기능                   |
|---------|--------|-------------------|-----------------------|
| todo관리 | GET    | /todo?id={userid} | 사용자별 todo 조회       |
| todo관리 | POST   | /todo             | todo 등록              |
| todo관리 | PUT    | /todo             | todo 수정              |
| todo관리 | DELETE | /todo             | todo 삭제              |


## 📂 Directory 


    ㄴ src
        ㄴ main
            ㄴ java
                ㄴ com.sizxero.GtOdOD
                    ㄴ controller
                    ㄴ dto
                    ㄴ entity
                    ㄴ repository
                    ㄴ service
                    ㄴ GtOdOdApplication.java

            ㄴ resource
                
        ㄴ test