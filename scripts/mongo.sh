podman run --name mongo-myapp -d  \
    -e MONGO_INITDB_ROOT_USERNAME=mongo \
    -e MONGO_INITDB_ROOT_PASSWORD=mongo \
    -e MONGO_INITDB_DATABASE=myapp \
    -p 27017:27017 \
    mongo