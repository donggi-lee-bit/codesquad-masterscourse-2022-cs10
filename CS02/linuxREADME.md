# ssh 설정, 실행

### ssh 서버 설치

<img width="573" alt="스크린샷 2022-01-06 오후 2 20 19" src="https://user-images.githubusercontent.com/73376468/148358149-8acc38e4-6242-4daf-bd60-f616ab5c17b5.png">

우분투에는 client만 설치되어있기 때문에 ssh 서버를 설치해줍니다

### ssh 서버 상태 확인

<img width="403" alt="스크린샷 2022-01-06 오후 2 20 33" src="https://user-images.githubusercontent.com/73376468/148358687-5c06e812-abcd-4c21-80f1-8d53e6e9b1c0.png">

명령어를 사용하여 ssh가 실행 중인지 확인합니다. 실행되지 않았다면 ```sudo systemctl enable ssh``` ```sudo systemctl start ssh``` 를 입력하여 ssh를 실행시킵니다.


# ssh 를 이용하여 로컬에서 원격 접속

<img width="600" alt="스크린샷 2022-01-06 오후 6 15 53" src="https://user-images.githubusercontent.com/73376468/148359096-6a0299d2-5ebe-4a0d-829d-6f806e711b91.png">

# chmod 로 권한 부여하기

<img width="456" alt="스크린샷 2022-01-06 오후 5 21 58" src="https://user-images.githubusercontent.com/73376468/148361107-ce942381-7f14-442f-ad47-5c40dba68f4c.png">

<p>
  파일과 디렉토리의 접근 권한을 변경하는 chmod 명령어를 사용하였습니다. ls 의 l 옵션을 주어서 파일의 권한을 확인합니다. drwxrw-r-- 를 보면 d는 디렉토리라는 구분입니다. d 뒤로 rwx w-- r-- 세가지씩 끊어 보면 됩니다. 처음 세 문자는 소유자, 두 번쨰는 그룹, 세 번째는 타인에 관한 권한입니다. r은 쓰기, w는 읽기, x 실행에 관한 권한입니다. 각각을 8진수로 표현할 수 있는데 r -> 4, w -> 2, x -> 1, - -> 0 입니다. 4 + 2 + 1 = 7, 4 + 2 = 6, 1 소유자는 모든 권한을 갖고 그룹은 읽고 쓰는 권한, 그 외 사용자는 읽을 수 있는 권한만 부여받게 됩니다. 해당 [링크](https://recipes4dev.tistory.com/175)를 참조하였습니다.
</p>

# date

<img width="454" alt="스크린샷 2022-01-06 오후 5 42 03" src="https://user-images.githubusercontent.com/73376468/148364048-68ac3393-6cff-4474-9b9c-3ed1071e3fdc.png">
<br>

# 쉘 스크립트

## 디렉토리 생성
- day1 부터 day16 까지 디렉토리를 생성해주기 위한 스크립트를 만들었습니다

```bash
#!/bin/bash

echo "make directories"

for i in {1..16}
do
	if ! [ -d ./day$i ]; then
		mkdir ./day$i
	fi
done
```

<p>
    현재 디렉토리에 day1이 없으면 day1 이라는 디렉토리를 생성해줍니다. 이 작업을 day16까지 해줍니다.
<p>
<br>

### 실행 결과
<br>

<img width="1483" alt="스크린샷 2022-01-07 오후 5 18 09" src="https://user-images.githubusercontent.com/73376468/148513934-3e895a4c-9461-4289-b368-29279f4b3e96.png">

<br>

<p>
현재 위치에 day1 부터 day16 까지 디렉토리가 생성된 걸 확인했습니다.
</p>

<br>

## 파일 생성
- 2의 배수와 3의 배수 번호를 가진 day 디렉토리 내부에 디렉토리 번호와 같은 ```.cs``` 파일을 생성하였습니다.

```bash
#!/bin/bash

echo "make files"

for i in {1..16}
do
	if (($i % 2 == 0)); then
		touch day$i/a$i.cs
	elif (($i % 3 == 0)); then
		touch day$i/a$i.cs
	fi
done
```

### 실행 결과
- 2, 3의 배수의 숫자를 가진 day 디렉토리 내부에 ```.cs``` 파일이 생성되었습니다.
<br>

<img width="176" alt="스크린샷 2022-01-07 오후 9 12 12" src="https://user-images.githubusercontent.com/73376468/148542539-cc88d28a-d04e-4962-a1b3-b59169c81f76.png">

## 압축
- 디렉토리를 순회하면서 ```.cs``` 파일이 없으면 ```is empty``` 를 출력해줍니다. ```.cs``` 파일은 ```zip``` 파일로 압축해줍니다.

```bash
#!/bin/bash

echo "zipzipzipzipzipzip"
mkdir zipDir

for i in {1..16}
do
	if ! [ day$i/*.cs ]; then
		echo "day$i is empty"
	else
		cp day$i/*.cs zipDir
	fi
done
```

### 실행 결과
<img width="883" alt="스크린샷 2022-01-07 오후 9 24 47" src="https://user-images.githubusercontent.com/73376468/148543795-7c375db7-af2b-4579-8f1c-aff88a2dc0df.png">

- 아 지금보니 if 문 내부 echo 가 실행되지 않아서 수정이 필요하다..

