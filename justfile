enter-container:
  podman-compose up -d
  podman exec -it maven /bin/sh
stop-services:
  podman-compose down
exec:
  mvn exec:java -Dexec.mainClass="JDBCPostgres"
clean-compile:
  mvn clean compile exec:java -Dexec.mainClass="JDBCPostgres"
