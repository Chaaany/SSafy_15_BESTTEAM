#!/bin/bash

# 변경된 파일들 확인 (새로 추가된 파일과 수정된 파일 포함)
changed_files=$(git status --porcelain)

# 변경된 파일이 있는지 확인
if [ -z "$changed_files" ]; then
  echo "No changes to commit."
  exit 0
fi

# 모든 변경된 파일에 대해 커밋 및 푸시 수행
echo "$changed_files" | while read -r line; do
  # 파일의 상태와 파일명을 구분
  status=$(echo "$line" | awk '{print $1}')
  file=$(echo "$line" | awk '{print substr($0, index($0,$2))}')

  # 디렉토리 구조상 마지막 파일명 (확장자를 포함한 파일명) 추출
  filename=$(basename "$file")

  # 파일의 상태에 따라 다른 커밋 메시지 설정
  if [[ "$status" == "??" ]]; then
    commit_message="Create $filename"
  else
    commit_message="Change $filename"
  fi

  # git add 명령어로 파일 추가
  git add "$file"
  
  # git commit 명령어로 커밋 메시지 생성
  git commit -m "$commit_message"
done

# origin의 main 브랜치로 푸시
git push origin main