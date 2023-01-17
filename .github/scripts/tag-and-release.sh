#!/bin/bash

BRANCH="release-test"

function check_semver() {
  if [[ $1 =~ ^(v|V)?(0|[1-9][0-9]*)\.(0|[1-9][0-9]*)\.(0|[1-9][0-9]*)(-((0|[1-9][0-9]*|[0-9]*[a-zA-Z-][0-9a-zA-Z-]*)(\.(0|[1-9][0-9]*|[0-9]*[a-zA-Z-][0-9a-zA-Z-]*))*))?(\+([0-9a-zA-Z-]+(\.[0-9a-zA-Z-]+)*))?$ ]]; then
    echo "$1"
  else
    echo ""
  fi
}

main_branch=$(curl \
  -s \
  -H "Accept: application/vnd.github+json" \
  -H "Authorization: Bearer $GH_PAT" \
  -H "X-GitHub-Api-Version: 2022-11-28" \
  https://api.github.com/repos/labforward/$REPO/branches/$BRANCH)

commit_sha=$(echo  "$main_branch" | jq -r ".commit.sha")

head_branch=$(curl -s \
  -H "Accept: application/vnd.github+json" \
  -H "Authorization: Bearer $GH_PAT" \
  -H "X-GitHub-Api-Version: 2022-11-28" \
  https://api.github.com/repos/labforward/$REPO/commits/"$commit_sha"/pulls )

head_version_raw=$(echo "$head_branch" | jq -r ".[].head.ref" | tail -1  | awk -F"/" '{print$2}')
head_branch_sha=$(echo "$head_branch" | jq -r ".[].head.sha" | tail -1 )

tag_version=$(check_semver "$head_version_raw")

echo -e "debugging info\n head_branch:\n$head_branch"
echo "head_branch_sha $head_branch_sha"
echo "tag_version $tag_version"

if test -z "$tag_version"; then
  echo "This is not a release merge: $head_version_raw" # so its ok to stop right here
  exit 0
fi

# git fetch origin $head_branch_sha
# git switch "$head_branch_sha"
git checkout HEAD^
git branch
git tag -a "$tag_version" -m "Release $tag_version"
git push origin "$tag_version"

create_release=$(curl \
  -X POST \
  -s \
  -H "Accept: application/vnd.github+json" \
  -H "Authorization: Bearer $GH_PAT" \
  -H "X-GitHub-Api-Version: 2022-11-28" \
  https://api.github.com/repos/labforward/$REPO/releases \
  --data-binary @- << EOF
{
  "tag_name":"$tag_version", 
  "target_commitish": "$BRANCH", 
  "name":"Release $tag_version", 
  "body":"Release $tag_version", 
  "draft":false, 
  "prerelease":false, 
  "generate_release_notes":true
} 
EOF
)

url=$(echo "$create_release" | jq -r ".url")

if [ "null" = "$url" ];
then
  echo "Release process failed.\n$create_release"
  exit 1
fi

echo "Release $tag_version created"
