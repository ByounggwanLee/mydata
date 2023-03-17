# Git Repository STS 연동
* Perspective에 GIT이 추가되지 않았다면 Open Perspective -> Git을 Open
![image](https://user-images.githubusercontent.com/108439363/225805878-002f486d-db71-43b0-a5c5-b8a9977f1fef.png)

* Git Repositories 창을 보기 위해 Window -> Show View에서 추가<br>
  초기에 Git Repositories 창이 뜨지 않는다면 Other를 클릭해준 후<br>
![image](https://user-images.githubusercontent.com/108439363/225806021-1e4e9300-37a7-4f29-a090-25bada078a9b.png)
<br>  Git -> Git Repositories Open<br>
![image](https://user-images.githubusercontent.com/108439363/225806154-f0285ea6-6374-445d-8e17-68e0c93aba1c.png)

* 이제 Git Repositories창에서 Git Repositories를 Clone<br>
![image](https://user-images.githubusercontent.com/108439363/225806242-3878c01c-beef-4d19-83d1-cd1c47a8fcb4.png)

* Repository를 Clone 하기 위해 해당 Repository의 URI를 확인<br>
  해당 URL은 Git Repository에서 확인<br>
  Code -> HTTPS 에서 URI를 복사해준 후<br>
 ![image](https://user-images.githubusercontent.com/108439363/225811003-26ea7180-0f8b-4688-b2d5-c93ff06f139b.png)<br>
<br>  Git Repository URI에 붙여 넣으면 Host와 Repository path가 알아서 채워진다.
<br>  Authentication이 필요하다면 자신의 git 계정 정보를 입력해주자.<br>
![image](https://user-images.githubusercontent.com/108439363/225811194-7ff7a005-f4ad-4d16-ad86-1ce830696512.png)
 
* 현재 해당 Repository에는 branch가 mater밖에 없으므로 master만 체크해주고 Next!
![image](https://user-images.githubusercontent.com/108439363/225811356-c4ddb91d-0349-487a-a3dc-d0efad39d652.png)

* 이제 Git과 연동된 Project를 저장할 Local Directory path를 지정<br>
![image](https://user-images.githubusercontent.com/108439363/225811407-f68cf2bc-bb75-494a-8aa5-33038e3f4ed9.png)

* Git Repositories에 Git Repository가 연동된 것을 확인<br>
![image](https://user-images.githubusercontent.com/108439363/225811498-19e4251c-8fee-440f-b08d-3c84df51b4fe.png)

* .gitignore에 해당되는 configure 관련 파일들이 Git Repository에 포함되지 않아 import를 하였을 때 Spring 프로젝트 형태로 보이지 않음
![image](https://user-images.githubusercontent.com/108439363/225812015-a9671183-ae0c-4c79-bfb4-6fd1e94b4b09.png)

* Configure -> Add Gradle Nature 작동<br>
![image](https://user-images.githubusercontent.com/108439363/225812032-20a6088c-b221-4f7b-aa23-c1bb6c1f6ee3.png)

* configure 관련 파일들이 추가 Spring 프로젝트 형태로 보임<br>
![image](https://user-images.githubusercontent.com/108439363/225812139-579aed2a-214f-4d36-82b2-3fb472956ea4.png)
