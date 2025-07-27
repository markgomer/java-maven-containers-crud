#! /bin/sh
podman-compose up -d
podman exec -it maven /bin/sh
