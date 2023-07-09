Shopping list with auth

##In order to run the docker database, run this command

docker run --name adspace-postgres -e POSTGRES_PASSWORD=thisispassword -p 5432:5432 -m 512m -d postgres:12.0
