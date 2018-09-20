# spring-session-redis

[spring-session-redis](https://github.com/arpitaggarwal/spring-session-redis "title") 

[![Join the chat at https://gitter.im/arpitaggarwal/spring-session-redis](https://badges.gitter.im/arpitaggarwal/spring-session-redis.svg)](https://gitter.im/arpitaggarwal/spring-session-redis?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

### Redis Installation

```
$ wget http://download.redis.io/releases/redis-3.2.3.tar.gz
$ tar xzf redis-3.2.3.tar.gz
$ cd redis-3.2.3
$ make
```

### Start Redis Server

```
src/redis-server
```

### Start Redis Cli

```
$ src/redis-cli
redis> set foo bar
OK
redis> get foo
"bar"
```

### Redis GUI Installation

```
gem install redis-browser
```

### Redis GUI Start - Standalone

```
redis-browser
```

### Build application

```
$ spring-session-redis/mvn clean install
```

### Get Request to Server at 8080

```
curl -i -H "Content-type: application/json" -X POST -d '{"id":"1","name":"Arpit"}' http://localhost:8080/spring-session-redis/get
```

-i (or —-include) is a cURL flag for including HTTP headers in the response and the -d (or —data) flag is used to submit data as request parameters.

<strong>Output:</strong>

```
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Cache-Control: no-store
Set-Cookie: SESSION=014a4543-d661-462c-ba5a-4099c56fbbc4; Path=/spring-session-redis/; HttpOnly
Content-Type: text/html;charset=UTF-8
Content-Language: en-US
Content-Length: 271
Date: Fri, 02 Sep 2016 11:48:37 GMT

<!DOCTYPE html>
<html>
<head>

<title>Spring Session Redis | Index</title>

</head>

<body>Hello Arpit!

</body>
</html>

```

In the response, we take note of the value of the <strong>Set-Cookie</strong> header.

### Get Request to Server at 8081

```
curl -i -H "Content-type: application/json" -H "Cookie: SESSION=014a4543-d661-462c-ba5a-4099c56fbbc4" -X POST -d '{"id":"1","name":"Arpit"}' http://localhost:8081/spring-session-redis/get
```


Reference:

 - https://www.jayway.com/2015/05/31/scaling-out-with-spring-session/

 - http://redis.io/download

 - https://github.com/arpitaggarwal/redis-browser
