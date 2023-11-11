Steps to verify :

Hit the below endpoints:

1.On server
 http://localhost:8888/{property}/{profile}
eg. http://localhost:8888/limit-service/default

2. On Client side
  http://localhost:8001/value
  check value before refreshing the config
  
3. Refresh the config from client side
	http://localhost:8001/actuator/refresh