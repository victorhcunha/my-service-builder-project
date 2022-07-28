curl http://localhost:8080/api/jsonws/ohqiwtsfhl.h7g5folder/add-my-custom-h7-g5-folder \
  -d description="This is where I store all my vacation photos." \
  -d name="Vacation Photos" \
  -u test@liferay.com:test

curl http://localhost:8080/api/jsonws/ohqiwtsfhl.h7g5folder/add-my-custom-h7-g5-folder \
  -d description="Test Description" \
  -d name="Test Name" \
  -u test@liferay.com:test

# curl to invoke add-my-custom-h7-g5-folder-with-permission-check
curl http://localhost:8080/api/jsonws/ohqiwtsfhl.h7g5folder/add-my-custom-h7-g5-folder-with-permission-check \
  -d description="Invoking Permission Check" \
  -d name="Permission Check" \
  -u test@liferay.com:test

# I added a new user to Liferay and got the exception message "You are not test@liferay.com"
curl http://localhost:8080/api/jsonws/ohqiwtsfhl.h7g5folder/add-my-custom-h7-g5-folder-with-permission-check \
  -d description="Using other user" \
  -d name="Other user" \
  -u victor@liferay.com:test

#I used this curl command to invoke JSONWS and invoked
curl http://localhost:8080/api/jsonws/ohqiwtsfhl.h7g5entry/add-my-custom-h7-g5-entry-service-with-permission-check \
  -d description="desc 1." \
  -d name="name 1" \
  -u test@liferay.com:test

#I used this curl command to invoke JSONWS and didn't invok
  curl http://localhost:8080/api/jsonws/ohqiwtsfhl.h7g5entry/add-my-custom-h7-g5-entry-service-with-permission-check \
  -d description="desc 2" \
  -d name="name 2" \
  -u victor@liferay.com:test

  #I used this curl command to invoke JSONWS and didn't invok
  curl http://localhost:8080/api/jsonws/ohqiwtsfhl.h7g5entry/add-my-custom-h7-g5-entry-service-with-permission-check \
  -d description="desc 3" \
  -d name="name 3" \
  -u victor@liferay.com:test
