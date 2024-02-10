
## Run Spring boot service with gradle
```
./gradlew eureka-server:bootRun
./gradlew guest-tracking:bootRun
./gradlew parcel-service:bootRun
```

## Build
```
./gradlew eureka-server:build
./gradlew guest-tracking:build
./gradlew parcel-service:build
```

## Check health

Guest service: `http://localhost:8080/actuator/health`

Parcel service: `http://localhost:8081/actuator/health`

Eureka registry and discovery: `http://localhost:8761`

## API with Swagger

Guest service: `http://localhost:8080/swagger-ui.html#/guest-controller`

Parcel service: `http://localhost:8081/swagger-ui.html#/parcel-controller`

