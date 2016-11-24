Tech Day by Init Survey Collector, Yorick
=========================================

A Docker based comedy in five scenes
------------------------------------


## Prologue: To build the Docker images

### Database image
    (cd database-image && docker build -t initdemo/yorick-db . && docker push initdemo/yorick-db)

### Yorick application image
    ./mvnw clean package
    docker build -t initdemo/yorick . && docker push initdemo/yorick

## Scene 1: The beginning

### Database storage container
    docker create -v /var/lib/postgresql/data --name yorick-db-storage postgres:9.6 /bin/true

### Start up the database container
    docker run -d --volumes-from yorick-db-storage --name yorick-db initdemo/yorick-db

### Start up the application container
    docker run -d -p 80:8090 --link yorick-db --name yorick initdemo/yorick

The application take a few seconds to start. To test it:

    curl http://localhost/health

## Scene 2: No database passwords

### Clear away the existing database
    docker stop yorick yorick-db
    docker rm yorick-db yorick
    docker rmi initdemo/yorick-db
    docker rmi initdemo/yorick
    docker rm --volumes yorick-db-storage

Developers will have pushed updated images.

### Recreate the containers as in scene 1
    docker create -v /var/lib/postgresql/data --name yorick-db-storage postgres:9.6 /bin/true
    docker run -d --volumes-from yorick-db-storage --name yorick-db initdemo/yorick-db
    docker run -d -p 80:8090 --link yorick-db --name yorick initdemo/yorick


## Epilogue: The cleanups

### To uninstall the database and application containers
    docker stop yorick yorick-db
    docker rm yorick-db yorick
    docker rmi initdemo/yorick-db
    docker rmi initdemo/yorick

### To uninstall the database volume
    docker rm --volumes yorick-db-storage

### To uninstall the nginx proxy and letsencrypt
    docker stop nginx-proxy letsencrypt
    docker rm --volumes nginx-proxy letsencrypt

### To uninstall oauth2_proxy
    docker stop oauth2_proxy
    docker rm oauth2_proxy
