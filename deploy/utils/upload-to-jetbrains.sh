#!/bin/bash

if [ $# -lt 4 ] || [ -z $1  -o  -z $2  -o  -z $3  -o  -z $4 ]; then
	cat <<-EOF
	[!] error: missing arguments :(
	
	 syntax: upload-to-jetbrains.sh <user> <password> <plugin id> <local file to upload>
	example: upload-to-jetbrains.sh swyter secret1 1111 myfile.zip
EOF
	
	exit
fi
 
usr=$1; pwd=$2; plugin_id=$3; fil=$4

curl -k -c cookies.txt --progress-bar -o /dev/null https://plugins.jetbrains.com/login/auth

# and login using POST, to get the final session cookies, then redirect it to the right page
echo "signing in with the credentials provided:"
curl -k -c cookies.txt -b cookies.txt --progress-bar -o /dev/null -d "j_username=$usr&j_password=$pwd&_spring_security_remember_me=on" --referer "https://plugins.jetbrains.com/j_spring_security_check" -L https://plugins.jetbrains.com/j_spring_security_check

# check that we have the session cookie, if not, something bad happened, don't spend time uploading.
if [ -z "$(grep grails_remember_me cookies.txt)" ]; then
	cat <<-EOF
	
	[!] error: didn't get the session cookie, probably bad credentials or they changed stuff... upload canceled!
EOF

	exit
fi

# now that we're logged-in and at the right page, upload whatever you want to your repository...
echo "actual upload progress should appear right now as a progress bar, be patient:"
curl -k -c cookies.txt -b cookies.txt --progress-bar -o /dev/null --referer "https://plugins.jetbrains.com/plugin/uploadPlugin" -L --form pluginId=$plugin_id --form pr=pr --form type_down= --form file=@"$fil" --form notes= https://plugins.jetbrains.com/plugin/uploadPlugin

echo "done? maybe. *crosses fingers* signing out, closing session!"
curl -k -c cookies.txt -b cookies.txt --progress-bar -o /dev/null -L https://plugins.jetbrains.com/j_spring_security_logout
rm -f cookies.txt > /dev/null