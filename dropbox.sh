cat > ~/.dropbox_uploader <<EOL
OAUTH_ACCESS_TOKEN=${OAUTH_ACCESS_TOKEN}
EOL

curl "https://raw.githubusercontent.com/andreafabrizi/Dropbox-Uploader/master/dropbox_uploader.sh" -o ~/dropbox_uploader.sh
chmod +x ~/dropbox_uploader.sh

if [ "$TRAVIS_PULL_REQUEST" == "false" ]; then
    ~/dropbox_uploader.sh mkdir "branch"
    ~/dropbox_uploader.sh mkdir "branch/$TRAVIS_BRANCH"
    ~/dropbox_uploader.sh upload ./build/libs/*univ*.jar "branch/$TRAVIS_BRANCH"
else
    ~/dropbox_uploader.sh mkdir "pr"
    ~/dropbox_uploader.sh mkdir "pr/$TRAVIS_PULL_REQUEST"
    ~/dropbox_uploader.sh upload ./build/libs/*univ*.jar "pr/$TRAVIS_PULL_REQUEST"
fi

exit 0
